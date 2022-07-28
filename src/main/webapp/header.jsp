
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <title>Title</title>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="local" var="localization"/>

    <fmt:message bundle="${localization}" key="local.cars" var="name"/>
    <fmt:message bundle="${localization}" key="local.registration" var="reg"/>
    <fmt:message bundle="${localization}" key="local.login" var="login"/>
    <fmt:message bundle="${localization}" key="local.logout" var="logout"/>
    <fmt:message bundle="${localization}" key="local.profile" var="profile"/>
    <fmt:message bundle="${localization}" key="local.catalog" var="main"/>

    <fmt:message bundle="${localization}" key="local.locbutton.name.en" var="en_button"/>
    <fmt:message bundle="${localization}" key="local.locbutton.name.ru" var="ru_button"/>
    <fmt:message bundle="${localization}" key="local.locbutton.name.by" var="by_button"/>


</head>

<body>
<div class="buttons">
<div class="lang">
<form class="local" action="controller" method="post">
    <input type="hidden" name="local" value="en"/>
    <input type="hidden" name="command" value="change_lang"/>
    <input type="submit" value="${en_button}" />
</form>

<form class="local" action="controller" method="post">
    <input type="hidden" name="local" value="ru"/>
    <input type="hidden" name="command" value="change_lang"/>
    <input type="submit" value="${ru_button}" />
</form>

<form class="local" action="controller" method="post">
    <input type="hidden" name="local" value="by"/>
    <input type="hidden" name="command" value="change_lang"/>
    <input type="submit" value="${by_button}" />
</form>
</div>
<br/>
<br/>

    <div class="catalog">
        <form action="controller" method="post">
            <input type="hidden" name="command" value="get_car_list"/>
            <input type="submit"  value="${main}"/>
        </form>
    </div>


<div class="header_user">
<c:choose>
    <c:when test="${user==null}">
        <button onclick="location='registration.jsp'">${reg}</button>
        <button onclick="location='authorization.jsp'">${login}</button>
    </c:when>
</c:choose>

<c:choose>
    <c:when test="${user!=null}">
        <form class="logout" action="controller" method="post">
            <input type="hidden" name="command" value="log_out"/>
            <input type="hidden" name="filter" value=""/>
            <input type="submit"  value="${logout}"/>
        </form>
    </c:when>
</c:choose>

<c:choose>
    <c:when test="${user.role>1}">
        <button class="yourpage" onclick="location='user_home.jsp'">${profile}</button>
    </c:when>
</c:choose>
</div>
</div>
<%--${name}--%>
</body>
</html>
<style>
    /*div.header_user {*/

    /*    position: absolute;*/
    /*    right: 25px;*/
    /*    top: 5px;*/
    /*}*/
    /*div.lang {*/

    /*    position: absolute;*/
    /*    left: 25px;*/

    /*}*/
    div.buttons {
        display: flex;
        flex-direction: row;
        align-items: center;
        justify-content: space-between;

    }
</style>
