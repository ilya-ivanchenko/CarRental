
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form action="controller" method="post">
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
  <input type="email" name="email" value=""/> <br/>
  <input type="submit" value="Registration"/>
</form>
<br/>

<a href="index.jsp">Home page</a>
<div> <input type = "button" value = "Back" onclick = "window.history.back();" /> </div>
<button onclick="window.history.back();">Back1</button>
</body>
</html>

<%----%>

