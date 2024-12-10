<%--
  Created by IntelliJ IDEA.
  User: Maha
  Date: 10/23/2024
  Time: 11:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css">
</head>
<body class="authpage">
<div class="container">
    <h1>Register</h1>

    <c:if test="${param.error != null}">
        <p class="error">${param.error}</p>
    </c:if>

    <c:if test="${param.message != null}">
        <p class="success">${param.message}</p>
    </c:if>

    <form action="${pageContext.request.contextPath}/auth/register" method="post">
        <label for="nom">Name:</label>
        <input type="text" id="nom" name="nom" required />

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required />

        <label for="motdepasse">Password:</label>
        <input type="password" id="motdepasse" name="motdepasse" required />

        <label for="adresse">Address:</label>
        <input type="text" id="adresse" name="adresse" required />

        <label for="telephone">Telephone:</label>
        <input type="tel" id="telephone" name="telephone" required />

        <button type="submit">Register</button>
    </form>
</div>
</body>
</html>
