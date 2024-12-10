<%--
  Created by IntelliJ IDEA.
  User: Maha
  Date: 10/25/2024
  Time: 4:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Contrat Creation</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/contrat.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/navbar.css">
</head>
<body>
<nav class="navbar">
    <div class="container">
        <a href="${pageContext.request.contextPath}/home" class="nav-brand">AssuranceApp</a>
        <ul class="nav-menu">
            <li><a href="${pageContext.request.contextPath}/assuranceauto">Assurance Auto</a></li>
            <li><a href="${pageContext.request.contextPath}/assurancehabitation">Assurance Habitation</a></li>
            <li><a href="${pageContext.request.contextPath}/assurancesante">Assurance Santé</a></li>
            <li>
                <form action="${pageContext.request.contextPath}/auth/logout" method="post" style="display:inline;">
                    <button type="submit" class="logout">Logout</button>
                </form>
            </li>
        </ul>
    </div>
</nav>
<div class="container">
    <div class="row">
        <!-- Devis Details Card -->
        <div class="card details-card">
            <h2>Devis Details</h2>
            <p><strong>Type:</strong> ${contrat.devis.typeassurance}</p>
            <p><strong>Montant:</strong> ${contrat.devis.montant} DH</p>
            <p><strong>Date Created:</strong> ${contrat.devis.datecreation}</p>
        </div>


        <div class="card form-card">
            <h2>Create Contrat</h2>
            <p><strong>Date Debut:</strong> ${contrat.dateDebut}</p>

            <form action="${pageContext.request.contextPath}/contrat/save" method="post">
                <label for="dateFin">Date Fin:</label>
                <input type="date" id="dateFin" name="dateFin" required>

                <label for="fichier">Fichier:</label>
                <input type="text" id="fichier" name="fichier" placeholder="Document name or link" required>

                <button type="submit" class="submit-button">Create Contrat</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
