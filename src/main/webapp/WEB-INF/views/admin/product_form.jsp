<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Create new product</title>
</head>
<body>
<fieldset>
    <legend>Create new product</legend>
    <form:form method="post" action="/product/save" modelAttribute="product">
        <div><label for="title">Title</label>
            <form:input path="title" placeholder="Title"/>
        </div>

        <div><label for="price">Price</label>
            <form:input path="price" placeholder="Price ($)"/>
        </div>
        <div><input type="submit" value="Save"/></div>
        <form:input path="productID" type="hidden"/>

    </form:form>
</fieldset>
</body>
</html>
