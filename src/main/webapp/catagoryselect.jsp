<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>选择题型</title>
    <style type="text/css">
        body, ul, ol, li, p, h1, h2, h3, h4, h5, h6, form, table, td, img, div, input { border: 0 none; margin: 0; padding: 0; }
        body { font-family: '新宋体' , '宋体' ,Verdana;  overflow-y: scroll;   overflow-x: hidden;}
        ul, ol { list-style-type: none; }
        img { outline: medium none; vertical-align: middle; }
        a { text-decoration: none; }
        *{
            margin: 0 auto;
            padding: 0px;

        }
        a:link {color: #FF0000} /* 未访问的链接 */
        a:visited {color: #00FF00} /* 已访问的链接 */
        a:hover {color: #FF00FF} /* 当有鼠标悬停在链接上 */
        a:active {color: #0000FF} /* 被选择的链接 */
        #head{
            width: 100%;
            height: 80px;
            background-color: #EBF379;
        }
        #wrap{
            width: 100%;
            margin: 0 auto;
            height: 540px;
            position: relative;
            background: #F3F5F6;

        }
        #wrapcenter{
            width: 800px;
            height: 450px;
            margin: 43px 350px;
            background: #FFFFFF;
            position: absolute;
        }
        #wrapcenter .title{
            margin: 45px  50px;
            font-size: 22px;
            font-weight: bolder;
            width: 500px;
            height: 60px;

        }
        #wrapcenter .main{
            margin: 10px auto;
            height: 150px;
            width: 500px;

            line-height: 50px;
        }
        .main a{
            padding: 30px;
        }
        #foot{
            width: 100%;
            height: 100px;
            background: #7772B7;
        }
    </style>
</head>

<body>
<div id="head"></div>
<div id="wrap">
    <div id="wrapcenter">
        <div class="title">
            请选择题型:
        </div>
        <div class="main">
            <a  href="/AntNest/selectitems.do?catagory=C">C语言</a>
            <a  href="/AntNest/selectitems.do?catagory=Java">java</a>
            <a  href="/AntNest/selectitems.do?catagory=JavaScript">JAVAScript</a>
        </div>
    </div>
</div>

<div id="foot"></div>

</body>
</html>
