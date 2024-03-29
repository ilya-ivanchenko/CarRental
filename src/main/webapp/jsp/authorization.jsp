
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
  <fmt:setLocale value="${sessionScope.local}"/>
  <fmt:setBundle basename="local" var="localization"/>

  <fmt:message bundle="${localization}" key="local.authorization" var="authorization"/>
  <fmt:message bundle="${localization}" key="local.enter" var="enter"/>
  <fmt:message bundle="${localization}" key="local.back" var="back"/>
  <fmt:message bundle="${localization}" key="local.email" var="email"/>
  <fmt:message bundle="${localization}" key="local.password" var="password"/>
    <title>${authorization}</title>

  <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/common.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/authorization.css" type="text/css">
</head>
<c:set  var="page"  value="authorization.jsp" scope="session"/>
<jsp:include page="header.jsp"/>
<body>
    <div>
        <form class="auth" action="controller" method="post">
          <input type="hidden" name="command" value="authorization"/>
           ${email}:<br/>
          <input type="text" name="email" value="" required="required"/> <br/>
           ${password}:<br/>
          <input type="password" name="password" value="" required="required"/> <br/>
          <input class="button-enter" type="submit" value="${enter}"/>
        </form>
        <h4 class="message">${message}</h4>
    </div>
</body>
</html>
