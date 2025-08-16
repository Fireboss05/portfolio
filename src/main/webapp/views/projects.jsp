<%@ page import="Model.Project" %>
<%@ page import="Model.Vignette" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Model.ProjectCompetence" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<% List<Project> projects = (List<Project>) request.getAttribute("projects");
    Map<Project, List<ProjectCompetence>> projectsCompetences =
            (Map<Project, List<ProjectCompetence>>) request.getAttribute("projectsCompetences");

    if (projects == null) projects = new java.util.ArrayList<>();
    if (projectsCompetences == null) projectsCompetences = new java.util.HashMap<>();
%>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Mes Projets - Mon Portfolio</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

<%@ include file="includes/header.jsp" %>

<main>
    <section class="projects container">
        <h2>Mes Projets</h2>
        <div class="projects-grid">
            <% for(Project project : projects) { %>
            <div class="project-card">
                <%Vignette vignette = project.getVignette();%>
                <div class="card-normal">
                    <div class="image-wrapper">
                        <img src="${pageContext.request.contextPath}/<%=vignette!=null?vignette.getImagePath():project.getImagePath()%>"
                             alt="<%=vignette!=null?vignette.getTitle():project.getTitle()%>"/>
                    </div>
                    <div class="project-desc">
                        <h3><%=vignette!=null?vignette.getTitle():project.getTitle()%></h3>
                        <p><%=vignette!=null?vignette.getDescription():project.getDescription()%></p>
                    </div>
                </div>
                <div class="card-zoom">
                    <div class="image-wrapper">
                        <img src="${pageContext.request.contextPath}/<%=project.getImagePath()%>"
                             alt="<%=project.getTitle()%>"/>
                    </div>
                    <div class="project-desc">
                        <h3><%=project.getTitle()%></h3>
                        <p><%=project.getDescription()%></p>
                    </div>
                </div>
            </div>
            <%}%>
    </section>
</main>

<%@ include file="includes/footer.jsp" %>

</body>
</html>