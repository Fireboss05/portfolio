<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>A Propos - Mon Portfolio</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <%@ include file="/views/includes/meta-robots.jsp" %>
</head>
<body>

<%@ include file="/views/includes/header.jsp" %>

<main class="container">
    <h1>A Propos</h1>

    <section>
        <h2>Présentation</h2>
        <p>
            Je suis étudiant en dernière année d’école d’ingénieur en informatique, animé par une curiosité profonde
            pour le fonctionnement interne des systèmes. Ce qui me motive n’est pas uniquement de développer des
            applications, mais de comprendre comment elles fonctionnent à un niveau fondamental :
            <a href="competenceController?comp=Algorithmes">algorithmes</a>,
            structures de données, gestion mémoire, performance et architecture logicielle.
        </p>

        <p>
            Au fil de mes études et de mes projets personnels comme
            <a href="projectController?proj=ia_backgammon">IA Backgammon</a>,
            <a href="projectController?proj=processeur">Architecture de processeur</a> ou
            <a href="projectController?proj=compilateur">Compilateur</a>,
            j’ai développé une affinité forte pour les problématiques techniques exigeantes :
            modélisation, optimisation, simulation et conception d’outils.
        </p>
    </section>

    <section>
        <h2>Projet professionnel</h2>

        <p>
            Mon projet professionnel s’oriente vers des environnements à forte intensité technique :
            développement bas niveau en <a href="competenceController?comp=C++/C">C/C++</a>,
            conception de moteurs, outils systèmes, optimisation de performance et R&D.
        </p>

        <p>
            Je suis davantage attiré par la conception d’architectures robustes et d’outils techniques
            que par le développement purement applicatif. Comprendre les mécanismes internes d’un moteur,
            d’un compilateur ou d’un système me stimule davantage que l’implémentation de fonctionnalités visibles.
        </p>

        <p>
            À long terme, je me projette dans des environnements d’ingénierie avancée ou de R&D,
            où la rigueur, la performance et la réflexion algorithmique sont centrales.
        </p>
    </section>

    <section>
        <h2>Compétences techniques</h2>

        <p>
            Je travaille principalement avec
            <a href="competenceController?comp=Java">Java</a>,
            <a href="competenceController?comp=C++/C">C/C++</a>,
            <a href="competenceController?comp=Python">Python</a>,
            et m’intéresse particulièrement aux problématiques d’
            <a href="competenceController?comp=Algorithmes">algorithmes</a>,
            d’optimisation et d’analyse de complexité.
        </p>

        <p>
            Mon portfolio lui-même est développé en
            <a href="competenceController?comp=Java">Java</a> avec
            <a href="competenceController?comp=JakartaEE">JakartaEE</a>,
            en suivant une architecture MVC avec DAO et une base organisée en fichiers JSON
            (voir le projet <a href="projectController?proj=portfolio">Portfolio</a>).
        </p>
    </section>

    <section>
        <h2>Centres d’intérêt techniques</h2>

        <h3>Comprendre “comment ça marche”</h3>
        <p>
            Je consacre beaucoup de temps à explorer le fonctionnement interne des systèmes :
            processeurs, compilateurs, architectures mémoire, moteurs.
            La compréhension fine d’un mécanisme technique me motive plus que son simple usage.
        </p>

        <h3>Simulation et génération</h3>
        <p>
            Les projets comme
            <a href="projectController?proj=julia_projet_Julia">Fractales de Julia</a>,
            <a href="projectController?proj=mandelbrot_projet_MandelbrotFin">Ensemble de Mandelbrot</a> ou
            <a href="projectController?proj=automates_cellulaires">Automates Cellulaires</a>
            illustrent mon intérêt pour la simulation, la modélisation et les systèmes dynamiques.
        </p>

        <h3>Outils et systèmes</h3>
        <p>
            Lors de mon stage en tant qu’
            <a href="indexController?action=experiences"><strong>Ingénieur Développement d’Outils</strong></a>,
            j’ai développé des outils internes en
            <a href="competenceController?comp=Python">Python</a> et pour l’environnement
            <a href="competenceController?comp=Windows">Windows</a>.
            Cette expérience a renforcé mon intérêt pour les outils techniques et les systèmes robustes.
            En plus de m'avoir conforté dans ce que je voulais faire plus tard :
            travailler dans un domaine plus exigeant techniquement.
        </p>
    </section>

    <section>
        <h2>Ce qui me caractérise</h2>
        <ul>
            <li>Curiosité intellectuelle forte</li>
            <li>Goût pour la complexité technique</li>
            <li>Recherche de rigueur et de performance</li>
            <li><a href="competenceController?comp=Autonomie">Autonomie</a></li>
            <li><a href="competenceController?comp=Organisation">Organisation</a></li>
            <li><a href="competenceController?comp=Travail en Groupe">Travail en groupe</a></li>
        </ul>

        <p>
            Je suis davantage attiré par la profondeur technique que par l’effet visuel immédiat.
            J’aime les défis où la solution demande réflexion, modélisation et optimisation.
        </p>
    </section>

</main>

<%@ include file="/views/includes/footer.jsp" %>

</body>
</html>