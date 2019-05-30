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
 <div id="reg_four">
    <p class="log_p">修改会员信息</p>
    <form method="post" action="/business/UpdateMemberSer" id="regf">
        <input class="in" type="text" placeholder="请输入要修改的用户ID" name="uid"/><br><br>
        <input id="name" class="in_reg" type="text" placeholder="请输入新的用户名" name="uname"/><br>
        <div id="regname" class="regin"></div><br>
        <input id="pass1" class="in_reg" type="password" placeholder="请输入密码" name="upass1" /><br>
        <div id="reginfo" class="regin"></div><br>
        <input id="pass2" class="in_reg" type="password" placeholder="请重复密码" name="upass2" /><br>
        <div id="reginfo2" class="regin add_bottom"></div>
        <input class="but sub" type="submit" value="修改">
        <input class="but" type="reset" value="重置">
    </form>
    </div>
    
</body>
<script type="text/javascript" src="/business/scripts/addLoadEvent.js"></script>
<script type="text/javascript" src="/business/scripts/validatePass.js"></script>
</html>