<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of orders</title>
    <style type="text/css">
        th {
            text-align: left
        }
    </style>
</head>
<body>
<jsp:include page="menu_admin.jsp"></jsp:include>
<div class="container">
    <h3>Orders</h3>
    <c:choose>
        <c:when test="${not empty listOrders}">
            <table class="table">
                <thead class="thead-default">
                <tr>
                    <th>Order Id</th>
                    <th>Client</th>
                    <th>Items</th>
                    <th>Total</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${listOrders}" var="order">
                <tr>
                    <td><c:out value="${order.orderID}"/></td>
                    <td><c:out value="${order.customer.name} ${order.customer.surname}"/></td>
                    <td><c:forEach items="${order.productList}" var="product">
                        <c:out value="${product.title} (${product.price})"/>
                    </c:forEach></td>
                    <td><c:set var="total" value="${0}"/>
                        <c:forEach items="${order.productList}" var="product">
                            <c:set var="total" value="${total + product.price}"/>
                        </c:forEach>
                        <c:out value="${total}"/>
                    </td>
                    </c:forEach>
                </tbody>
            </table>
        </c:when>
        <c:otherwise>
            <div class="alert alert-info" role="alert"> There are no orders</div>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>
