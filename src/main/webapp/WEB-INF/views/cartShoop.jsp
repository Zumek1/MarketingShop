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
                        <tr>
                            <td>${items.product.name}</td>
                            <td>${items.quantity}</td>
                            <td>${items.amount}</td>
                            <td>
                                <input type="submit" class="btn btn-success" value="Dodaj do koszyka"/>
                            </td>
                        </tr>
                </c:forEach>

            </table>
        </div>
    </div>
</div>
</html>
