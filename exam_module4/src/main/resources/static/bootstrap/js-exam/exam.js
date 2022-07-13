function functionEdit(answer, title, questionType, dateCreate, status, content) {
    document.getElementById("view-title").innerText = title;
    document.getElementById("view-questionType").innerText = questionType;
    document.getElementById("view-dateCreate").innerText = dateCreate;
    document.getElementById("view-status").innerText = status;
    document.getElementById("view-content").innerText = content;
    document.getElementById("view-answer").innerText = answer;
}

//addNew
$(document).ready(function () {
    $('#buttonAddNew').click(function (event) {

        var title = document.getElementById("title").value;
        var content = document.getElementById("content").value;
        var questionType = document.getElementById("questionType").value;
        var jsonModel = {
            title: title,
            content: content,
            questionType: {
                id : questionType
            }
        }
        $.ajax({
            type: 'post',
            url: '/create',
            data: JSON.stringify(jsonModel),
            contentType: "application/json; charset=utf-8",
            success: function (data) {
                console.log(data)
                $('#addNewModal').modal('hide');
                let content = '';
                for (let i = 0; i < data.content.length; i++) {
                    if (title === data.content[i].title){
                        content += getElement(data.content[i],` class="classNew"`);
                    }else{
                        content += getElement(data.content[i],"");
                    }
                }
                document.getElementById('bodyTable').innerHTML = content;
                transitionColorForRow()

            },
            error : function(data) {
                console.log(data.responseJSON.title)
                let validTitle = document.getElementById('valid-title');
                data.responseJSON.title != undefined ? validTitle.innerText = data.responseJSON.title : validTitle.innerText = "";

                let validContent = document.getElementById('valid-content');
                data.responseJSON.content != undefined ? validContent.innerText = data.responseJSON.content : validContent.innerText = "";
            }

        });
        event.preventDefault();
    });
})

function functionDelete(id, title, questionType) {
    document.getElementById("idDelete").value = id;
    document.getElementById("bodyDelete").innerHTML = "Tiêu đề: <b style='color: #005cbf'>" + title + "</b><br>" +
        "Loại câu hỏi <b style='color: #005cbf'>" + questionType + "</b><br>" +
        "Xóa câu hỏi này chứ ?";
}

// delete
$(document).ready(function () {
    $('#buttonDelete').click(function (event) {
        var idDelete = document.getElementById("idDelete").value;
        $.ajax({
            type: "GET",
            //tên API
            url: `/delete/${idDelete}`,
            success: function (data) {
                $('#deleteModal').modal('hide');
                let content = '';
                for (let i = 0; i < data.content.length; i++) {
                    content += getElement(data.content[i],"");
                }
                document.getElementById('bodyTable').innerHTML = content;
                document.getElementById("message").innerHTML = "Xóa thành công"

            },
            error : function(data) {
            alert("Xóa không thành công, lỗi : "+ data.status);
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
        var questionTypeSearch = document.getElementById("questionTypeSearch").value;
        console.log(questionTypeSearch)
        $.ajax({
            type: "GET",
            //tên API
            url: `/search/${key}/${questionTypeSearch}`,
            success: function (data) {
                let content = '';
                for (let i = 0; i < data.content.length; i++) {
                    content += getElement(data.content[i],` class="classNew"`);
                }
                document.getElementById('bodyTable').innerHTML = content;
                document.getElementById("message").innerHTML = ""
                callLoading()
                transitionColorForRow()
            },
            error : function() {
                callLoading()
                document.getElementById('bodyTable').innerHTML = ""
                document.getElementById("message").innerHTML = "<h4 style='font-weight: bold;color: red'>Không tìm thấy</h4>";
            }
        });
        event.preventDefault();
    });
})


//edit
$(document).ready(function () {
    $('#buttonEdit').click(function (event) {
        var id = document.getElementById("idEdit").value;
        var code = document.getElementById("codeEdit").value;
        var name = document.getElementById("nameEdit").value;
        var birthDay = document.getElementById("birthDayEdit").value;
        var phone = document.getElementById("phoneEdit").value;
        var email = document.getElementById("emailEdit").value;
        var customerType =  document.getElementById("customerTypeEdit").value;

        var jsonModel = {
            id: id,
            code: code,
            name: name,
            birthDay: birthDay,
            customerType: {
                id : customerType
            },
            email: email,
            phone: phone
        }
        $.ajax({
            type: 'post',
            url: '/edit',
            data: JSON.stringify(jsonModel),
            contentType: "application/json; charset=utf-8",
            success: function (data) {
                $('#editModal').modal('hide');
                let content = '';
                for (let i = 0; i < data.content.length; i++) {
                    if (code === data.content[i].code){
                        content += getElement(data.content[i],` class="classNew"`);
                    }else{
                        content += getElement(data.content[i],"");
                    }
                }
                document.getElementById('bodyTable').innerHTML = content;
                transitionColorForRow()


            },
            error : function(data) {
                console.log(data.responseJSON.code)
                let validCode = document.getElementById('valid-code-edit');
                data.responseJSON.code != undefined ? validCode.innerText = data.responseJSON.code : validCode.innerText = "";

                let validName = document.getElementById('valid-name-edit');
                data.responseJSON.name != undefined ? validName.innerText = data.responseJSON.name : validName.innerText = "";

                let validBirthDay = document.getElementById('valid-birthDay-edit');
                data.responseJSON.birthDay != undefined ? validBirthDay.innerText = data.responseJSON.birthDay : validBirthDay.innerText = "";

                let validEmail = document.getElementById('valid-email-edit');
                data.responseJSON.email != undefined ? validEmail.innerText = data.responseJSON.email : validEmail.innerText = "";

                let validPhone = document.getElementById('valid-phone-edit');
                data.responseJSON.phone != undefined ? validPhone.innerText = data.responseJSON.phone : validPhone.innerText = "";

            }

        });
        event.preventDefault();
    });
})

// loop
function getElement(elements,codeNew) {
    console.log(codeNew)
    return `<tr `+ codeNew +`>
               <td >${elements.title}</td>
               <td >${elements.questionType.name}</td>
               <td >${elements.dateCreate}</td>
               <td >${elements.status}</td>
               <td>
                    <button type="button" class="btn btn-outline-primary" data-toggle="modal" data-target="#editModal"
                            onclick="functionEdit('${elements.answer}', '${elements.title}', '${elements.questionType.name}'
                                                        , '${elements.dateCreate}', '${elements.status}', '${elements.content}')">Cập nhật</button>
                    <button type="button" class="btn btn-outline-danger" data-toggle="modal" data-target="#deleteModal"
                            onclick="functionDelete('${elements.id}', '${elements.title}', '${elements.questionType.name}')">Xóa</button>
                </td></tr>`;

}

function transitionColorForRow(){
    setTimeout(function() {
        $('.classNew').removeClass('classNew');
    }, 1000);
}



// // loop
// function getElement(elements) {
//     return `<tr>
//                <td >${elements.id}</td>
//                <td >${elements.code}</td>
//                <td >${elements.name}</td>
//                <td >${elements.birthDay}</td>
//                <td >${elements.customerType.name}</td>
//                <td >${elements.phone}</td>
//                <td >${elements.email}</td>
//                <td>
//         <button type="button" class="btn btn-outline-primary" data-toggle="modal" data-target="#editModal"
//                             onclick="functionEdit('${elements.id}', '${elements.code}', '${elements.name}'
//                                      , '${elements.birthDay}', '${elements.customerType.id}', '${elements.phone}'
//                                      , '${elements.email}')">Edit</button>
//                     <button type="button" class="btn btn-outline-danger" data-toggle="modal" data-target="#deleteModal"
//                             onclick="functionDelete('${elements.id}', '${elements.code}', '${elements.name}')">Delete</button>
//          </td></tr>`;
//
// }