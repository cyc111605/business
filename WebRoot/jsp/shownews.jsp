<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.business.vo.*" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" type="text/css" href="/business/style/main.css" />
    <link rel="stylesheet" type="text/css" href="/business/style/front.css" />
</head>
<%
	request.setCharacterEncoding("UTF-8");
	NewsInfo news=(NewsInfo)session.getAttribute("newsinfoout");
 %>
<body>
<div id="top">
    <div id="top_content">
        <div id="top_left">
            <a href="/business/index.jsp">首页</a>
            <a href="/business/jsp/companyProfile.jsp">企业简介</a>
            <a href="/business/jsp/companyNews.jsp">企业新闻</a>
            <a href="/business/jsp/productShow.jsp">产品展示</a>
            <a href="/business/jsp/addAgent.jsp">加盟代理</a>
            <a href="/business/jsp/addComment.jsp">用户评论</a>
        </div>
        <div id="top_right">
    			<c:if test="${empty inname}">
    	 			<a class="right" href="/business/jsp/register.jsp">免费注册</a>
   	     			<a class="right" id="lo" href="/business/jsp/login.jsp">请登录</a>
    			</c:if>
   				<c:if test="${!empty inname}">
   					<a href="/business/Exit">退出登录</a>
    				<div id="logover">您好，${inname}</div>
    			</c:if>
    	</div>
    </div>
</div>
<div id="banner"></div>
<div id="main">
    <c:if test="${!empty newsinfoout}">
    	 <p><%=news.getNewsName()%></p>
    	 <pre><%=news.getNewsAbstract()%></pre>
    </c:if>
</div>
<div id="bottom">©版权所有 第四组 企业网站</div>
</body>
</html>