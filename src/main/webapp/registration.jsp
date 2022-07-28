<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
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
  Enter name:<br/>
  <input type="text" name="name" value=""/> <br/>
  Enter surname:<br/>
  <input type="text" name="surname" value="" /> <br/>
  Enter phone:<br/>
  <input type="text" name="phone" value="" /> <br/>
  Enter password:<br/>
  <input type="password" name="password" value="" required="required"/> <br/>
  Enter email:<br/>
  <input type="email" name="email" value="" required="required"/> <br/>
  <c:choose>
    <c:when test="${user.role != 4}">
  <input type="submit" value="Sign up"/>
    </c:when>
    <c:when test="${user.role == 4}">
      <input type="submit" value="Add manager"/>
    </c:when>
  </c:choose>
</form>
<h4>${message}</h4>
<br/>

<%--<div> <input type = "button" value = "Back" onclick = "window.history.back();" /> </div>--%>
<button onclick="window.history.back();">Back</button>
</body>
</html>

<%----%>

