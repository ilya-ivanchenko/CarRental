
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Done</title>
</head>
<body>
<c:set  var="page"  value="after_order.jsp" scope="session"/>
<jsp:include page="header.jsp"/>
<h3>Rental booking completed successfully! Manager will contact you</h3>
<br/>Also you can check  your order status in
<button class="yourpage" onclick="location='user_home.jsp'">Your profile</button>
<br/>
<br/><button onclick="location='index.jsp'">Main page</button>
</body>
</html>
