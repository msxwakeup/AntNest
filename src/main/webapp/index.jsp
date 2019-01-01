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
    <title>码蚁窝index</title>
    <script src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
    <script src="js/JS.js"></script>
</head>
<body>
<%@include file="index_header.jsp" %>
<div id="flash">
    <img src="img/index1.jpg" style="display:block"/>
    <img src="img/index2.jpg" />
    <img src="img/index3.jpg" />
    <img src="img/index4.jpg" />
    <ul>
        <li style="background-color:#933"></li>
        <li></li>
        <li></li>
        <li></li>
    </ul>
</div>
<!-- 这是视频课程部分 -->
<div id="video">
    <div class="title">
        视频课程
    </div>
    <div class="video_content">
        <c:forEach items="${videolist}" var="videos">
        <div class="video">
            <div class="image">
                <a href="showvideo?vid=${videos.vId}">
                    <img src="${videos.videoimg}" style="display:block" />
                </a>
            </div>
            <div class="video_title">
                <a href="showvideo?vid=${videos.vId}">
                        ${videos.videoName}
                </a>
            </div>

        </div>
        </c:forEach>
    </div>

</div>
<!-- 这是悬赏榜部分 -->
<div id="reward">
    <div class="title">
        悬赏榜单
    </div>
    <div class="reward_content">
        <div class="reward">
            <div class="head_img">
                <img src="img/headimg1.jpg" />
            </div>
            <div class="reward_title">
                <div class="username">
                    昵称：<a>花满楼</a>
                </div>
                <div class="describle">
                    问题：<a href="#">这是一个悬赏榜的内容描述1</a>
                </div>
            </div>
        </div>
        <div class="reward">
            <div class="head_img">
                <img src="img/headimg2.jpg" />
            </div>
            <div class="reward_title">
                <a href="#">
                    这是一个悬赏榜的内容描述2
                </a>
            </div>
        </div>
        <div class="reward">
            <div class="head_img">
                <img src="img/headimg3.jpg" />
            </div>
            <div class="reward_title">
                <a href="#">
                    这是一个悬赏榜的内容描述3
                </a>
            </div>
        </div>
        <div class="reward">
            <div class="head_img">
                <img src="img/headimg5.jpg" />
            </div>
            <div class="reward_title">
                <a href="#">
                    这是一个悬赏榜的内容描述4
                </a>
            </div>
        </div>
        <div class="reward">
            <div class="head_img">
                <img src="img/headimg5.jpg" />
            </div>
            <div class="reward_title">
                <a href="#">
                    这是一个悬赏榜的内容描述5
                </a>
            </div>
        </div>
        <div class="reward">
            <div class="head_img">
                <img src="img/headimg6.jpg" />
            </div>
            <div class="reward_title">
                <a href="#">
                    这是一个悬赏榜的内容描述6
                </a>
            </div>
        </div>

    </div>

</div>
<%@include file="index_footer.jsp" %>
</body>
</html>
