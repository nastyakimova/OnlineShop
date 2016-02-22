<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create new product</title>
</head>
<body>
<fieldset>
    <legend>Create new product</legend>
    <form method="post" action="/product/save">
        <p><input type="text" name="title" value="${product.title}" placeholder="Title"></p>

        <p><input type="number" name="price" value="${product.price}" placeholder="Price ($)"></p>

        <p><input type="hidden" value="productID"/></p>

        <p><input type="submit" value="Save"></p>
    </form>
</fieldset>
</body>
</html>
