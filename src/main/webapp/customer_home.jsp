
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User information</title>
</head>
<body>
<h2>Hi, ${user.name}!</h2>

<h3>Your information:</h3>
<div>
    <p>Имя: ${user.name}</p>
    <p>Фамилия: ${user.surname}</p>
    <p>Телефон: ${user.phone}</p>
    <p>E-mail: ${user.email}</p>
    <p>ID: ${user.id}</p>
</div>

<br/>
<button onclick="location='index.jsp'">Main page</button>
<button onclick="location='index.jsp'">Edit information</button>

</body>
</html>
