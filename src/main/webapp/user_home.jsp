
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User information</title>
</head>
<body>
<c:choose>
    <c:when test="${user.role == 2}">
<h2>Hi, ${user.name}!</h2>

<h3>Your information:</h3>
<div>
    <p>Имя: ${user.name}</p>
    <p>Фамилия: ${user.surname}</p>
    <p>Телефон: ${user.phone}</p>
    <p>E-mail: ${user.email}</p>
    <p>ID: ${user.id}</p>
</div>

<br/>
<form  action="controller" method="post">
    <input type="hidden" name="command" value="order_info"/>
    <input type="submit"  value="My orders"/>
</form>

<button onclick="location='edit_user.jsp'">Edit information</button>

<form  action="controller" method="post">
    <input type="hidden" name="command" value="delete_user"/>
    <input class="del" type="submit"  value="Delete user"/>
</form>
<br/>
<button onclick="location='index.jsp'">Main page</button>
<br/>
<c:choose>
    <c:when test="${orders.size()>0}">
<table>
    <tr>
        <th scope="col">Car</th>
        <th scope="col">Price</th>
        <th scope="col">Start date</th>
        <th scope="col">End date</th>
        <th scope="col">Approved by manager</th>
    </tr>
    <tr scope="row">
    <c:forEach var="orders" items="${orders}">
        <td>${orders.carId}</td>
        <td>${orders.totalPrice}$</td>
        <td>${orders.startDate}</td>
        <td>${orders.endDate}</td>
        <c:choose>
            <c:when test="${!orders.approved}">
                <td>No</td>
            </c:when>
            <c:when test="${orders.approved}">
                <td>Yes</td>
            </c:when>
        </c:choose>
    </c:forEach>
    </tr>
</table>
    </c:when>
</c:choose>
<br>
${message}
    </c:when>





    <c:when test="${user.role == 3}">
        <h3>${user.name}</h3>
        <form  action="controller" method="post">
            <input type="hidden" name="command" value="order_info"/>
            <input type="submit"  value="See orders"/>
        </form>
        <br/>
        <c:choose>
            <c:when test="${orders.size()>0}">
                <table>
                    <tr>
                        <th scope="col">Car</th>
                        <th scope="col">Price</th>
                        <th scope="col">Start date</th>
                        <th scope="col">End date</th>
                        <th scope="col">Approved by manager</th>
                    </tr>
                    <tr scope="row">
                        <c:forEach var="orders" items="${orders}">
                            <td>${orders.carId}</td>
                            <td>${orders.totalPrice}$</td>
                            <td>${orders.startDate}</td>
                            <td>${orders.endDate}</td>
                            <c:choose>
                                <c:when test="${!orders.approved}">
                                    <td>No</td>
                                </c:when>
                                <c:when test="${orders.approved}">
                                    <td>Yes</td>
                                </c:when>
                            </c:choose>
                        </c:forEach>
                    </tr>
                </table>
            </c:when>
        </c:choose>
        <br/>
        <button onclick="location='index.jsp'">Main page</button>
        <button onclick="window.history.back();">Back</button>
    </c:when>







    <c:when test="${user.role == 4}">
        <h3>${user.name}</h3>
        </br>
        <button onclick="location='registration.jsp'">Register manager</button>
        <br/>
        <button onclick="location='index.jsp'">Main page</button>
        <button onclick="window.history.back();">Back</button>
        <h3>${message}</h3>

    </c:when>
</c:choose>



<style>
    input.del {
    /*font-weight: bold;*/
        color: red;
    }
    form {
    display: inline-block;
    }
    td {
        text-align: center;
    }
    th,td {
        padding-right: 20px;
        padding-bottom: 5px;
    }
</style>
</body>
</html>
