<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery.js" type="text/javascript"></script>
    <script src="js/jquery.min.js"></script>
    <script src="js/itemcheck.js"></script>

<style type="text/css">
    body, ul, ol, li, p, h1, h2, h3, h4, h5, h6, form, table, td, img, div, input { border: 0 none; margin: 0; padding: 0; }
    body { font-family: '新宋体' , '宋体' ,Verdana; overflow-y: scroll;   overflow-x: hidden;}
    ul, ol { list-style-type: none; }
    img { outline: medium none; vertical-align: middle; }
    a { text-decoration: none; }
    *{
        margin: 0 auto;
        padding: 0px;

    }
    #head{
        width: 100%;
        height: 80px;
        background-color: #6C8CBD;
    }
    #wrap{
        width: 1050px;
        margin: 0 auto;
        height: 540px;
        position: relative;
    }

    #wrapcenter{
        float: left;
        width: 850px;
        height: 540px;
        background: #E9F2BC;

    }
    #wrapcenter .search{
        margin: 0 auto;
        width: 600px;
        height: 50px;
        background: #E2C8C8;

    }
    #wrapcenter .content{
        margin: 25px auto 0px;
        width: 750px;
        height: 80px;

    }
    #wrap .content p{
        font-size: 17px;
        font-weight: 100;
        font-weight: 700;
    }
    #wrapcenter .anwser{
        margin: 5px auto;
        width: 700px;
        height: 30px;
        background: ;
    }
    #wrapcenter .select{
        margin: 5px auto;
        width: 700px;
        height: 20px;
        background: #881012;
    }
    #wrapcenter .operate{
        letter-spacing: 5px;
        margin: 30px auto 0;
        width: 580px;
        height: 30px;

    }
    .operate a{
        padding: 0 10px;
    }
    #analyse{
        width: 750px;
        margin: 5px auto;
        height: 80px;


    }
    #analyse .analyse1{
        height: 15px;

    }
    #analyse .analyse2{

        height: 50px;

    }
    #wrapright{
        float: left;
        width: 200px;
        height: 500px;
        background: #319827;

    }
    #foot{
        width: 100%;
        height: 100px;
        background: #D16668;
    }
</style>
</head>
<body>
<div id="head"></div>
<div id="wrap">
    <div id="wrapcenter">
        <div class="search">搜索</div>
        <input value="${item.catagroy}" hidden="hidden" id="catagory">
        <input value="${item.itId}" hidden="hidden" id="itid">
        <div class="content">
            <p>${item.itContent}</p>
        </div>
        <div class="anwser">
            A:${item.aKey}
        </div>
        <div class="anwser">
            B:${item.bKey}
        </div>
        <div class="anwser">
            C: ${item.cKey}
        </div>
        <div class="anwser">
            D:${item.dKey}
        </div>
        <div class="select">   <!--点击选择答案则执行该事件-->

            选择答案：A:<input type="radio" name="anwser" value="A"  >
            B:<input type="radio" name="anwser" value="B"  >
            C:<input type="radio" name="anwser" value="C" >
            D:<input type="radio" name="anwser" value="D"  >

        </div>
        <div class="operate">
            <a href="javascript:void(0);" onClick="showanwser()">查看答案</a>
            <a href="javascript:void(0);" onClick="showanalyse()">查看解析</a>
            <a href="/AntNest/selectitems.do?catagory=${item.catagroy}&topic=-1"> 上一题</a>
            <a href="javascript:void(0);">收藏题目</a>
            <a href="/AntNest/selectitems.do?catagory=${item.catagroy}&topic=1">下一题</a>
        </div>
        <div id="analyse">
            <div id="anwsererror" class="analyse1" hidden=""><font  size="+1" color="#9F0E10">你答错了</font></div> <div id="anwserright" class="analyse1" hidden=""><font size="+1" color="#16BB0B">你答对了</font></div>
            <div id="correct" class="analyse1" hidden=""><input id="correctanwser" value="${item.answer}" hidden="">正确答案为:${item.answer}</div>
            <div id="resolve" class="analyse2" hidden="">解析：${item.analyse}</div>
        </div>

    </div>
    <div id="wrapright">1111111111</div>
</div>
<div id="foot"></div>
</body>
</html>
