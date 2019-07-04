<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="<c:url value="/webjars/bootstrap/4.3.1/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">
</head>
<body>

<form method="post">

    <div class="container">

        <header>Login</header>

        <div class="card">
            <div class="card-body">

                <div class="form-group">
                    <label for="usernameId">Username:</label>
                    <input type="text" name="email" id="usernameId" class="form-control">
                </div>

                <div class="form-group">
                    <label for="passwordId">Password:</label>
                    <input type="password" name="password" id="passwordId" class="form-control">
                </div>

                <c:if test="${isLogged == false}">
                    <div class="error">Login failed</div>
                    <br><br>
                </c:if>

                <input type="submit" value="Login" class="btn btn-primary">

            </div>
        </div>

    </div>

</form>
</body>
</html>
