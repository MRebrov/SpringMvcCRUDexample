<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http//www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>User Form</title>
</head>
<body>
<spring:url value="/save" var="saveURL" />

<form:form modelAttribute="userForm" method="POST" action="${saveURL}">
    <form:hidden path="user_id"/>
    <table>
        <tr>
            <td>Name: </td>
            <td><form:input path="name"/>
        </tr>
        <tr>
            <td>Surname: </td>
            <td><form:input path="surname"/>
        </tr>
        <tr>
            <td>Mail: </td>
            <td><form:input path="mail"/>
        </tr>
        <tr>
            <td></td>
            <td><button type="submit">Save</button>
        </tr>
    </table>
</form:form>

</body>
</html>
