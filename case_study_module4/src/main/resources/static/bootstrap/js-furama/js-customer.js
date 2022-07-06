function deleteModalCustomer(id, code, name) {
    document.getElementById("idDelete").value = id;
    document.getElementById("bodyDeleteCustomer").innerHTML = "Mã khách hàng: <b style='color: #005cbf'>" + code + "</b><br>" +
        "Tên khách hàng <b style='color: #005cbf'>" + name + "</b><br>" +
        "Xóa khách hàng này chứ ?";
}
function editModalCustomer(id, code, name, gender, birthday, idCard, phone, email, address, customerType) {
    document.getElementById("idEdit").value = id;
    document.getElementById("codeEdit").value = code;
    document.getElementById("nameEdit").value = name;
    document.getElementById("genderEdit").value = gender;
    document.getElementById("birthdayEdit").value = birthday;
    document.getElementById("idCardEdit").value = idCard;
    document.getElementById("phoneEdit").value = phone;
    document.getElementById("emailEdit").value = email;
    document.getElementById("addressEdit").innerText = address;
    document.getElementById("customerTypeEdit").value = customerType;
}

//edit
$(document).ready(function () {
    $('#buttonEditCustomer').click(function (event) {
        var id = document.getElementById("idEdit").value;
        var code = document.getElementById("idEdit").value;
        var name = document.getElementById("nameEdit").value;
        var gender = document.getElementById("genderEdit").value;
        var birthday = document.getElementById("birthdayEdit").value;
        var idCard = document.getElementById("idCardEdit").value;
        var phone = document.getElementById("phoneEdit").value;
        var email = document.getElementById("emailEdit").value;
        var address = document.getElementById("addressEdit").value;
        var customerType =  document.getElementById("customerTypeEdit").value;

        var jsonModel = {
            "id": id,
            "code": code,
            "name": name,
            "gender": gender,
            "birthday": birthday,
            "idCard": idCard,
            "phone": phone,
            "email": email,
            "address": address,
            "CustomerType": {
                "id": customerType
            }
        }
        $.ajax({
            type: 'post',
            url: '/customer/edit',
            data: JSON.stringify(jsonModel),
            contentType: "application/json; charset=utf-8",
            success: function (data) {
                $('#edit').modal('hide')
                let content = '';
                for (let i = 0; i < data.content.length; i++) {
                    content += getElementCustomer(data.content[i]);
                }
                document.getElementById('bodyTable').innerHTML = content;
                document.getElementById("message").innerHTML = "<h4 style='font-weight: bold;color: dodgerblue'>Sửa thành công</h4>";
            },
            error : function() {
                document.getElementById("message").innerHTML = "<p style='font-weight: bold;color: red'>không thành công</p>";
            }

        });
        event.preventDefault();
    });
})

// loop
function getElementCustomer(elements) {
    return `<tr>
               <td >${elements.id}</td>
               <td >${elements.code}</td>
               <td >${elements.name}</td>
               <td >${elements.birthday}</td>
               <td >${elements.gender}</td>
               <td >${elements.idCard}</td>
              <td >${elements.phone}</td>
               <td >${elements.email}</td>
              <td >${elements.address}</td>
               <td >${elements.customerType.id}</td>
               <td>
        <button type="button" class="btn btn-outline-primary m-1" data-toggle="modal" data-target="#edit"
        onclick= editModalCustomer('${elements.id}', '${elements.code}', '${elements.name}'
                                                        , '${elements.gender}', '${elements.birthday}', '${elements.idCard}'
                                                        , '${elements.phone}', '${elements.email}', '${elements.address}'
                                                        , '${elements.customerType.id}')>Sửa</button>
        <button type="button" class="btn btn-outline-danger m-1" data-toggle="modal" data-target="#delete"
         onclick=deleteModalCustomer('${elements.id}', '${elements.code}', '${elements.name}')>Xóa</button></td></tr>`;
}