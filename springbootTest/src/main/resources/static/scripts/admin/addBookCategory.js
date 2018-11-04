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

    //表单验证后，添加种类
   $("#btn_addBookCategory").click(function () {
       if(validateForm().form())
       addBookCategory();
   });

   //点击删除按钮后删除一行
    $("button").click(function () {
        if(confirm("确认删除?")){

            var bookCategoryId=$(this).val();
            // alert(bookCategoryId);
            deleteBookCategoryById(bookCategoryId);
            $(this).parent().parent().remove();
        }

    });
});

//表单验证
function validateForm() {
    return  $("#addBookCategoryForm").validate({
        rules:{
            categoryId:{
                required:true,
                digits:true
            },
            categoryName:{
                required:true
            }
        },
        messages:{
            categoryId:{
                required:"请输入类别编号",
                digits:"请输入整数"
            },
            categoryName:{
                required:"请输入图书类别"
            }
        }
    }) ;
}

//ajax添加种类
function addBookCategory() {
    $.ajax({
        async : false,
        type : "post",
        url : "/addBookCategory",
        dataType : "json",
        data: $("#addBookCategoryForm").serialize(),
        success: function (data) {
            console.log(data.toString());
            if(data.toString()=="true"){
                alert("添加成功!");
            }else{
                alert("添加失败!");
            }

        },
        error:function (data) {
            alert(data.result);
        }
    });
};

//ajax删除种类
function deleteBookCategoryById(bookCategoryId) {
    $.ajax({
        async : false,
        type : "post",
        url : "/deleteCategory",
        dataType : "json",
        data: {bookCategoryId:bookCategoryId},
        success: function (data) {

        },
        error:function (data) {
            alert(data.result);
        }
    });
}

