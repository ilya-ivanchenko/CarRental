
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Car info</title>
</head>
<jsp:include page="header.jsp"/>
<c:set  var="page"  value="car_info.jsp" scope="session"/>
<body>

<button onclick="window.history.back();">Back</button>
<h3>All cars:</h3>
<p class="ok_message">${message}</p>
<form action="controller" method="post">
    <input type="hidden" name="command" value="delete_car"/>

<c:choose>
    <c:when test="${cars.size() > 0}">

        <table cellpadding="5">
            <tr><th></th>
                <th scope="col">ID</th>
                <th scope="col">Car</th>
                <th scope="col">Transmission</th>
                <th scope="col">Year</th>
                <th scope="col">Drive</th>
                <th scope="col">Fuel</th>
                <th scope="col">Engine Capacity</th>
                <th scope="col">Tank</th>
                <th scope="col">Consumption</th>
                <th scope="col">Body Type</th>
                <th scope="col">Cost per day</th>
                <th scope="col">Mileage</th>
            </tr>

            <c:forEach  var="cars" items="${cars}">
                <tr scope="row">
                    <td>  <input type="radio" name="id" value="${cars.id}"/></td>
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
                    <td>${cars.price}$</td>
                    <td>${cars.mileage}</td>

                </tr>
            </c:forEach>
        </table>
    </c:when>
</c:choose>
    <input type="submit" value="Delete car"/>
</form>





</body>
<style>
    p.ok_message {
        color: blue;
    }
</style>
</html>
