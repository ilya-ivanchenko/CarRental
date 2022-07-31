
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="local" var="localization"/>

    <fmt:message bundle="${localization}" key="local.pay" var="pay"/>
    <fmt:message bundle="${localization}" key="local.payment" var="payment"/>
    <fmt:message bundle="${localization}" key="local.back" var="back"/>
    <fmt:message bundle="${localization}" key="local.myorders" var="myorders"/>
    <title>${payment}</title>
</head>
<body>
<c:set  var="page"  value="payment.jsp" scope="session"/>
<jsp:include page="header.jsp"/>
<form  action="controller" method="post">
    <input type="hidden" name="command" value="pay"/>
    <input  type="submit"  value="${pay}"/>
    <h4>${message}</h4>
    <br/>
</form>
<form  action="controller" method="post">
    <input type="hidden" name="command" value="order_info"/>
    <input type="submit"  value="${myorders}"/>
</form>
<br/>
<button onclick="window.history.back();">${back}</button>
</body>
</html>
