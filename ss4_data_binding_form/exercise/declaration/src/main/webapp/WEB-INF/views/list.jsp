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

    <div class="left col-12">
        <table id="tables" class="table table-striped table-bordered" style="width:100%">
            <thead>
            <tr>
                <th>STT</th>
                <th>Họ tên</th>
                <th>Năm sinh</th>
                <th>Quốc tịch</th>
                <th>Giới tính</th>
                <th>Số CMND</th>
                <th>Thông tin đi lại</th>
                <th>Số hiệu phương tiện</th>
                <th>Số ghế</th>
                <th>Ngày khởi hành</th>
                <th>Ngày kết thúc</th>
                <th>14 Ngày qua</th>

            </tr>
            </thead>
            <tbody>
            <c:forEach items="${declarationList}" var="declaration" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td>${declaration.name}</td>
                <td>${declaration.yearOfBirthday}</td>
                <td>${declaration.country}</td>
                <td>${declaration.gender}</td>
                <td>${declaration.idCard}</td>
                <td>${declaration.vehicles}</td>
                <td>${declaration.license}</td>
                <td>${declaration.seatNumber}</td>
                <td>${declaration.startDay}</td>
                <td>${declaration.endtDay}</td>
                <td>${declaration.declare}</td>

            </tr>
            </c:forEach>
        </table>
    </div>
</div>
<%@include file="form/footer.jsp" %>


</body>
</html>
