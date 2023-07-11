<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Jp
  Date: 20/06/2023
  Time: 11:32 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<c:url value="/home" var="linkServlet"/>
<html>
<head>
    <title>Home</title>
</head>
<body>
 <h1>Home</h1>
 <ul>
     <c:forEach items="${debts}" var="debt">
         <li>
             ${debt.lender} - ${debt.debtor}
         </li>
     </c:forEach>
 </ul>

 <a href="${linkServlet}?action=NewDebtForm">New Debt</a>
</body>
</html>
