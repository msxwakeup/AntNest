<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>视频上传</title>
    <script language="JavaScript" type="text/javascript">
        window.onload=function () {
            showTime();
        }
        function checkTime(i) {
            if(i<10){
                i="0"+i;
            }
            return i;
        }
        function showTime() {
            var now=new Date();
            var year=now.getFullYear();
            var month=now.getMonth()+1;
            var day=now.getDate();
            var h=now.getHours();
            var m=now.getMinutes();
            var s=now.getSeconds();
            m=checkTime(m);
            s=checkTime(s);
            document.getElementById("show").innerHTML=""+year+"年"+month+"月"+day+"日 "+h+":"+m+":"+s;
            t=setTimeout('showTime()',500);
        }
    </script>
</head>
<body>
 <form action="/AntNest/uploadvideo.do" method="post">
     上传视频<input type="file" name="video" ><<br>
      视频名称：<input type="text" name="videoname"></video>"<br>
     <div id="show"> <input type="text" name="time"></div>
     视频类型：<input type="text" name="knowledge">
     <input name="submit" type="submit"  value="上传" />
     <input name="reset" type="reset"  value="重置"/>
     
 </form>
</body>
</html>
