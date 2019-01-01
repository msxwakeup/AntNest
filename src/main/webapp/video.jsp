
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
    <title>video</title>
    <script src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
    <script src="js/JS.js"></script>
</head>
<body>
<%@include file="index_header.jsp" %>
<div class="video_list">
    <div class="list1">
        <ul>
            <li><a href="video.do">全部</a></li>
            <li><a href="video.do?name=hot">热门</a></li>
            <li><a href="video.do?name=new">上新</a></li>
        </ul>
    </div>
    <div class="list2">
        <div class="video_content">
            <c:forEach items="${videos}" var="videos">
            <div class="video">
                <div class="image">
                    <a href="showvideo?vid=${videos.vId}">
                        <img src="${videos.videoimg}" style="display:block" />
                    </a>
                </div>
                <div class="video_title">
                    <a href="showvideo?vid=${videos.vId}">
                            ${videos.videoName}</a>
                </div>
            </div>
            </c:forEach>
        </div>
    </div>

    <div class="pagination">
        <ul>
            <li><a href="#">«</a></li>
            <li><a href="#">1</a></li>
            <li><a href="#">2</a></li>
            <li><a href="#">3</a></li>
            <li><a href="#">4</a></li>
            <li><a href="#">5</a></li>
            <li><a href="#">6</a></li>
            <li><a href="#">7</a></li>
            <li><a href="#">»</a></li>
        </ul>
    </div>
</div>
<%@include file="index_footer.jsp" %>
</body>
</html>
