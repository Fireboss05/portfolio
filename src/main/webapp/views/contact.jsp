<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Contact - Mon Portfolio</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <%@ include file="/views/includes/meta-robots.jsp" %>
</head>
<body>

<%@ include file="/views/includes/header.jsp" %>

<main>
    <h1>Contactez-moi</h1>

    <div class="contact-container">

        <div class="contact-item">
            <h2>Email</h2>
            <p>
                Pour toutes prises de contact : questions, offres d'emploi, collaborations ou autres demandes, vous pouvez m'envoyer un mail.
                Je m'efforce de répondre sous <strong>48h</strong> au maximum.
            </p>
            <p><a href="mailto:sachaterrasson@gmail.com" class="contact-link">sachaterrasson@gmail.com</a></p>
        </div>

        <div class="contact-item">
            <h2>LinkedIn</h2>
            <p>
                Vous pouvez également me contacter via LinkedIn. Je suis moins réactif que par mail, mais je reste ouvert aux messages et aux invitations professionnelles.
            </p>
            <p><a href="https://www.linkedin.com/in/sacha-terrasson-7a0879306" target="_blank" class="contact-link">Mon profil LinkedIn</a></p>
        </div>

        <div class="contact-item">
            <h2>GitHub</h2>
            <p>
                Mon GitHub contient tous mes projets, sérieux et moins sérieux. Ce n'est pas un GitHub professionnel, mais il permet de se faire une idée de mon travail.
                Les projets épinglés donnent un aperçu de la qualité que je peux fournir.
            </p>
            <p><a href="https://github.com/Fireboss05" target="_blank" class="contact-link">Mon GitHub</a></p>
        </div>

    </div>
</main>

<%@ include file="/views/includes/footer.jsp" %>

</body>
</html>
