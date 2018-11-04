$(document).ready(function () {
    $("#form1").validate({
        rules:{  //校验规则
            userName:{
                required: true,
                minlength: 2,
                remote:{
                    url: "isUserExist",     //后台处理程序
                    type: "post",               //数据发送方式
                    dataType: "json",           //接受数据格式
                    data: {                     //要传递的数据
                        userName: function() {
                            return $("#userName").val();
                        }
                    }
                }
            },
            email:{
                required:true
            },
            password:{
                required: true,
                minlength: 5
            }
        } ,
        messages:{ //提示
            userName:{
                required: "请输入用户名",
                minlength: "用户名必需由两个字母组成",
                remote:"用户不存在"
            },
            email:{
                required:"请输入邮箱地址"
            },
            password:{
                required: "请输入密码",
                minlength: "密码长度不能小于 5 个字母"
            }
        }
    });
});

function findAllDepts() {
    $.ajax({
        async : false,
        type : "post",
        url : "/getDepts",
        dataType : "json",
        success: function (data) {
          console.log(data);
          for(var i=0;i<data.length;i++){
              console.log(data[i].deptId+" "+data[i].deptName);
          }
            $("select[name='depertmentId']").empty();
            $("select[name='depertmentId']").append('<option value="">——请选择——</option>');
            for(var i=0;i<data.length;i++){
                var html ='<option value="'+data[i].deptId+'">';
                html +=data[i].deptName + '</option>';
                $("select[name='departmentId']").append(html);
            }
        },
        error:function (data) {
            alert(data.result);
        }
    });
};

$(document).ready(function () {
   findAllDepts();
});