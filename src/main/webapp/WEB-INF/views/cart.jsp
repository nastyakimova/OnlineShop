<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Shopping Cart</title>
    <link rel="stylesheet"
          href='<c:url value="/resources/css/bootstrap.min.css"/>'>
</head>
<body>
<jsp:include page="menu_user.jsp"></jsp:include>
<c:url var="actionUrl" value="/order/create"/>
<div class="container">
    <h3>Your Shopping Cart</h3>
    <c:if test="${not empty cart}">
        <form:form action="${actionUrl}" method="post">
            <c:forEach var="product" items="${cart}">
                <div class="checkbox">
                    <label><input type="checkbox" name="productIds" value="${product.productID}"/>
                        <c:out value="${product.title}"/>
                        <c:out value="${product.price}"/>
                        <a href='/cart/delete/${product.productID}'
                           onclick="return confirm('Are you sure you want to delete this product?');">Remove
                        </a>
                    </label>
                </div>
            </c:forEach>
            <button type="submit" class="btn btn-default">Buy it now</button>
        </form:form>
    </c:if>
</div>
</body>
</html>