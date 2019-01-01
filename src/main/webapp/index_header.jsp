<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/17 0017
  Time: 上午 8:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<header class="header">
    <div class="nav_c">
        <div class="logo">
        <img src="img/LOGO.jpg">
        </div>
        <nav class="nav" id="nav">
            <ul>
                <li><a href="index.do">首页</a><span></span></li>
                <li><a href="video.do">视频课程</a><span></span></li>
                <li><a href="materialpage.do">资料文档</a><span></span></li>
                <li><a href="catagoryselect.jsp">在线评测</a><span></span></li>
                <li><a href="#">悬赏榜</a></li>
            </ul>
        </nav>
        <div class="search bar">
            <form class="searchform">
                <!-- <div class="choose">
                    <select>
                        <option>全部</option>
                        <option>视频</option>
                        <option>文档</option>
                    </select>
                </div> -->
                <input type="text" placeholder="请输入您要搜索的内容...">
                <button type="submit">搜索</button>
            </form>
        </div>
        <div class="navc" >
            <a href="login.jsp">登录</a>
            <span>|</span>
            <a href="registe.jsp">注册</a>
            <div class="loginImg">
                <img src="img/small.jpg" />
            </div>
        </div>
    </div>
</header>
