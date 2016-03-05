<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of customers</title>
    <style type="text/css">
        th {
            text-align: left
        }
    </style>
</head>
<body>
<jsp:include page="menu_user.jsp"></jsp:include>
<div class="container">
    <h3>Orders</h3>
    <c:choose>
        <c:when test="${not empty listOrders}">
            <table class="table">
                <thead class="thead-default">
                <tr>
                    <th>Order ID</th>
                    <th></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${listOrders}" var="order">
                    <tr>
                        <td><c:out value="${order.orderID}"/></td>
                        <td><c:out value="${order.productList}"/></td>
                        <td></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:when>
        <c:otherwise>
            <div class="alert alert-info" role="alert"> There are no orders</div>
        </c:otherwise>
    </c:choose>
    <button type="button" onclick="location.href='/home'"
            class="btn btn-default">Back
    </button>
</div>
</body>
</html>
