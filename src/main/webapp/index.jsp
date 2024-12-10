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
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Assurance App</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/indexstyle.css">
</head>
<body>
<header>
    <nav class="navbar">
        <div class="navbar-container">
            <a href="${pageContext.request.contextPath}/" class="navbar-logo">Assurance App</a>
            <ul class="navbar-links">
                <li><a href="${pageContext.request.contextPath}/auth/login">Login</a></li>
                <li><a href="${pageContext.request.contextPath}/auth/register">Register</a></li>
            </ul>
        </div>
    </nav>
</header>

<main>
    <div class="image-container">
        <img src="${pageContext.request.contextPath}/assets/images/Assueance_Habitation1.png" alt="Assurance Image">
    </div>
    <h1>${message}</h1>
</main>

<footer>
    <p>&copy; 2024 Assurance App. All rights reserved.</p>
</footer>
</body>
</html>
