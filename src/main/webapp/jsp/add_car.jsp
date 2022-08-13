
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="local" var="localization"/>

    <fmt:message bundle="${localization}" key="local.addignewcar" var="addingnewcar"/>
    <fmt:message bundle="${localization}" key="local.Namecar" var="Namecar"/>
    <fmt:message bundle="${localization}" key="local.capacity" var="capacity"/>
    <fmt:message bundle="${localization}" key="local.gearbox" var="gearbox"/>
    <fmt:message bundle="${localization}" key="local.manual" var="manual"/>
    <fmt:message bundle="${localization}" key="local.automatic" var="automaic"/>
    <fmt:message bundle="${localization}" key="local.year" var="year"/>
    <fmt:message bundle="${localization}" key="local.drive" var="drive"/>
    <fmt:message bundle="${localization}" key="local.rear" var="rear"/>
    <fmt:message bundle="${localization}" key="local.front" var="front"/>
    <fmt:message bundle="${localization}" key="local.full" var="full"/>
    <fmt:message bundle="${localization}" key="local.tank" var="tank"/>
    <fmt:message bundle="${localization}" key="local.consumption" var="consumption"/>
    <fmt:message bundle="${localization}" key="local.engine" var="engine"/>
    <fmt:message bundle="${localization}" key="local.gasoline" var="gasoline"/>
    <fmt:message bundle="${localization}" key="local.diesel" var="diesel"/>
    <fmt:message bundle="${localization}" key="local.electro" var="electro"/>
    <fmt:message bundle="${localization}" key="local.addcar" var="addcar"/>
    <fmt:message bundle="${localization}" key="local.sedan" var="sedan"/>
    <fmt:message bundle="${localization}" key="local.hatchback" var="hatch"/>
    <fmt:message bundle="${localization}" key="local.wagon" var="wagon"/>
    <fmt:message bundle="${localization}" key="local.liftback" var="lift"/>
    <fmt:message bundle="${localization}" key="local.suv" var="suv"/>
    <fmt:message bundle="${localization}" key="local.coupe" var="coupe"/>
    <fmt:message bundle="${localization}" key="local.cabriolet" var="cabriolet"/>
    <fmt:message bundle="${localization}" key="local.priceday" var="priceday"/>
    <fmt:message bundle="${localization}" key="local.power" var="power"/>
    <fmt:message bundle="${localization}" key="local.body" var="body"/>
    <title>${addingnewcar}</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/common.css" type="text/css">
</head>
<body>
<c:set  var="page"  value="add_car.jsp" scope="session"/>
<jsp:include page="header.jsp"/>
    <div>
        <form  action="controller" method="post">
          <input type="hidden" name="command" value="add_car"/>

            ${Namecar}: <input type="text" name="name" value="" />

            <div>
                <br/>${gearbox}:<br/>
                <input type="radio" name="transmission" value="Механика" checked/>${manual} <br/>
                <input type="radio" name="transmission" value="Автомат" />${automaic} <br/>
            </div>

            <br/>${year}:
            <select name="year">
                <option selected value="2022">2022</option>
                <option value="2021">2021</option>
                <option value="2020">2020</option>
                <option value="2019">2019</option>
                <option value="2018">2018</option>
                <option value="2017">2017</option>
                <option value="2016">2016</option>
                <option value="2015">2015</option>
                <option value="2014">2014</option>
                <option value="2013">2013</option>
                <option value="2012">2012</option>
                <option value="2011">2011</option>
                <option value="2010">2010</option>
            </select>
            <div>
                <br/>${engine}:<br/>
                <input type="radio" name="fuel" value="Бензин" onchange="onChangeEngineType(this.value)" checked/>${gasoline} <br/>
                <input type="radio" name="fuel" value="Дизель" onchange="onChangeEngineType(this.value)"/>${diesel} <br/>
                <input type="radio" name="fuel" value="Электро" onchange="onChangeEngineType(this.value)"/>${electro} <br/>
            </div>
            <div>
                <br/>${drive}:<br/>
                <input type="radio" name="drive" value="Передний" checked />${front} <br/>
                <input type="radio" name="drive" value="Задний" />${rear} <br/>
                <input type="radio" name="drive" value="Полный" />${full} <br/>
            </div>

            <div id="tank-consumption-block">
                <br/> ${capacity}:
                <select name="engine_capacity">
                    <option selected value="0.0">0.0</option>
                    <option value="1.0">1.0</option>
                    <option value="1.2">1.2</option>
                    <option value="1.4">1.4</option>
                    <option value="1.6">1.6</option>
                    <option value="1.8">1.8</option>
                    <option value="2.0">2.0</option>
                    <option value="2.2">2.2</option>
                    <option value="2.3">2.3</option>
                    <option value="2.5">2.5</option>
                    <option value="2.7">2.7</option>
                    <option value="3.0">3.0</option>
                    <option value="3.5">3.5</option>
                </select>
                <br/>${tank}:
                <input type="text" name="tank" value="0" /> <br/>
                <br/>${consumption}:
                <input type="text" name="consumption" value="0.0" /> <br/>
            </div>
            <br/>

            <div id="e-mileage-block">
                <label for="e-mileage">${power}:</label>
                <input id="e-mileage" type="text" name="mileage" value="0" />
            </div>

            <div>
                <br/>${body}:<br/>
           <select name="body_type">
               <option value="Седан">${sedan}</option>
               <option value="Хэтчбек">${hatch}</option>
               <option value="Универсал">${wagon}</option>
               <option value="Лифтбек">${lift}</option>
               <option value="Внедорожник">${suv}</option>
               <option value="Купе">${coupe}</option>
               <option value="Кабриолет">${cabriolet}</option>
           </select>
            </div>
            <br/>${priceday}, $:  <input type="text" name="price" value="" /> <br/>
            <br/><input type="submit"  value="${addcar}"/>
        </form>
    </div>
    <script src="../JS/add_car.js"></script>
</body>
</html>
