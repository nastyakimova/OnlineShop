<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List of products</title>
</head>
<body>
    <legend>Options</legend>
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
                        <a href="delete/${product.productID}"
                           onclick="return confirm('Are you sure you want to delete this client?');">Remove
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
