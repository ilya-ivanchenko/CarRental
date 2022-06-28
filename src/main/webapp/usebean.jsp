
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Приветствие</title>
</head>
<body>
<jsp:useBean id="registration" class="by.ivanchenko.carrental.bean.user.User"/>
<jsp:setProperty name="registration" property="*"/>
    Hi,
<jsp:getProperty name="registration" property="name"/>
<jsp:getProperty name="registration" property="surname"/>
<%--<jsp:getProperty name="registration" property="phone"/>--%>
<%--<jsp:getProperty name="registration" property="password"/>--%>
<%--<jsp:getProperty name="registration" property="email"/>--%>
<%--<jsp:getProperty name="registration" property="id"/>--%>
<%--<jsp:getProperty name="registration" property="role"/>--%>
<br/>
<br/>

<%--вместо getProperty:  --%>
${pageScope.registration.name}
<%-- requestScope   sessionScope  applicationScope   cookie  header ... --%>
<a href="index.jsp">Home page</a>

<%--${list.[1]}--%>
<%--<c:out value="${list.[1]}"/>--%>
</body>
</html>
