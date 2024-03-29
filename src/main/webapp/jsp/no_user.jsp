
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="local" var="localization"/>

    <fmt:message bundle="${localization}" key="local.pleaseauthorize" var="pleaseauthorize"/>
    <fmt:message bundle="${localization}" key="local.forcontinue" var="forcontinue"/>
    <fmt:message bundle="${localization}" key="local.orgoto" var="orgoto"/>
    <fmt:message bundle="${localization}" key="local.loginnouser" var="loginnouser"/>
    <fmt:message bundle="${localization}" key="local.registnouser" var="registernouser"/>
    <fmt:message bundle="${localization}" key="local.back" var="back"/>
    <title>${pleaseauthorize}</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/common.css" type="text/css">
</head>
    <body>
    <c:set  var="page"  value="no_user.jsp" scope="session"/>
    <jsp:include page="header.jsp"/>
        <div>
            <h4>${forcontinue} <a href="authorization.jsp">${loginnouser}</a> ${orgoto}
               <a href="registration.jsp">${registernouser}</a>
            </h4>
            <br/>
            <button onclick="window.history.back();">${back}</button>
        </div>
    </body>
</html>
