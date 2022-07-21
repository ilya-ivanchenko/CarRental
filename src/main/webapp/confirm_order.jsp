
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <title>Confirm order</title>
</head>
<body>
<h3>Check your order and  fill the required data:</h3>
<br/>
<h3>Car:</h3>
<table cellpadding="5">
    <tr>
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
        <th></th>
    </tr>
        <tr scope="row">
            <td>${car.name}</td>
            <td>${car.transmission}</td>
            <td>${car.year}</td>
            <td>${car.drive}</td>
            <td>${car.fuel}</td>
            <td>${car.engineCapacity}</td>
            <td>${car.tank}</td>
            <td>${car.consumption}</td>
            <td>${car.bodyType}</td>
            <td>${car.price}</td>
            <td>${car.mileage}</td>
        </tr>
</table>
<br/>
<%--кол-во дней--%>
<h3 class="dates">Rental dates: с ${start_date} по ${end_date}</h3>


<h3 class="dates">Total days: ${rent_days}</h3>


<h3 class="dates">Total price: ${car.price * rent_days}$</h3>

<br/>
<br/>
<h3>Your information:</h3>
<div>
    <p>Имя: ${user.name}</p>
    <p>Фамилия: ${user.surname}</p>
    <p>Телефон: ${user.phone}</p>
    <p>E-mail: ${user.email}</p>
    <p>ID: ${user.id}</p>
</div>
<br/>
<br/>
<form action="controller" method="post">
    <input type="hidden" name="command" value="create_order"/>
    <input type="hidden" name="total_price" value="${car.price * rent_days}"/>

    Enter passport id:<br/>
    <input type="text" name="passport" value=""  required="required"/> <br/>

    <input type="submit" value="Send book request"/>
</form>
<br/>
<button onclick="location='index.jsp'">Main page</button>
<button onclick="window.history.back();">Back</button>


<jsp:useBean id="now" class="java.util.Date" scope="session"/>

<fmt:formatDate value="${now}" pattern="dd.MM.yyyy"/>

<br/>

</body>
<style>
    h3.dates {
        display: inline-block;
        /*padding-left: 30px;*/
        margin-left: 30px;
    }
</style>
</html>
