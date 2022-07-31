<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="local" var="localization"/>

    <fmt:message bundle="${localization}" key="local.registerreturn" var="registerreturn"/>
    <fmt:message bundle="${localization}" key="local.needrepair" var="needrepair"/>
    <fmt:message bundle="${localization}" key="local.repairprice" var="repairprice"/>
    <fmt:message bundle="${localization}" key="local.description" var="description"/>
    <fmt:message bundle="${localization}" key="local.back" var="back"/>
    <title>${registerreturn}</title>
</head>
<body>
<c:set  var="page"  value="reg_return.jsp" scope="session"/>
<jsp:include page="header.jsp"/>
<form action="controller" method="post">
    <input type="hidden" name="command" value="register_return"/>
    <div>
        <br/>
        <input type="checkbox" name="need_repair" value="1" /> ${needrepair}
    </div>
    <div>
        <br/>
        ${repairprice}, $:<br/>
        <c:choose>
            <c:when test="need_repair">

            </c:when>
        </c:choose>
        <input type="text" name="repair_price" autocomplete="0" />
    </div>
    <div>
        <br/>
        ${description}:<br/>
        <textarea name="description" cols="30" rows="5"></textarea>
    </div>
    <br/>
    <input type="submit"  value="${registerreturn}"/>
</form>
<br/>
<button onclick="window.history.back();">${back}</button>
</body>
</html>
