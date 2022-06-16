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
        <p class="text-xl-center m-2" style="font-size: 20px">TỜ KHAI Y TẾ</p>
        <p class="text-xl-center" style="font-size: 18px">ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ
            QUAN Y TẾ LIÊN LẠC KHI CẦN THIẾT ĐỂ PHÒNG CHỐNG DỊCH BỆNH TRUYỀN NHIỄM</p>
        <form:form class="needs-validation" action="/" method="post" modelAttribute="declaration">
        <div class="form-row">
            <div class="col-md-12">
                <label>Họ tên (ghi chữ IN HOA)</label>
                <form:input path="name" class="form-control" required="required"></form:input>
            </div>
        </div>
        <div class="form-row">
            <div class="col-md-4 mb-3">
                <label>Năm sinh</label>
                <form:select path="yearOfBirthday" class="form-control">
                    <form:options items="${yearOfBirthdayList}"></form:options>
                </form:select>
            </div>
            <div class="col-md-4 mb-3">
                <label>Quốc tịch</label>
                <form:select path="country" class="form-control">
                    <form:option value="Việt Nam">Việt Nam</form:option>
                    <form:option value="USA">USA</form:option>
                </form:select>
            </div>
            <div class="col-md-4 mb-3">
                <label>Giới tính</label>
                <form:select path="gender" class="form-control">
                    <form:option value="Nam">Nam</form:option>
                    <form:option value="Nữ">Nữ</form:option>
                </form:select>
            </div>
        </div>
        <div class="form-row">
            <div class="col-md-12">
                <label>Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác</label>
                <form:input path="idCard" class="form-control" required="required"></form:input>
            </div>
        </div>
        <div class="form-row">
            <div class="col-md-12">
                <label>Thông tin đi lại</label><br>
                <div class="custom-control custom-radio custom-control-inline">
                    <form:radiobutton path="vehicles" id="vehicles1" class="custom-control-input"
                                      value="Tàu bay"></form:radiobutton>
                    <label class="custom-control-label" for="vehicles1">Tàu bay</label>
                </div>
                <div class="custom-control custom-radio custom-control-inline">
                    <form:radiobutton path="vehicles" id="vehicles2" class="custom-control-input"
                                      value="Tàu thuyền"></form:radiobutton>
                    <label class="custom-control-label" for="vehicles2">Tàu thuyền</label>
                </div>
                <div class="custom-control custom-radio custom-control-inline">
                    <form:radiobutton path="vehicles" id="vehicles3" class="custom-control-input"
                                      value="Ô tô"></form:radiobutton>
                    <label class="custom-control-label" for="vehicles3">Ô tô</label>
                </div>
            </div>
        </div>
        <div class="form-row">
            <div class="col-md-6 mb-3">
                <label>Số hiệu phương tiện</label>
                <form:input path="license" class="form-control" required="required"></form:input>
            </div>
            <div class="col-md-6 mb-3">
                <label>Số ghế</label>
                <form:input path="seatNumber" class="form-control" required="required"></form:input></div>
        </div>
        <div class="form-row">
            <div class="col-md-6 mb-3">
                <label>Ngày khởi hành</label>
                <form:input  path="startDay" class="form-control"  required="required"></form:input>
            </div>

        <div class="col-md-6 mb-3">
            <label>Ngày kết thúc</label>
            <form:input path="endtDay" class="form-control" required="required"></form:input>
    </div>
</div>
<div class="form-row">
    <div class="col-md-12">
        <label>Trong vòng 14 ngày qua, Anh/Chị có đến tỉnh/thành phố nào ?</label>
        <form:textarea path="declare" rows="3" required="required" class="form-control"></form:textarea>
    </div>
</div>
<div class="form-group m-2">
    <div class="col-md-12">
        <button type="submit" class="btn btn-primary btn-block mb-4">Xác nhận</button>
    </div>
</div>
</form:form>
</div>
</div>
<%@include file="form/footer.jsp" %>


</body>
</html>
