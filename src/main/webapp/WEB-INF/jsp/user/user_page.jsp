<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http//www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>User Page</title>
</head>
<body>

<h1>Users List</h1>
<table width="100%" border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Mail</th>
        <th colspan="2">Action</th>
    </tr>
    <c:forEach items="${listUser}" var="user">
        <tr>
            <td>${user.user_id}</td>
            <td>${user.name}</td>
            <td>${user.surname}</td>
            <td>${user.mail}</td>
            <td>
                <spring:url value="/update/${user.user_id}" var="updateURL" />
                <a href="${updateURL}">Update</a>
            </td>
            <td>
                <spring:url value="/delete/${user.user_id}" var="delteURL" />
                <a href="${deleteURL}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
