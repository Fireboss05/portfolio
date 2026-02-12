<%@ page contentType="text/html;charset=UTF-8"  %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Java - Mon Portfolio</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <%@ include file="/views/includes/meta-robots.jsp" %>
</head>
<body>

<%@ include file="/views/includes/header.jsp" %>

<main class="container">
    <h1>Java</h1>

    <p>
        J’ai appris Java en complètement de manière autonome avant qu’il ne devienne
        un langage central dans mon cursus. Il m’a ensuite été régulièrement imposé en cours,
        ce qui m’a permis de le pratiquer en profondeur.
    </p>

    <p>
        Aujourd’hui, je suis très à l’aise avec Java. J’apprécie sa structure,
        sa rigueur et son organisation. C’est un langage qui correspond bien
        à ma manière de penser et de concevoir des projets.
        Evidemment, je sais aussi que ce n'est pas le meilleur langage pour beaucoup de tâches.
    </p>

    <p>
        Mon portfolio est d’ailleurs développé en Java avec JakartaEE,
        en respectant une architecture MVC et DAO.
    </p>
</main>


<%@ include file="/views/includes/footer.jsp" %>

</body>
</html>
