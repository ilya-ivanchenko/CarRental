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

    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/common.css" type="text/css">
</head>
<body>
<c:set  var="page"  value="reg_return.jsp" scope="session"/>
<jsp:include page="header.jsp"/>
<div>
    <form action="controller" method="post">
        <input type="hidden" name="command" value="register_return"/>
        <div>
            <br/>
            <input type="checkbox" name="need_repair" onchange="onChangeRepairStatus(this.checked)" value="1"  /> ${needrepair}
        </div>
        <div id="repairPrice-block">
           <label for="repairPrice"> ${repairprice}, $:</label>
            <input id="repairPrice"
                   type="text"
                   name="repair_price"
                   required="required"
                   placeholder="0"
                   autocomplete="off"
                   pattern="\d+"
            />
        </div>
        <div>
            ${description}:<br/>
            <textarea name="description" cols="30" rows="5"></textarea>
            <br/>
            <br/>
            <input  class="button" type="submit" value="${registerreturn}"/>
        </div>
        <br/>
    </form>
    <button onclick="window.history.back();">${back}</button>
</div>
<script src="../JS/reg_return.js"></script>
</body>
</html>
