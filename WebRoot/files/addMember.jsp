<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>操作界面</title>
    <link rel="stylesheet" type="text/css" href="/business/style/files.css" />
    <link rel="stylesheet" type="text/css" href="/business/style/login.css" />
</head>
<body>
    <div id="reg">
    <p class="log_p">添加会员</p>
    <form method="post" action="/business/InsertMemberSer" id="regf">
        <input class="in" type="text" placeholder="请输入要添加的用户名" name="uname"/><br><br>
        <input id="pass1" class="in_reg" type="password" placeholder="请输入密码" name="upass1" /><br>
        <div id="reginfo" class="regin"></div><br>
        <input id="pass2" class="in_reg" type="password" placeholder="请重复密码" name="upass2" /><br>
        <div id="reginfo2" class="regin add_bottom"></div>
        <input class="but sub" type="submit" value="注册">
        <input class="but" type="reset" value="重置">
    </form>
	</div>
</body>
<script type="text/javascript" src="/business/scripts/addLoadEvent.js"></script>
<script type="text/javascript" src="/business/scripts/validatePass.js"></script>
</html>