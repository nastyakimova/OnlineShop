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
<jsp:include page="menu_admin.jsp"></jsp:include>
<h3>Customers</h3>
<c:if test="${not empty listCustomers}">
    <table>
        <thead>
        <tr>
            <th>Name</th>
            <th>Surname</th>
            <th>Email</th>
            <th>Password</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listCustomers}" var="customer">
            <tr>
                <td><c:out value="${customer.name}"/></td>
                <td><c:out value="${customer.surname}"/></td>
                <td><c:out value="${customer.email}"/></td>
                <td><c:out value="${customer.password}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>
</body>

</html>
