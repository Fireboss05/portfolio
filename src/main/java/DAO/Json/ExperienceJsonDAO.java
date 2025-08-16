package DAO.Json;

import DAO.ExperienceDAO;
import Model.Experience;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ExperienceJsonDAO implements ExperienceDAO {

    private static final String JSON_KEY = "experiences";

    private final String jsonPath;
    private final ServletContext context;


    public ExperienceJsonDAO(ServletContext context, String jsonPath) {
        this.context = context;
        this.jsonPath = jsonPath;
    }

    @Override
    public List<Experience> getAll() {
        try (InputStream input = context.getResourceAsStream(jsonPath)) {
            if (input == null) {
                throw new IOException("Fichier introuvable: " + jsonPath);
            }

            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(input);
            JsonNode experiencesArray = root.get(JSON_KEY);

            return mapper.readValue(
                    experiencesArray.toString(),
                    new TypeReference<List<Experience>>() {}
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Experience getByTitle(String title) {
        List<Experience> experiences = getAll();
        for (Experience experience : experiences) {
            if (experience.getTitle().equalsIgnoreCase(title)) {
                return experience;
            }
        }

        return null;
    }
}
