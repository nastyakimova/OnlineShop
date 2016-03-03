<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<jsp:include page="menu_admin.jsp"></jsp:include>
<div class="container">
    <h3>Products</h3>
    <button type="button" onclick="location.href='/admin/product/new'" class="btn btn-default">
        Add Product
    </button>
    <br>
    <c:if test="${not empty listProducts}">
        <table class="table">
            <thead class="thead-default">
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
                        <button type="button" onclick="location.href='/admin/product/edit/${product.productID}'"
                                class="btn btn-default">Edit Product
                        </button>
                        <button type="button" onclick="location.href='/admin/product/delete/${product.productID}'"
                                class="btn btn-default">Remove
                        </button>
                    </nobr>
                </td>
            </tr>
            </tbody>
            </c:forEach>
        </table>
    </c:if>
</div>
</body>
</html>
