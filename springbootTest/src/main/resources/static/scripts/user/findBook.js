$(document).ready(function () {
   $("#findBookByNameForm").validate({
       rules:{
           bookName:{
               required:true
           }
       },
       messages:{
           bookName:{
               required:"请输入书名"
           }
       }
   })
});