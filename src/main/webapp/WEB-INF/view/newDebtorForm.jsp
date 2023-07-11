<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Jp
  Date: 20/06/2023
  Time: 12:01 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<c:url value="/home" var="linkServlet"/>
<html>
<head>
    <title>New Debtor</title>
</head>
    <body>
        <form method="post" action="${linkServlet}">
            <label for="id">Cellphone number</label>
            <input type="number" name="id" id="id">
            <label for="name">Name</label>
            <input type="text" name="name" id="name">
            <label for="user">User</label>
            <input type="text" name="user" id="user">
            <label for="password">Password</label>
            <input type="text" name="password" id="password">
            <input type="hidden" name="action" value="SignUp">
            <input type="submit">
        </form>
    </body>
</html>
