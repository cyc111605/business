<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.*" %>
<%@page import="com.business.vo.*" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>公司新闻</title>
    <link rel="stylesheet" type="text/css" href="/business/style/main.css" />
    <link rel="stylesheet" type="text/css" href="/business/style/front.css" />
    <link rel="stylesheet" type="text/css" href="/business/style/jspnews.css" />
</head>

<c:if test="${empty newsoutput}">
	<c:redirect url="/AllNewsSer"></c:redirect>
</c:if>
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
    <c:if test="${!empty newsinfo}">
    	<div id="newsinfo">${newsinfo}</div>
    	<%session.removeAttribute("newsinfo"); %>
    </c:if>
    <c:if test="${!empty newsoutput}">
    <div id="news">
    	<%
    		List<NewsInfo> all=(List<NewsInfo>)session.getAttribute("newsoutput");
    		Iterator<NewsInfo> iter=all.iterator();
    		while(iter.hasNext()){
    		NewsInfo news=iter.next();
    		%>
    		<form action="/business/ShowNewsSer" method="post">
    		<input type="hidden" name="newsid" value=<%=news.getNewsId()%> />
    		<input type="submit" value=<%=news.getNewsName()%> />
    		</form>
    	<%
    		}
    	 %>
    	</div>
    	<%session.removeAttribute("newsoutput"); %>
    </c:if>
</div>
<div id="bottom">©版权所有 第四组 企业网站</div>
</body>
</html>