<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <fmt:setLocale value="${sessionScope.local}"/>
  <fmt:setBundle basename="local" var="localization"/>

  <fmt:message bundle="${localization}" key="local.registration" var="reg"/>
  <fmt:message bundle="${localization}" key="local.name" var="name"/>
  <fmt:message bundle="${localization}" key="local.surname" var="surname"/>
  <fmt:message bundle="${localization}" key="local.phone" var="phone"/>
  <fmt:message bundle="${localization}" key="local.password" var="password"/>
  <fmt:message bundle="${localization}" key="local.email" var="email"/>
  <fmt:message bundle="${localization}" key="local.register" var="register"/>
  <fmt:message bundle="${localization}" key="local.back" var="back"/>
  <fmt:message bundle="${localization}" key="local.addmanager" var="addmanager"/>

    <title>${reg}</title>
</head>
<c:set  var="page"  value="registration.jsp" scope="session"/>
<jsp:include page="header.jsp"/>
<body>
<c:set  var="page"  value="registration.jsp" scope="session"/>

<form action="controller" method="post">
  <input type="hidden" name="command" value="registration"/>
  <c:choose>
    <c:when test="${user.role == 4}">
      <input type="hidden" name="role" value="3"/>
    </c:when>
    <c:when test="${user.role != 4}">
      <input type="hidden" name="role" value="2"/>
    </c:when>
  </c:choose>
  ${name}:<br/>
  <input type="text" name="name" value=""/> <br/>
  ${surname}:<br/>
  <input type="text" name="surname" value="" /> <br/>
  ${phone}:<br/>
  <input type="text" name="phone" value="" /> <br/>
  ${password}:<br/>
  <input type="password" name="password" value="" required="required"/> <br/>
  ${email}:<br/>
  <input type="email" name="email" value="" required="required"/> <br/>
  <c:choose>
    <c:when test="${user.role != 4}">
  <input type="submit" value="${register}"/>
    </c:when>
    <c:when test="${user.role == 4}">
      <input type="submit" value="${addmanager}"/>
    </c:when>
  </c:choose>
</form>
<br/>
<h4>${message}</h4>
<br/>

<%--<div> <input type = "button" value = "Back" onclick = "window.history.back();" /> </div>--%>
<button onclick="window.history.back();">${back}</button>
</body>
<style>
  p.ok_message {
    color: blue;
  }
</style>
</html>

<%----%>

