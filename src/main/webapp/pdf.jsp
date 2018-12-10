<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/5 0005
  Time: 下午 6:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <title>Title</title>
</head>
<body>
<a href="http://localhost:8080/pdf/web/viewer.html?file=<%=basePath%>/pdfStreamHandeler.do"target="myframe">pdf1</a>


<%--<iframe id="displayPdfIframe" width="100%" height="800"
        src="<c:url value="pdf/web/viewer.html" />?file=<%=basePath%>/pdfStreamHandeler.do">--%>
    <%--
    </iframe>
    <iframe id="displayPdfIframe" width="100%" height="800"

            src="<c:url value="pdf/web/viewer.html" />?file=<c:url value="/helloworld.pdf"/>">

    </iframe>
    --%>
</body>

</html>
