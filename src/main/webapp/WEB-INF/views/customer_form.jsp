<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Registration form</title>
</head>
<body>
    <h3>Join</h3>
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
    <div><label for="password">Password</label>
        <form:input path="password" placeholder="Password"/>
    </div>
    <br>
    <form:input path="customerID" type="hidden"/>
    <tr>
        <td colspan="2">
            <button type="button" class="btn btn-default">Cancel</button>
            <button type="submit" class="btn btn-default">Save</button>
        </td>
    </tr>
</form:form>

</body>
</html>
