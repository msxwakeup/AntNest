$(document).ready(function() {
	
	/** ----------- 输入框事件 ----------- */
	// 当文本框按下键时
	$("#checkDigit").bind("keydown", function(event) {
		if (event.which==13){
			submitForm();}
		
		
	});
	
	$(".refleshCheckCode").click(function(){
		
		$("#checkCode").attr("src","imageServlet?"+Math.random());
		
		
	});
	$("#loginClick").click(function(){
		//alert("ll;");
		submitForm();
	});
	
	$("#checkDigit").blur(function(){
		checkCode();
		
	});
	
});

function submitForm(){
	
	  if(confirm()){
	     //将密码加密码传输

	     $("#action").val("login");
	     $("form").submit();
	  }
	}


function checkCode(){
	var codeNo=$.trim($("#checkDigit").val());
	//alert(codeNo);
	$.get("checkCodeServlet",{checkDigit:codeNo}, function(result){
	   // alert(result);
		if ($.trim(result)=="no"){
	    	$("#checkDigitIsError").show();
	    	$("#checkCode").attr("src",'imageServlet?'+Math.random());
	    	
	    }
	    else{

	    	$("#checkDigitIsError").hide();
	    	
	    }
		
	  });

}

function confirm(){
	var userID=$.trim($("#userID").val());
	var pwd=$.trim($("#pwd").val());
	var checkDigit=$.trim($("#checkDigit").val());
	var flag=true;
	//  alert($("#pwd").val().length);
	 
	  if(checkDigit==""){
	   //  alert("验证码不能为空！");
		 $("#checkDigitIsError").show(); 
	     $("#checkDigit").focus();
	     flag=false;
	  } 
	  else
	  {
	//判断验证是否通过
	  if(!checkState){
		  $("#checkDigitIsError").show(); 
	  	$("#checkDigit").focus();
	  	flag=false;
	  }
	  }
	  
	  if(pwd==""){
		  
		  $("#pwdIsError").show(); 
		     $("#pwd").focus();
		     flag=false;
		  } 
	  
	  if(userID==""){
		  $("#userIDIsError").show(); 
		    $("#userID").focus();
		    flag=false;
		  }
	  
	 
	  return flag;
	}