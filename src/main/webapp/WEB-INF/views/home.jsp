<%--
  Created by IntelliJ IDEA.
  User: Maha
  Date: 10/22/2024
  Time: 11:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title>Assurance App</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/navbar.css">
</head>
<body>
<nav class="navbar">
  <div class="">
    <a href="${pageContext.request.contextPath}/home" >AssuranceApp</a>
    <ul class="nav-menu">
      <li><a href="">Assurance Auto</a></li>
      <li><a href="">Assurance Habitation</a></li>
      <li><a href="">Assurance Santé</a></li>
      <li>
        <form action="${pageContext.request.contextPath}/auth/logout" method="post" >
          <button type="submit" class="logout">Logout</button>
        </form>
      </li>
    </ul>
  </div>
</nav>


<!-- Cards Section -->
<div class="cards-container">
  <!-- Assurance Auto Card -->
  <div class="card">
    <img src="${pageContext.request.contextPath}/assets/images/assurance_auto1.jpg" alt="Assurance Auto" class="card-image">
    <div class="card-content">
      <h2>Assurance Auto</h2>
      <p>Protégez votre véhicule avec notre assurance auto complète, adaptée à tous les besoins.</p>
      <a href="${pageContext.request.contextPath}/assuranceauto/new" class="card-button">Voir Plus</a>
    </div>
  </div>

  <!-- Assurance Habitation Card -->
  <div class="card">
    <img src="${pageContext.request.contextPath}/assets/images/assurance_habitation2.jpg" alt="Assurance Habitation" class="card-image">
    <div class="card-content">
      <h2>Assurance Habitation</h2>
      <p>Protégez votre domicile avec notre assurance habitation, offrant une couverture complète.</p>
      <a href="${pageContext.request.contextPath}/assurancehabitation/new" class="card-button">Voir Plus</a>
    </div>
  </div>

  <!-- Assurance Santé Card -->
  <div class="card">
    <img src="${pageContext.request.contextPath}/assets/images/assurance_sante.jpg" alt="Assurance Santé" class="card-image">
    <div class="card-content">
      <h2>Assurance Santé</h2>
      <p>Optez pour notre assurance santé pour une couverture médicale complète.</p>
      <a href="${pageContext.request.contextPath}/assurancesante/new" class="card-button">Voir Plus</a>
    </div>
  </div>
</div>

</body>
</html>
