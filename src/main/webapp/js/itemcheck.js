// JavaScript Document
 $(document).ready(function(){
	 var correctanwser=$("#correctanwser").val();
	 var catagroy=$("#catagory").val();
	 var itid=$("#itid").val();
	 var theanswer=$("#theanswer").val();
	 var num=-1;

	   if(theanswer==num) {

           $("input[name=anwser]").click(function () {
               var anwser = $('input:radio[name="anwser"]:checked').val();
               var input = $(".select").find("input[type='radio']");
                    input.attr("disabled","disabled");
               //alert("选中的radio的值是：" +$(this).val());
               sendanwser();
               checkanwser();

               function checkanwser() {

                   if (anwser == correctanwser) {
                       $("#anwserright").show();
                       $("#anwsererror").hide();
                       $("#correct").show();
                   }
                   if (anwser != correctanwser) {
                       $("#anwsererror").show();
                       $("#anwserright").hide();
                       $("#correct").show();
                       $("#resolve").show();
                       senderroritem();
                   }
               }

               function sendanwser() {
                   $.ajax({
                       type: "post",
                       async: true, //异步执行
                       url: "finishitems",   //后台处理的servlet路径
                       data: {anwser: anwser, itid: itid, catagroy: catagroy},
                       dataType: "json", //返回数据形式为json

                   });
               }

               function senderroritem() {
                   $.ajax({
                       type: "post",
                       async: true, //异步执行
                       url: "geterroritem",   //后台处理的servlet路径
                       data: {anwser: anwser, itid: itid},
                       dataType: "json", //返回数据形式为json

                   });
               }


           });
       }
       else if(theanswer!=num){
           var input = $(".select").find("input[type='radio']");
                input.attr("disabled","disabled");
                input.each(function(){
               if($(this).val()==theanswer)
                   $(this).attr("checked", true);
                });
           if(theanswer==correctanwser){
               $("#anwserright").show();
               $("#anwsererror").hide();
               $("#correct").show();
           }
           if(theanswer!=correctanwser){
               $("#anwsererror").show();
               $("#anwserright").hide();
               $("#correct").show();
               $("#resolve").show();
           }
       }

 });

   function showanwser(){
    $("#correct").show();
   }
   function showanalyse(){
    $("#resolve").show();
   }