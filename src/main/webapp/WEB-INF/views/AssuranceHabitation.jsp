<%--
  Created by IntelliJ IDEA.
  User: Maha
  Date: 10/24/2024
  Time: 10:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title> Assurance  Habitation</title>
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
  <h1>Ajouter une Assurance Habitation</h1>


  <form action="${pageContext.request.contextPath}/assurancehabitation/createhabitation" method="post">


    <div class="form-group">
      <label for="valeurBien">Valeur du Bien:</label>
      <input type="number" id="valeurBien" name="valeurBien" required>
    </div>


    <div class="form-group">
      <label for="typeLogement">Type de Logement:</label>
      <select id="typeLogement" name="typeLogement" required>
        <option value="">Sélectionner</option>
        <option value="appartement">Appartement</option>
        <option value="maison">Maison</option>
      </select>
    </div>


    <div class="form-group">
      <label for="systemeSecurite">Système de Sécurité:</label>
      <input type="checkbox" id="systemeSecurite" name="systemeSecurite">
    </div>


    <div class="form-group">
      <label for="localisation">Localisation:</label>
      <select id="localisation" name="localisationId" required>
        <option value="">Sélectionner une localisation</option>
        <c:forEach var="localisation" items="${localisations}">
          <option value="${localisation.id}">
              ${localisation.adresse} ${localisation.zoneRisques ? '(Zone à risques)' : ''}
          </option>
        </c:forEach>
      </select>

</div>

    <div class="form-group">
      <input type="submit" value="Ajouter Assurance Habitation">
    </div>
  </form>


  <c:if test="${not empty param.message}">
    <div class="message">${param.message}</div>
  </c:if>
</div>
</body>
</html>
