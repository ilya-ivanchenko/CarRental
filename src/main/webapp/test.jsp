<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  %>
<%--<%@ page isELIgnored="true" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html>
<head>
    <title>TEST PAGE</title>
<h2>опа</h2>
<fmt:setLocale value="${sessionScope.local}"/>
<fmt:setBundle basename="local" var="localization"/> <%-- "local_en" - стандатрные данные  --%>

<fmt:message bundle="${localization}" key="local.message" var="message"/>
<fmt:message bundle="${localization}" key="local.locbutton.name.en" var="en_button"/>
<fmt:message bundle="${localization}" key="local.locbutton.name.ru" var="ru_button"/>
<fmt:message bundle="${localization}" key="local.locbutton.name.by" var="by_button"/>
</head>
<body>
<form action="mypage" method="post">
    <input type="hidden" name="local" value="en"/>
    <input type="submit" value="${en_button}" />
</form>

<form action="mypage" method="post">
    <input type="hidden" name="local" value="ru"/>
    <input type="submit" value="${ru_button}" />
</form>

<form action="mypage" method="post">
    <input type="hidden" name="local" value="by"/>
    <input type="submit" value="${by_button}" />
</form>

<c:out value="${message}"/>
<h3>${message}</h3>

${sessionScope.local}






</body>
</html>

