<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>评论管理</title>
    <link rel="stylesheet" type="text/css" href="/business/style/end.css" />
    <link rel="stylesheet" type="text/css" href="/business/style/main.css" />
</head>
<body>
<div id="top">
    <div id="hr">
    	<div id="time"></div>
        <a href="/business/Exit">退出登录</a>
        <c:if test="${!empty inname}">
    		<div id="adminover">您好，${inname}</div>
    	</c:if>
        <a href="/business/files/updateAdmin.jsp">删除评论</a>
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
            <form action="" method="post">
                <input type="text" placeholder="请输入用户ID" title="用户ID" name="uid" />
                <input type="submit" value="查询" />
                <input type="reset" value="重置" />
            </form>
            <form action="" method="post">
                <input type="text" placeholder="请输入关键字" title="关键字" name="key" />
                <input type="submit" value="查询" />
                <input type="reset" value="重置" />
            </form>
        </div>
        <div class="center">本功能暂未开放，敬请期待！</div>
    </div>
</div>
<div class="clear"></div>
<div id="bottom">©版权所有 第四组 企业网站</div>
</body>
<script src="/business/scripts/addLoadEvent.js"></script>
<script src="/business/scripts/time.js"></script>
<script src="/business/scripts/stripeTables.js"></script>
</html>