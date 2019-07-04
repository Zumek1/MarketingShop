<%--
  Created by IntelliJ IDEA.
  User: zumek1
  Date: 22.05.19
  Time: 21:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Title</title>
    <script src="<c:url value="/webjars/jquery/3.0.0/jquery.min.js"/>"></script>
    <script src="<c:url value="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"/>"></script>
    <link href="<c:url value="/webjars/bootstrap/4.3.1/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">
</head>
<body>
<%@include file="/WEB-INF/views/headerRKP.jspf" %>
<br>

<div class="container">
    <header>Lista przedstawicieli</header>
    <div class="card mt-3">
        <div class="card-body">

            <table class="table table-hover">
                <tr>
                    <th>Imię i Nazwisko</th>
                    <th>Budzet</th>
                    <th>Liczba nowych zamówień</th>
                    <th style="width: 30%">Akcja</th>
                </tr>

                <c:forEach items="${pms}" var="pms">
                    <c:set var="total" value="0"></c:set>

                    <c:forEach items="${orders}" var="order">
                        <c:if test="${order.przedstawicielMedyczny.id==(pms.id)&&order.status.equals('New order')}">
                            <c:set var="total" value="${total+1}"></c:set>
                        </c:if>
                    </c:forEach>


                    <tr>
                        <td>${pms.firstName} ${pms.lastName}</td>
                        <td>${pms.budzet} PLN</td>
                        <td>${total}</td>
                        <td>
                            <a href="${pms.id}/orderList" class="btn btn-success">Zamówienia</a>
                            <a href="${pms.id}/message" class="btn btn-primary">Wiadomość</a>
                        </td>
                    </tr>
                </c:forEach>

            </table>
        </div>
    </div>
</div>
</body>
</html>
