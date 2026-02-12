package DAO.Json;

import DAO.ProjectCompetenceDAO;
import DAO.ProjectDAO;
import DAO.CompetenceDAO;
import DAO.DTO.ProjectCompetenceDTO;
import Model.ExperienceCompetence;
import Model.Project;
import Model.Competence;
import Model.ProjectCompetence;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProjectCompetenceJsonDAO implements ProjectCompetenceDAO {

    private static final String JSON_KEY = "project_competences";
    private final String jsonPath;
    private final ServletContext context;
    private final ProjectDAO projectDAO;
    private final CompetenceDAO competenceDAO;


    public ProjectCompetenceJsonDAO(ServletContext context, String jsonPath,
                                    ProjectDAO projectDAO,
                                    CompetenceDAO competenceDAO) {
        this.context = context;
        this.jsonPath = jsonPath;
        this.projectDAO = projectDAO;
        this.competenceDAO = competenceDAO;
    }

    @Override
    public List<ProjectCompetence> getAll() {
        try (InputStream input = context.getResourceAsStream(jsonPath)) {
            if (input == null) {
                throw new IOException("Fichier introuvable: " + jsonPath);
            }

            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(input);
            JsonNode array = root.get(JSON_KEY);

            List<ProjectCompetenceDTO> dtos = mapper.readValue(
                    array.toString(),
                    new TypeReference<List<ProjectCompetenceDTO>>() {}
            );

            // Transformation DTO -> ProjectCompetence complet
            return dtos.stream().map(dto -> {
                Project proj = projectDAO.getByName(dto.project);
                Competence comp = competenceDAO.getByName(dto.competence);
                return new ProjectCompetence(proj, comp, dto.level, dto.order);
            }).collect(Collectors.toList());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<ProjectCompetence> getByProjectTitle(String projectTitle) {
        return getAll().stream()
                .filter(pc -> pc.getP() != null &&
                        pc.getP().getTitle().equalsIgnoreCase(projectTitle))
                .sorted(Comparator.comparingInt(ProjectCompetence::getOrder))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProjectCompetence> getByCompetenceName(String competenceName) {
        return getAll().stream()
                .filter(pc -> pc.getC() != null &&
                        pc.getC().getName().equalsIgnoreCase(competenceName))
                .sorted(Comparator.comparingInt(ProjectCompetence::getOrder))
                .collect(Collectors.toList());
    }
}
