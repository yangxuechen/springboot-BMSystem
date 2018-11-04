$(document).ready(function () {
   $("#btn1").click(function () {
       if(validateBorrowingBookForm().form()){
           var bookId=$("#bookId").val();
           borrowingBook(bookId);
       }
   });
});

//表单验证
function validateBorrowingBookForm() {
    return $("#borrowingBookForm").validate({
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
    });
}
//借书
function borrowingBook(bookId) {
    $.ajax({
        async : false,
        type : "post",
        url : "/userBorrowingBook",
        dataType : "json",
        data:{bookId:bookId},
        success: function (data) {
            console.log(data.toString());
            if(data.toString()=="true"){
                alert("借书成功!");
            }else{
                alert("借书失败!");
            }

        },
        error:function (data) {
            alert(data.result);
        }
    });
};