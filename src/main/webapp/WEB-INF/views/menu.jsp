<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
        <div class="navbar-header">
            <a class="navbar-brand">Admin</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="<c:url value="/admin/product/list_products"/>">Products</a></li>
                <li><a href="<c:url value="/admin/list_orders"/>">Orders</a></li>
                <li><a href="<c:url value="/admin/list_customers"/>">Customers</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="<c:url value="/"/>">Exit</a></li>
            </ul>
        </div>
    </div>
</nav>
</body>
</html>
