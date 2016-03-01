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
<jsp:include page="menu_user.jsp"></jsp:include>
 <h3>Products</h3>
<c:if test="${not empty listProducts}">
    <table class="table">
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
                <button type="button" onclick="location.href='/cart/addProductToCart/${product.productID}'"
                        class="btn btn-default"> Add To Cart
                </button>
            </td>
        </tr>
        </tbody>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
