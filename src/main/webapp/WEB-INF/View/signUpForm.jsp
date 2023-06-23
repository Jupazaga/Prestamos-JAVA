<%--
  Created by IntelliJ IDEA.
  User: Jp
  Date: 18/06/2023
  Time: 10:33 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Sign Up</title>
</head>
<body>
    <form method="post" action="${pageContext.request.contextPath}/SignUp">
        <label for="id">Cellphone number</label>
        <input type="number" id="id" name="id">
        <label for="name">Name</label>
        <input type="text" name="name" id="name">
        <label for="user">User</label>
        <input type="text" name="user" id="user">
        <label for="password">Password</label>
        <input type="text" name="password" id="password">
        <input type="submit">
    </form>
</body>
</html>
