<%--
  Created by IntelliJ IDEA.
  User: zumek1
  Date: 30.05.19
  Time: 12:59
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

    <header>Products</header>

    <div class="card mt-4">
        <div class="card-body">

            <iframe width="1140" height="541.25" src="https://app.powerbi.com/reportEmbed?reportId=944e0741-d9f9-4dba-8d96-50df7a02fb16&autoAuth=true&ctid=99fa0d61-fca7-403f-944e-76f881608825" frameborder="0" allowFullScreen="true"></iframe>


        </div>
    </div>
</div>
</body>
</html>
