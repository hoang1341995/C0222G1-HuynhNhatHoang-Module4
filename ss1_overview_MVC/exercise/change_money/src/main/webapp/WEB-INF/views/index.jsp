<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>đổi tiền tệ</title>
</head>
<body>
<c:if test="${vnd!= null}">${usd} USD = ${vnd} VND</c:if>
<form action="/change-money" method="post">
    <input type="number" name="usd" value="${usd}" placeholder="Nhập USD">
    <input type="submit" name="xác nhận">
</form>
</body>
</html>
