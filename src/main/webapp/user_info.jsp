
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User info</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<c:set  var="page"  value="delete_user.jsp" scope="session"/>

<button onclick="window.history.back();">Back</button>

<h3>All users:</h3>
<p class="ok_message">${message}</p>
<form action="controller" method="post">
    <input type="hidden" name="command" value="delete_user_by_admin"/>

    <table cellpadding="5">
        <tr><th></th>
            <th scope="col">ID</th>
            <th scope="col">Name</th>
            <th scope="col">Surname</th>
            <th scope="col">Phone</th>
            <th scope="col">Password</th>
            <th scope="col">Email</th>
            <th scope="col">Role</th>
        </tr>

        <c:forEach  var="users" items="${users}">
            <tr scope="row">
                <td>  <input type="radio" name="id" value="${users.id}"/></td>
                <td>${users.id}</td>
                <td>${users.name}</td>
                <td>${users.surname}</td>
                <td>${users.phone}</td>
                <td>${users.password}</td>
                <td>${users.email}</td>
                <td>${users.role}</td>
            </tr>
        </c:forEach>
    </table>
    <input type="submit"  value="Delete user"/>
</form>
</body>
<style>
    p.ok_message {
        color: blue;
    }
</style>
</html>
