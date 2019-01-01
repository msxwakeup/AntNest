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
    <title>视频上传</title>
    <script language="JavaScript" type="text/javascript">
        function check(videotype) {
            var fileTypes = new Array("flv","avi","mp4");  //定义可支持的文件类型数组
            var fileTypeFlag = "0";
            var newFileName = videotype.split('.');
            newFileName = newFileName[newFileName.length-1];
            for(var i=0;i<fileTypes.length;i++){
                if(fileTypes[i] == newFileName){
                    fileTypeFlag = "1";
                }
            }
            if(fileTypeFlag == "0"){
                alert("必须是视频文件！");
                var obj=document.getElementById('file_input');
                obj.outerHTML=obj.outerHTML;

            }

        }
        function checkimg(imgtype) {
            var fileTypes = new Array("jpg","png","jpeg","PNG","JPEG","JPG");  //定义可支持的文件类型数组
            var fileTypeFlag = "0";
            var newFileName = imgtype.split('.');
            newFileName = newFileName[newFileName.length-1];
            for(var i=0;i<fileTypes.length;i++){
                if(fileTypes[i] == newFileName){
                    fileTypeFlag = "1";
                }
            }
            if(fileTypeFlag == "0"){
                alert("必须是图片文件！");
                var obj=document.getElementById('fileinput');
                obj.outerHTML=obj.outerHTML;

            }

        }

    </script>
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
        }
        #wrapinput{
            width: 500px;
            height: 300px;
            text-align: left;
            margin: 20px 250px;
            line-height: 50px;
        }


    </style>
</head>
<body>
<%@include file="/index_header.jsp" %>
<div id="wrap">
    <div id="wrapcenter">
        <div id="wrapinput">
 <form action="/AntNest/uploadvideo.do" method="post" enctype="multipart/form-data">
     <span style="color: red">${error}</span><br>
     上传视频<input id="file_input" type="file" value="选择文件" name="video"  onchange="check(this.value)"><br>
     上传视频图片<input id="fileinput" type="file" value="选择文件" name="videoimg" onchange="checkimg(this.value)" ><br>
     视频名称：<input type="text" name="videoname"><br>
     视频类型：<input type="text" name="knowledge">
     <br>
     <input name="submit" type="submit"  value="上传" />
     <input name="reset" type="reset"  value="重置"/>
     
  </form>
        </div>
    </div>
</div>
</body>
</html>
