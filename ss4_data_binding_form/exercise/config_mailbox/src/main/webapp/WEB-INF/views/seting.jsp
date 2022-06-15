<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
        <fieldset>
            <legend>
                <h1>Settings</h1>
            </legend>

            <form:form method="post" action="/" modelAttribute="mailbox">


            </form:form>

        </fieldset>
    </div>
    <div class="left col-2">
        right
    </div>
</div>
<%@include file="form/footer.jsp" %>


</body>
</html>
