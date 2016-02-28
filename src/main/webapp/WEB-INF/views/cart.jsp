<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Shopping Cart</title>
</head>
<body>
<h3>Your Shopping Cart</h3>
<c:if test="${not empty cart}">
    <c:url var="actionUrl" value="/order/create"/>
    <form:form action="${actionUrl}" method="post">
        <table>
            <thead>
            <tr>
                <th>Add</th>
                <th>Title</th>
                <th>Price</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="product" items="${cart}">
            <tr>
                <td><input type="checkbox" name="productIds" value="${product.productID}"/></td>
                <td><c:out value="${product.title}"/></td>
                <td><c:out value="${product.price}"/></td>
                <td>
                    <a href='/cart/delete/${product.productID}'
                       onclick="return confirm('Are you sure you want to delete this product?');">Remove
                    </a>
                </td>
            </tr>
            </tbody>
            </c:forEach>
        </table>
        <input type="submit"  value="Buy it now">
    </form:form>
</c:if>
</body>
</html>