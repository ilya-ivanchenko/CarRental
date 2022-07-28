
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Cancel order</title>
</head>
<body>
<c:set  var="page"  value="cancel_order.jsp" scope="session"/>
<jsp:include page="header.jsp"/>
<form action="controller" method="post">
  <input type="hidden" name="command" value="cancel_order_manager"/>
  Write a description:<br/>
    <textarea name="description" cols="50" rows="5"></textarea>
    <br/>
  <br/>
  <input type="submit"  value="Cancel order"/>
</form>
</body>
</html>
