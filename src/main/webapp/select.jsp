<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/11 0011
  Time: 下午 12:13
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
<form action="material.do">
<input type="text" id="str" name="str">
<input name="submit" type="submit"  value="确定" />
</form>
</body>
</html>
