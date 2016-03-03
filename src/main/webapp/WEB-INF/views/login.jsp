<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Sign in </title>
    <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/signin.css"/>" rel="stylesheet">

</head>
<body>
<c:url var="loginUrl" value="/login"/>
<div class="container">
    <form action="${loginUrl}" method="post" class="form-signin">
        <h2 class="form-signin-heading text-center">Please sign in</h2>
        <label for="j_username" class="sr-only">Email address</label>
        <input type="text" id="j_username" name="j_username" class="form-control"
               placeholder="Email address" required autofocus>
        <label for="j_password" class="sr-only">Password</label>
        <input type="password" id="j_password" name="j_password" class="form-control"
               placeholder="Password" required>

        <div class='wrapper text-center'>
            <button class="btn btn-lg btn-primary" type="submit">Sign in</button>
            <button class="btn btn-lg btn-primary" type="button"
                    onclick="location.href='/customer/new'">Sign up
            </button>
        </div>
        <span class="text-danger">
                <c:if test="${not empty param.login_error}">
                    Login failed: <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>
                </c:if>
        </span>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
</div>
</body>
</html>