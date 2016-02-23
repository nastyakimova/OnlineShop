<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
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
        <button type="button" class="btn btn-default navbar-btn">Sign in</button>
    <button type="button" class="btn btn-default" aria-label="Right Align">
        <span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span>
    </button>

</nav>
</body>
</html>
