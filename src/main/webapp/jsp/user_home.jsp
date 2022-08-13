
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="local" var="localization"/>

    <fmt:message bundle="${localization}" key="local.userinfo" var="userinfo"/>
    <fmt:message bundle="${localization}" key="local.hi" var="hi"/>
    <fmt:message bundle="${localization}" key="local.yourinfo" var="yourinfo"/>
    <fmt:message bundle="${localization}" key="local.Name" var="Name"/>
    <fmt:message bundle="${localization}" key="local.Surname" var="Surname"/>
    <fmt:message bundle="${localization}" key="local.Phone" var="Phone"/>
    <fmt:message bundle="${localization}" key="local.Mail" var="Mail"/>
    <fmt:message bundle="${localization}" key="local.myorders" var="myorders"/>
    <fmt:message bundle="${localization}" key="local.editinfo" var="editinfo"/>
    <fmt:message bundle="${localization}" key="local.delaccount" var="delaccount"/>
    <fmt:message bundle="${localization}" key="local.passport" var="passport"/>
    <fmt:message bundle="${localization}" key="local.startdate" var="startdate"/>
    <fmt:message bundle="${localization}" key="local.enddate" var="enddate"/>
    <fmt:message bundle="${localization}" key="local.description" var="description"/>
    <fmt:message bundle="${localization}" key="local.approvedmanager" var="approved"/>
    <fmt:message bundle="${localization}" key="local.paid" var="paid"/>
    <fmt:message bundle="${localization}" key="local.gopayment" var="gopayment"/>
    <fmt:message bundle="${localization}" key="local.cancel" var="cancel"/>
    <fmt:message bundle="${localization}" key="local.canceled" var="canceled"/>
    <fmt:message bundle="${localization}" key="local.allorders" var="allorders"/>
    <fmt:message bundle="${localization}" key="local.addnewcar" var="addnewcar"/>
    <fmt:message bundle="${localization}" key="local.order" var="orderid"/>
    <fmt:message bundle="${localization}" key="local.user" var="userid"/>
    <fmt:message bundle="${localization}" key="local.manager" var="managerid"/>
    <fmt:message bundle="${localization}" key="local.given" var="given"/>
    <fmt:message bundle="${localization}" key="local.returned" var="returned"/>
    <fmt:message bundle="${localization}" key="local.needrepair" var="needrepair"/>
    <fmt:message bundle="${localization}" key="local.repairprice" var="repairprice"/>
    <fmt:message bundle="${localization}" key="local.approve" var="approve"/>
    <fmt:message bundle="${localization}" key="local.givecustomer" var="givecustomer"/>
    <fmt:message bundle="${localization}" key="local.registerreturn" var="registerreturn"/>
    <fmt:message bundle="${localization}" key="local.allcars" var="allcars"/>
    <fmt:message bundle="${localization}" key="local.allusers" var="allusers"/>
    <fmt:message bundle="${localization}" key="local.car" var="car"/>
    <fmt:message bundle="${localization}" key="local.price" var="price"/>
    <fmt:message bundle="${localization}" key="local.no" var="no"/>
    <fmt:message bundle="${localization}" key="local.yes" var="yes"/>
    <fmt:message bundle="${localization}" key="local.back" var="back"/>
    <fmt:message bundle="${localization}" key="local.addmanager" var="addmanager"/>
    <fmt:message bundle="${localization}" key="local.noorders" var="noorders"/>

    <title>${userinfo}</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/common.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/user_home.css" type="text/css">
</head>
<body>
<jsp:include page="header.jsp"/>
<c:set  var="page"  value="user_home.jsp" scope="session"/>

<c:choose>
    <c:when test="${user.role == 2}">
        <div>
        <h2>${hi}, ${user.name}!</h2>

        <div>
            <h3>${yourinfo}:</h3>
            <p>${Name}: ${user.name}</p>
            <p>${Surname}: ${user.surname}</p>
            <p>${Phone}: ${user.phone}</p>
            <p>${Mail}: ${user.email}</p>
            <p>ID: ${user.id}</p>
        </div>
                <p class="ok_message">${message}</p>
        <div class="buttons">
            <form  action="controller" method="post">
                <input type="hidden" name="command" value="order_info"/>
                <input class="button" type="submit"  value="${myorders}"/>
            </form>
            <button onclick="location='edit_user.jsp'">${editinfo}</button>
            <form  action="controller" method="post">
                <input type="hidden" name="command" value="delete_user"/>
                <input class="del_button" type="submit"  value="${delaccount}"/>
            </form>
        </div>
        <br/>
        <br/>
        <c:choose>
            <c:when test="${orders.size()>0}">
        <table>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">${passport}</th>
                <th scope="col">${car}</th>
                <th scope="col">${price}, $</th>
                <th scope="col">${startdate}</th>
                <th scope="col">${enddate}</th>
                <th scope="col">${description}</th>
                <th scope="col">${approved}</th>
                <th scope="col">${paid}</th>
                <th></th>
                <th></th>

            </tr>

            <c:forEach var="orders" items="${orders}">
            <tr scope="row">
                <td>${orders.id}</td>
                <td>${orders.passport}</td>
                <td>${orders.carName}</td>
                <td>${orders.totalPrice}</td>
                <td>${orders.startDate}</td>
                <td>${orders.endDate}</td>
                <td class="desc">${orders.description}</td>

                <c:choose>
                    <c:when test="${!orders.approved}">
                        <td>${no}</td>
                        <td>${no}</td>
                    </c:when>
                    <c:when test="${orders.approved}">
                        <td>${yes}</td>
                            <c:choose>
                                <c:when test="${!orders.payment}">
                                    <td>${no}</td>
                                    <td>
                                        <c:set  var="idOrder"  value="${orders.id}" scope="session"/>
                                        <button  onclick="location='payment.jsp'">${gopayment}</button>
                                    </td>
                                </c:when>
                                <c:when test="${orders.payment}">
                                     <td>${yes}</td>
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
                                <input class="del" type="submit"  value="${cancel}"/>
                            </form>
                            </p>
                        </td>
                    </c:when>
                    <c:when test="${!orders.approved && orders.returned}">
                        <td class="cancel">${canceled}</td>
                    </c:when>
                </c:choose>
            </tr>
            </c:forEach>
        </table>
            </c:when>

            <c:when test="${orders.size()<1}">
                <br/>
                <br/>
                <p class="noorders">${noorders}</p>
            </c:when>
        </c:choose>
        </div>
    </c:when>







    <c:when test="${user.role == 3}">
           <div>
               <h3> <p> ${user.name} ${user.surname}, ID: ${user.id}</p></h3>
                <p>${Phone}: ${user.phone}</p>
                <p>${Mail}: ${user.email}</p>
                <form  action="controller" method="post">
                    <input type="hidden" name="command" value="order_info"/>
                    <input class="button" type="submit"  value="${allorders}"/>
                </form>
                <form  action="controller" method="post">
                    <input type="hidden" name="command" value="manager_order"/>
                    <input type="hidden" name="id" value="${user.id}"/>
                    <input  class="button" type="submit"  value="${myorders}"/>
                </form>
                <button  onclick="location='add_car.jsp'">${addnewcar}</button>

            <p class="ok_message">${message}</p>
            <br/>
            <c:choose>
                <c:when test="${orders.size()>0}">
                    <table class="big">
                        <tr>
                            <th scope="col">${orderid}</th>
                            <th scope="col">${managerid}</th>
                            <th scope="col">${userid}</th>
                            <th scope="col">${passport}</th>
                            <th scope="col">${car}</th>
                            <th scope="col">${price}, $</th>
                            <th scope="col">${startdate}</th>
                            <th scope="col">${enddate}</th>
                            <th scope="col">${approved}</th>
                            <th scope="col">${paid}</th>
                            <th scope="col">${given}</th>
                            <th scope="col">${returned}</th>
                            <th scope="col">${needrepair}</th>
                            <th scope="col">${repairprice}, $</th>
                            <th scope="col">${description}</th>
                            <th></th>
                        </tr>
                            <c:forEach var="orders" items="${orders}">
                        <tr scope="row">
                                <td>${orders.id}</td>
                                <td>${orders.managerId}</td>
                                <td>
                                    <form class="id-user" action="controller" method="post">
                                        <input type="hidden" name="command" value="user_info_by_manager"/>
                                        <input type="hidden" name="id" value="${orders.customerId}"/>
                                        <input  class="button-id" type="submit"  value="${orders.customerId}"/>
                                    </form>
                                </td>
                                <td>${orders.passport}</td>
                                <td>${orders.carName}</td>
                                <td>${orders.totalPrice}</td>
                                <td>${orders.startDate}</td>
                                <td>${orders.endDate}</td>
                                <c:choose>
                                    <c:when test="${!orders.approved}">
                                        <td>${no}</td>
                                    </c:when>
                                    <c:when test="${orders.approved}">
                                        <td>${yes}</td>
                                    </c:when>
                                </c:choose>
                                <c:choose>
                                    <c:when test="${!orders.payment}">
                                        <td>${no}</td>
                                    </c:when>
                                    <c:when test="${orders.payment}">
                                        <td>${yes}</td>
                                    </c:when>
                                </c:choose>
                            <c:choose>
                                <c:when test="${!orders.given}">
                                    <td>${no}</td>
                                </c:when>
                                <c:when test="${orders.given}">
                                    <td>${yes}</td>
                                </c:when>
                            </c:choose>
                                <c:choose>
                                    <c:when test="${!orders.returned}">
                                        <td>${no}</td>
                                    </c:when>
                                    <c:when test="${orders.returned}">
                                        <td>${yes}</td>
                                    </c:when>
                                </c:choose>
                                <c:choose>
                                    <c:when test="${!orders.needRepair}">
                                        <td>${no}</td>
                                    </c:when>
                                    <c:when test="${orders.needRepair}">
                                        <td>${yes}</td>
                                    </c:when>
                                </c:choose>
                                <td>${orders.repairPrice}</td>
                                <td class="desc">${orders.description}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${!orders.approved && !orders.returned}">
                                    <div class="buttons">
                                <form action="controller" method="post">
                                    <input type="hidden" name="command" value="approve_order"/>
                                    <input type="hidden" name="idOrder" value="${orders.id}"/>
                                    <input type="hidden" name="idManager" value="${user.id}"/>
                                    <input type="submit"  value="${approve}"/>
                                </form>
                                    </div>
                                    <div class="buttons">
                                        <c:set  var="idOrder"  value="${orders.id}" scope="session"/>
                                        <c:set  var="idManager"  value="${user.id}" scope="session"/>
                                        <button  onclick="location='cancel_order.jsp'">${cancel}</button>
                                    </div>
                                    </c:when>
                                    <c:when test="${orders.approved && orders.payment && !orders.returned && !orders.given}">
                                        <form action="controller" method="post">
                                            <input type="hidden" name="command" value="give_car_customer"/>
                                            <input type="hidden" name="idOrder" value="${orders.id}"/>
                                            <input type="submit"  value="${givecustomer}"/>
                                        </form>
                                    </c:when>
                                    <c:when test="${orders.given && !orders.returned}">
                                        <c:set  var="idOrder"  value="${orders.id}" scope="session"/>
                                        <button onclick="location='reg_return.jsp'">${registerreturn}</button>
                                    </c:when>
                                    <c:when test="${!orders.approved && orders.returned}">
                                        <td class = "cancel">${canceled}</td>
                                    </c:when>
                                </c:choose>
                            </td>
                        </tr>
                            </c:forEach>
                    </table>
                </c:when>
            </c:choose>
            <br/>
            <button onclick="window.history.back();">${back}</button>
        </div>
    </c:when>







    <c:when test="${user.role == 4}">
        <div>
            <h3>${user.name}</h3>
            </br> <p class="ok_message">${message}</p>
            <form  action="controller" method="post">
                <input type="hidden" name="command" value="order_info"/>
                <input class="button" type="submit"  value="${allorders}"/>
            </form>
            <form action="controller" method="post">
                <input type="hidden" name="command" value="car_info"/>
                <input class="button" type="submit"  value="${allcars}"/>
            </form>
            <button  onclick="location='add_car.jsp'">${addnewcar}</button>
            <form action="controller" method="post">
                <input type="hidden" name="command" value="all_user_info"/>
                <input class="button" type="submit"  value="${allusers}"/>
            </form>
            <button onclick="location='registration.jsp'">${addmanager}</button>
            <br/>
            <br/>
            <c:choose>
                <c:when test="${orders.size()>0}">
                    <table class="big">
                        <tr>
                            <th scope="col">${orderid}</th>
                            <th scope="col">${managerid}</th>
                            <th scope="col">${userid}</th>
                            <th scope="col">${passport}</th>
                            <th scope="col">${car}</th>
                            <th scope="col">${price}, $</th>
                            <th scope="col">${startdate}</th>
                            <th scope="col">${enddate}</th>
                            <th scope="col">${approved}</th>
                            <th scope="col">${paid}</th>
                            <th scope="col">${given}</th>
                            <th scope="col">${returned}</th>
                            <th scope="col">${needrepair}</th>
                            <th scope="col">${repairprice}, $</th>
                            <th scope="col">${description}</th>
                            <th></th>
                        </tr>
                        <c:forEach var="orders" items="${orders}">
                            <tr scope="row">
                                <td>${orders.id}</td>
                                <td>${orders.managerId}</td>
                                <td>
                                    <form class="id-user" action="controller" method="post">
                                        <input type="hidden" name="command" value="user_info_by_manager"/>
                                        <input type="hidden" name="id" value="${orders.customerId}"/>
                                        <input  class="button-id" type="submit"  value="${orders.customerId}"/>
                                    </form>
                                </td>
                                <td>${orders.passport}</td>
                                <td>${orders.carName}</td>
                                <td>${orders.totalPrice}</td>
                                <td>${orders.startDate}</td>
                                <td>${orders.endDate}</td>
                                <c:choose>
                                    <c:when test="${!orders.approved}">
                                        <td>${no}</td>
                                    </c:when>
                                    <c:when test="${orders.approved}">
                                        <td>${yes}</td>
                                    </c:when>
                                </c:choose>
                                <c:choose>
                                    <c:when test="${!orders.payment}">
                                        <td>${no}</td>
                                    </c:when>
                                    <c:when test="${orders.payment}">
                                        <td>${yes}</td>
                                    </c:when>
                                </c:choose>
                                <c:choose>
                                    <c:when test="${!orders.given}">
                                        <td>${no}</td>
                                    </c:when>
                                    <c:when test="${orders.given}">
                                        <td>${yes}</td>
                                    </c:when>
                                </c:choose>
                                <c:choose>
                                    <c:when test="${!orders.returned}">
                                        <td>${yes}</td>
                                    </c:when>
                                    <c:when test="${orders.returned}">
                                        <td>${yes}</td>
                                    </c:when>
                                </c:choose>
                                <c:choose>
                                    <c:when test="${!orders.needRepair}">
                                        <td>${no}</td>
                                    </c:when>
                                    <c:when test="${orders.needRepair}">
                                        <td>${yes}</td>
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
                                        <input type="submit"  value="${approve}"/>
                                    </form>
                                        <c:set  var="idOrder"  value="${orders.id}" scope="session"/>
                                    <button  onclick="location='cancel_order.jsp'">${cancel}</button>
                                    </c:when>
                                    <c:when test="${orders.approved && orders.payment && !orders.returned && !orders.given}">
                                    <form action="controller" method="post">
                                        <input type="hidden" name="command" value="give_car_customer"/>
                                        <input type="hidden" name="idOrder" value="${orders.id}"/>
                                        <input type="submit"  value="${givecustomer}"/>
                                    </form>
                                    </c:when>
                                    <c:when test="${orders.given && !orders.returned}">
                                        <c:set  var="idOrder"  value="${orders.id}" scope="session"/>
                                    <button  onclick="location='reg_return.jsp'">${registerreturn}</button>
                                    </c:when>
                                    <c:when test="${!orders.approved && orders.returned}">
                                <td class = "cancel">${canceled}</td>
                                </c:when>
                                </c:choose>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
            </c:when>
        </c:choose>
            <button onclick="window.history.back();">${back}</button>
        </div>


<%--        <h3>${message}</h3>--%>

    </c:when>
</c:choose>


</body>
</html>
