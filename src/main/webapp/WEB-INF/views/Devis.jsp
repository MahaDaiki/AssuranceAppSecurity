<%--
  Created by IntelliJ IDEA.
  User: Maha
  Date: 10/25/2024
  Time: 12:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Devis Details</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css">
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
<h1>Devis Details</h1>
<p>Type: ${devis.typeassurance}</p>
<p>Montant: ${devis.montant}  DH</p>
<p>Date de création: ${devis.datecreation}</p>




<form action="${pageContext.request.contextPath}/devis/accept" method="post">
    <button type="submit">Accepter Devis</button>
</form>

<form action="${pageContext.request.contextPath}/devis/decline" method="post">
    <button type="submit">Décliner Devis</button>
</form>

<a href="${pageContext.request.contextPath}/home">Retour à l'accueil</a>
</body>
</html>
