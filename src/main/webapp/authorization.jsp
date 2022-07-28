
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Authorization</title>
</head>
<body>
<c:set  var="page"  value="authorization.jsp" scope="session"/>

<form action="controller" method="post">
  <input type="hidden" name="command" value="authorization"/>

  Enter email:<br/>
  <input type="text" name="email" value="" required="required"/> <br/>
  Enter password:<br/>
  <input type="password" name="password" value="" required="required"/> <br/>
  <input type="submit" value="Enter"/>
</form>
<h4>${message}</h4>
<br/>
<button onclick="location='index.jsp'">Main page</button>
<button onclick="window.history.back();">Back</button>
</body>
</html>
