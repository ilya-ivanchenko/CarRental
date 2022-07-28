<%@ page  import="by.ivanchenko.carrental.bean.user.User" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  %>
<%--<%@ page isELIgnored="true" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
    <title>Main</title>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="local" var="localization"/>

    <fmt:message bundle="${localization}" key="local.gearbox" var="gearbox"/>
    <fmt:message bundle="${localization}" key="local.drive" var="drive"/>
    <fmt:message bundle="${localization}" key="local.engine" var="engine"/>
    <fmt:message bundle="${localization}" key="local.capacity" var="capacity"/>
    <fmt:message bundle="${localization}" key="local.consumption" var="consumption"/>
    <fmt:message bundle="${localization}" key="local.price" var="price"/>
    <fmt:message bundle="${localization}" key="local.dates" var="dates"/>
    <fmt:message bundle="${localization}" key="local.apply" var="apply"/>
    <fmt:message bundle="${localization}" key="local.any" var="any"/>
    <fmt:message bundle="${localization}" key="local.any1" var="any1"/>
    <fmt:message bundle="${localization}" key="local.manual" var="manual"/>
    <fmt:message bundle="${localization}" key="local.automatic" var="automatic"/>
    <fmt:message bundle="${localization}" key="local.front" var="front"/>
    <fmt:message bundle="${localization}" key="local.rear" var="rear"/>
    <fmt:message bundle="${localization}" key="local.full" var="full"/>
    <fmt:message bundle="${localization}" key="local.gasoline" var="gasoline"/>
    <fmt:message bundle="${localization}" key="local.diesel" var="diesel"/>
    <fmt:message bundle="${localization}" key="local.electro" var="electro"/>
    <fmt:message bundle="${localization}" key="local.totaldays" var="totaldays"/>
    <fmt:message bundle="${localization}" key="local.totalprice" var="totalprice"/>
    <fmt:message bundle="${localization}" key="local.book" var="book"/>
    <fmt:message bundle="${localization}" key="local.car" var="car"/>
    <fmt:message bundle="${localization}" key="local.year" var="year"/>
    <fmt:message bundle="${localization}" key="local.tank" var="tank"/>
    <fmt:message bundle="${localization}" key="local.body" var="body"/>
    <fmt:message bundle="${localization}" key="local.power" var="power"/>


</head>
<body>

<c:set  var="page"  value="index.jsp" scope="session"/>
<jsp:include page="header.jsp"/>

<c:choose>
    <c:when test="${cars != null}">

<form action="controller" method="post">
    <input type="hidden" name="command" value="get_car_list_filtred"/>
<div>
    <br/>${gearbox}:<br/>
    <input type="radio" name="transmission" value="%" checked/>${any}<br/>
    <input type="radio" name="transmission" value="Механика" />${manual}<br/>
    <input type="radio" name="transmission" value="Автомат" />${automatic}<br/>
</div>
<div>
    ${drive}:<br/>
    <input type="radio" name="drive" value="%" checked/>${any1}<br/>
    <input type="radio" name="drive" value="Передний" />${front}<br/>
    <input type="radio" name="drive" value="Задний" />${rear}<br/>
    <input type="radio" name="drive" value="Полный" />${full}<br/>
</div>
    <div>
        <br/>${engine}:<br/>
        <input type="radio" name="fuel" value="%" checked/>${any1}<br/>
        <input type="radio" name="fuel" value="Бензин" />${gasoline}<br/>
        <input type="radio" name="fuel" value="Дизель" />${diesel}<br/>
        <input type="radio" name="fuel" value="Электро" />${electro}<br/>
    </div>
<div>
    ${capacity}:<br/>
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
        ${consumption}:<br/>
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
    ${price}, $:<br/>
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
    ${dates}:<br/>
    <input type="date" name="date1" value="${currentDate}" min="${currentDate}" max="${maxDate}" >
    <input type="date" name="date2" value="${currentDatePlus}" min="${currentDatePlus}" max="${maxDate}" >
</div>
    <c:choose>
        <c:when test="${rent_days!=null}">
            <div>
            ${totaldays}: ${rent_days}
            </div>
        </c:when>
    </c:choose>
    <br/>
    <br/>
    <input type="submit" value="${apply}"/>
</form>
<br/>

<table cellpadding="5">
<tr>
    <th scope="col">${car}</th>
    <th scope="col">${gearbox}</th>
    <th scope="col">${year}</th>
    <th scope="col">${drive}</th>
    <th scope="col">${engine}</th>
    <th scope="col">${capacity}</th>
    <th scope="col">${tank}</th>
    <th scope="col">${consumption}</th>
    <th scope="col">${body}</th>
    <th scope="col">${price}</th>
    <th scope="col">${power}</th>
    <c:choose>
        <c:when test="${rent_days!=null}">
            <th scope="col">${totalprice}</th>
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
                <input type="submit"  value="${book}"/>
            </form>
        </td>
    </tr>
</c:forEach>
    </table>
    </c:when>
</c:choose>
<br/>

</body>





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
