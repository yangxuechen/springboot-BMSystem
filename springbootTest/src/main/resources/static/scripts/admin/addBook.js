$(document).ready(function () {

    //查找所有图书种类，并给select选择框赋值
    findAllBookCategory();


    $("#btn1").click(function () {
        if(validateAddBookForm().form()) //  表单验证
        addBook();//异步添加书籍
    });
});

function validateAddBookForm() {
    return $("#addBookForm").validate({
        rules:{
            bookName:{
                required:true
            },
            bookAuthor:{
                required:true
            },
            bookPublish:{
                required:true
            },
            bookCategory:{
                required:true
            },
            bookPrice:{
                required:true
            },
            bookIntroduction:{
                required:true
            }
        } ,
        messages:{

            bookName:{
                required:"请输入书名"
            },
            bookAuthor:{
                required:"请输入作者"
            },
            bookPublish:{
                required:"请输入出版社"
            },
            bookCategory:{
                required:"请选择种类"
            },
            bookPrice:{
                required:"请输入价格"
            },
            bookIntroduction:{
                required:"请输入简介"
            }
        }
    });
}
function findAllBookCategory() {
    $.ajax({
        async : false,
        type : "post",
        url : "/findAllBookCategory",
        dataType : "json",
        success: function (data) {
            console.log(data);
            $("select[name='bookCategory']").empty();
            $("select[name='bookCategory']").append('<option value="">——请选择——</option>');
            for(var i=0;i<data.length;i++){
                var html ='<option value="'+data[i].categoryId+'">';
                html +=data[i].categoryName + '</option>';
                $("select[name='bookCategory']").append(html);
            }
        },
        error:function (data) {
            alert(data.result);
        }
    });
};

function addBook() {
    $.ajax({
        async : false,
        type : 'post',
        url : '/addBook',
        data : $('#addBookForm').serialize(),
        success : function(data) {
            alert("添加成功");

        },
        error : function(data) {
            alert("添加失败");
        }
    });
};











