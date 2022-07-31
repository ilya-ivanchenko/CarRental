
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="local" var="localization"/>

    <fmt:message bundle="${localization}" key="local.userinfo" var="userinfo"/>
    <fmt:message bundle="${localization}" key="local.usersall" var="allusers"/>
    <fmt:message bundle="${localization}" key="local.deleteuser" var="deleteuser"/>
    <fmt:message bundle="${localization}" key="local.Name" var="Name"/>
    <fmt:message bundle="${localization}" key="local.Surname" var="Surname"/>
    <fmt:message bundle="${localization}" key="local.Phone" var="Phone"/>
    <fmt:message bundle="${localization}" key="local.Mail" var="Mail"/>
    <fmt:message bundle="${localization}" key="local.role" var="role"/>
    <fmt:message bundle="${localization}" key="local.back" var="back"/>

    <title>${userinfo}</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<c:set  var="page"  value="user_info.jsp" scope="session"/>

<button onclick="window.history.back();">${back}</button>

<h3>${allusers}:</h3>
<p class="ok_message">${message}</p>
<form action="controller" method="post">
    <input type="hidden" name="command" value="delete_user_by_admin"/>

    <table cellpadding="5">
        <tr><th></th>
            <th scope="col">ID</th>
            <th scope="col">${Name}</th>
            <th scope="col">${Surname}</th>
            <th scope="col">${Phone}</th>
<%--            <th scope="col">Password</th>--%>
            <th scope="col">${Mail}</th>
            <th scope="col">${role}</th>
        </tr>

        <c:forEach  var="users" items="${users}">
            <tr scope="row">
                <td>  <input type="radio" name="id" value="${users.id}"/></td>
                <td>${users.id}</td>
                <td>${users.name}</td>
                <td>${users.surname}</td>
                <td>${users.phone}</td>
<%--                <td>${users.password}</td>--%>
                <td>${users.email}</td>
                <td>${users.role}</td>
            </tr>
        </c:forEach>
    </table>
    <input class="del" type="submit"  value="${deleteuser}"/>
</form>
</body>
<style>
    p.ok_message {
        color: blue;
    }
    td {
        text-align: center;
    }
    input.del {
        color: red;
    }
</style>
</html>
