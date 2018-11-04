$(document).ready(function () {
    //检查能否再点击上一页，下一页
    var lab1=$("#lab1").html().trim();//获取当前页码
    var lab2=$("#lab2").html().trim();//获取总页码
    // alert(lab1+" *****"+lab2);
    $("#prePage").click(function () {
        if(lab1==1){
            alert("已经是第一页了!");
            return false;
        }
        return true;
    });
    $("#nextPage").click(function () {
        if(lab1==lab2){
            alert("已经是最后一页了!");
            return false;
        }
        return true;
    });

    //点击删除按钮后删除一行
    $("button").click(function () {
        if(confirm("确认删除?")){

            var userId=$(this).val();
            // alert(userId);
            deleteBookCategoryById(userId);
            $(this).parent().parent().remove();
        }

    });

});

//ajax删除用户
function deleteBookCategoryById(userId) {
    $.ajax({
        async : false,
        type : "post",
        url : "/deleteUser",
        dataType : "json",
        data: {userId:userId},
        success: function (data) {

        },
        error:function (data) {
            alert(data.result);
        }
    });
}