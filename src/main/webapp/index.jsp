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
<a href="authorization.jsp">logIn</a>
<a href="registration.jsp">${reg}</a>
<br/>

<form action="controller" method="post">
    <input type="hidden" name="command" value="get_car_list"/>
    <input type="submit"  value="Каталог авто"/>
</form>

<form action="controller" method="post">
    <input type="hidden" name="command" value="get_car_list_filtred"/>
<div>
    <br/>Gear box:<br/>
    <input type="radio" name="transmission" value="Любая" checked/>Любая <br/>
    <input type="radio" name="transmission" value="Механика" />Механика <br/>
    <input type="radio" name="transmission" value="Автомат" />Автомат <br/>
</div>
<div>
    Drive:<br/>
    <input type="checkbox" name="drive" value="Передний" checked/>Передний <br/>
    <input type="checkbox" name="drive" value="Задний" checked/>Задний <br/>
    <input type="checkbox" name="drive" value="Полный" checked/>Полный <br/>
</div>
    <div class="aaa" >
        <br/>Engine:<br/>
        <input type="checkbox" name="fuel" value="Бензин" checked/>Бензин <br/>
        <input type="checkbox" name="fuel" value="Дизель" checked/>Дизель <br/>
        <input type="checkbox" name="fuel" value="Электро" checked/>Электро <br/>
    </div>
<div>
    Engine capacity, l.:<br/>
    <select name="engine_capacity1">
                <option value="1.0">1.0</option>
                <option value="1.4">1.4</option>
                <option value="1.6">1.6</option>
                <option value="1.8">1.8</option>
                <option value="2.0">2.0</option>
                <option value="2.5">2.5</option>
                <option value="3.0">3.0</option>
    </select>
    <select name="engine_capacity2">
        <option value="1.0">1.0</option>
        <option value="1.4">1.4</option>
        <option value="1.6">1.6</option>
        <option value="1.8">1.8</option>
        <option value="2.0">2.0</option>
        <option value="2.5">2.5</option>
        <option value="3.0">3.0</option>
    </select>
</div>
    <div>
        Consumption, l/100 km:<br/>
        <select name="consumption1">
            <option value="4.0">4.0</option>
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
            <option value="12.0">12.0</option>
        </select>
    </div>
<div>
    Cost per day, $:<br/>
    <select name="price1">
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
        <option value="90">90</option>
    </select>
</div>

<%--    <select name="transmission">--%>
<%--        <option value="">Любая</option>--%>
<%--        <option value="Механика">Механика</option>--%>
<%--        <option value="Автомат">Автомат</option>--%>
<%--    </select>--%>


<%--    ...--%>
    <br/><input type="submit" value="Применить"/>
</form>

<h3>${name}</h3>

<table cellpadding="5">
<tr>
<%--    <th scope="col">id</th>--%>
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
<%--        <td>${cars.id}</td>--%>
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




<br/>
<button onclick="location='registration.jsp'">Registration</button>


<%--<tr>--%>
<%--    <td>${car1.id}</td>--%>
<%--    <td>${car1.name}</td>--%>
<%--    <td>${cars[1].name}</td>--%>
<%--</tr>--%>


<%--форма авторизации  method="get" или post  --%>
<%--<form action="mainpage" method="get">  &lt;%&ndash; post &ndash;%&gt;--%>
<%--    <input type="hidden" name="command" value="authorization"/>--%>

<%--    Enter email:<br/>--%>
<%--    <input type="text" name="email" value=""/> <br/>--%>

<%--    Enter password:<br/>--%>
<%--    <input type="password" name="password" value=""/> <br/>--%>

<%--    <input type="submit" value="Send"/>--%>
<%--</form>--%>



<c:set var="admin" value="admin_user" scope="session"/>
<c:set var="manger" value="manager_user" scope="session"/>
<c:set var="customer" value="customer_user" scope="session"/>
<c:choose>
    <c:when test="${user.role==2}">
        <button onclick="location='customer_home.jsp'">Customer page</button>
    </c:when>
</c:choose>

<br/>

<style>
    /*div.aaa { display: inline;*/
    /*margin-right: 30px;*/
    /*text-align: left;}*/
    div {
        display: inline-block;
        padding: 10px;
    }
    form.local {
        display: inline-block;

    }
</style>

</body>
</html>
