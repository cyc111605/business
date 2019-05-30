<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.*" %>
<%@page import="com.business.vo.*" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>新闻删除</title>
    <link rel="stylesheet" type="text/css" href="/business/style/news.css" />
</head>
<body>
<div id="dmain">
    <form action="" method="post">
        <input type="text" placeholder="请输入要删除的新闻的ID" name="id" />
        <input type="submit" value="删除">
        <input type="reset" value="重置">
    </form>
    <div id="cont">
<c:if test="${!empty resultkey}">
    	<table>
    		<tr>
    			<td>新闻ID</td>
    			<td>新闻名称</td>
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
    </div>
</div>
</body>
</html>