<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.business.vo.*" %>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>会员管理</title>
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
        <a href="/business/files/updateMember.jsp">修改信息</a>
        <a href="/business/files/deleteMember.jsp">删除会员</a>
        <a href="/business/files/addMember.jsp">添加会员</a>
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
            <form action="/business/SelectMemberSer" method="post">
                <input type="text" placeholder="请输入用户ID" title="用户ID" name="uid" />
                <input type="hidden" name="flag" value="uid" />
                <input type="submit" value="查询" />
                <input type="reset" value="重置" />
            </form>
            <form action="/business/SelectMemberSer" method="post">
                <input type="text" placeholder="请输入关键字" title="关键字" name="key" />
                <input type="hidden" name="flag" value="key" />
                <input type="submit" value="查询" />
                <input type="reset" value="重置" />
            </form>
        </div>
        <c:if test="${!empty info}">
    		<div id="admininfo">${info}</div>
    		<%session.removeAttribute("info"); %>
    	</c:if>
    	<c:if test="${!empty resultlist && empty result}">
    	<table>
    		<tr>
    			<th>会员ID</th>
    			<th>会员名称</th>
    		</tr>
    		<%
    		List<UserInfo> all=(List<UserInfo>)session.getAttribute("resultlist");
    		Iterator<UserInfo> iter=all.iterator();
    		while(iter.hasNext()){
    			UserInfo user=iter.next();
    		%>
    		<tr>
    		<td><%=user.getUserId()%></td>
    		<td><%=user.getUserName()%></td>
    		</tr>
    		<%
    		}
    		 %>
    		 </table>
    		 <%session.removeAttribute("resultlist"); %>
    	</c:if>
    	
    	<c:if test="${!empty result && empty resultlist}">
    	<table>
    		<tr>
    			<th>会员ID</th>
    			<th>会员名称</th>
    		</tr>
    		<%
    		UserInfo user=new UserInfo();
    		user=(UserInfo)session.getAttribute("result");
    		%>
    		<tr>
    		<td><%=user.getUserId()%></td>
    		<td><%=user.getUserName()%></td>
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