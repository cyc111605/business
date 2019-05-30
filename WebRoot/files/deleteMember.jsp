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
    <p class="log_p">删除用户</p>
    <form method="post" action="/business/deleteMemberSer" id="regf">
        <input class="in" type="text" placeholder="请输入要删除的用户ID" name="uid"/><br><br>
        <input class="but sub" type="submit" value="删除">
        <input class="but" type="reset" value="重置">
    </form>
	</div>
</body>
</body>
</html>