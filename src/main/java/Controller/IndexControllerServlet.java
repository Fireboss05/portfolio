package Controller;

import Model.Experience;
import Model.Project;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@WebServlet("/indexController")
public class IndexControllerServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        switch(action) {
            case "about":
                about(request, response);
                break;
            case "parcours":
                parcours(request, response);
                break;
            case "contact":
                contact(request, response);
                break;
            case "projects":
                projects(request, response);
                break;
            case "competences":
                competences(request, response);
                break;
            case "index":
            default:
                index(request, response);
                break;
        }
    }

    private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("views/index.jsp").forward(request, response);
    }

    private void about(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("views/about.jsp").forward(request, response);
    }

    private void parcours(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        InputStream input = getServletContext().getResourceAsStream("/data/experiences_informatiques.json");

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(input);
        JsonNode experiencesInformatiquesArray = root.get("experiences_informatiques");

        List<Experience> experiencesInfo = mapper.readValue(
                experiencesInformatiquesArray.toString(),
                new TypeReference<>() {
                }
        );

        request.setAttribute("experiencesInfo", experiencesInfo);

        input = getServletContext().getResourceAsStream("/data/experiences_tierces.json");

        mapper = new ObjectMapper();
        root = mapper.readTree(input);
        JsonNode experiencesTiercesArray = root.get("experiences_tierces");

        List<Experience> experiencesTierces = mapper.readValue(
                experiencesTiercesArray.toString(),
                new TypeReference<>() {
                }
        );

        request.setAttribute("experiencesTierces", experiencesTierces);

        request.getRequestDispatcher("views/parcours.jsp").forward(request, response);
    }



    private void projects(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        InputStream input = getServletContext().getResourceAsStream("/data/projets.json");

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(input);
        JsonNode projectArray = root.get("projects");

        List<Project> projects = mapper.readValue(
                projectArray.toString(),
                new TypeReference<>() {
                }
        );

        request.setAttribute("projects", projects);
        request.getRequestDispatcher("views/projects.jsp").forward(request, response);
    }

    private void competences(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("views/competences.jsp").forward(request, response);
    }

    private void contact(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("views/contact.jsp").forward(request, response);
    }

}
