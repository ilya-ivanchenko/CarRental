
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

    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/common.css" type="text/css">
</head>
<body>
<jsp:include page="header.jsp"/>
<c:set  var="page"  value="user_info.jsp" scope="session"/>
    <div>
        <h3>${allusers}:</h3>
        <p class="ok_message">${message}</p>
        <form action="controller" method="post">
            <input type="hidden" name="command" value="delete_user_by_admin"/>

            <table  cellpadding="5">
                <tr><th></th>
                    <th scope="col">ID</th>
                    <th scope="col">${Name}</th>
                    <th scope="col">${Surname}</th>
                    <th scope="col">${Phone}</th>
                    <th scope="col">${Mail}</th>
                    <th scope="col">${role}</th>
                </tr>

                <c:forEach  var="users" items="${users}">
                    <tr scope="row">
                        <td>
                            <c:choose>
                                <c:when test="${users.roleName != 'Админ'}">
                                    <input type="radio" name="id" value="${users.id}" checked/>
                                </c:when>
                            </c:choose>
                        </td>
                        <td>${users.id}</td>
                        <td>${users.name}</td>
                        <td>${users.surname}</td>
                        <td>${users.phone}</td>
                        <td>${users.email}</td>
                        <td>${users.roleName}</td>
                    </tr>
                </c:forEach>
            </table>
            <br/>
            <input class="del_button" type="submit"  value="${deleteuser}"/>
        </form>
        <br/>
        <button onclick="window.history.back();">${back}</button>
    </div>
</body>
</html>
