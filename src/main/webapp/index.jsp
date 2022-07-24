<%@ page  import="by.ivanchenko.carrental.bean.user.User" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  %>
<%--<%@ page isELIgnored="true" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
    <title>Main</title>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="local" var="localization"/> <%-- "local" - стандатрные данные  --%>

    <fmt:message bundle="${localization}" key="local.cars" var="name"/>
    <fmt:message bundle="${localization}" key="local.registration" var="reg"/>
    <fmt:message bundle="${localization}" key="local.locbutton.name.en" var="en_button"/>
    <fmt:message bundle="${localization}" key="local.locbutton.name.ru" var="ru_button"/>
    <fmt:message bundle="${localization}" key="local.locbutton.name.by" var="by_button"/>
</head>
<body>
<form class="local" action="controller" method="post">
    <input type="hidden" name="local" value="en"/>
    <input type="hidden" name="command" value="change_lang"/>
    <input type="submit" value="${en_button}" />
</form>

<form class="local" action="controller" method="post">
    <input type="hidden" name="local" value="ru"/>
    <input type="hidden" name="command" value="change_lang"/>
    <input type="submit" value="${ru_button}" />
</form>

<form class="local" action="controller" method="post">
    <input type="hidden" name="local" value="by"/>
    <input type="hidden" name="command" value="change_lang"/>
    <input type="submit" value="${by_button}" />
</form>
<br/>
<br/>

<c:choose>
    <c:when test="${user==null || user.role == 4}">
        <button onclick="location='registration.jsp'">${reg}</button>
        <button onclick="location='authorization.jsp'">Log In</button>
    </c:when>
</c:choose>

<c:choose>
    <c:when test="${user!=null}">
        <form class="logout" action="controller" method="post">
            <input type="hidden" name="command" value="log_out"/>
            <input type="hidden" name="filter" value=""/>
            <input type="submit"  value="Log out"/>
        </form>
    </c:when>
</c:choose>

<c:choose>
    <c:when test="${user.role>1}">
        <button class="yourpage" onclick="location='user_home.jsp'">My profile</button>
    </c:when>
</c:choose>
<br/>
<br/>


<form action="controller" method="post">
    <input type="hidden" name="command" value="get_car_list"/>
    <input type="submit"  value="Каталог авто"/>
</form>



<h3>${name}</h3>
<c:choose>
    <c:when test="${cars != null}">

<form action="controller" method="post">
    <input type="hidden" name="command" value="get_car_list_filtred"/>
<div>
    <br/>Gear box:<br/>
    <input type="radio" name="transmission" value="%" checked/>Любая <br/>
    <input type="radio" name="transmission" value="Механика" />Механика <br/>
    <input type="radio" name="transmission" value="Автомат" />Автомат <br/>
</div>
<div>
    Drive:<br/>
    <input type="radio" name="drive" value="%" checked/>Любой <br/>
    <input type="radio" name="drive" value="Передний" />Передний <br/>
    <input type="radio" name="drive" value="Задний" />Задний <br/>
    <input type="radio" name="drive" value="Полный" />Полный <br/>
</div>
    <div>
        <br/>Engine:<br/>
        <input type="radio" name="fuel" value="%" checked/>Любой <br/>
        <input type="radio" name="fuel" value="Бензин" />Бензин <br/>
        <input type="radio" name="fuel" value="Дизель" />Дизель <br/>
        <input type="radio" name="fuel" value="Электро" />Электро <br/>
    </div>
<div>
    Engine capacity, l.:<br/>
    <select name="engine_capacity1">
                <option selected value="0.0">0.0</option>
                <option value="1.4">1.4</option>
                <option value="1.6">1.6</option>
                <option value="1.8">1.8</option>
                <option value="2.0">2.0</option>
                <option value="2.5">2.5</option>
                <option value="3.0">3.0</option>
    </select>
    <select name="engine_capacity2">
        <option value="0.0">0.0</option>
        <option value="1.4">1.4</option>
        <option value="1.6">1.6</option>
        <option value="1.8">1.8</option>
        <option value="2.0">2.0</option>
        <option value="2.5">2.5</option>
        <option selected value="3.0">3.0</option>
    </select>
</div>
    <div>
        Consumption, l/100 km:<br/>
        <select name="consumption1">
            <option selected value="0.0">4.0</option>
            <option value="5.0">5.0</option>
            <option value="6.0">6.0</option>
            <option value="7.0">7.0</option>
            <option value="8.0">8.0</option>
            <option value="9.0">9.0</option>
            <option value="10.0">10.0</option>
            <option value="11.0">11.0</option>
            <option value="12.0">12.0</option>
        </select>
        <select name="consumption2">
            <option value="4.0">4.0</option>
            <option value="5.0">5.0</option>
            <option value="6.0">6.0</option>
            <option value="7.0">7.0</option>
            <option value="8.0">8.0</option>
            <option value="9.0">9.0</option>
            <option value="10.0">10.0</option>
            <option value="11.0">11.0</option>
            <option selected value="12.0">12.0</option>
        </select>
    </div>
<div>
    Cost per day, $:<br/>
    <select name="price1">
        <option selected value="15">15</option>
        <option value="20">20</option>
        <option value="25">25</option>
        <option value="30">30</option>
        <option value="35">35</option>
        <option value="40">40</option>
        <option value="45">45</option>
        <option value="50">50</option>
        <option value="60">60</option>
        <option value="70">70</option>
        <option value="80">80</option>
        <option value="90">90</option>
    </select>
    <select name="price2">
        <option value="15">15</option>
        <option value="20">20</option>
        <option value="25">25</option>
        <option value="30">30</option>
        <option value="35">35</option>
        <option value="40">40</option>
        <option value="45">45</option>
        <option value="50">50</option>
        <option value="60">60</option>
        <option value="70">70</option>
        <option value="80">80</option>
        <option  selected value="90">90</option>
    </select>
</div>
<div>
    Rental dates:<br/>
    <input type="date" name="date1" value="${currentDate}" min="${currentDate}" max="${maxDate}" >
    <input type="date" name="date2" value="${currentDatePlus}" min="${currentDatePlus}" max="${maxDate}" >
</div>
    <c:choose>
        <c:when test="${rent_days!=null}">
            <div>
            Total rental days: ${rent_days}
            </div>
        </c:when>
    </c:choose>
    <br/><input type="submit" value="Применить"/>
</form>

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
    <th scope="col">Cost per day</th>
    <th scope="col">Mileage</th>
    <c:choose>
        <c:when test="${rent_days!=null}">
            <th scope="col">Total price</th>
        </c:when>
    </c:choose>
    <th></th>
</tr>

<c:forEach  var="cars" items="${cars}">
    <tr scope="row">
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
        <c:choose>
            <c:when test="${rent_days!=null}">
                <td class="price">${cars.price * rent_days}$</td>
            </c:when>
        </c:choose>
        <td>
            <form action="controller" method="post">
                <input type="hidden" name="command" value="book_car"/>
                <input type="hidden" name="car" value="${cars.id}" />
                <input type="submit"  value="Забронировать"/>
            </form>
        </td>
    </tr>
</c:forEach>
    </table>
    </c:when>
</c:choose>
<br/>






<%--<c:set var="admin" value="admin_user" scope="session"/>--%>
<%--<c:set var="manager" value="manager_user" scope="session"/>--%>
<%--<c:set var="customer" value="customer_user" scope="session"/>--%>



<%--${start_date}--%>
<%--${end_date}--%>
<%--date: ${currentDate}--%>
<%--days: ${rent_days}--%>
<style>
    div {
        display: inline-block;
        padding: 10px;
    }
    form.local {
        display: inline-block;
    }
    form.logout {
        display: inline-block;
    }
    button.yourpage {
        display: inline-block;
    }
    td.price {
        font-weight: bold;
    }
    td {
        text-align: center;
    }


</style>

</body>
</html>
