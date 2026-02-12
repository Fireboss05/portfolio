<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>Git - Mon Portfolio</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

<%@ include file="/views/includes/header.jsp" %>

<main class="container">
  <h1>Git</h1>

  <p>
    J’ai significativement approfondi ma pratique de Git
    lors de mon stage chez Artefacts.
    Notamment pour l'utilisation de hooks, et d'autres fonctionnalités plus rarement utilisées de git.
  </p>

  <p>
    Je l’utilise également pour tous mes projets personnels.
    Je suis à l’aise avec la gestion de branches, les merges
    et une organisation propre de l’historique.
  </p>

  <p>
    Mon portfolio est lui-même versionné comme un projet professionnel. (Sans gestion de branches car je travaille sur une feature à la fois)
  </p>
</main>


<%@ include file="/views/includes/footer.jsp" %>

</body>
</html>
