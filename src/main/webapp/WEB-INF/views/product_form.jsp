<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Create new product</title>
</head>
<body>
<jsp:include page="menu_admin.jsp"></jsp:include>
<div class="container">
    <h3>Create new product</h3>
    <form:form method="post" action="/admin/product/save" modelAttribute="product">
        <div>
            <label for="title">Title</label>
            <form:input path="title" placeholder="Title"/>
        </div>

        <div><label for="price">Price</label>
            <form:input path="price" placeholder="Price ($)"/>
        </div>
        <br>
        <tr>
            <td colspan="2">
                <button type="button" onclick="location.href='/admin/list_products'"
                        class="btn btn-default">Cancel
                </button>
                <button type="submit" class="btn btn-default">Save
                </button>
            </td>
        </tr>
        <form:input path="productID" type="hidden"/>
    </form:form>
</div>
</body>
</html>
