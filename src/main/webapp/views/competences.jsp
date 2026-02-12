<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.nio.charset.StandardCharsets" %>
<%@ page import="Model.*" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<% List<Competence> competences = (List<Competence>) request.getAttribute("competences");
    Map<Competence, List<DisplayableCompetence>> competenceDisplays =
            (Map<Competence, List<DisplayableCompetence>>) request.getAttribute("competenceDisplays");

    if (competences == null) competences = new ArrayList<>();
    if (competenceDisplays == null) competenceDisplays = new HashMap<>();
%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Mes Compétences - Mon Portfolio</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <%@ include file="/views/includes/meta-robots.jsp" %>
</head>
<body>

<%@ include file="/views/includes/header.jsp" %>

<main>
    <h1>Mes Compétences</h1>

    <div class="competence-list">
        <%
            for (Competence comp : competences) {
        %>
        <div class="competence-item">
            <h2><a href="competenceController?comp=<%= URLEncoder.encode(comp.getName(), StandardCharsets.UTF_8) %>"><%= comp.getName() %></a></h2>
            <ul>
                <%
                    List<DisplayableCompetence> dispComps = competenceDisplays.get(comp);
                    if (dispComps != null) {
                        for (DisplayableCompetence dc : dispComps) {
                %>
                <li>
                    <span class="level-label">Niveau:</span> <%= dc.getLevel() %>
                    (<%= dc.getDisplayType() %> : <%= dc.getDisplayTitle() %>)
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

<%@ include file="/views/includes/footer.jsp" %>

</body>
</html>