<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.*" %>
<%@page import="com.business.vo.*" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>新闻管理</title>
    <link rel="stylesheet" type="text/css" href="/business/style/end.css" />
    <link rel="stylesheet" type="text/css" href="/business/style/main.css" />
    <link rel="stylesheet" type="text/css" href="/business/style/table.css" />
</head>
<body>
<div id="top">
    <div id="hr">
    	<div id="time"></div>
        <a href="/business/Exit">退出登录</a>
        <c:if test="${!empty inname}">
    		<div id="adminover">您好，${inname}</div>
    	</c:if>
        <a href="/business/files/deleteNews.jsp">删除新闻</a>
        <a href="/business/files/addNews.jsp">添加新闻</a>
    </div>
</div>
<div id="content">
    <div id="left">
        <div class="left_title">用户管理</div>
        <a href="/business/end/adminManage.jsp">管理员管理</a>
        <a href="/business/end/memberManage.jsp">会员管理</a>
        <div class="left_title">栏目管理</div>
        <a href="/business/end/newsManage.jsp">新闻管理</a>
        <a href="/business/end/commentManage.jsp">评论管理</a>
        <div class="left_title">产品管理</div>
        <a href="/business/end/productManage.jsp">产品管理</a>
        <a href="/business/end/addManage.jsp">订单处理</a>
    </div>
    <div id="right">
        <div id="right_search">
            <form action="/business/SelectNewsSer" method="post">
                <input type="text" placeholder="请输入新闻ID" title="新闻ID" name="uid" />
                <input type="hidden" name="flag" value="id" />
                <input type="submit" value="查询" />
                <input type="reset" value="重置" />
            </form>
            <form action="/business/SelectNewsSer" method="post">
                <input type="text" placeholder="请输入关键字" title="关键字" name="name" />
                <input type="hidden" name="flag" value="key" />
                <input type="submit" value="查询" />
                <input type="reset" value="重置" />
            </form>
        </div>
        <c:if test="${!empty info && empty resultkey && empty result}">
    		<div id="admininfo">${info}</div>
    		<%session.removeAttribute("info"); %>
    	</c:if>
    	<c:if test="${!empty resultkey && empty result}">
    	<table>
    		<tr>
    			<th>新闻ID</th>
    			<th>新闻名称</th>
    		</tr>
    		<%
    		List<NewsInfo> all=(List<NewsInfo>)session.getAttribute("resultkey");
    		Iterator<NewsInfo> iter=all.iterator();
    		while(iter.hasNext()){
    			NewsInfo news=iter.next();
    		%>
    		<tr>
    		<td><%=news.getNewsId()%></td>
    		<td><%=news.getNewsName()%></td>
    		</tr>
    		<%
    		}
    		 %>
    		 </table>
    		 <%session.removeAttribute("resultkey"); %>
    	</c:if>
    	
    	<c:if test="${!empty result && empty resultkey}">
    	<table>
    		<thead>
    		<tr>
    			<th>新闻ID</th>
    			<th>新闻名称</th>
    		</tr>
    		</thead>
    		<%
    		NewsInfo news=new NewsInfo();
    		news=(NewsInfo)session.getAttribute("result");
    		%>
    		<tr>
    		<td><%=news.getNewsId()%></td>
    		<td><%=news.getNewsName()%></td>
    		</tr>
    		</table>
    		<%session.removeAttribute("result"); %>
    	</c:if>
    </div>
</div>
<div class="clear"></div>
<div id="bottom">©版权所有 第四组 企业网站</div>
</body>
<script src="/business/scripts/addLoadEvent.js"></script>
<script src="/business/scripts/time.js"></script>
<script src="/business/scripts/stripeTables.js"></script>
<script src="/business/scripts/highlightRows.js"></script>
</html>