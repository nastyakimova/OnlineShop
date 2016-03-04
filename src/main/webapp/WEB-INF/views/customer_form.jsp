<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Registration form</title>
    <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/signin.css"/>" rel="stylesheet">
</head>
<body>
<c:url var="actionUrl" value="/customer/save"/>
<div class="container">
    <form:form action="${actionUrl}" method="post" modelAttribute="customer" class="form-signin">
        <h2 class="form-signin-heading text-center">Please sign ip</h2>
        <label for="name" class="sr-only">Name</label>
        <form:input path="name" class="form-control" placeholder="Name"/>

        <label for="surname" class="sr-only">Surname</label>
        <form:input path="surname" class="form-control" placeholder="Surname"/>

        <label for="email" class="sr-only">E-mail</label>
        <form:input path="email" class="form-control" placeholder="E-mail"
                    required="required"/>

        <label for="password" class="sr-only">Password</label>
        <form:input path="password" class="form-control" placeholder="Password"
                    required="required"/>
        <br>
        <form:input path="customerID" type="hidden"/>
        <div class='wrapper text-center'>
            <button type="button" onclick="location.href='/home'"
                    class="btn btn-lg btn-primary">Cancel</button>
            <button type="submit" class="btn btn-lg btn-primary">Register</button>
        </div>
    </form:form>
</div>
</body>
</html>
