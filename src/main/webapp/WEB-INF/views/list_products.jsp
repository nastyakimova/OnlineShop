<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List of products</title>
    <style type="text/css">
        th {
            text-align: left
        }
    </style>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<h3>Products</h3>
<input type="button" onclick="location.href='/product/new'" value="Add Product">
<br>
<c:if test="${not empty listProducts}">
    <table>
        <thead>
        <tr>
            <th>Title</th>
            <th>Price</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="product" items="${listProducts}">
        <tr>
            <td><c:out value="${product.title}"/></td>
            <td><c:out value="${product.price}"/></td>
            <td>
                <nobr>
                    <input type="button" onclick="location.href='/product/edit/${product.productID}'"
                           value="Edit Product">
                    <a href='/product/delete/${product.productID}'
                       onclick="return confirm('Are you sure you want to delete this product?');">Remove
                    </a>
                </nobr>
            </td>
        </tr>
        </tbody>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
