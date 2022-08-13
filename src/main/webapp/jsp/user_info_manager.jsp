<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="local" var="localization"/>

    <fmt:message bundle="${localization}" key="local.userinfo" var="userinfo"/>
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
<c:set  var="page"  value="user_info_manager.jsp" scope="session"/>
    <div>
        <img src="/images/user.png" height="128" width="128">

        <p>${Name}: ${userInfo.name}</p>
        <p>${Surname}: ${userInfo.surname}</p>
        <p>${Phone}: ${userInfo.phone}</p>
        <p>${Mail}: ${userInfo.email}</p>
        <p>${role}: ${userInfo.roleName}</p>
        <p>ID: ${userInfo.id}</p>
    </div>
</body>
</html>
