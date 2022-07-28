<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>ERROR PAGE</title>
</head>
<body>
<c:set  var="page"  value="error_page.jsp" scope="session"/>
<jsp:include page="header.jsp"/>
<h4>${message}</h4>
<button onclick="location='index.jsp'">Main page</button>
<div> <input type = "button" value = "Back" onclick = "window.history.back();" /> </div>

</body>
</html>

