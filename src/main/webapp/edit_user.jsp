
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Edit information</title>
</head>
<body>
<c:set  var="page"  value="edit_user.jsp" scope="session"/>
<jsp:include page="header.jsp"/>
<form action="controller" method="post">
  <input type="hidden" name="command" value="edit_user"/>

  Enter name:<br/>
  <input type="text" name="name" value="" placeholder="${user.name}"/> <br/>
  Enter surname:<br/>
  <input type="text" name="surname" value="" placeholder="${user.surname}"/> <br/>
  Enter phone:<br/>
  <input type="text" name="phone" value="" placeholder="${user.phone}"/> <br/>
  Enter password:<br/>
  <input type="password" name="password" value="" /> <br/>
  Enter email:<br/>
  <input type="email" name="email" value="" placeholder="${user.email}"/> <br/>
  <input type="submit" value="Save"/>
</form>
<br/>

<button onclick="location='index.jsp'">Main page</button>
<button onclick="window.history.back();">Back</button>
</body>
</html>

<%----%>

