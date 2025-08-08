<%@ page import="java.util.ArrayList" %>
<%@ page import="Model.Experience" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%
    List<Experience> experiencesInfo;
    List<Experience> experiencesTierces;
    if (request.getAttribute("experiencesInfo") != null)
        experiencesInfo = (List<Experience>) request.getAttribute("experiencesInfo");
    else experiencesInfo = new ArrayList<>();
    if (request.getAttribute("experiencesTierces") != null)
        experiencesTierces = (List<Experience>) request.getAttribute("experiencesTierces");
    else experiencesTierces = new ArrayList<>();
%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Mon Parcours - Mon Portfolio</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

<%@ include file="includes/header.jsp" %>

<main>
    <h1>Mon Parcours</h1>

    <div class="timelines">
        <!-- Timeline 1 -->
        <div class="timeline">
            <h2>Expériences Info</h2>
            <ul>
                <%
                    for (Experience exp : experiencesInfo) {
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
                        <% if (exp.getCompetences() != null && !exp.getCompetences().isEmpty()) { %>
                        <div class="competence-slider">
                            <% for (Model.Competence comp : exp.getCompetences()) { %>
                            <a href="CompetenceControllerServlet?comp=<%= java.net.URLEncoder.encode(comp.getName(), "UTF-8") %>"
                               class="competence-badge">
                                <%= comp.getName() %>
                            </a>
                            <% } %>
                        </div>
                        <% } %>
                    </div>
                </li>
                <% } %>
            </ul>
        </div>

        <!-- Timeline 2 -->
        <div class="timeline">
            <h2>Expériences Tierces</h2>
            <ul>
                <%
                    for (Experience exp : experiencesTierces) {
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
                        <% if (exp.getCompetences() != null && !exp.getCompetences().isEmpty()) { %>
                        <div class="competence-slider">
                            <% for (Model.Competence comp : exp.getCompetences()) { %>
                            <a href="CompetenceControllerServlet?comp=<%= java.net.URLEncoder.encode(comp.getName(), "UTF-8") %>"
                               class="competence-badge">
                                <%= comp.getName() %>
                            </a>
                            <% } %>
                        </div>
                        <% } %>
                    </div>
                </li>
                <% } %>
            </ul>
        </div>
    </div>
</main>

<%@ include file="includes/footer.jsp" %>

</body>
</html>