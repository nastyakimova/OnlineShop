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
<legend>Products</legend>
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
      <td><input type="button" value="Add To Cart">
      </td>
    </tr>
    </tbody>
    </c:forEach>
  </table>
</c:if>
</body>
</html>
