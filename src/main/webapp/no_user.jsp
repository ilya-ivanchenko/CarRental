
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Please, enter</title>
</head>
<body>
<c:set  var="page"  value="no_user.jsp" scope="session"/>
<jsp:include page="header.jsp"/>
<h3>For continue, please <button onclick="location='authorization.jsp'">Log In</button> or
    <button onclick="location='registration.jsp'">Registration</button></h3>
<br/>
<div> <input type = "button" value = "Back" onclick = "window.history.back();" /> </div>
</body>
</html>
