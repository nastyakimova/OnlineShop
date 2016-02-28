<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<h3>Orders</h3>
<c:if test="${not empty listOrders}">
    <table>
        <thead>
        <tr>
            <th>Order Id</th>
            <th>Client</th>
            <th>Total amount</th>
            <th>Payment Status</th>
            <th>> Add Customer to Blacklist</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listOrders}" var="order">
            <tr>
                <td><c:out value="${order.orderID}"/></td>
                <td><c:out value="${order.getCustomer}"/></td>
                <td></td>
                <td><c:out value="${order.isPaid}"/></td>
                <td colspan="2">
                <input type="button" onclick="location.href='/admin/lock_customer/${order.orderID}'"
                       value="Lock Customer" />
            </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>
</body>

</html>
