
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="local" var="localization"/>

    <fmt:message bundle="${localization}" key="local.confirmorder" var="confirmorder"/>
    <fmt:message bundle="${localization}" key="local.checkorder" var="checkorder"/>
    <fmt:message bundle="${localization}" key="local.from" var="from"/>
    <fmt:message bundle="${localization}" key="local.to" var="to"/>
    <fmt:message bundle="${localization}" key="local.writecomment" var="writecomment"/>
    <fmt:message bundle="${localization}" key="local.passportid" var="passportid"/>
    <fmt:message bundle="${localization}" key="local.sendbookrequest" var="sendbookrequest"/>
    <fmt:message bundle="${localization}" key="local.car" var="Car"/>
    <fmt:message bundle="${localization}" key="local.gearbox" var="gearbox"/>
    <fmt:message bundle="${localization}" key="local.drive" var="drive"/>
    <fmt:message bundle="${localization}" key="local.engine" var="engine"/>
    <fmt:message bundle="${localization}" key="local.capacity" var="capacity"/>
    <fmt:message bundle="${localization}" key="local.consumption" var="consumption"/>
    <fmt:message bundle="${localization}" key="local.priceday" var="priceday"/>
    <fmt:message bundle="${localization}" key="local.year" var="year"/>
    <fmt:message bundle="${localization}" key="local.tank" var="tank"/>
    <fmt:message bundle="${localization}" key="local.body" var="body"/>
    <fmt:message bundle="${localization}" key="local.power" var="power"/>
    <fmt:message bundle="${localization}" key="local.dates" var="dates"/>
    <fmt:message bundle="${localization}" key="local.totaldays" var="totaldays"/>
    <fmt:message bundle="${localization}" key="local.totalprice" var="totalprice"/>
    <fmt:message bundle="${localization}" key="local.yourinfo" var="yourinfo"/>
    <fmt:message bundle="${localization}" key="local.Name" var="Name"/>
    <fmt:message bundle="${localization}" key="local.Surname" var="Surname"/>
    <fmt:message bundle="${localization}" key="local.Phone" var="Phone"/>
    <fmt:message bundle="${localization}" key="local.Mail" var="Mail"/>
    <fmt:message bundle="${localization}" key="local.back" var="back"/>

    <title>${confirmorder}</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<c:set  var="page"  value="confirm_order.jsp" scope="session"/>
<h3>${checkorder}:</h3>
<br/>
<table cellpadding="5">
    <tr>
        <th scope="col">${Car}</th>
        <th scope="col">${gearbox}</th>
        <th scope="col">${year}</th>
        <th scope="col">${drive}</th>
        <th scope="col">${engine}</th>
        <th scope="col">${capacity}</th>
        <th scope="col">${tank}</th>
        <th scope="col">${consumption}</th>
        <th scope="col">${body}</th>
        <th scope="col">${priceday}, $</th>
        <th scope="col">${power}</th>
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
<h3 class="dates">${dates}: ${from} ${start_date} ${to} ${end_date}</h3>


<h3 class="dates">${totaldays}: ${rent_days}</h3>


<h3 class="dates">${totalprice}: ${car.price * rent_days}$</h3>
<br/>

<h3>${yourinfo}:</h3>
<div>
    <p>${Name}: ${user.name}</p>
    <p>${Surname}: ${user.surname}</p>
    <p>${Phone}: ${user.phone}</p>
    <p>${Mail}: ${user.email}</p>
    <p>ID: ${user.id}</p>
</div>

<form action="controller" method="post">
    <input type="hidden" name="command" value="create_order"/>
    <input type="hidden" name="total_price" value="${car.price * rent_days}"/>
    ${writecomment}:<br/>
    <textarea name="comment" cols="30" rows="3"></textarea>
    <br/>
    ${passportid}:<br/>
    <input type="text" name="passport" value=""  required="required"/> <br/>
    <input type="submit" value="${sendbookrequest}"/>
</form>
<p class="ok_message">${message}</p>
<br/>
<button onclick="window.history.back();">${back}</button>
</body>
<style>
    h3.dates {
        display: inline-block;
        /*padding-left: 30px;*/
        margin-left: 30px;
    }
    p.ok_message {
        color: blue;
    }
    td {
        text-align: center;
    }
</style>
</html>
