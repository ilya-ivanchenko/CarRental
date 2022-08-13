<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="local" var="localization"/>

    <fmt:message bundle="${localization}" key="local.Error" var="error"/>
    <fmt:message bundle="${localization}" key="local.back" var="back"/>
    <title>${error}</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/common.css" type="text/css">
</head>
<body>
<c:set  var="page"  value="error_page.jsp" scope="session"/>
<jsp:include page="header.jsp"/>
<h4>${message}</h4>

<div> <input type = "button" value = "${back}" onclick = "window.history.back();" /> </div>

</body>
</html>

