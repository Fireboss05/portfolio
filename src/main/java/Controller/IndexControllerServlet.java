package Controller;

import DAO.*;
import DAO.Json.*;
import Model.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/indexController")
public class IndexControllerServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        switch(action) {
            case "about":
                about(request, response);
                break;
            case "experiences":
                experiences(request, response);
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

    private void experiences(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ExperienceDAO experienceDAO = new ExperienceJsonDAO(request.getServletContext(), "/data/experiences.json");
        CompetenceDAO competenceDAO = new CompetenceJsonDAO(request.getServletContext(), "/data/competences.json");
        ExperienceCompetenceDAO experienceCompetenceDAO = new ExperienceCompetenceJsonDAO(request.getServletContext(), "/data/competences_d_experience.json",experienceDAO, competenceDAO);

        List<Experience> experiences = experienceDAO.getAll();
        request.setAttribute("experiences", experiences);

        Map<Experience, List<ExperienceCompetence>> experiencesCompetences = new HashMap<>();
        for (Experience experience : experiences) {
            experiencesCompetences.put(experience, experienceCompetenceDAO.getByExperienceTitle(experience.getTitle()));
        }
        request.setAttribute("experiencesCompetences", experiencesCompetences);

        List<Competence> competences = new ArrayList<>();
        for (List<ExperienceCompetence> experienceCompetences : experiencesCompetences.values()) {
            for (ExperienceCompetence experienceCompetence : experienceCompetences) {
                if(!competences.contains(experienceCompetence.getC())) {
                    competences.add(experienceCompetence.getC());
                }
            }
        }
        request.setAttribute("competences", competences);

        request.getRequestDispatcher("views/experiences.jsp").forward(request, response);
    }

    private void projects(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Instanciation des DAO
        ProjectDAO projectDAO = new ProjectJsonDAO(request.getServletContext(), "/data/projets.json");
        CompetenceDAO competenceDAO = new CompetenceJsonDAO(request.getServletContext(), "/data/competences.json");
        ProjectCompetenceDAO projectCompetenceDAO = new ProjectCompetenceJsonDAO(
                request.getServletContext(),
                "/data/competences_de_projet.json",
                projectDAO,
                competenceDAO
        );

        // Récupérer tous les projets
        List<Project> projects = projectDAO.getAll();
        request.setAttribute("projects", projects);

        // Associer chaque projet à ses compétences
        Map<Project, List<ProjectCompetence>> projectsCompetences = new HashMap<>();
        for (Project project : projects) {
            projectsCompetences.put(project, projectCompetenceDAO.getByProjectTitle(project.getTitle()));
        }
        request.setAttribute("projectsCompetences", projectsCompetences);

        // Récupérer toutes les compétences uniques liées aux projets
        List<Competence> competences = new ArrayList<>();
        for (List<ProjectCompetence> projectCompetences : projectsCompetences.values()) {
            for (ProjectCompetence projectCompetence : projectCompetences) {
                if (!competences.contains(projectCompetence.getC())) {
                    competences.add(projectCompetence.getC());
                }
            }
        }
        request.setAttribute("competences", competences);

        // Forward vers la vue
        request.getRequestDispatcher("views/projects.jsp").forward(request, response);
    }

    private void competences(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // DAO pour compétences, projets, experience
        CompetenceDAO competenceDAO = new CompetenceJsonDAO(request.getServletContext(), "/data/competences.json");
        ProjectDAO projectDAO = new ProjectJsonDAO(request.getServletContext(), "/data/projets.json");
        ExperienceDAO experienceDAO = new ExperienceJsonDAO(request.getServletContext(), "/data/experiences.json");

        // DAO pour relations
        ExperienceCompetenceDAO expCompDAO = new ExperienceCompetenceJsonDAO(request.getServletContext(), "/data/competences_d_experience.json", experienceDAO, competenceDAO);
        ProjectCompetenceDAO projCompDAO = new ProjectCompetenceJsonDAO(request.getServletContext(), "/data/competences_de_projet.json", projectDAO, competenceDAO);

        // Récupération de toutes les compétences
        List<Competence> competences = competenceDAO.getAll();

        // Préparer les maps : Compétence -> Expériences / Projets
        Map<Competence, List<ExperienceCompetence>> competenceExperiences = new HashMap<>();
        Map<Competence, List<ProjectCompetence>> competenceProjects = new HashMap<>();

        for (Competence c : competences) {
            // Expériences liées à la compétence
            List<ExperienceCompetence> expComps = expCompDAO.getByCompetenceName(c.getName());
            if (expComps != null && !expComps.isEmpty()) {
                competenceExperiences.put(c, expComps);
            }

            // Projets liés à la compétence
            List<ProjectCompetence> projComps = projCompDAO.getByCompetenceName(c.getName());
            if (projComps != null && !projComps.isEmpty()) {
                competenceProjects.put(c, projComps);
            }
        }

        // Passage des données à la JSP
        request.setAttribute("competences", competences);
        request.setAttribute("competenceExperiences", competenceExperiences);
        request.setAttribute("competenceProjects", competenceProjects);

        // Forward vers la vue
        request.getRequestDispatcher("views/competences.jsp").forward(request, response);
    }

    private void contact(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("views/contact.jsp").forward(request, response);
    }

}
