<%@ page import="java.util.ArrayList" %>
<%@ page import="Model.Experience" %>
<%@ page import="java.util.List" %>
<%@ page import="Model.ExperienceCompetence" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%
    List<Experience> experiences = (List<Experience>) request.getAttribute("experiences");
    Map<Experience, List<ExperienceCompetence>> experiencesCompetences =
            (Map<Experience, List<ExperienceCompetence>>) request.getAttribute("experiencesCompetences");

    if (experiences == null) experiences = new java.util.ArrayList<>();
    if (experiencesCompetences == null) experiencesCompetences = new java.util.HashMap<>();
%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Mon Parcours - Mon Portfolio</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

<%@ include file="/views/includes/header.jsp" %>

<main>
    <h1>Mon Parcours</h1>

    <div class="timelines">
        <!-- Timeline 1 -->
        <div class="timeline">
            <h2>Expériences en Informatique</h2>
            <ul>
                <%
                    for (Experience exp : experiences) {
                        if (exp.getType().equalsIgnoreCase("info")) {
                %>
                <li>
                    <div class="timeline-marker"></div>
                    <div class="timeline-content">
                        <h3><%= exp.getTitle() %> - <%= exp.getCompany() %></h3>
                        <p class="timeline-date">
                            <%= exp.getStart_date() %> → <%= exp.getEnd_date() %> • <%= exp.getCity() %>, <%= exp.getCountry() %>
                        </p>
                        <p><strong><%= exp.getContract_type() %></strong></p>
                        <ul>
                            <% for (String mission : exp.getMissions()) { %>
                            <li><%= mission %></li>
                            <% } %>
                        </ul>
                        <%
                            List<ExperienceCompetence> compList = experiencesCompetences.get(exp);
                            if (compList != null && !compList.isEmpty()) {
                        %>
                        <div class="competence-slider">
                            <% for (ExperienceCompetence expComp : compList) { %>
                            <a href="competenceController?comp=<%= java.net.URLEncoder.encode(expComp.getC().getName(), "UTF-8") %>"
                               class="competence-badge">
                                <%= expComp.getC().getName() %> (<%= expComp.getLevel() %>)
                            </a>
                            <% } %>
                        </div>
                        <% } %>
                    </div>
                </li>
                <%     }
                }
                %>
            </ul>
        </div>

        <!-- Timeline 2 -->
        <div class="timeline">
            <h2>Expériences Tierces</h2>
            <ul>
                <%
                    for (Experience exp : experiences) {
                        if (exp.getType().equalsIgnoreCase("tierce")) {
                %>
                <li>
                    <div class="timeline-marker"></div>
                    <div class="timeline-content">
                        <h3><%= exp.getTitle() %> - <%= exp.getCompany() %></h3>
                        <p class="timeline-date">
                            <%= exp.getStart_date() %> → <%= exp.getEnd_date() %> • <%= exp.getCity() %>, <%= exp.getCountry() %>
                        </p>
                        <p><strong><%= exp.getContract_type() %></strong></p>
                        <ul>
                            <% for (String mission : exp.getMissions()) { %>
                            <li><%= mission %></li>
                            <% } %>
                        </ul>
                        <%
                            List<ExperienceCompetence> compList = experiencesCompetences.get(exp);
                            if (compList != null && !compList.isEmpty()) {
                        %>
                        <div class="competence-slider">
                            <% for (ExperienceCompetence expComp : compList) { %>
                            <a href="competenceController?comp=<%= java.net.URLEncoder.encode(expComp.getC().getName(), "UTF-8") %>"
                               class="competence-badge">
                                <%= expComp.getC().getName() %> (<%= expComp.getLevel() %>)
                            </a>
                            <% } %>
                        </div>
                        <% } %>
                    </div>
                </li>
                <%     }
                }
                %>
            </ul>
        </div>
    </div>
</main>

<%@ include file="/views/includes/footer.jsp" %>

</body>
</html>
