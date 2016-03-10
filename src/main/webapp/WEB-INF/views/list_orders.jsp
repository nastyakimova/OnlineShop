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
        <c:when test="${not empty orders}">
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
                <c:forEach items="${orders}" var="order">
                <tr>
                    <td><c:out value="${order.key.orderID}"/></td>
                    <td><c:out value="${order.key.customer.name} ${order.key.customer.surname}"/></td>
                    <td><c:forEach items="${order.value}" var="orderValue">
                        <c:out value="${orderValue.key.title} x ${orderValue.value}"/>
                        <br>
                    </c:forEach></td>
                    <td><c:set var="total" value="${0}"/>
                        <c:forEach items="${order.value}" var="orderValue">
                            <c:set var="total" value="${total + orderValue.key.price*orderValue.value}"/>
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
