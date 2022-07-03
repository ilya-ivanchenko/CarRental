
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Authorization User</title>
</head>
<body>
<jsp:useBean id="authorization" class="by.ivanchenko.carrental.bean.user.User"/>
<jsp:setProperty name="authorization" property="*"/>
Hi,
<jsp:getProperty name="authorization" property="name"/>
<jsp:getProperty name="authorization" property="surname"/>
<jsp:getProperty name="authorization" property="email"/>

<br/>
<br/>

<%--вместо getProperty:  --%>

<%-- requestScope   sessionScope  applicationScope   cookie  header ... --%>
<br/>
<a href="index.jsp">Home page</a>

</body>
</html>
