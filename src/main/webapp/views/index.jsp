<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Accueil - Mon Portfolio</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <%@ include file="/views/includes/meta-robots.jsp" %>
</head>
<body>

<%@ include file="/views/includes/header.jsp" %>

<main class="welcome">
    <section class="intro container">
        <h1>Bienvenue sur mon portfolio</h1>
        <p>
            Ce site a pour objectif de vous présenter mes projets, mes expériences et mes compétences de manière plus complète qu’un CV traditionnel.
            Ici, vous découvrirez ce que j’ai créé, appris et expérimenté, tant dans le cadre scolaire que personnel.
        </p>
    </section>

    <section class="projects-intro container">
        <h2>Mes projets</h2>
        <p>
            Vous trouverez ici mes projets personnels et scolaires qui me tiennent à cœur. Chacun illustre non seulement mes centres d’intérêt,
            mais aussi les compétences techniques et méthodologiques que j’ai développées. Les codes sources sont disponibles, et ce site lui-même a été conçu comme un projet professionnel : un historique complet des commits est consultable sur GitHub.
        </p>
    </section>

    <section class="experience-intro container">
        <h2>Mes expériences</h2>
        <p>
            Au-delà des projets, j’ai accumulé diverses expériences professionnelles, associatives et même des petits boulots, qui m’ont permis de développer des compétences concrètes et une approche pratique des situations réelles.
            Ce site permet de les mettre en avant de manière complémentaire à mon profil LinkedIn.
        </p>
    </section>

    <section class="tech-intro container">
        <h2>Comment ce site a été construit</h2>
        <p>
            Ce site est développé en Java avec JakartaEE, en suivant des schémas de conception classiques tels que DAO et MVC.
            La base de données est organisée à l’aide de fichiers JSON.
            Cela reflète mon goût pour le travail bien fait.
            <br><br>
            Par ailleurs, je l'ai conçu de manière à ce qu'il soit fonctionnel sur téléphone, mais c'est imparfait de par mon manque de compétences.
            J'envisage aussi de le rendre accessible aux personnes atteintes de cécité autant que possible, et toutes formes de handicap.
            Il ne contient ni sons ni palette de couleurs rapprochées, donc il devrait déja atteindre une vaste audience.
        </p>
    </section>

    <section class="about-intro container">
        <h2>À propos</h2>
        <p>
            Cette section vous permet de mieux comprendre ma personnalité et mes motivations, sans prétention et sans cacher qui je suis.
            Mon objectif est de partager ce que j’aime faire et ce que j’ai appris, à travers mes projets et mes expériences.
        </p>
    </section>

    <section class="closing container">
        <p>Bonne visite, et merci de prendre le temps de découvrir mon univers !</p>
    </section>
</main>

<%@ include file="/views/includes/footer.jsp" %>

</body>
</html>
