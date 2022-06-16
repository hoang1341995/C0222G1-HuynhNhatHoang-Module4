<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Settings</title>
</head>
<body>
<%@include file="form/header.jsp" %>
<%@include file="form/nav-bar.jsp" %>
<div class="container-fluid d-flex">
    <div class="left col-2">
        left
    </div>
    <div class="left col-8">
        <table id="tables" class="table table-striped table-bordered" style="width:100%">
            <thead>
            <tr>
                <th>STT</th>
                <th>Languages</th>
                <th>Page Size</th>
                <th>Spams fillter</th>
                <th>Signature</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${mailboxList}" var="mailbox" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td>${mailbox.language}</td>
                <td>${mailbox.size}</td>
                <td>${mailbox.spamsFillter}</td>
                <td>${mailbox.signature}</td>

            </tr>
            </c:forEach>
        </table>
    </div>
    <div class="left col-2">
        right
    </div>
</div>
<%@include file="form/footer.jsp" %>


</body>
</html>
