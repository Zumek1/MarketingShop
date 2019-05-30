<%--
  Created by IntelliJ IDEA.
  User: zumek1
  Date: 26.05.19
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Title</title>
</head>
<body>


<p>TEST</p>
<c:forEach items="${cart}" var="items">

        <tr>

            <td>${items.quantity} </td>
            <td>${items.product.name} </td>
            <td>${items.amount} PLN  </td>


        </tr>

</c:forEach>

</body>
</html>
