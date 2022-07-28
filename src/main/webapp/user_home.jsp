
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User information</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<c:set  var="page"  value="user_home.jsp" scope="session"/>


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
    <input class="del" type="submit"  value="Delete account"/>
</form>
<br/>
<br/>
<c:choose>
    <c:when test="${orders.size()>0}">
<table>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Passport</th>
        <th scope="col">Car</th>
        <th scope="col">Price</th>
        <th scope="col">Start date</th>
        <th scope="col">End date</th>
        <th scope="col">Description</th>
        <th scope="col">Approved by manager</th>
        <th scope="col">Payment</th>
        <th></th>
        <th></th>

    </tr>
    <tr scope="row">
    <c:forEach var="orders" items="${orders}">
        <td>${orders.id}</td>
        <td>${orders.passport}</td>
        <td>${orders.carId}</td>
        <td>${orders.totalPrice}$</td>
        <td>${orders.startDate}</td>
        <td>${orders.endDate}</td>
        <td class="desc">${orders.description}</td>

        <c:choose>
            <c:when test="${!orders.approved}">
                <td>No</td>
                <td>No</td>
            </c:when>
            <c:when test="${orders.approved}">
                <td>Yes</td>
                    <c:choose>
                        <c:when test="${!orders.payment}">
                            <td> No </td>
                            <td>
                                <c:set  var="idOrder"  value="${orders.id}" scope="session"/>
                                <button  onclick="location='payment.jsp'">Go to payment</button>
                            </td>
                        </c:when>
                        <c:when test="${orders.payment}">
                             <td>Yes</td>
                        </c:when>
                    </c:choose>
            </c:when>
        </c:choose>
        <c:choose>
            <c:when test="${!orders.payment && !orders.returned}">
                <td>
                    <form  action="controller" method="post">
                        <input type="hidden" name="command" value="delete_order"/>
                        <input type="hidden" name="id" value="${orders.id}"/>
                        <input class="del" type="submit"  value="Cancel"/>
                    </form>
                    </p>
                </td>
            </c:when>
            <c:when test="${!orders.approved && orders.returned}">
                <td class="cancel">Order canceled</td>
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
        <h3>${user.name}, ID: ${user.id}</h3>
        <form  action="controller" method="post">
            <input type="hidden" name="command" value="order_info"/>
            <input type="submit"  value="See all orders"/>
        </form>
        <form  action="controller" method="post">
            <input type="hidden" name="command" value="manager_order"/>
            <input type="hidden" name="id" value="${user.id}"/>
            <input type="submit"  value="My orders"/>
        </form>
        <button  onclick="location='add_car.jsp'">Add new car</button>

        <p class="ok_message">${message}</p>
        <br/>
        <c:choose>
            <c:when test="${orders.size()>0}">
                <table>
                    <tr>
                        <th scope="col">Order id</th>
                        <th scope="col">Manager id</th>
                        <th scope="col">User id</th>
                        <th scope="col">Passport</th>
                        <th scope="col">Car</th>
                        <th scope="col">Price</th>
                        <th scope="col">Start date</th>
                        <th scope="col">End date</th>
                        <th scope="col">Approved</th>
                        <th scope="col">Payment</th>
                        <th scope="col">Given</th>
                        <th scope="col">Returned</th>
                        <th scope="col">Need repair</th>
                        <th scope="col">Repair price</th>
                        <th scope="col">Description</th>
                        <th></th>
                    </tr>
                        <c:forEach var="orders" items="${orders}">
                    <tr scope="row">
                            <td>${orders.id}</td>
                            <td>${orders.managerId}</td>
                            <td>${orders.customerId}</td>
                            <td>${orders.passport}</td>
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
                            <c:choose>
                                <c:when test="${!orders.payment}">
                                    <td>No</td>
                                </c:when>
                                <c:when test="${orders.payment}">
                                    <td>Yes</td>
                                </c:when>
                            </c:choose>
                        <c:choose>
                            <c:when test="${!orders.given}">
                                <td>No</td>
                            </c:when>
                            <c:when test="${orders.given}">
                                <td>Yes</td>
                            </c:when>
                        </c:choose>
                            <c:choose>
                                <c:when test="${!orders.returned}">
                                    <td>No</td>
                                </c:when>
                                <c:when test="${orders.returned}">
                                    <td>Yes</td>
                                </c:when>
                            </c:choose>
                            <c:choose>
                                <c:when test="${!orders.needRepair}">
                                    <td>No</td>
                                </c:when>
                                <c:when test="${orders.needRepair}">
                                    <td>Yes</td>
                                </c:when>
                            </c:choose>
                            <td>${orders.repairPrice}</td>
                            <td class="desc">${orders.description}</td>
                        <td>
                            <c:choose>
                                <c:when test="${!orders.approved && !orders.returned}">
                            <form action="controller" method="post">
                                <input type="hidden" name="command" value="approve_order"/>
                                <input type="hidden" name="idOrder" value="${orders.id}"/>
                                <input type="hidden" name="idManager" value="${user.id}"/>
                                <input type="submit"  value="Approve"/>
                            </form>
                                    <c:set  var="idOrder"  value="${orders.id}" scope="session"/>
                                    <button  onclick="location='cancel_order.jsp'">Cancel</button>
                                </c:when>
                                <c:when test="${orders.approved && orders.payment && !orders.returned && !orders.given}">
                                    <form action="controller" method="post">
                                        <input type="hidden" name="command" value="give_car_customer"/>
                                        <input type="hidden" name="idOrder" value="${orders.id}"/>
                                        <input type="submit"  value="Give to customer"/>
                                    </form>
                                </c:when>
                                <c:when test="${orders.given && !orders.returned}">
                                    <c:set  var="idOrder"  value="${orders.id}" scope="session"/>
                                    <button  onclick="location='reg_return.jsp'">Register a return</button>
                                </c:when>
                                <c:when test="${!orders.approved && orders.returned}">
                                    <td class = "cancel">Order canceled</td>
                                </c:when>
                            </c:choose>
                        </td>
                    </tr>
                        </c:forEach>
                </table>
            </c:when>
        </c:choose>
        <br/>
        <button onclick="location='index.jsp'">Main page</button>
        <button onclick="window.history.back();">Back</button>
        <br>
        ${message}
    </c:when>







    <c:when test="${user.role == 4}">
        <h3>${user.name}</h3>
        </br> <p class="ok_message">${message}</p>
        <form  action="controller" method="post">
            <input type="hidden" name="command" value="order_info"/>
            <input type="submit"  value="See all orders"/>
        </form>
        <form action="controller" method="post">
            <input type="hidden" name="command" value="car_info"/>
            <input type="submit"  value="See all cars"/>
        </form>
        <button  onclick="location='add_car.jsp'">Add new car</button>

        <form action="controller" method="post">
            <input type="hidden" name="command" value="all_user_info"/>
            <input type="submit"  value="See all users"/>
        </form>
        <button onclick="location='registration.jsp'">Register manager</button>
        <br/>
        <br/>
        <button onclick="window.history.back();">Back</button>
        <c:choose>
            <c:when test="${orders.size()>0}">
                <table>
                    <tr>
                        <th scope="col">Order id</th>
                        <th scope="col">Manager id</th>
                        <th scope="col">User id</th>
                        <th scope="col">Passport</th>
                        <th scope="col">Car</th>
                        <th scope="col">Price</th>
                        <th scope="col">Start date</th>
                        <th scope="col">End date</th>
                        <th scope="col">Approved</th>
                        <th scope="col">Payment</th>
                        <th scope="col">Given</th>
                        <th scope="col">Returned</th>
                        <th scope="col">Need repair</th>
                        <th scope="col">Repair price</th>
                        <th scope="col">Description</th>
                        <th></th>
                    </tr>
                    <c:forEach var="orders" items="${orders}">
                        <tr scope="row">
                            <td>${orders.id}</td>
                            <td>${orders.managerId}</td>
                            <td>${orders.customerId}</td>
                            <td>${orders.passport}</td>
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
                            <c:choose>
                                <c:when test="${!orders.payment}">
                                    <td>No</td>
                                </c:when>
                                <c:when test="${orders.payment}">
                                    <td>Yes</td>
                                </c:when>
                            </c:choose>
                            <c:choose>
                                <c:when test="${!orders.given}">
                                    <td>No</td>
                                </c:when>
                                <c:when test="${orders.given}">
                                    <td>Yes</td>
                                </c:when>
                            </c:choose>
                            <c:choose>
                                <c:when test="${!orders.returned}">
                                    <td>No</td>
                                </c:when>
                                <c:when test="${orders.returned}">
                                    <td>Yes</td>
                                </c:when>
                            </c:choose>
                            <c:choose>
                                <c:when test="${!orders.needRepair}">
                                    <td>No</td>
                                </c:when>
                                <c:when test="${orders.needRepair}">
                                    <td>Yes</td>
                                </c:when>
                            </c:choose>
                            <td>${orders.repairPrice}</td>
                            <td class="desc">${orders.description}</td>
                            <td>
                                <c:choose>
                                <c:when test="${!orders.approved && !orders.returned}">
                                <form action="controller" method="post">
                                    <input type="hidden" name="command" value="approve_order"/>
                                    <input type="hidden" name="idOrder" value="${orders.id}"/>
                                    <input type="hidden" name="idManager" value="${user.id}"/>
                                    <input type="submit"  value="Approve"/>
                                </form>
                                    <c:set  var="idOrder"  value="${orders.id}" scope="session"/>
                                <button  onclick="location='cancel_order.jsp'">Cancel</button>
                                </c:when>
                                <c:when test="${orders.approved && orders.payment && !orders.returned && !orders.given}">
                                <form action="controller" method="post">
                                    <input type="hidden" name="command" value="give_car_customer"/>
                                    <input type="hidden" name="idOrder" value="${orders.id}"/>
                                    <input type="submit"  value="Give to customer"/>
                                </form>
                                </c:when>
                                <c:when test="${orders.given && !orders.returned}">
                                    <c:set  var="idOrder"  value="${orders.id}" scope="session"/>
                                <button  onclick="location='reg_return.jsp'">Register a return</button>
                                </c:when>
                                <c:when test="${!orders.approved && orders.returned}">
                            <td class = "cancel">Order canceled</td>
                            </c:when>
                            </c:choose>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </c:when>
        </c:choose>










<%--        <h3>${message}</h3>--%>

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
    td.desc {
        width: 150px;
    }
    td.cancel {
        color: red;
    }
    p.ok_message {
        color: blue;
    }

</style>
</body>
</html>
