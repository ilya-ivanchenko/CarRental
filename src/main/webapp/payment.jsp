
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Payment</title>
</head>
<body>
<form  action="controller" method="post">
    <input type="hidden" name="command" value="pay"/>
    <input  type="submit"  value="Pay"/>
    <h4>${message}</h4>
    <br/>
</form>
<form  action="controller" method="post">
    <input type="hidden" name="command" value="order_info"/>
    <input type="submit"  value="My orders"/>
</form>
<button onclick="location='index.jsp'">Main page</button>
</body>
</html>
