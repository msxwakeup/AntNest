<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/17 0017
  Time: 上午 9:44
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
    <title>video</title>
    <script src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
    <script src="js/JS.js"></script>
</head>
<body>
<%@include file="index_header.jsp" %>
<div class="video_list">
    <div class="list1">
        <ul>
            <li><a href="#">全部</a></li>
            <li><a href="#">热门</a></li>
            <li><a href="#">上新</a></li>
        </ul>
    </div>
    <div class="list2">
        <div class="video_content">
            <div class="video">
                <div class="image">
                    <a href="#">
                        <img src="img/1200-576.jpg" style="display:block" />
                    </a>
                </div>
                <div class="video_title">
                    <a href="#">
                        这是视频的标题1
                    </a>
                </div>
            </div>
            <div class="video">
                <div class="image">
                    <a href="#">
                        <img src="img/wtg.jpg" />
                    </a>
                </div>
                <div class="video_title">
                    <a href="#">
                        这是视频的标题2
                    </a>
                </div>
            </div>
            <div class="video">
                <div class="image">
                    <a href="#">
                        <img src="img/zt4.0.jpg">
                    </a>
                </div>
                <div class="video_title">
                    <a href="#">
                        这是视频的标题3
                    </a>
                </div>
            </div>
            <div class="video">
                <div class="image">
                    <a href="#">
                        <img src="img/fbxzt.jpg">
                    </a>
                </div>
                <div class="video_title">
                    <a href="#">
                        这是视频的标题4
                    </a>
                </div>
            </div>

            <div class="video">
                <div class="image">
                    <a href="#">
                        <img src="img/1200-576.jpg" style="display:block" />
                    </a>
                </div>
                <div class="video_title">
                    <a href="#">
                        这是视频的标题5
                    </a>
                </div>
            </div>
            <div class="video">
                <div class="image">
                    <a href="#">
                        <img src="img/wtg.jpg" />
                    </a>
                </div>
                <div class="video_title">
                    <a href="#">
                        这是视频的标题6
                    </a>
                </div>
            </div>
            <div class="video">
                <div class="image">
                    <a href="#">
                        <img src="img/zt4.0.jpg">
                    </a>
                </div>
                <div class="video_title">
                    <a href="#">
                        这是视频的标题7
                    </a>
                </div>
            </div>
            <div class="video">
                <div class="image">
                    <a href="#">
                        <img src="img/fbxzt.jpg">
                    </a>
                </div>
                <div class="video_title">
                    <a href="#">
                        这是视频的标题8
                    </a>
                </div>
            </div>

            <div class="video">
                <div class="image">
                    <a href="#">
                        <img src="img/1200-576.jpg" style="display:block" />
                    </a>
                </div>
                <div class="video_title">
                    <a href="#">
                        这是视频的标题1
                    </a>
                </div>
            </div>
            <div class="video">
                <div class="image">
                    <a href="#">
                        <img src="img/wtg.jpg" />
                    </a>
                </div>
                <div class="video_title">
                    <a href="#">
                        这是视频的标题2
                    </a>
                </div>
            </div>
            <div class="video">
                <div class="image">
                    <a href="#">
                        <img src="img/zt4.0.jpg">
                    </a>
                </div>
                <div class="video_title">
                    <a href="#">
                        这是视频的标题3
                    </a>
                </div>
            </div>
            <div class="video">
                <div class="image">
                    <a href="#">
                        <img src="img/fbxzt.jpg">
                    </a>
                </div>
                <div class="video_title">
                    <a href="#">
                        这是视频的标题4
                    </a>
                </div>
            </div>

            <div class="video">
                <div class="image">
                    <a href="#">
                        <img src="img/1200-576.jpg" style="display:block" />
                    </a>
                </div>
                <div class="video_title">
                    <a href="#">
                        这是视频的标题5
                    </a>
                </div>
            </div>
            <div class="video">
                <div class="image">
                    <a href="#">
                        <img src="img/wtg.jpg" />
                    </a>
                </div>
                <div class="video_title">
                    <a href="#">
                        这是视频的标题6
                    </a>
                </div>
            </div>
            <div class="video">
                <div class="image">
                    <a href="#">
                        <img src="img/zt4.0.jpg">
                    </a>
                </div>
                <div class="video_title">
                    <a href="#">
                        这是视频的标题7
                    </a>
                </div>
            </div>
            <div class="video">
                <div class="image">
                    <a href="#">
                        <img src="img/fbxzt.jpg">
                    </a>
                </div>
                <div class="video_title">
                    <a href="#">
                        这是视频的标题8
                    </a>
                </div>
            </div>
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
