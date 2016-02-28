<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Registration form</title>
</head>
<body>
<h1>Join</h1>
<form:form method="post" action="/customer/save" modelAttribute="customer">
    <div><label for="name">Name</label>
        <form:input path="name" placeholder="Name"/>
    </div>
    <div><label for="surname">Surname</label>
        <form:input path="surname" placeholder="Surname"/>
    </div>
    <div><label for="email">E-mail</label>
        <form:input path="email" placeholder="E-mail"/>
    </div>
    <div><label for="username">Username</label>
        <form:input path="username" placeholder="Username"/>
    </div>
    <div><label for="password">Password</label>
        <form:input path="password" placeholder="Password"/>
    </div>
    <br>
    <form:input path="customerID" type="hidden"/>
    <tr>
        <td colspan="2">
            <input type="button" value="Cancel"/>
            <input type="submit" value="Save"/>
        </td>
    </tr>
</form:form>

</body>
</html>
