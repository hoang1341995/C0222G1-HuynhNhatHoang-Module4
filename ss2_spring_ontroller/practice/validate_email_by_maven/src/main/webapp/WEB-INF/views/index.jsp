<%--
  Created by IntelliJ IDEA.
  User: huynhhoang
  Date: 14/06/2022
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p style="color: red">${error}</p>
${success}
<h1 ${hidden}>VALIDATE EMAIL</h1>
<form ${hidden} action="/" method="post">
    <input type="text" name="email" value="${email}" placeholder="Enter email">
    <input type="submit" value="Validate">
</form>
</body>
</html>
