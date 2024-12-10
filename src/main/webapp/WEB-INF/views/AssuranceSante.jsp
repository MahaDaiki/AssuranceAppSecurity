<%--
  Created by IntelliJ IDEA.
  User: Maha
  Date: 10/24/2024
  Time: 4:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ajouter une Assurance Santé</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/assuranceStyle.css">
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
    <h1>Ajouter une Assurance Santé</h1>

    <form action="${pageContext.request.contextPath}/assurancesante/createsante" method="post">

        <div class="form-group">
            <label for="age">Âge:</label>
            <input type="number" id="age" name="age" required>
        </div>


        <div class="form-group">
            <label for="etatSante">État de Santé:</label>
            <input type="text" id="etatSante" name="etatSante" required>
        </div>

        <div class="form-group">
            <label for="maladieChronique">Maladie Chronique:</label>
            <input type="checkbox" id="maladieChronique" name="maladieChronique" value="true">
            <label for="maladieChronique">Oui</label>
        </div>

        <div class="form-group">
            <label for="typeDeCouverture">Type de Couverture:</label>
            <select id="typeDeCouverture" name="typeDeCouverture" required>
                <option value="basic">Basic</option>
                <option value="premium">Premium</option>
            </select>
        </div>

        <!-- Submit Button -->
        <div class="form-group">
            <input type="submit" value="Ajouter Assurance Santé">
        </div>
    </form>

    <!-- Display Success Message -->
    <c:if test="${not empty param.message}">
        <div class="message">${param.message}</div>
    </c:if>
</div>
</body>
</html>
