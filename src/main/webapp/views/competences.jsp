<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="Model.*" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<% List<Competence> competences = (List<Competence>) request.getAttribute("competences");
    Map<Competence, List<ExperienceCompetence>> competenceExperiences =
            (Map<Competence, List<ExperienceCompetence>>) request.getAttribute("competenceExperiences");
    Map<Competence, List<ProjectCompetence>> competenceProjects =
            (Map<Competence, List<ProjectCompetence>>) request.getAttribute("competenceProjects");

    if (competences == null) competences = new ArrayList<>();
    if (competenceExperiences == null) competenceExperiences = new HashMap<>();
    if (competenceProjects == null) competenceProjects = new HashMap<>();
%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Mes Compétences - Mon Portfolio</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

<%@ include file="includes/header.jsp" %>

<main>
    <h1>Mes Compétences</h1>

    <div class="competence-list">
        <%
            for (Competence comp : competences) {
        %>
        <div class="competence-item">
            <h2><%= comp.getName() %></h2>
            <ul>
                <%
                    List<ExperienceCompetence> expComps = competenceExperiences.get(comp);
                    if (expComps != null) {
                        for (ExperienceCompetence ec : expComps) {
                            Experience e = ec.getE();
                %>
                <li>
                    <span class="level-label">Niveau:</span> <%= ec.getLevel() %>
                    (Expérience : <%= e.getTitle() %>)
                </li>
                <%
                        }
                    }

                    List<ProjectCompetence> projComps = competenceProjects.get(comp);
                    if (projComps != null) {
                        for (ProjectCompetence pc : projComps) {
                            Project p = pc.getP();
                %>
                <li>
                    <span class="level-label">Niveau:</span> <%= pc.getLevel() %>
                    (Projet : <%= p.getTitle() %>)
                </li>
                <%
                        }
                    }
                %>
            </ul>
            <hr>
        </div>
        <% } %>
    </div>


</main>

<%@ include file="includes/footer.jsp" %>

</body>
</html>