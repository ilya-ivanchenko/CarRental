
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form action="registration" method="post">  <%-- post/get      // action  = "/registration" --%>
  <input type="hidden" name="command" value="registration"/>

  Enter name:<br/>
  <input type="text" name="name" value=""/> <br/>
  Enter surname:<br/>
  <input type="text" name="surname" value=""/> <br/>
  Enter phone:<br/>
  <input type="text" name="phone" value=""/> <br/>
  Enter password:<br/>
  <input type="password" name="password" value=""/> <br/>
  Enter email:<br/>
  <input type="text" name="email" value=""/> <br/>
  <input type="submit" value="Send"/>
</form>
</body>
</html>

<%----%>
<form action="registration" method="post">  <%-- post/get      // action  = "/registration" --%>
  <input type="hidden" name="command" value="GoToRegistration"/>
  <input type="submit" value="Registration"/>
</form>
