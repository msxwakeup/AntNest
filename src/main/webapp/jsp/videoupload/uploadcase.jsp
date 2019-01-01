<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <link type="text/css"  href="css/ants.css" rel="stylesheet"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
    <script src="js/JS.js"></script>
    <title>视频上传情况</title>
    <style type="text/css">
        body, ul, ol, li, p, h1, h2, h3, h4, h5, h6, form, table, td, img, div, input { border: 0 none; margin: 0; padding: 0; }
        body { font-family: '新宋体' , '宋体' ,Verdana;  overflow-y: scroll;   overflow-x: hidden;}
        ul, ol { list-style-type: none; }
        img { outline: medium none; vertical-align: middle; }
        *{
            margin: 0 auto;
            padding: 0px;

        }
        #wrap{
            width: 100%;
            margin: 0 auto;
            height: 540px;
            position: relative;
            background: #F3F5F6;

        }
        #wrapcenter{
            width: 800px;
            height: 450px;

            margin: 43px 350px;
            background: khaki;
            position: absolute;
            text-align: center;
        }
        #wrapinput{
            width: 500px;
            height: 30px;
            text-align: center;
            margin: 170px auto;
        }
        #wrapcenter a{
            padding: 30px;
        }

    </style>
</head>
<body>
<%@include file="/index_header.jsp" %>
<div id="wrap">
    <div id="wrapcenter">
        <div id="wrapinput">

            <span style="color: green;font-size: 22px">${uploadcase}</span>
            <span style="color: red;font-size: 22px">${uploadcase1}</span>
            <br>

        </div>
        <a href="jsp/videoupload/videoupload.jsp" >返回上传 </a>
        <a href="index.do" >回到首页 </a>
    </div>
</div>
</body>
</html>
