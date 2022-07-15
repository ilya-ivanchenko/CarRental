
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authorization</title>
</head>
<body>
<form action="controller" method="post">  <%-- post/get      // action  = "/registration" --%>
  <input type="hidden" name="command" value="authorization"/>

  Enter email:<br/>
  <input type="text" name="email" value="" required="required"/> <br/>
  Enter password:<br/>
  <input type="password" name="password" value="" required="required"/> <br/>
  <input type="submit" value="Enter"/>
</form>
<br/>
<button onclick="location='index.jsp'">Main page</button>
<button onclick="window.history.back();">Back</button>
</body>
</html>
