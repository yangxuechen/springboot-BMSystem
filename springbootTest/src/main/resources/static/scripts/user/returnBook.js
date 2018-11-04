$(document).ready(function () {
   $("#btn1").click(function () {
       if(validateReturnBookForm().form()){
           var bookId=$("#bookId").val();
           returnBook(bookId);
       }

   });
});

function returnBook(bookId) {
    $.ajax({
        async : false,
        type : "post",
        url : "/userReturnBook",
        dataType : "json",
        data:{bookId:bookId},
        success: function (data) {
            console.log(data.toString());
            if(data.toString()=="true"){
                alert("还书成功!");
            }else{
                alert("还书失败!");
            }

        },
        error:function (data) {
            alert(data.result);
        }
    });
};

function validateReturnBookForm() {
    return $("#returnBookForm").validate({
        rules:{
            bookId:{
                required:true
            }
        },
        messages:{
            bookId:{
                required:"请输入书籍编号"
            }

        }
    })
}