package DAO.Json;

import DAO.ProjectDAO;
import Model.Project;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ProjectJsonDAO implements ProjectDAO {

    private static final String JSON_KEY = "projects";
    private final String jsonPath;
    private final ServletContext context;

    public ProjectJsonDAO(ServletContext context, String jsonPath) {
        this.context = context;
        this.jsonPath = jsonPath;
    }

    @Override
    public List<Project> getAll() {
        try (InputStream input = context.getResourceAsStream(jsonPath)) {
            if (input == null) {
                throw new IOException("Fichier introuvable: " + jsonPath);
            }

            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(input);
            JsonNode projectsArray = root.get(JSON_KEY);

            return mapper.readValue(
                    projectsArray.toString(),
                    new TypeReference<>() {}
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Project getByName(String name) {
        return getAll().stream()
                .filter(p -> p.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Project getByTitle(String title) {
        return getAll().stream()
                .filter(p -> p.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElse(null);
    }
}
