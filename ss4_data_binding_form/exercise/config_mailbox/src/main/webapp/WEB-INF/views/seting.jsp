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
        <fieldset class="border p-2">
            <legend class="w-auto">Settings</legend>


            <form:form action="/" method="post" modelAttribute="mailbox">
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Languages</label>
                    <div class="col-sm-10">
                        <form:select path="language" class="form-control">
                            <form:option value="English">English</form:option>
                            <form:option value="VietNam">VietNam</form:option>
                        </form:select>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Page Size:</label>
                    <div class="col-sm-10 row">
                        Show
                        <form:select path="size" class="form-control col-sm-1">
                            <form:option value="25">25</form:option>
                            <form:option value="15">15</form:option>
                        </form:select>
                        emails per page

                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Spams fillter:</label>
                    <div class="col-sm-10 row">
                        <form:checkbox path="spamsFillter" value="false" class="form-check-input"></form:checkbox>
                        <label class="form-check-label">
                            Enable spams fillter
                        </label>

                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Signature:</label>
                    <div class="col-sm-10 row">
                        <form:textarea path="signature" rows="3" class="form-control"></form:textarea>
                    </div>
                </div>
                <button type="submit" class="btn btn-primary">Update</button>

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
