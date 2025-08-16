package DAO.Json;

import DAO.ExperienceCompetenceDAO;
import DAO.ExperienceDAO;
import DAO.CompetenceDAO;
import Model.Experience;
import Model.Competence;
import Model.ExperienceCompetence;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

public class ExperienceCompetenceJsonDAO implements ExperienceCompetenceDAO {

    private static final String JSON_KEY = "experience_competences";
    private final String jsonPath;
    private final ServletContext context;
    private final ExperienceDAO experienceDAO;
    private final CompetenceDAO competenceDAO;

    // DTO interne pour mapper le JSON brut
    private static class ExperienceCompetenceDTO {
        public String experience;
        public String competence;
        public String level;
    }

    public ExperienceCompetenceJsonDAO(ServletContext context, String jsonPath,
                                       ExperienceDAO experienceDAO,
                                       CompetenceDAO competenceDAO) {
        this.context = context;
        this.jsonPath = jsonPath;
        this.experienceDAO = experienceDAO;
        this.competenceDAO = competenceDAO;
    }

    @Override
    public List<ExperienceCompetence> getAll() {
        try (InputStream input = context.getResourceAsStream(jsonPath)) {
            if (input == null) {
                throw new IOException("Fichier introuvable: " + jsonPath);
            }

            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(input);
            JsonNode array = root.get(JSON_KEY);

            List<ExperienceCompetenceDTO> dtos = mapper.readValue(
                    array.toString(),
                    new TypeReference<List<ExperienceCompetenceDTO>>() {}
            );

            // Transformation DTO -> ExperienceCompetence complet
            return dtos.stream().map(dto -> {
                Experience exp = experienceDAO.getByTitle(dto.experience);
                Competence comp = competenceDAO.getByName(dto.competence);
                return new ExperienceCompetence(exp, comp, dto.level);
            }).collect(Collectors.toList());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<ExperienceCompetence> getByExperienceTitle(String experienceTitle) {
        return getAll().stream()
                .filter(ec -> ec.getE() != null &&
                        ec.getE().getTitle().equalsIgnoreCase(experienceTitle))
                .collect(Collectors.toList());
    }

    @Override
    public List<ExperienceCompetence> getByCompetenceName(String competenceName) {
        return getAll().stream()
                .filter(ec -> ec.getC() != null &&
                        ec.getC().getName().equalsIgnoreCase(competenceName))
                .collect(Collectors.toList());
    }
}
