<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="stylesheet"
          href='<c:url value="/resources/css/bootstrap.min.css"/>'>
    <link rel="stylesheet"
          href='<c:url value="/resources/css/jquery-ui-1.10.4.custom.css"/>'>
    <link rel="stylesheet"
          href='<c:url value="/resources/css/navbar-static-top.css"/>'>
    <style type="text/css">
        th {
            text-align: left
        }
    </style>
</head>
<body>
<!-- Static navbar -->
<nav class="navbar navbar-default navbar-static-top">
    <div class="container">
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <sec:authorize access="!isAuthenticated()">
                    <li><a href="<c:url value="/login"/>">Log in</a></li>
                    <li><a href="<c:url value="/customer/new"/>">Sign up</a></li>
                </sec:authorize>
                <li><a href="<c:url value="/cart/get"/>">
                    <span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span>
                </a>
                </li>
                <sec:authorize access="isAuthenticated()">
                <li><a href="<c:url value="/order/get"/>">Orders</a></li>
            </ul>
            <form action="<c:url value="/logout"/>" method="post"
                  class="navbar-form navbar-right">
                <button class="btn btn-primary" type="submit">Logout</button>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>
            </sec:authorize>
        </div>
    </div>
</nav>
</body>
</html>
