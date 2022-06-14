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
<h1>Caculator</h1>
<p style="color: blue">${total}</p>
<form action="/" method="post">
    <table style="border: black solid 1px">
        <tr>
            <td colspan="2">
                <input type="number" name="number1" value="${number1}" placeholder="Enter number 1">
            </td>
            <td colspan="2">
                <input type="number" name="number2" value="${number2}" placeholder="Enter number 2">
            </td>
        </tr>
        <tr>
            <td>
                <button name="cal" value="+">Addition(+)</button>
            </td>
            <td>
                <button name="cal" value="-">Subtraction(-)</button>
            </td>
            <td>
                <button name="cal" value="*">Multiplication(*)</button>
            </td>
            <td>
                <button name="cal" value="/">Division(/)</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
