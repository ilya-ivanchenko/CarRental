
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
    <fmt:message bundle="${localization}" key="local.checkpassport" var="checkpassport"/>
    <title>${confirmorder}</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/common.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/confirm_order.css" type="text/css">
</head>
<body>
<jsp:include page="header.jsp"/>
<c:set  var="page"  value="confirm_order.jsp" scope="session"/>
<br/>
<div>
    <h3>${checkorder}:</h3>
<table cellpadding="5">
    <tr>
        <th scope="col">${Car}</th>
        <th scope="col">${gearbox}</th>
        <th scope="col">${year}</th>
        <th scope="col">${drive}</th>
        <th scope="col">${engine}</th>
        <c:choose>
            <c:when test="${car.fuel != 'Электро'}">
                <th scope="col">${capacity}</th>
                <th scope="col">${tank}</th>
                <th scope="col">${consumption}</th>
            </c:when>
            <c:when test="${car.fuel =='Электро'}">
                <th scope="col">${power}</th>
            </c:when>
        </c:choose>
        <th scope="col">${body}</th>
        <th scope="col">${priceday}, $</th>
    </tr>
    <tr scope="row">
        <td>${car.name}</td>
        <td>${car.transmission}</td>
        <td>${car.year}</td>
        <td>${car.drive}</td>
        <td>${car.fuel}</td>
        <c:choose>
            <c:when test="${car.fuel != 'Электро'}">
                <td>${car.engineCapacity}</td>
                <td>${car.tank}</td>
                <td>${car.consumption}</td>
            </c:when>
            <c:when test="${car.fuel == 'Электро'}">
                <td>${car.mileage}</td>
            </c:when>
        </c:choose>
        <td>${car.bodyType}</td>
        <td>${car.price}</td>
    </tr>
</table>
<h4 class="dates">${dates}: ${from} ${start_date} ${to} ${end_date}</h4>
<h4 class="dates">${totaldays}:     ${rent_days}</h4>
<h4 class="dates">${totalprice}:    ${car.price * rent_days}$</h4>
<div>
    <p>${Name}: ${user.name}</p>
    <p>${Surname}: ${user.surname}</p>
    <p>${Phone}: ${user.phone}</p>
    <p>${Mail}: ${user.email}</p>
    <p>ID: ${user.id}</p>
</div>

<form class="auth" action="controller" method="post">
    <input type="hidden" name="command" value="create_order"/>
    <input type="hidden" name="total_price" value="${car.price * rent_days}"/>
    ${writecomment}:<br/>
    <textarea name="comment" cols="30" rows="3"></textarea>
    <br/>${passportid}:<br/>
    <input type="text"
           name="passport"
           value=""
           required="required"
           pattern="([A-Za-z]{2}\d{7})"
           oninvalid="this.setCustomValidity('${checkpassport}')"
           oninput="this.setCustomValidity('')"
           autocomplete="off"
    /> <br/>
    <input  class="button" type="submit" value="${sendbookrequest}"/>
</form>
<p class="ok_message">${message}</p>

</div>
<script src="/JS/confirm_order.js"></script>
</body>
</html>
