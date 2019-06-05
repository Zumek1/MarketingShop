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
    <script src="<c:url value="/webjars/jquery/3.0.0/jquery.min.js"/>"></script>
    <script src="<c:url value="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"/>"></script>
    <link href="<c:url value="/webjars/bootstrap/4.3.1/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">
</head>
<body>
<%@include file="/WEB-INF/views/header.jspf"%>


<div class="container">

    <header>Cart Products</header>

    <div class="card inline text-black bg-succes mb-3" style="max-width: 18rem;">
        <div class="card-header">
            Budżet
        </div>
        <div class="card-body text-black">
            ${userSession.budzet} PLN
        </div>

        <div class="card-header">
            Łączna wartość zamówienia
        </div>
        <div class="card-body text-black">
            <c:set var="total" value="0"></c:set>
        <c:forEach items="${cart}" var="items">
            <c:set var="total" value="${total+items.amount}"></c:set>
        </c:forEach>
            <tr>${total} PLN</tr>
            <form:form method="post" modelAttribute="order" action="/ordersHistory">
                <form:hidden path="totalAmount" value="${total}"></form:hidden>
            <tr> <input type="submit" name="addOrder" value="Zamów" style="float:right" class="btn btn-primary btn-small"></input></tr>
            </form:form>
        </div>

    </div>



    </div>

    <div class="card mt-4">
        <div class="card-body">

            <table class="table table-hover">
                <tr>

                    <th>Nazwa produktu</th>
                    <th>Ilosc</th>
                    <th>Wartosc</th>
                    <th style="width: 5%">Actions</th>
                </tr>

                <c:forEach items="${cart}" var="items">
                    <form:form method="post" modelAttribute="orderItem" action="/cart">
                        <tr>
                            <form:hidden path="product.id" value="${items.product.id}"/>
                            <td>${items.product.name}</td>
                            <td>${items.quantity}</td>
                            <td>${items.amount} PLN</td>
                            <td>
                                <input type="submit" class="btn btn-danger" value="Usuń"/>
                            </td>
                        </tr>
                    </form:form>
                </c:forEach>

            </table>
        </div>

    </div>
</div>
</html>
