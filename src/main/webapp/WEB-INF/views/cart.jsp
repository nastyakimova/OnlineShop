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
<c:url var="actionUrl" value="/order/create/${customer.customerID}"/>
<div class="container">
    <h3>Your Shopping Cart</h3>
    <c:choose>
        <c:when test="${not empty cart}">
            <form:form action="${actionUrl}" method="post">
                <table class="table">
                    <thead class="thead-default">
                    <tr>
                        <th>Title</th>
                        <th>Price</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="product" items="${cart}">
                    <tr>
                        <td><c:out value="${product.title}"/></td>
                        <td><c:out value="${product.price}"/></td>
                        <td>
                            <button type="button" onclick="location.href='/cart/delete/${product.productID}'"
                                    class="btn btn-default">Remove
                            </button>
                        </td>
                    </tr>
                    </tbody>
                    </c:forEach>
                </table>
                <nobr>
                    <button type="button" onclick="location.href='/home'"
                            class="btn btn-default">Back
                    </button>
                    <c:choose>
                        <c:when test="${customer.isLocked}">
                            <button type="submit" class="btn btn-default" disabled="disabled">
                                Buy it now
                            </button>
                        </c:when>
                        <c:otherwise>
                            <button type="submit" class="btn btn-default">
                                Buy it now
                            </button>
                        </c:otherwise>
                    </c:choose>
                </nobr>
            </form:form>
        </c:when>
        <c:otherwise>
            <div class="alert alert-info" role="alert"> There are no products in your shopping cart</div>
            <button type="button" onclick="location.href='/home'"
                    class="btn btn-default">Back
            </button>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>