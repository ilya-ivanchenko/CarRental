
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

    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/common.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/header.css" type="text/css">
</head>

<body>
    <div class="header">
        <div class="header-top">
            <div class="header-logo">
                <img src="/images/carLogo.png" height="64" width="64">
                <span>
                    Rent Cars Company
                </span>
            </div>

            <div class="header-lang">
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
        </div>

        <div class="header-buttons">
            <div class="catalog">
                <form action="controller" method="post">
                    <input type="hidden" name="command" value="get_car_list"/>
                    <input class="button" type="submit"  value="${main}"/>
                </form>
            </div>
            <div class="header-user">
                <c:choose>
                    <c:when test="${user==null}">
                        <button onclick="window.location.pathname='jsp/registration.jsp';">${reg}</button>
                        <button onclick="window.location.pathname='jsp/authorization.jsp';">${login}</button>
                    </c:when>
                </c:choose>
                <c:choose>
                    <c:when test="${user!=null}">
                        <form class="logout" action="controller" method="post">
                            <input type="hidden" name="command" value="log_out"/>
                            <input type="hidden" name="filter" value=""/>
                            <input class="button" type="submit"  value="${logout}"/>
                        </form>
                    </c:when>
                </c:choose>

                <c:choose>
                    <c:when test="${user.role>1}">
                        <button class="yourpage" onclick="window.location.pathname='jsp/user_home.jsp'">${profile}</button>
                    </c:when>
                </c:choose>
            </div>
        </div>
    </div>
</body>
</html>



<%--    <form action="controller" method="post">--%>
<%--        <select name="local" onchange="this.form.submit()">--%>
<%--            <option value="en">${en_button}</option>--%>
<%--            <option value="by">${by_button}</option>--%>
<%--            <option value="ru">${ru_button}</option>--%>
<%--        </select>--%>
<%--        <input type="hidden" name="command" value="change_lang"/>--%>
<%--    </form>--%>