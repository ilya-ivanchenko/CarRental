<%@ page import="by.ivanchenko.carrental.bean.User" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  %>
<%--<%@ page isELIgnored="true" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="local" var="localization"/>

    <fmt:message bundle="${localization}" key="local.gearbox" var="gearbox"/>
    <fmt:message bundle="${localization}" key="local.drive" var="drive"/>
    <fmt:message bundle="${localization}" key="local.engine" var="engine"/>
    <fmt:message bundle="${localization}" key="local.capacity" var="capacity"/>
    <fmt:message bundle="${localization}" key="local.consumption" var="consumption"/>
    <fmt:message bundle="${localization}" key="local.priceday" var="priceday"/>
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
    <fmt:message bundle="${localization}" key="local.catalog" var="main"/>
    <fmt:message bundle="${localization}" key="local.nocars" var="nocars"/>
    <title>${main}</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/common.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/index.css" type="text/css">
</head>
<body>
<c:set  var="page"  value="index.jsp" scope="session"/>
<jsp:include page="header.jsp"/>

<c:choose>
    <c:when test="${cars != null}">

<div class="cars-filter">
    <form action="controller" method="post">
        <input type="hidden" name="command" value="get_car_list_filtered"/>
        <div class="filter">
            <span class="filter-name">${gearbox}:</span>
            <input type="radio" name="transmission" value="%" checked/>${any}<br/>
            <input type="radio" name="transmission" value="Механика"  ${gearboxType == 'Механика' ? 'checked' : ''} />${manual}<br/>
            <input type="radio" name="transmission" value="Автомат" ${gearboxType == 'Автомат' ? 'checked' : ''} />${automatic}<br/>
        </div>
        <div class="filter">
            <span class="filter-name">${drive}:</span>
            <input type="radio" name="drive" value="%" checked/>${any1}<br/>
            <input type="radio" name="drive" value="Передний" ${driveType == 'Передний' ? 'checked' : ''}/>${front}<br/>
            <input type="radio" name="drive" value="Задний" ${driveType == 'Задний' ? 'checked' : ''}/>${rear}<br/>
            <input type="radio" name="drive" value="Полный" ${driveType == 'Полный' ? 'checked' : ''} />${full}<br/>
        </div>
        <div class="filter">
            <span class="filter-name">${engine}:</span>
            <input type="radio" name="fuel" value="%" checked/>${any1}<br/>
            <input type="radio" name="fuel" value="Бензин" ${fuelType == 'Бензин' ? 'checked' : ''}/>${gasoline}<br/>
            <input type="radio" name="fuel" value="Дизель" ${fuelType == 'Дизель' ? 'checked' : ''}/>${diesel}<br/>
            <input type="radio" name="fuel" value="Электро" ${fuelType == 'Электро' ? 'checked' : ''}/>${electro}<br/>
        </div>

        <div class="filter filter-dvs">
            <div>
                <span class="filter-name">${capacity}:</span>
                <select name="engine_capacity1">
                    <option selected value="0.0" >0.0</option>
                    <option value="1.4" ${engineCapacity1 == '1.4' ? 'selected' : ''}>1.4</option>
                    <option value="1.6" ${engineCapacity1 == '1.6' ? 'selected' : ''}>1.6</option>
                    <option value="1.8" ${engineCapacity1 == '1.8' ? 'selected' : ''}>1.8</option>
                    <option value="2.0" ${engineCapacity1 == '2.0' ? 'selected' : ''}>2.0</option>
                    <option value="2.5" ${engineCapacity1 == '2.5' ? 'selected' : ''}>2.5</option>
                    <option value="3.0" ${engineCapacity1 == '3.0' ? 'selected' : ''}>3.0</option>
                </select>
                <select name="engine_capacity2">
                    <option value="0.0" ${engineCapacity2 == '0.0' ? 'selected' : ''}>0.0</option>
                    <option value="1.4" ${engineCapacity2 == '1.4' ? 'selected' : ''}>1.4</option>
                    <option value="1.6" ${engineCapacity2 == '1.6' ? 'selected' : ''}>1.6</option>
                    <option value="1.8" ${engineCapacity2 == '1.8' ? 'selected' : ''}>1.8</option>
                    <option value="2.0" ${engineCapacity2 == '2.0' ? 'selected' : ''}>2.0</option>
                    <option value="2.5" ${engineCapacity2 == '2.5' ? 'selected' : ''}>2.5</option>
                    <option value="3.0" ${engineCapacity2 == '3.0' ? 'selected' : ''}>3.0</option>
                </select>
            </div>
            <div>
                <span class="filter-name">${consumption}:</span>
                <select name="consumption1">
                    <option value="0.0" ${engineConsumption1 == '0.0' ? 'selected' : ''}>4.0</option>
                    <option value="5.0" ${engineConsumption1 == '5.0' ? 'selected' : ''}>5.0</option>
                    <option value="6.0" ${engineConsumption1 == '6.0' ? 'selected' : ''}>6.0</option>
                    <option value="7.0" ${engineConsumption1 == '7.0' ? 'selected' : ''}>7.0</option>
                    <option value="8.0" ${engineConsumption1 == '8.0' ? 'selected' : ''}>8.0</option>
                    <option value="9.0" ${engineConsumption1 == '9.0' ? 'selected' : ''}>9.0</option>
                    <option value="10.0" ${engineConsumption1 == '10.0' ? 'selected' : ''}>10.0</option>
                    <option value="11.0" ${engineConsumption1 == '11.0' ? 'selected' : ''}>11.0</option>
                    <option value="12.0" ${engineConsumption1 == '12.0' ? 'selected' : ''}>12.0</option>
                </select>
                <select name="consumption2">
                    <option value="4.0" ${engineConsumption2 == '4.0' ? 'selected' : ''}>4.0</option>
                    <option value="5.0" ${engineConsumption2 == '5.0' ? 'selected' : ''}>5.0</option>
                    <option value="6.0" ${engineConsumption2 == '6.0' ? 'selected' : ''}>6.0</option>
                    <option value="7.0" ${engineConsumption2 == '7.0' ? 'selected' : ''}>7.0</option>
                    <option value="8.0" ${engineConsumption2 == '8.0' ? 'selected' : ''}>8.0</option>
                    <option value="9.0" ${engineConsumption2 == '9.0' ? 'selected' : ''}>9.0</option>
                    <option value="10.0" ${engineConsumption2 == '10.0' ? 'selected' : ''}>10.0</option>
                    <option value="11.0" ${engineConsumption2 == '11.0' ? 'selected' : ''}>11.0</option>
                    <option value="12.0" ${engineConsumption2 == '12.0' ? 'selected' : ''}>12.0</option>
                </select>
            </div>
        </div>

        <div class="filter">
            <span class="filter-name">${priceday}, $:</span>
            <select name="price1">
                <option value="15" ${rentPrice1 == '15' ? 'selected' : ''}>15</option>
                <option value="20" ${rentPrice1 == '20' ? 'selected' : ''}>20</option>
                <option value="25" ${rentPrice1 == '25' ? 'selected' : ''}>25</option>
                <option value="30" ${rentPrice1 == '30' ? 'selected' : ''}>30</option>
                <option value="35" ${rentPrice1 == '35' ? 'selected' : ''}>35</option>
                <option value="40" ${rentPrice1 == '40' ? 'selected' : ''}>40</option>
                <option value="45" ${rentPrice1 == '45' ? 'selected' : ''}>45</option>
                <option value="50" ${rentPrice1 == '50' ? 'selected' : ''}>50</option>
                <option value="60" ${rentPrice1 == '60' ? 'selected' : ''}>60</option>
                <option value="70" ${rentPrice1 == '70' ? 'selected' : ''}>70</option>
                <option value="80" ${rentPrice1 == '80' ? 'selected' : ''}>80</option>
                <option value="90" ${rentPrice1 == '90' ? 'selected' : ''}>90</option>
                <option value="100" ${rentPrice1 == '100' ? 'selected' : ''}>100</option>
                <option value="110" ${rentPrice1 == '110' ? 'selected' : ''}>110</option>
                <option value="120" ${rentPrice1 == '120' ? 'selected' : ''}>120</option>
            </select>
            <select name="price2">
                <option value="15" ${rentPrice2 == '15' ? 'selected' : ''}>15</option>
                <option value="20" ${rentPrice2 == '20' ? 'selected' : ''}>20</option>
                <option value="25" ${rentPrice2 == '25' ? 'selected' : ''}>25</option>
                <option value="30" ${rentPrice2 == '30' ? 'selected' : ''}>30</option>
                <option value="35" ${rentPrice2 == '35' ? 'selected' : ''}>35</option>
                <option value="40" ${rentPrice2 == '40' ? 'selected' : ''}>40</option>
                <option value="45" ${rentPrice2 == '45' ? 'selected' : ''}>45</option>
                <option value="50" ${rentPrice2 == '50' ? 'selected' : ''}>50</option>
                <option value="60" ${rentPrice2 == '60' ? 'selected' : ''}>60</option>
                <option value="70" ${rentPrice2 == '70' ? 'selected' : ''}>70</option>
                <option value="80" ${rentPrice2 == '80' ? 'selected' : ''}>80</option>
                <option value="90" ${rentPrice2 == '90' ? 'selected' : ''}>90</option>
                <option value="100" ${rentPrice2 == '100' ? 'selected' : ''}>100</option>
                <option value="110" ${rentPrice2 == '110' ? 'selected' : ''}>110</option>
                <option value="120" ${rentPrice2 == '120' ? 'selected' : ''}>120</option>
            </select>
        </div>

        <div>
            <div class="filter filter-dates">
                <span class="filter-name">${dates}:</span>
                <input id="rentStartDate" type="date" name="date1" value="${currentDate}" min="${currentDate}" max="${maxDate}" >
                <input id="rentEndDate" type="date" name="date2" value="${currentDatePlus}" min="${currentDatePlus}" max="${maxDate}" >
                <c:choose>
                    <c:when test="${rent_days!=null}">
                        <span>
                                ${totaldays}: ${rent_days}
                        </span>
                    </c:when>
                </c:choose>
            </div>
            <div class="cars-filter-apply">
                <input class="button" type="submit" value="${apply}"/>
            </div>
        </div>
    </form>
</div>


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
    <th scope="col">${priceday}, $</th>
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
            <c:choose>
                <c:when test="${cars.fuel == 'Электро'}">
                    <td colspan="3">-</td>
                    <td>${cars.bodyType}</td>
                    <td>${cars.price}</td>
                    <td>${cars.mileage}</td>
                </c:when>
                <c:when test="${cars.fuel != 'Электро'}">
                    <td>${cars.engineCapacity}</td>
                    <td>${cars.tank}</td>
                    <td>${cars.consumption}</td>
                    <td>${cars.bodyType}</td>
                    <td>${cars.price}</td>
                    <td>-</td>
                </c:when>
            </c:choose>
        <c:choose>
            <c:when test="${rent_days!=null}">
                <td class="price">${cars.price * rent_days}$</td>
            </c:when>
        </c:choose>
        <td>
            <form action="controller" method="post">
                <input type="hidden" name="command" value="book_car"/>
                <input type="hidden" name="car" value="${cars.id}" />
                <input class="button-book" type="submit"  value="${book}"/>
            </form>
        </td>
    </tr>
</c:forEach>
    </table>
    </c:when>
</c:choose>
<c:choose>
    <c:when test="${cars.size()<1}">
        <br/>
        <br/>
        <p class="nocars">${nocars}</p>
    </c:when>
</c:choose>

</body>





<%--<c:set var="admin" value="admin_user" scope="session"/>--%>
<%--<c:set var="manager" value="manager_user" scope="session"/>--%>
<%--<c:set var="customer" value="customer_user" scope="session"/>--%>



<%--${start_date}--%>
<%--${end_date}--%>
<%--date: ${currentDate}--%>
<%--days: ${rent_days}--%>

<script src="../JS/index.js"></script>
</body>
</html>
