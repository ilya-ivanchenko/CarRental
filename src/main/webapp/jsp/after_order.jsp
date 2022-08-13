
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="local" var="localization"/>

    <fmt:message bundle="${localization}" key="local.done" var="done"/>
    <fmt:message bundle="${localization}" key="local.succesbook" var="succesbook"/>
    <fmt:message bundle="${localization}" key="local.checkstatusorder" var="checkstatusorder"/>
    <fmt:message bundle="${localization}" key="local.yourprofile" var="youprofile"/>
    <title>${done}</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/common.css" type="text/css">
</head>
<body>
<c:set  var="page"  value="after_order.jsp" scope="session"/>
<jsp:include page="header.jsp"/>
<h3>${succesbook}</h3>
<br/>${checkstatusorder}
<a href="jsp/user_home.jsp">${youprofile}</a>
</body>
</html>
