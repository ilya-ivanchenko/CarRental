
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Adding a new car</title>
</head>
<body>
<c:set  var="page"  value="add_car.jsp" scope="session"/>
<jsp:include page="header.jsp"/>
<form  action="controller" method="post">
  <input type="hidden" name="command" value="add_car"/>

    Name: <input type="text" name="name" value="" />

    <br/> Engine capacity:
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

    <div>
        <br/>Gear box:<br/>
        <input type="radio" name="transmission" value="Механика" />Механика <br/>
        <input type="radio" name="transmission" value="Автомат" />Автомат <br/>
    </div>

    <br/>Year:
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
        <br/>Drive:<br/>
        <input type="radio" name="drive" value="Передний" />Передний <br/>
        <input type="radio" name="drive" value="Задний" />Задний <br/>
        <input type="radio" name="drive" value="Полный" />Полный <br/>
    </div>

    <br/>Tank, l:
    <input type="text" name="tank" value="" /> <br/>

    <br/>Consumption, l/100 km:
    <input type="text" name="consumption" value="" /> <br/>

    <div>
        <br/>Engine:<br/>
        <input type="radio" name="fuel" value="Бензин" />Бензин <br/>
        <input type="radio" name="fuel" value="Дизель" />Дизель <br/>
        <input type="radio" name="fuel" value="Электро" />Электро <br/>
    </div>

    <div>
        <br/>Body type:<br/>
   <select name="body_type">
       <option value="Седан">Седан</option>
       <option value="Хэтчбек">Хэтчбек</option>
       <option value="Универсал">Универсал</option>
       <option value="Лифтбек">Лифтбек</option>
       <option value="Внедорожник">Внедорожник</option>
       <option value="Купе">Купе</option>
       <option value="Кабриолет">Кабриолет</option>
   </select>
    </div>

    <br/>Price:  <input type="text" name="price" value="" /> <br/>
    <br/>Mileage: <input type="text" name="mileage" value="" /> <br/>

    <br/><input type="submit"  value="Add car"/>
</form>
</body>
</html>
