<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>用户注册</title>
    <link rel="stylesheet" type="text/css" href="/business/style/main.css" />
    <link rel="stylesheet" type="text/css" href="/business/style/login.css" />
</head>
<body>
<div id="topl">
    <div id="logo">

    </div>
    <div id="right">
        <span class="marrig">免费咨询：tel-1234567</span>
        <a href="/business/index.jsp">返回首页</a>
    </div>
</div>
<div id="reg">
    <p class="log_p">用户注册</p>
    <form method="post" action="/business/RegisterSer" id="regf">
        <input class="in" type="text" placeholder="请输入要注册的用户名" name="username"/><br><br>
        <input id="pass1" class="in_reg" type="password" placeholder="请输入密码" name="userpass1" /><br>
        <div id="reginfo" class="regin"></div><br>
        <input id="pass2" class="in_reg" type="password" placeholder="请重复密码" name="userpass2" /><br>
        <div id="reginfo2" class="regin add_bottom"></div>
        <input class="but sub" type="submit" value="注册">
        <input class="but" type="reset" value="重置">
    </form>
</div>
</body>
<script type="text/javascript" src="/business/scripts/addLoadEvent.js"></script>
<script type="text/javascript" src="/business/scripts/addLoadEvent.js"></script>
<script type="text/javascript" src="/business/scripts/validatePass.js"></script>
</html>