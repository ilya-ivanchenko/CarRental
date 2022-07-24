
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register a return</title>
</head>
<body>
<form action="controller" method="post">
    <input type="hidden" name="command" value="reg_return"/>

    <div>
        <br/>
        Need repair:  <input type="checkbox" name="need_repair" value="1" />
    </div>
    <div>
        <br/>
        Repair price, $:
        <input type="text" name="repair_price" />
    </div>
    <div>
        <br/>
        Description:
        <textarea name="description" cols="30" rows="5"></textarea>
    </div>
    <br/>
    <input type="submit"  value="Register a return"/>
</form>
</body>
</html>
