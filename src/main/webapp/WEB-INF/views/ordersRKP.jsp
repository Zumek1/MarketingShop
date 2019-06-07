<%--
  Created by IntelliJ IDEA.
  User: zumek1
  Date: 05.06.19
  Time: 23:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Historia Zamówień</title>
    <script src="<c:url value="/webjars/jquery/3.0.0/jquery.min.js"/>"></script>
    <script src="<c:url value="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"/>"></script>
    <link href="<c:url value="/webjars/bootstrap/4.3.1/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">
</head>
<body>
<%@include file="/WEB-INF/views/headerRKP.jspf"%>
<br>
<br>
<div class="container">

    <div class="card mt-4">
        <div class="card-body">

            <table class="table table-hover">
                <tr>

                    <th style="width:10%">Id zamówienia</th>
                    <th>Data</th>
                    <th>Wartość</th>
                    <th style="width:15%">Status </th>
                    <th style="width: 30%">Actions</th>
                </tr>

                <c:forEach items="${orders}" var="order">

                    <tr>
                        <td>${order.id}</td>
                        <td>${order.created}</td>
                        <td>${order.totalAmount} PLN</td>
                        <td >${order.status}</td>
                        <form:form method="post" modelAttribute="order">
                        <td>
                            <form:hidden path="id" value="${order.id}"/>
                            <a href="${order.id}/orderDetails" class="btn btn-success">Szczegóły</a>
                            <input type="submit" class="btn btn-primary" name="action" value="Akcept"/>
                            <input type="submit" class="btn btn-danger" name="action" value="Odrzuć"/>
                        </td>
                        </form:form>
                    </tr>
                </c:forEach>

            </table>
        </div>
    </div>
</div>

</body>
</html>
