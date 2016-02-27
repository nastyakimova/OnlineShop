<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>

<c:url var="loginUrl" value="/login"/>

<form action="${loginUrl}" method="post" id="f" class="form-horizontal container login-form">
    <div class="form-group">
        <div class="col-xs-10">
            <input type="text" class="form-control" name="j_username" required autofocus/>
        </div>
    </div>

    <div class="form-group">
        <div class="col-xs-10">
            <input type="password" class="form-control" name="j_password" required/>
        </div>
    </div>

    <div class="form-group">
        <div class="col-xs-offset-2 col-xs-10">
            <button class="btn btn-primary" type="submit">Login</button>
            <span class="text-danger">
                <c:if test="${not empty param.login_error}">
                    Login failed: <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>
                </c:if>
            </span>
        </div>
    </div>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
</body>
</html>