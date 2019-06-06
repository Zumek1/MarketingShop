<%--
  Created by IntelliJ IDEA.
  User: zumek1
  Date: 05.06.19
  Time: 11:32
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

    <header>ALERT</header>

    <h1 style="font-weight:bold">UWAGA. Przekroczyłeś budżedt lub stan magazynu.</h1>
    <h3> Produkt nie został dodany do koszyka</h3>
</div>
</body>
</html>
