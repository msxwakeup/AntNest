<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
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


        // window.onload=function () {
        //     showTime();
        // }
        // function checkTime(i) {
        //     if(i<10){
        //         i="0"+i;
        //     }
        //     return i;
        // }
        // function showTime() {
        //     var now=new Date();
        //     var year=now.getFullYear();
        //     var month=now.getMonth()+1;
        //     var day=now.getDate();
        //     var h=now.getHours();
        //     var m=now.getMinutes();
        //     var s=now.getSeconds();
        //     m=checkTime(m);
        //     s=checkTime(s);
        //     document.getElementById("show").innerHTML=""+year+"年"+month+"月"+day+"日 "+h+":"+m+":"+s;
        //     t=setTimeout('showTime()',500);
        // }
    </script>
</head>
<body>
 <form action="/AntNest/uploadvideo.do" method="post" enctype="multipart/form-data">
     上传视频<input id="file_input" type="file" value="选择文件" name="video"  onchange="check(this.value)"><br>
      视频名称：<input type="text" name="videoname"><br>
     视频类型：<input type="text" name="knowledge">
     <input name="submit" type="submit"  value="上传" />
     <input name="reset" type="reset"  value="重置"/>
     
 </form>
</body>
</html>
