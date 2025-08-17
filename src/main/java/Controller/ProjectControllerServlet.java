package Controller;

import DAO.ProjectDAO;
import DAO.Json.ProjectJsonDAO;
import Model.Project;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/projectController")
public class ProjectControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String projectName = request.getParameter("proj");

        // DAO pour les projets
        ProjectDAO projectDAO = new ProjectJsonDAO(request.getServletContext(), "data/projets.json");
        Project project = projectDAO.getByName(projectName);

        if (project == null) {
            // Si aucun projet trouvé → redirection vers la liste des projets
            response.sendRedirect(request.getServletContext().getContextPath() + "/indexController?action=projects");
        } else {
            // Passage du projet en attribut pour la JSP
            request.setAttribute("project", project);
            request.getRequestDispatcher("views/projects/" + project.getDetailFileName()).forward(request, response);
        }
    }
}
