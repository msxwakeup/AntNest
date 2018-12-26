<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/10 0010
  Time: 下午 5:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@page import="Mo.Material" %>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title>Title</title>
    <script src="js/jquery-1.8.2.js"></script>
    <style>
        *{margin: 0;padding: 0;}
        #fl{
            width: 30%;
            height: 80%;
            float: left;
        }
        #fd{
            width: 70%;
            height: 80%;
            float: left;
        }
    </style>
</head>
<script >
    $(document).ready(function() {


        $(".lookfor").click(function() {


alert($(this).attr("materialLink"));

            $.get("<%=basePath%>setLink.do",{mlink:$(this).attr("materialLink")} ,function(result){
                //alert(result);
            });

            $("#myframe").attr("src","http://localhost:8080/pdf/web/viewer.html?file=<%=basePath%>pdfStreamHandeler.do?"+Math.random());


        });
    });

</script>
<body>
bbbbb

<div id="fl">

    <ul id="booklist" >
        <c:forEach var="material" items="${mlist}">
        <li>


            <a class="lookfor"  materialLink="${material.link}"   href="javaScript:;"    target="myframe" >${material.name}</a>

                ${material.knowledge}
        </li>
        </c:forEach>
    </ul>
</div>



<%--<iframe id="displayPdfIframe" width="100%" height="800"
        src="<c:url value="pdf/web/viewer.html" />?file=<%=basePath%>/pdfStreamHandeler.do">

    </iframe> --%>
<div id="fd">
<iframe id="myframe" name="myframe" width="100%" height="100%">

    <%--src="<c:url value="pdf/web/viewer.html" />?file=<c:url value="/helloworld.pdf"/>">--%>

</iframe>
</div>
<script >
$(document).ready(function() {


    $("li:eq(1) ").css("background-color","#B2E0FF");

    alert( $("li:eq(1) a").attr("materiallink"));

$.get("<%=basePath%>setLink.do",{mlink:$("#booklist li:eq(0) a").attr("materialLink")} ,function(result){
//alert(result);
});

$("#myframe").attr("src","http://localhost:8080/pdf/web/viewer.html?file=<%=basePath%>pdfStreamHandeler.do?"+Math.random());
});
</script>
</body>
</html>
