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
<h1>Sandwich Condiments</h1>
<p style="color: blue">${mess}</p>
<form action="/" method="post">
    <input type="checkbox" name="condiment" id="lettuce" value="lettuce" ${lettuce}>
    <label for="lettuce">Lettuce</label><br>
    <input type="checkbox" name="condiment" id="tomato" value="tomato" ${tomato}>
    <label for="tomato">Tomato</label><br>
    <input type="checkbox" name="condiment" id="mustard" value="mustard" ${mustard}>
    <label for="mustard">Mustard</label><br>
    <input type="checkbox" name="condiment" id="sprouts" value="sprouts" ${sprouts}>
    <label for="sprouts">Sprouts</label><br><br>
    <input type="submit" value="Save">
</form>
</body>
</html>
