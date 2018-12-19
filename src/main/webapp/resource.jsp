<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/17 0017
  Time: 上午 10:00
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
    <title>resource</title>
    <script src="js/JS.js"></script>
</head>
<body>
<%@include file="index_header.jsp" %>
<div class="resource">
    <div class="resource_top">
        <span></span>
    </div>
    <div class="resource_nav">

    </div>
    <div class="resource_content">
        <div class="resource_item">
            <div class="item_file">
                <span>全部文档</span>
            </div>
            <div class="page_view">
                <a href="#">浏览量</span>
            </div>
            <div class="update_date">
                <a href="#">上传日期</span>
            </div>
        </div>
        <div class="resource_list">
            <ul>
                <li class="list_box">
                    <div class="pdf_img">
                        <img src="img/pdfimg.jpg" />
                    </div>
                    <div class="file_title">
                        <a href="#">
                            这时一个文档的标题
                            这时一个文档的标题
                            这时一个文档的标题
                            这时一个文档的标题
                            这时一个文档的标题
                            这时一个文档的标题
                            这时一个文档的标题
                            这时一个文档的标题
                            这时一个文档的标题
                            这时一个文档的标题
                        </a>
                    </div>
                    <div class="page_view_num">
                        <span>20</span>
                    </div>
                    <div class="update_date_num">
                        <span>2018-12-11</span>
                    </div>
                </li>
                <li class="list_box">
                    <div class="pdf_img">
                        <img src="img/pdfimg.jpg" />
                    </div>
                    <div class="file_title">
                        <a href="#">
                            这时一个文档的标题
                            这时一个文档的标题
                            这时一个文档的标题

                        </a>
                    </div>
                </li>
                <li class="list_box">
                    <div class="pdf_img">
                        <img src="img/pdfimg.jpg" />
                    </div>
                    <div class="file_title">
                        <a href="#">
                            这时一个文档的标题
                            这时一个文档的标题
                            这时一个文档的标题

                        </a>
                    </div>
                </li>
                <li class="list_box">
                    <div class="pdf_img">
                        <img src="img/pdfimg.jpg" />
                    </div>
                    <div class="file_title">
                        <a href="#">
                            这时一个文档的标题
                            这时一个文档的标题
                            这时一个文档的标题

                        </a>
                    </div>
                </li>
                <li class="list_box">
                    <div class="pdf_img">
                        <img src="img/pdfimg.jpg" />
                    </div>
                    <div class="file_title">
                        <a href="#">
                            这时一个文档的标题
                            这时一个文档的标题
                            这时一个文档的标题

                        </a>
                    </div>
                </li>
            </ul>

        </div>
        <div class="pagination1">
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
</div>
<%@include file="index_footer.jsp" %>
</body>
</html>
