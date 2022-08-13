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
  <fmt:message bundle="${localization}" key="local.checkname" var="checkname"/>
  <fmt:message bundle="${localization}" key="local.checksurname" var="checksurname"/>
  <fmt:message bundle="${localization}" key="local.checkphone" var="checkphone"/>
  <fmt:message bundle="${localization}" key="local.checkemail" var="checkemail"/>

    <title>${reg}</title>

  <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/common.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/authorization.css" type="text/css">

</head>
<c:set  var="page"  value="registration.jsp" scope="session"/>
<jsp:include page="header.jsp"/>
<body>
<div>
    <form class="auth" action="controller" method="post">
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
        <input type="text"
               name="name"
               value=""
               required="required"
               pattern="\D+"
               oninvalid="this.setCustomValidity('${checkname}')"
               oninput="this.setCustomValidity('')"
               autocomplete="off"
        /> <br/>
        ${surname}:<br/>
        <input type="text"
               name="surname"
               value=""
               required="required"
               pattern="\D+"
               oninvalid="this.setCustomValidity('${checksurname}')"
               oninput="this.setCustomValidity('')"
               autocomplete="off"
        /> <br/>
        ${phone}:<br/>
        <input type="text"
               name="phone"
               value=""
               required="required"
               pattern="(\+\d{12})"
               oninvalid="this.setCustomValidity('${checkphone}')"
               oninput="this.setCustomValidity('')"
               autocomplete="off"
        /> <br/>
        ${password}:<br/>
        <input type="password"
               name="password"
               value=""
               required="required"
        /><br/>
        ${email}:<br/>
        <input type="email"
               name="email"
               value=""
               required="required"
               pattern="([.[^@\s]]+)@([.[^@\s]]+)\.([a-z]+)"
               oninvalid="this.setCustomValidity('${checkemail}')"
               oninput="this.setCustomValidity('')"
               autocomplete="off"
        />
        <br/>
          <c:choose>
              <c:when test="${user.role != 4}">
                <input class="button" type="submit" value="${register}"/>
              </c:when>
              <c:when test="${user.role == 4}">
                <input class="button" type="submit" value="${addmanager}"/>
              </c:when>
          </c:choose>
    </form>
    <br/>
    <h4>${message}</h4>
    <br/>
</div>
<script src="/JS/registration.js"></script>
</body>
</html>



