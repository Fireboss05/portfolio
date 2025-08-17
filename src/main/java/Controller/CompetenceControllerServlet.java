package Controller;

import DAO.CompetenceDAO;
import DAO.Json.CompetenceJsonDAO;
import Model.Competence;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/competenceController")
public class CompetenceControllerServlet  extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String compName = request.getParameter("comp");

        //get the comp
        CompetenceDAO competenceDAO = new CompetenceJsonDAO(request.getServletContext(), "data/competences.json");
        Competence comp = competenceDAO.getByName(compName);

        if (comp == null) {
            response.sendRedirect(request.getServletContext().getContextPath() + "/indexController?action=competences");
        }else{
            request.setAttribute("comp", comp);
            request.getRequestDispatcher("views/competences/" + comp.getDetailFileName()).forward(request, response);
        }
    }
}
