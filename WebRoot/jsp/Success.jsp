<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>操作成功页</title>
    <link rel="stylesheet" type="text/css" href="/business/style/sf.css">
</head>
<%
	String info=(String)session.getAttribute("info");
 %>
<body>
<p><%=info %></p>
<a href="/business/index.jsp">返回首页</a>
</body>
</html>