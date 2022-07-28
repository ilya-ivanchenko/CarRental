<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register a return</title>
</head>
<body>
<c:set  var="page"  value="reg_return.jsp" scope="session"/>
<jsp:include page="header.jsp"/>
<form action="controller" method="post">
    <input type="hidden" name="command" value="register_return"/>

    <div>
        <br/>
        <input type="checkbox" name="need_repair" value="1" /> Need repair
    </div>
    <div>
        <br/>
        Repair price, $:<br/>
        <c:choose>
            <c:when test="need_repair">

            </c:when>
        </c:choose>
        <input type="text" name="repair_price" autocomplete="0" />
    </div>
    <div>
        <br/>
        Description:<br/>
        <textarea name="description" cols="30" rows="5"></textarea>
    </div>
    <br/>
    <input type="submit"  value="Register a return"/>
</form>
</body>
</html>
