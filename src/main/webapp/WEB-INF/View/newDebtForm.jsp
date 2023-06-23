<%--
  Created by IntelliJ IDEA.
  User: Jp
  Date: 20/06/2023
  Time: 1:02 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>New Debt</title>
</head>
<body>
    <form method="post" action="${pageContext.request.contextPath}/NewDebt">
        <label for="id">Cellphone number</label>
        <input type="number" id="id" name="id" required >
        <label for="debt">Amount Borrowed</label>
        <input type="number" name="total_debt" id="debt" required>
        <label for="lastPayment"> Loan Date</label>
        <input type="date" name="lastPayment" id="lastPayment" required>
        <input type="submit">
    </form>
</body>
</html>
