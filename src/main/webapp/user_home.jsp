
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
<button onclick="location='edit_user.jsp'">Edit information</button>

<form  action="controller" method="post">
    <input type="hidden" name="command" value="delete_user"/>
    <input class="del" type="submit"  value="Delete user"/>
</form>


<style>
    input.del {
    /*font-weight: bold;*/
        color: red;
    }
    form {
    display: inline-block;
    }

</style>
</body>
</html>
