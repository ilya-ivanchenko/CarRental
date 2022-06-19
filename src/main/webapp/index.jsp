<%@ page  import="by.ivanchenko.carrental.bean.user.User" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  %>
<%--<%@ page isELIgnored="true" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE html>
<html>
<head>
    <title>main</title>
</head>


<h3>Каталог авто </h3>
<br/>

<table cellpadding="5">
<tr>
    <th scope="col">id</th>
    <th scope="col">Car</th>
    <th scope="col">Transmission</th>
    <th scope="col">Year</th>
    <th scope="col">Drive</th>
    <th scope="col">Fuel</th>
    <th scope="col">Engine Capacity</th>
    <th scope="col">Tank</th>
    <th scope="col">Consumption</th>
    <th scope="col">Body Type</th>
    <th scope="col">Price</th>
    <th scope="col">Mileage</th>
</tr>

<c:forEach  var="cars" items="${cars}">
    <tr scope="row">
        <td>${cars.id}</td>
        <td>${cars.name}</td>
        <td>${cars.transmission}</td>
        <td>${cars.year}</td>
        <td>${cars.drive}</td>
        <td>${cars.fuel}</td>
        <td>${cars.engineCapacity}</td>
        <td>${cars.tank}</td>
        <td>${cars.consumption}</td>
        <td>${cars.bodyType}</td>
        <td>${cars.price}</td>
        <td>${cars.mileage}</td>
    </tr>
</c:forEach>
    </table>

<%--<tr>--%>
<%--    <td>${car1.id}</td>--%>
<%--    <td>${car1.name}</td>--%>
<%--    <td>${cars[1].name}</td>--%>
<%--</tr>--%>
<a href="mainpage">logIn</a>

<%--форма авторизации  method="get" или post  --%>
<form action="mainpage" method="get">
    <input type="hidden" name="command" value="authorization"/>

    Enter email:<br/>
    <input type="text" name="email" value=""/> <br/>

    Enter password:<br/>
    <input type="password" name="password" value=""/> <br/>

    <input type="submit" value="press me"/>
</form>


</body>
</html>