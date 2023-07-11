<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Jp
  Date: 18/06/2023
  Time: 10:33 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<c:url value="/home" var="linkServlet"/>
<html>
<head>
    <title>Sign Up</title>
</head>
<body>
    <form method="post" action="${linkServlet}">
        <label for="id">Cellphone number</label>
        <input type="number" id="id" name="id">
        <label for="name">Name</label>
        <input type="text" id="name" name="name">
        <label for="user">User</label>
        <input type="text" id="user" name="user" >
        <label for="password">Password</label>
        <input type="text" id="password" name="password" >
        <input type="hidden" name="action" value="SignUp">
        <input type="submit">
    </form>
</body>
</html>
