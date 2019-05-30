<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>添加新闻</title>
    <link rel="stylesheet" type="text/css" href="/business/style/news.css" />
</head>
<body>
    <div id="main">
        <form action="" method="post">
            <span id="title">请输入产品名称：</span>
            <input type="text" name="title"/><br><br>
            <p id="content">请输入产品简介（最多200行）</p><br><br>
            <textarea id="textarea" name="content" wrap="hard" cols="200"></textarea><br><br>
            <input class="sub" type="submit" value="发布" />
            <input type="button" value="返回">
        </form>
     </div>
</body>
</html>