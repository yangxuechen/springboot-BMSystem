$(document).ready(function () {

    $("#btn_addUser").click(function () {
        if(validateAddUserForm().form()){
            addUser();
        }
    });
});


//添加用户的ajax方法
function addUser() {
    $.ajax({
        async : false,
        type : 'post',
        url : '/addUser',
        data : $('#addUserForm').serialize(),
        success : function(data) {
            alert("添加成功");

        },
        error : function(data) {
            alert("添加失败");
        }
    });
};

function validateAddUserForm() {
    return $("#addUserForm").validate({
        rules:{
            userName:{
                required:true
            },
            password:{
                required:true
            }
        },
        messages:{
            userName:{
                required:"请输入用户名"
            },
            password:{
                required:"请输入密码"
            }
        }
    })
}