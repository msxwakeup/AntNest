<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<html>
<head>

    <link type="text/css"  href="css/ants.css" rel="stylesheet"/>
    <script src="js/jquery.js"></script>

    <title>视频播放</title>
    <style type="text/css">
        *{
            margin: 0 auto;
            padding: 0px;

        }
        #wrap{
            width: 100%;
            margin: 0 auto;
            height: 700px;
            position: relative;
            background: #F3F5F6;

        }
        #wrapcenter{
            width: 1200px;
            height: 500px;
            margin: 30px auto;
        }
        #wrapcentervideo{
            width: 1000px;
            height: 500px;
            margin: 25px 0px;
            background: #FFFFFF;
        }
    </style>
    <script type="text/javascript" >
        $(document).ready(function(){
            var vid=$("#vid").val();

            sendvid();

            function sendvid() {
                $.ajax({
                    type: "post",
                    async: true, //异步执行
                    url: "savevideotimes",   //后台处理的servlet路径
                    data: {vid: vid},
                    dataType: "json", //返回数据形式为json

                });
            }
        });
    </script>
</head>
<body>
<%@include file="/index_header.jsp" %>
<div id="wrap">
    <div id="wrapcenter">

        <div id="wrapcentervideo">
            <p style="font-size: 22px" >《${video.videoName}》</p><br>
            <video src="${video.vLink}" controls="controls" poster="${video.videoimg}" width="1000" height="450"></video>
        </div>
    </div>
</div>
<input id="vid" value="${video.vId}" hidden />
</body>
</html>
