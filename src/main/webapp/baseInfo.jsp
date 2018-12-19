<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/18 0018
  Time: 上午 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <link type="text/css"  href="css/ants.css" rel="stylesheet"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>baseInformation</title>
    <script src="js/JS.js"></script>
</head>
<body>
<%@include file="index_header.jsp" %>
<div class="setting"  onload="show(1);">
    <div class="baseTitle">个人信息</div>
    <div class="changeInformation">
        <div class="settingLeft">
            <div class="headImg">
                <img src="img/headimg2.jpg" />
            </div>
            <div class="settingList">
                <ul>
                    <li onclick="show(1);">基本信息</li>
                    <li onclick="show(2);">更新头像</li>
                    <li onclick="show(3);">重置密码</li>
                </ul>
            </div>
        </div>
        <div class="settingRight">
            <div id="d1" class="changeInfo">
                <form class="formInfo">
                    <div class="wrap">
                        <label class="tip">昵称：</label>
                        <input type="text" class="input1"/>
                    </div>

                    <div class="wrap">
                        <label class="tip">年龄：</label>
                        <input type="text" class="input1"/>
                    </div>

                    <div class="wrap">
                        <label class="tip">性别：</label>
                        <input type="radio" name="gender" />男
                        <input type="radio" name="gender" />女
                    </div>

                    <button class=" button">保存</button>
                </form>
            </div>

            <div id="d2" class="changeInfo">
                <div class="changeHeadImg">
                    <div class="headImg">
                        <img src="img/headimg2.jpg" />
                    </div>
                    <button class=" button">修改头像</button>
                </div>
            </div>
            <div id="d3" class="changeInfo">
                <form class="formInfo">
                    <div class="wrap">
                        <label class="tip">原密码：</label>
                        <input type="text" class="input1"/>
                    </div>

                    <div class="wrap">
                        <label class="tip">新密码：</label>
                        <input type="text" class="input1"/>
                    </div>

                    <div class="wrap">
                        <label class="tip">确认密码：</label>
                        <input type="text" class="input1"/>
                    </div>
                    <button class=" button">保存</button>
                </form>
            </div>
        </div>
    </div>
</div>
<%@include file="index_footer.jsp" %>
</body>
</html>
