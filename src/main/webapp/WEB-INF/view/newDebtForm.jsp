<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Jp
  Date: 20/06/2023
  Time: 1:02 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<c:url value="/home" var="linkServlet"/>
<html>
<head>
    <title>New Debt</title>
</head>
<body>
    <form method="post" action="${linkServlet}">
        <label for="id">Cellphone number</label>
        <input type="number" id="id" name="id" required >
        <label for="amount">Amount Borrowed</label>
        <input type="number" name="amount" id="amount" required>
        <label for="lastPayment"> Loan Date</label>
        <input type="date" name="lastPayment" id="lastPayment" required>
        <input type="hidden" name="action" value="NewDebt">
        <input type="submit">
    </form>
    <a href="home?action=SignUpForm">New debtor?</a>
</body>
</html>
