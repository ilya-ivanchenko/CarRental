
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
  <fmt:setLocale value="${sessionScope.local}"/>
  <fmt:setBundle basename="local" var="localization"/>

  <fmt:message bundle="${localization}" key="local.editinfo" var="editinfo"/>
  <fmt:message bundle="${localization}" key="local.name" var="name"/>
  <fmt:message bundle="${localization}" key="local.surname" var="surname"/>
  <fmt:message bundle="${localization}" key="local.phone" var="phone"/>
  <fmt:message bundle="${localization}" key="local.password" var="password"/>
  <fmt:message bundle="${localization}" key="local.email" var="email"/>
  <fmt:message bundle="${localization}" key="local.save" var="save"/>
  <fmt:message bundle="${localization}" key="local.back" var="back"/>

  <title>${editinfo}</title>

  <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/common.css" type="text/css">
</head>
  <body>
  <c:set  var="page"  value="edit_user.jsp" scope="session"/>
  <jsp:include page="header.jsp"/>
    <div>
      <form action="controller" method="post">
        <input type="hidden" name="command" value="edit_user"/>

        ${name}:<br/>
        <input type="text" name="name" value="" placeholder="${user.name}"/> <br/>
        ${surname}:<br/>
        <input type="text" name="surname" value="" placeholder="${user.surname}"/> <br/>
        ${phone}:<br/>
        <input type="text" name="phone" value="" placeholder="${user.phone}"/> <br/>
        ${password}:<br/>
        <input type="password" name="password" value="" /> <br/>
        ${email}:<br/>
        <input type="email" name="email" value="" placeholder="${user.email}"/> <br/>
        <input class="button" type="submit" value="${save}"/>
      </form>
      <br/>
      <button onclick="window.history.back();">${back}</button>
    </div>
  </body>
</html>



