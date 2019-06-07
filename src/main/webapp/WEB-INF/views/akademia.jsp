<%--
  Created by IntelliJ IDEA.
  User: zumek1
  Date: 07.06.19
  Time: 12:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<<head>
    <title>Title</title>
    <script src="<c:url value="/webjars/jquery/3.0.0/jquery.min.js"/>"></script>
    <script src="<c:url value="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"/>"></script>
    <link href="<c:url value="/webjars/bootstrap/4.3.1/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/ulotka.css"/>" rel="stylesheet">
    <script type="text/JavaScript" src="/resources/js/popap.js"></script>
</head>
<body>
<%@include file="/WEB-INF/views/header.jspf"%>


<div class="container">
    <header>Materiały szkoleniowe</header>
    <div class="linki">
        <a href="javascript:void(0)" id="ulotkaVisible">
            <image width="10%" src="/resources/images/FilmLink2.PNG"></image>
        </a>
    </div>

    <div class = "ulotka">
        <object data="/resources/images/POLHUMIN_ulotka_ABC_08_2018_DRUK.PDF" width="100%" height="800">
            <a href="/resources/images/POLHUMIN_ulotka_ABC_08_2018_DRUK.PDF">Pobierz plik</a>
        </object>
    </div>
</div>

</body>
</html>
