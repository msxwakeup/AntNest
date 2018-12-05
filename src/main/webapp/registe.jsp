
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- <link href="/CSS&JS/style_checkcode.css" rel="stylesheet" type="text/css">-->
    <script type="text/javascript" src="/AntNest/CSS&JS/jquery-1.8.2.js"></script>
    <script type="text/javascript" src="/AntNest/CSS&JS/logincheckcode.js"></script>
    <title>注册</title>
    <style type="text/css">
        *{
            margin: 0;
            padding: 0;
        }
        a{
            text-decoration: none;
            outline: medium none;
            color: #CF0;
        }
        #wrap {
            height: 524px;
            width: 100%;
            background-repeat: no-repeat;
            background-position: center center;
            position: relative;
        }
        #head {
            height: 70px;
            width: 100%;
            background-color: #66CCCC;
            text-align: center;
            position: relative;
        }
        #foot {
            width: 100%;
            height: 126px;
            background-color: #CC9933;
            position: relative;
        }
        #wrap .logGet {
            height: 408px;
            width: 368px;
            position: absolute;
            background-color: #FFFFFF;
            top: 11%;
            left: 10%;

        }
        .inputo{
            margin-top: 20px;
            width: 100%;
            height: 45px;
            background-color: #ee7700;
            border: none;
            color: white;
            font-size: 18px;
        }
        .logC a:hover {
            color: #63B1FF;
            text-shadow: 1px 1px 1px #000000;
        }

        .logGet .logD.logDtip .p1 {
            display: inline-block;
            font-size: 28px;
            margin-top: 10px;
            width: 86%;
        }
        #wrap .logGet .logD.logDtip {
            width: 86%;
            border-bottom: 1px solid #ee7700;
            margin-bottom: 35px;
            margin-top: 0px;
            margin-right: auto;
            margin-left: auto;
        }
        .logGet .lgD img {
            position: absolute;
            top: 12px;
            left: 8px;
        }
        .logGet .lgD input {
            width: 100%;
            height: 25px;
            text-indent: 2.5rem;
        }
        #wrap .logGet .lgD {
            width: 86%;
            position: relative;
            margin-bottom: 30px;
            margin-top: 10px;
            margin-right: auto;
            margin-left: auto;
        }
        #wrap .logGet .logC {
            width: 86%;
            margin-top: 0px;
            margin-right: auto;
            margin-bottom: 0px;
            margin-left: auto;
        }


        .title {
            font-family: "宋体";
            color: #FFFFFF;
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);  /* 使用css3的transform来实现 */
            font-size: 36px;
            height: 40px;
            width: 30%;
        }

        .copyright {
            font-family: "宋体";
            color: #FFFFFF;
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);  /* 使用css3的transform来实现 */
            height: 60px;
            width: 40%;
            text-align:center;
        }


        #foot .copyright .img {
            width: 100%;
            height: 24px;
            position: relative;
        }
        .copyright .img .icon {
            display: inline-block;
            width: 24px;
            height: 24px;
            margin-left: 22px;
            vertical-align: middle;
            /*background-image: url("");*/
            background-repeat: no-repeat;
            vertical-align: middle;
            margin-right: 5px;
        }

        .copyright .img .icon1 {
            display: inline-block;
            width: 24px;
            height: 24px;
            margin-left: 22px;
            vertical-align: middle;
            /*//background-image: url();*/
            background-repeat: no-repeat;
            vertical-align: middle;
            margin-right: 5px;
        }
        .copyright .img .icon2 {
            display: inline-block;
            width: 24px;
            height: 24px;
            margin-left: 22px;
            vertical-align: middle;
            /* //background-image: url();*/
            background-repeat: no-repeat;
            vertical-align: middle;
            margin-right: 5px;
        }
        #foot .copyright p {
            height: 24px;
            width: 100%;
        }
    </style>
</head>

<body>
<div class="header" id="head">
    <div class="title">码蚁窝</div>

</div>

<div class="wrap" id="wrap">
    <div class="logGet">
        <!-- 头部提示信息 -->
        <div class="logD logDtip">
            <p class="p1">会员注册</p>
        </div>
        <!-- 输入框 -->
        <form  id="formLogin" action="reg.do" method="post" >
            <span style="color: red">${error}</span>

            <div class="lgD">

                <!--   <img src="img/logName.png" width="20" height="20" alt=""/>-->
                会员名:<input type="text" name="name" id="name"
                       placeholder="输入会员名" />
            </div>
            <div class="lgD">
                <!-- <img src="img/logPwd.png" width="20" height="20" alt=""/>-->
                输入密码:<input type="password" name="pwd" id="pwd"
                       placeholder="输入密码" />
            </div>
            <div class="lgD">
                <!-- <img src="img/logPwd.png" width="20" height="20" alt=""/>-->
                确认密码:<input type="password" name="repwd" id="repwd"
                       placeholder="确认密码" />
            </div>
            <div class="lgD">
                <!-- <img src="img/logPwd.png" width="20" height="20" alt=""/>-->
                电话号码:<input type="text" name="mno" id="mno"
                       placeholder="输入电话号码" />
            </div>

            <div class="logC">
                <input name="submit" type="submit"  value="提交" class="inputo" /><br/>


            </div>


        </form>
    </div>
</div>

<div class="footer" id="foot">
    <div class="copyright">
        <p>Copyright © 2018</p>
        <div class="img">
            <i class="icon"></i><span></span>
        </div>

        <div class="img">
            <i class="icon1"></i><span></span>
        </div>

        <div class="img">
            <i class="icon2"></i><span>联系电话</span>
        </div>


    </div>

</div>


</body>
</html>
