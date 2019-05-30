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
        <form action="/business/InsertNewsSer" method="post">
            <span id="title">请输入新闻标题：</span>
            <input type="text" name="title"/><br><br>
            <p id="content">请输入正文（最多200行）</p><br><br>
            <textarea id="textarea" name="content" wrap="hard" cols="200"></textarea><br><br>
            <input class="sub" type="submit" value="发布" />
            <input id="exitnews" type="button" value="返回">
        </form>
     </div>
</body>
<script src="/business/scripts/addLoadEvent.js"></script>
<script src="/business/scripts/href.js"></script>
</html>