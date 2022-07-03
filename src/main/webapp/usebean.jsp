
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

<br/>
<br/>

<%--вместо getProperty:  --%>
${registration.name}

<%-- requestScope   sessionScope  applicationScope   cookie  header ... --%>
<br/>
<a href="index.jsp">Home page</a>

</body>
</html>
