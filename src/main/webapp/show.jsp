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
</head>
<body>
bbbbb
<table>

<c:forEach var="material" items="${mlist}">
    <tr>
    <td>${material.name}</td>
    <td>${material.knowledge}</td>
    <td>${material.link}</td>
    </tr>
</c:forEach>

</table>
</body>
</html>
