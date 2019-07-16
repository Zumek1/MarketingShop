<%--
  Created by IntelliJ IDEA.
  User: zumek1
  Date: 17.05.19
  Time: 22:23
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
    <script type="text/JavaScript" src="/resources/js/popap.js"></script>
</head>
<body>
<%@include file="/WEB-INF/views/header.jspf" %>

<br>
<div class="container">

    <header>Products</header>
    <div class="card text-black bg-succes mb-3" style="max-width: 18rem;">
        <div class="card-header">
            Budżet
        </div>
        <div class="card-body text-black">
            ${userSession.budzet} PLN
        </div>

    </div>

    <div class="card mt-4">
        <div class="card-body">

            <table id="dtBasic" class="table table-hover">
                <tr>

                    <th>Nazwa produktu</th>
                    <th>Zdjęcie</th>
                    <th>Cena</th>
                    <th style="width:15%">Ilosc</th>
                    <th>Stan magazynowy</th>
                    <th style="width: 5%">Actions</th>
                </tr>

                <c:forEach items="${products}" var="product">
                    <form:form method="post" modelAttribute="orderItem">
                        <tr>
                            <form:hidden path="product.id" value="${product.id}"/>
                            <td>${product.name}</td>
                            <td><img style="height: 20%" src="${product.image}"></td>
                            <td>${product.price} PLN</td>
                            <td><form:input name="ilosc" typ="number" min="0" style="width: 30%" path="quantity"/></td>
                            <td>${product.magQuantity}</td>
                            <td>
                                <input type="submit" class="btn btn-success" data-toggle="modal"
                                       data-target="#exampleModal" value="Dodaj do koszyka"/>
                            </td>
                        </tr>
                    </form:form>
                </c:forEach>

            </table>
        </div>
    </div>
</div>
</body>
</html>
