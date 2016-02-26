<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Create new product</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<h1>Create new product</h1>
<form:form method="post" action="/admin/product/save" modelAttribute="product">
    <div><label for="title">Title</label>
        <form:input path="title" placeholder="Title"/>
    </div>

    <div><label for="price">Price</label>
        <form:input path="price" placeholder="Price ($)"/>
    </div>
    <br>
    <tr>
        <td colspan="2">
            <input type="button" onclick="location.href='/admin/product/list_products'" value="Cancel" />
            <input type="submit" value="Save"/>
        </td>
    </tr>
    <form:input path="productID" type="hidden"/>
</form:form>

</body>
</html>
