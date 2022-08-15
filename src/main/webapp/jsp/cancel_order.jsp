
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
  <fmt:setLocale value="${sessionScope.local}"/>
  <fmt:setBundle basename="local" var="localization"/>

  <fmt:message bundle="${localization}" key="local.cancelorder" var="cancelorder"/>
  <fmt:message bundle="${localization}" key="local.writecomment" var="writecomment"/>
  <fmt:message bundle="${localization}" key="local.back" var="back"/>
    <title>${cancelorder}</title>

  <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/common.css" type="text/css">
</head>
<body>
<c:set  var="page"  value="cancel_order.jsp" scope="session"/>
<jsp:include page="header.jsp"/>
<div>
  <form action="controller" method="post">
    <input type="hidden" name="command" value="cancel_order_manager"/>
    ${writecomment}:<br/>
      <textarea name="description" cols="50" rows="5"></textarea>
      <br/>
    <br/>
    <input class="button" type="submit"  value="${cancelorder}"/>
  </form>
  <br/>
  <button onclick="window.history.back();">${back}</button>
</div>
</body>
</html>
