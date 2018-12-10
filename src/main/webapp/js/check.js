function $(elementId){
    return document.getElementById(elementId).value;
}
function divId(elementId){
    return document.getElementById(elementId);
}
//验证用户名
var flag1=false;
var flag2=false;
var flag3=false;
var flag4=false;


function checkUser(){

    var user=$("name");
    var userId=divId("user_prompt");
    userId.innerHTML="";
    var reg=/^[a-zA-Z][a-zA-Z0-9]{3,15}$/;

    if(reg.test(user)==false){
        userId.innerHTML="用户名不正确";
        document.getElementById("bot").disabled=true;
        flag1=false;

    }  else

    {
    flag1=true;}

    checkall();
}
function checkall() {

    if(flag1&&flag2&&flag3&&flag4)
        document.getElementById("bot").disabled=false;


}
//确认密码是否规范
function checkPwd(){
    var flagb=Boolean(true);
    var pwd=$("pwd");
    var pwdId=divId("pwd_prompt");
    pwdId.innerHTML="";
    var reg=/^[a-zA-Z0-9]{4,10}$/;
    if(reg.test(pwd)==false){
        pwdId.innerHTML="密码不能含有非法字符，长度在4-10之间";
        document.getElementById("bot").disabled=true;
        flag2=false;
    }  else

    {
    flag2=true;}
    checkall();
}
//确认密码是否一致
function checkRepwd(){
    var flagc=Boolean(true);
    var repwd=$("repwd");
    var pwd=$("pwd");
    var repwdId=divId("repwd_prompt");
    repwdId.innerHTML="";
    if(pwd!=repwd){
        repwdId.innerHTML="两次输入的密码不一致";
        document.getElementById("bot").disabled=true;
        flag3=false;
    }


    else

    {
    flag3=true;}
    checkall();
}

//电话号码验证
function checkMobile(){
    var flagd=Boolean(true);
    var mobile=$("mno");
    var mobileId=divId("mobile_prompt");
    var regMobile=/^1\d{10}$/;
    if(regMobile.test(mobile)==false){
        mobileId.innerHTML="手机号码不正确，请重新输入";
        document.getElementById("bot").disabled=true;
        flag4=false;
    }
    else

    {mobileId.innerHTML="";
    flag4=true;}
    checkall();
}