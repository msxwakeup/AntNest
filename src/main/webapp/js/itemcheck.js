// JavaScript Document
 $(document).ready(function(){
	 var correctanwser=$("#correctanwser").val();
	 var catagroy=$("#catagory").val();
	 var itid=$("#itid").val();
      $("input[name=anwser]").click(function(){
      	var anwser=$('input:radio[name="anwser"]:checked').val();

        // alert("选中的radio的值是：" +$(this).val());

          sendanwser();
          checkanwser();

          function checkanwser(){

              if(anwser==correctanwser){
                  $("#anwserright").show();
                  $("#anwsererror").hide();
                  $("#correct").show();
                  $("#resolve").show();
              }
              if(anwser!=correctanwser){

                  senderroritem();
                  $("#anwsererror").show();
                  $("#anwserright").hide();
                  $("#correct").show();
                  $("#resolve").show();
              }
          }

          function  sendanwser() {
              $.ajax({
                  type : "post",
                  async : true, //异步执行
                  url : "finishitems",   //后台处理的servlet路径
                  data : {anwser:anwser,itid:itid,catagroy:catagroy},
                  dataType : "json", //返回数据形式为json

              });
          }
          function senderroritem() {
              $.ajax({
                  type : "post",
                  async : true, //异步执行
                  url : "geterroritem",   //后台处理的servlet路径
                  data : {anwser:anwser,itid:itid},
                  dataType : "json", //返回数据形式为json

              });
          }


      });

      function showanwser(){
	$("#correct").show();
     }
    function showanalyse(){
	$("#resolve").show();
  }
 });
   function showanwser(){
    $("#correct").show();
   }
   function showanalyse(){
    $("#resolve").show();}