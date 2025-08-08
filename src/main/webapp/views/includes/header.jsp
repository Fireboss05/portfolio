<%@ page contentType="text/html;charset=UTF-8" %>
<header>
    <nav>
        <a href="<%=request.getContextPath()%>/indexController?action=index">Accueil</a>
        <a href="<%=request.getContextPath()%>/indexController?action=about">À propos</a>
        <a href="<%=request.getContextPath()%>/indexController?action=parcours">Mon Parcours</a>
        <a href="<%=request.getContextPath()%>/indexController?action=projects">Mes projets</a>
        <a href="<%=request.getContextPath()%>/indexController?action=competences">Mes Compétences</a>
        <a href="<%=request.getContextPath()%>/indexController?action=contact">Contact</a>
    </nav>
</header>


