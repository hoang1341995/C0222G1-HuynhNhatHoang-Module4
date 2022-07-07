function deleteModalEmployee(id, name) {
    document.getElementById("idDelete").value = id;
    document.getElementById("bodyDeleteEmployee").innerHTML = "ID nhân viên: <b style='color: #005cbf'>" + id + "</b><br>" +
        "Tên nhân viên <b style='color: #005cbf'>" + name + "</b><br>" +
        "Xóa nhân viên này chứ ?";
}

function editModalService(id, code, name, maxPeople, rentType, serviceType, standardRoom, poolArea, floor, serviceCost, description) {
    document.getElementById("idEdit").value = id;
    document.getElementById("codeEdit").value = code;
    document.getElementById("nameEdit").value = name;
    document.getElementById("maxPeopleEdit").value = maxPeople;
    document.getElementById("rentTypeEdit").value = rentType;
    document.getElementById("serviceTypeEdit").value = serviceType;
    document.getElementById("standardRoomEdit").value = standardRoom;
    document.getElementById("poolAreaEdit").value = poolArea;
    document.getElementById("floorEdit").value = floor;
    document.getElementById("serviceCostEdit").value = serviceCost;
    document.getElementById("descriptionEdit").value = description;
    console.log(description)
}


//addnew
$(document).ready(function () {
    $('#buttonAddNewService').click(function (event) {

        var code = document.getElementById("code").value;
        var name = document.getElementById("name").value;
        var area = document.getElementById("area").value;
        var maxPeople = document.getElementById("maxPeople").value;
        var rentType = document.getElementById("rentType").value; //model
        var serviceType = document.getElementById("serviceType").value; //model
        var standardRoom = document.getElementById("standardRoom").value;
        var poolArea = document.getElementById("poolArea").value;
        var numberFloors = document.getElementById("numberFloors").value;
        var serviceCost = document.getElementById("serviceCost").value;
        var description = document.getElementById("description").value;
        var jsonModel = {
            code: code,
            name: name,
            area: area,
            maxPeople: maxPeople,
            standardRoom: standardRoom,
            poolArea: poolArea,
            floor: numberFloors,
            serviceCost: serviceCost,
            description: description,
            rentType: {
                id: rentType
            },
            serviceType: {
                id: serviceType
            },
        }
        $.ajax({
            type: 'post',
            url: '/service/create',
            data: JSON.stringify(jsonModel),
            contentType: "application/json; charset=utf-8",
            success: function (data) {
                $('#addNew').modal('hide')
                let content = '';
                for (let i = 0; i < data.content.length; i++) {
                    content += getelementService(data.content[i]);
                }
                document.getElementById('bodyTable').innerHTML = content;
                document.getElementById("message").innerHTML = "<h4 style='font-weight: bold;color: dodgerblue'>Thêm thành công</h4>";

            },
            error : function() {
                document.getElementById("messageCreateEmployee").innerHTML = "<p style='font-weight: bold;color: red'>tạo tài khoản không thành công</p>";
            }

        });
        event.preventDefault();
    });
})

//edit
$(document).ready(function () {
    $('#buttonEditEmployee').click(function (event) {

        var id = document.getElementById("idEdit").value;
        var name = document.getElementById("nameEdit").value;
        var birthday = document.getElementById("birthdayEdit").value;
        var idCard = document.getElementById("idCardEdit").value;
        var phone = document.getElementById("phoneEdit").value;
        var email = document.getElementById("emailEdit").value;
        var address = document.getElementById("addressEdit").value;
        var salary = document.getElementById("salaryEdit").value;
        var position = document.getElementById("positionEdit").value;
        var education = document.getElementById("educationEdit").value;
        var division = document.getElementById("divisionEdit").value;
        var username = document.getElementById("usernameEdit").value;
        var jsonModel = {
            "id": id,
            "name": name,
            "birthday": birthday,
            "idCard": idCard,
            "phone": phone,
            "email": email,
            "address": address,
            "salary": salary,
            "position": {
                "id": position
            },
            "education": {
                "id": education
            },
            "division": {
                "id": division
            },
            "user": {
                "username": username
            }
        }
        $.ajax({
            type: 'post',
            url: '/employee/edit',
            data: JSON.stringify(jsonModel),
            contentType: "application/json; charset=utf-8",
            success: function (data) {
                $('#edit').modal('hide')
                let content = '';
                for (let i = 0; i < data.content.length; i++) {
                    content += getelementEmployee(data.content[i]);
                }
                document.getElementById('bodyTable').innerHTML = content;
                document.getElementById("messageEmployee").innerHTML = "<h4 style='font-weight: bold;color: dodgerblue'>Sửa thành công</h4>";


            },
            error : function() {

                document.getElementById("messageCreateEmployee").innerHTML = "<p style='font-weight: bold;color: red'>tạo tài khoản không thành công</p>";
            }

        });
        event.preventDefault();
    });
})

// loop
function getelementService(elements) {
    return `<tr>
               <td >${elements.code}</td>
               <td >${elements.name}</td>
               <td >${elements.area}</td>
               <td >${elements.maxPeople}</td>
               <td >${elements.rentType.name}</td>
               <td >${elements.serviceType.name}</td>
               <td >${elements.standardRoom}</td>
               <td >${elements.poolArea}</td>
               <td >${elements.poolArea}</td>
               <td >${elements.serviceCost}</td>
               <td >${elements.description}</td>
               <td>
        <button type="button" class="btn btn-outline-primary m-1" data-toggle="modal" data-target="#edit"
        onclick= "editModalService('${elements.id}','${elements.code}','${elements.name}'
                                                        , '${elements.area}', '${elements.maxPeople}', '${elements.rentType.id}'
                                                        , '${elements.serviceType.id}', '${elements.standardRoom}', '${elements.poolArea}'
                                                        , '${elements.poolArea}', '${elements.serviceCost}', '${elements.description}')">Sửa</button>
        <button type="button" class="btn btn-outline-danger m-1" data-toggle="modal" data-target="#delete"
         onclick="deleteModalService('${elements.id}', '${elements.code}', '${elements.name}')">Xóa</button></td></tr>`;
}

// delete
$(document).ready(function () {
    $('#buttonDelete').click(function (event) {

        var idDelete = document.getElementById("idDelete").value;
        $.ajax({
            type: "GET",
            //tên API
            url: `/employee/delete/${idDelete}`,
            success: function (data) {
                $('#delete').modal('hide')
                let content = '';
                for (let i = 0; i < data.content.length; i++) {
                    content += getelementEmployee(data.content[i]);
                }
                document.getElementById('bodyTable').innerHTML = content;
                document.getElementById("messageEmployee").innerHTML = "<h4 style='font-weight: bold;color: dodgerblue'>Xóa thành công</h4>";

            }
        });
        event.preventDefault();
    });
})

// search
$(document).ready(function () {
    $('#buttonSearch').click(function (event) {
        callLoading()
        var key = document.getElementById("key").value;
        $.ajax({
            type: "GET",
            //tên API
            url: `/employee/search/${key}`,
            success: function (data) {
                let content = '';
                for (let i = 0; i < data.content.length; i++) {
                    content += getelementEmployee(data.content[i]);
                }
                document.getElementById('bodyTable').innerHTML = content;
                callLoading()
            },
            error : function() {
                callLoading()
                document.getElementById("messageEmployee").innerHTML = "<h4 style='font-weight: bold;color: red'>Không tìm thấy</h4>";
            }
        });
        event.preventDefault();
    });
})

function changeServiceTypeAddNew(){
    if (document.getElementById("serviceTypeIdAddNew").value == "1"){
        document.getElementById("poolAreaAddNew").placeholder = "Nhập diện tích hồ bơi"
        document.getElementById("numberFloorsAddNew").placeholder = "Nhập số tầng"
        document.getElementById("poolAreaAddNew").disabled = false;
        document.getElementById("numberFloorsAddNew").disabled = false;
    }else if (document.getElementById("serviceTypeIdAddNew").value == "2"){
        document.getElementById("poolAreaAddNew").value = "";
        document.getElementById("poolAreaAddNew").placeholder = "House không có hồ bơi"
        document.getElementById("numberFloorsAddNew").placeholder = "Nhập số tầng"
        document.getElementById("poolAreaAddNew").disabled = true;
        document.getElementById("numberFloorsAddNew").disabled = false;
    }else {
        document.getElementById("poolAreaAddNew").value = "";
        document.getElementById("poolAreaAddNew").placeholder = "Room không có hồ bơi"
        document.getElementById("numberFloorsAddNew").value = "";
        document.getElementById("numberFloorsAddNew").placeholder = "Room không có tầng"
        document.getElementById("poolAreaAddNew").disabled = true;
        document.getElementById("numberFloorsAddNew").disabled = true;
    }
}
function changeServiceType(){
    if (document.getElementById("serviceType").value == "1"){
        document.getElementById("poolArea").placeholder = "Nhập diện tích hồ bơi"
        document.getElementById("numberFloors").placeholder = "Nhập số tầng"
        document.getElementById("poolArea").disabled = false;
        document.getElementById("numberFloors").disabled = false;
    }else if (document.getElementById("serviceType").value == "2"){
        document.getElementById("poolArea").value = "";
        document.getElementById("poolArea").placeholder = "House không có hồ bơi"
        document.getElementById("numberFloors").placeholder = "Nhập số tầng"
        document.getElementById("poolArea").disabled = true;
        document.getElementById("numberFloors").disabled = false;
    }else {
        document.getElementById("poolArea").value = "";
        document.getElementById("poolArea").placeholder = "Room không có hồ bơi"
        document.getElementById("numberFloors").value = "";
        document.getElementById("numberFloors").placeholder = "Room không có tầng"
        document.getElementById("poolArea").disabled = true;
        document.getElementById("numberFloors").disabled = true;
    }
}
function editService(id, name, area, maxPeople, rentTypeId, serviceTypeId, standardRoom, poolArea, numberFloors, serviceCost, description) {
    document.getElementById("id").value = id;
    document.getElementById("name").value = name;
    document.getElementById("area").value = area;
    document.getElementById("maxPeople").value = maxPeople;
    document.getElementById("rentTypeId").value = rentTypeId;
    document.getElementById("serviceTypeId").value = serviceTypeId;
    document.getElementById("standardRoom").value = standardRoom;
    document.getElementById("poolArea").value = poolArea;
    document.getElementById("numberFloors").value = numberFloors;
    document.getElementById("serviceCost").value = serviceCost;
    document.getElementById("description").value = description;
    changeServiceType();
}