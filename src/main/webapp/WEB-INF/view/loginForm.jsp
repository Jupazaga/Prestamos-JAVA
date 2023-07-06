<%--
  Created by IntelliJ IDEA.
  User: Jp
  Date: 19/06/2023
  Time: 11:09 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <form method="post" action="${pageContext.request.contextPath}/Login">
        <label for="user">User:</label>
        <input type="text" name="user" id="user">
        <label for="password">Password:</label>
        <input type="text" name="password" id="password">
        <input type="submit">
    </form>
</body>
</html>
