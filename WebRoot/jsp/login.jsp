<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<title>登录</title>
<link rel="stylesheet" type="text/css" href="/business/style/main.css" />
<link rel="stylesheet" type="text/css" href="/business/style/login.css" />
</head>
<body>
<div id="topl">
    <div id="logo"></div>
    <div id="right">
    	<span class="marrig">免费咨询：tel-1234567</span>
   		<a href="/business/index.jsp">返回首页</a>
    </div>
</div>
<div id="log_reg">
   	<p class="log_p">用户登录</p>
    <form action="/business/LoginSer" method="post">
    	<input id="uid" class="in" type="text" placeholder="请输入用户ID" title="用户名" name="uid"/><br>
    	<div id="reginfo" class="regin"></div><br>
    	<input id="upass" class="in add_bottom" type="password" placeholder="请输入密码" title="密码" name="upass" /><br><br>
    	<input class="but sub" type="submit" value="登录" />
    	<input class="but" type="reset" value="重置" />
    </form>
</div>
</body>
<script type="text/javascript" src="/business/scripts/addLoadEvent.js"></script>
<script src="/business/scripts/validateLogin.js"></script>
</html>