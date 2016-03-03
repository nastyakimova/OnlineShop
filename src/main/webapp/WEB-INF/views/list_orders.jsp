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
<h3>Orders</h3>
<c:if test="${not empty listOrders}">
    <table class="table">
        <thead class="thead-default">
        <tr>
            <th>Order Id</th>
            <th>Client</th>
            <th>Total amount</th>
            <th> Add Customer to Blacklist</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listOrders}" var="order">
            <form:form action="/admin/lock_customer/${order.orderID}" method="post">
                <tr>
                    <td><c:out value="${order.orderID}"/></td>
                    <td><c:out value="${order.customer.name}"/></td>
                    <td></td>
                    <td colspan="2">
                        <c:if test="${order.customer.isLocked eq 'false'}">
                            <button type="submit" class="btn btn-default">Lock Customer
                            </button>
                        </c:if>
                        <c:if test="${order.customer.isLocked eq 'true'}">
                            <button type="submit" class="btn btn-default">Unlock Customer
                            </button>
                        </c:if>

                    </td>
                </tr>
            </form:form>
        </c:forEach>
        </tbody>
    </table>
</c:if>
</body>

</html>
