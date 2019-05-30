<%--
  Created by IntelliJ IDEA.
  User: zumek1
  Date: 15.05.19
  Time: 09:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Title</title>
    <link href="<c:url value="/webjars/bootstrap/4.3.1/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">
</head>
<body>
<div class="jumbotron text-center">
    <h1 align="center"> Zaloguj się do systemu.</h1>
    <h1 align="center"> Wybierz odpowiednią grupę poniżej.</h1>
</div>
<div class="card-group">
    <div class="card">
        <img src="resources/images/avatar.png" class="card-img-top" style="width:30%">
        <div class="card-body">
            <h5 class="card-title">Przedstawiciel Medyczny</h5>
            <p class="card-text">Miejsce logowania dla Przedstawicieli Medycznych.</p>
            <a href="/pm/login" class="btn btn-success">Zaloguj</a>
        </div>
    </div>
    <div class="card">
        <img src="resources/images/avatar.png" class="card-img-top" style="width:30%">
        <div class="card-body">
            <h5 class="card-title">Regionalny Koordynator Promocji</h5>
            <p class="card-text">Miejsce logowania dla RKP.</p>
            <a href="/rkp/login" class="btn btn-success">Zaloguj</a>
        </div>
    </div>
    <div class="card">
        <img src="resources/images/avatar.png" class="card-img-top" style="width:30%">
        <div class="card-body">
            <h5 class="card-title">Pracownik Magazynu</h5>
            <p class="card-text">Logowanie dla pracownika magazynu.</p>
            <a href="mag/login" class="btn btn-success">Zaloguj</a>
        </div>
    </div>
</div>

</body>
</html>
