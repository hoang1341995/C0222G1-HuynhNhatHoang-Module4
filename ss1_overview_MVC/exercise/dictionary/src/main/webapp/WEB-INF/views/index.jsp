<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Từ điển</title>
</head>
<body>
<h1>Từ điển Anh - Việt</h1>
${mess}
<form action="/" method="post">
    <input type="text" name="en" placeholder="Enter english" value="${map.keySet().toArray()[0]}">
    <input type="text" name="vi" placeholder="Nhập tiếng việt" value="${map.values().toArray()[0]}">
    <input type="submit" value="Tra từ điển">

</form>
</body>
</html>
