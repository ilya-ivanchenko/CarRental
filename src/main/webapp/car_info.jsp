
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="local" var="localization"/>

    <fmt:message bundle="${localization}" key="local.carinfo" var="carinfo"/>
    <fmt:message bundle="${localization}" key="local.carsall" var="carsall"/>
    <fmt:message bundle="${localization}" key="local.deletecar" var="deletecar"/>
    <fmt:message bundle="${localization}" key="local.back" var="back"/>
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
    <fmt:message bundle="${localization}" key="local.car" var="car"/>

    <title>${carinfo}</title>
</head>
<jsp:include page="header.jsp"/>
<c:set  var="page"  value="car_info.jsp" scope="session"/>
<body>

<button onclick="window.history.back();">${back}</button>
<h3>${carsall}:</h3>
<p class="ok_message">${message}</p>
<form action="controller" method="post">
    <input type="hidden" name="command" value="delete_car"/>

<c:choose>
    <c:when test="${cars.size() > 0}">

        <table cellpadding="5">
            <tr><th></th>
                <th scope="col">ID</th>
                <th scope="col">${car}</th>
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
                    <td>${cars.price}</td>
                    <td>${cars.mileage}</td>

                </tr>
            </c:forEach>
        </table>
    </c:when>
</c:choose>
    <input class="del" type="submit" value="${deletecar}"/>
</form>





</body>
<style>
    p.ok_message {
        color: blue;
    }
    td {
        text-align: center;
    }
    input.del {
        color: red;
    }
</style>
</html>
