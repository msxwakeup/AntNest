<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/17 0017
  Time: 上午 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <link type="text/css"  href="css/ants.css" rel="stylesheet"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>resource</title>
    <script src="js/JS.js"></script>
    <script src="js/jquery-1.8.2.js"></script>
</head>
<script >
    $(document).ready(function() {


        $(".lookfor").click(function() {


//alert($(this).attr("materialLink"));

            $.get("<%=basePath%>setLink.do",{mlink:$(this).attr("materialLink")} ,function(result){
                //alert(result);
            });

            $("#showframe").attr("src","http://localhost:8080/pdf/web/viewer.html?file=<%=basePath%>pdfStreamHandeler.do?"+Math.random());


        });
    });

</script>
<script >
    $(document).ready(function() {


       //$("#booklist ul li:eq(0) ").css("background-color","#B2E0FF");

        //alert( $("li:eq(1) a").attr("materiallink"));

        $.get("<%=basePath%>setLink.do",{mlink:$(".resource_list ul li:eq(0) a").attr("materialLink")} ,function(result){
//alert(result);
        });

        $("#showframe").attr("src","http://localhost:8080/pdf/web/viewer.html?file=<%=basePath%>pdfStreamHandeler.do?"+Math.random());
    });
</script>
<body>
<%@include file="index_header.jsp" %>
<div class="resource">
    <div class="resource_top">
        <span></span>
    </div>
    <div class="resource_nav">
        <form action="materialpage.do" method="get">
            <input type="text" id="str" name="names"  value="${key}" >
            <%--<input type="radio" name="choose" value="filename" <c:if test="${dict}=='filename'">checked</c:if> >文件名--%>
            <%--<input type="radio" name="choose" value="fnowledge" <c:if test="${dict}=='fnowledge'">checked</c:if> >知识点--%>
            <button type="submit">搜索</button>
        </form>

    </div>
    <div class="resource_all">
        <div class="resource_show">
            <iframe id="showframe" name="showframe" width="90%" height="100%" >

                <%--src="<c:url value="pdf/web/viewer.html" />?file=<c:url value="/helloworld.pdf"/>">--%>

            </iframe>
        </div>

        <div class="resource_content">
        <div class="resource_item">
            <div class="item_file">
                <span>全部文档</span>
            </div>
            <div class="page_view">
                <a href="#">浏览量</a>
            </div>
            <div class="update_date">
                <a href="#">上传日期</a>
            </div>
        </div>
        <div class="resource_list">
            <ul>
              <c:forEach var="material" items="${pagebean.pageList}" >
                <li>
                    <div class="pdf_img">
                        <img src="img/pdfimg.jpg" />
                    </div>
                    <div class="file_title">
                        <a class="lookfor"  materialLink="${material.link}"   href="javaScript:;"    target="myframe" >${material.name}</a>
                    </div>
                    <div class="page_view_num">
                        20
                    </div>
                    <div class="update_date_num">
                        2018-12-11
                    </div>
                </li>
              </c:forEach>
            </ul>
        </div>


        <div class="pagination1">
            <span class="first">当前页数：[${pagebean.currentPage}/${pagebean.totalPages}] </span>


            <c:if test="${pagebean.firstPage==true}">
                <a >首页 </a>
                <a >上一页 </a>
            </c:if>

            <c:if test="${pagebean.firstPage==false}">
                <a href="materialpage.do?currentPage=1&names=${key}" class="first">首页 </a>
                <a href="materialpage.do?currentPage=${pagebean.previousPageCount}&names=${key}">上一页 </a>
            </c:if>

            <a href="materialpage.do?currentPage=${pagebean.nextPageCount}&names=${key}">下一页 </a>
            <a href="materialpage.do?currentPage=${pagebean.totalPages}&names=${key}">尾页 </a>

        </div>

    </div>

</div>
    <div class="resource_foot"></div>
</div>
<%@include file="index_footer.jsp" %>

</body>
</html>
