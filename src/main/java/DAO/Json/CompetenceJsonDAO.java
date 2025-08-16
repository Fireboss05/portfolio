package DAO.Json;

import DAO.CompetenceDAO;
import Model.Competence;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class CompetenceJsonDAO implements CompetenceDAO {

    private static final String JSON_KEY = "competences";
    private final String jsonPath;
    private final ServletContext context;

    public CompetenceJsonDAO(ServletContext context, String jsonPath) {
        this.context = context;
        this.jsonPath = jsonPath;
    }

    @Override
    public List<Competence> getAll() {
        try (InputStream input = context.getResourceAsStream(jsonPath)) {
            if (input == null) {
                throw new IOException("Fichier introuvable: " + jsonPath);
            }

            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(input);
            JsonNode competencesArray = root.get(JSON_KEY);

            return mapper.readValue(
                    competencesArray.toString(),
                    new TypeReference<List<Competence>>() {}
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Competence getByName(String name) {
        return getAll().stream()
                .filter(c -> c.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }
}
