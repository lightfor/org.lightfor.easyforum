<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <base href="${request.contextPath}">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <title>index</title>
</head>
<body>
<a href="${request.contextPath}/f/">首页</a>
<a href="javascript:void(0);" onclick="openDialog('forumDialog');">新增板块</a>
<a href="javascript:void(0);" onclick="openDialog('topicDialog')">新增帖子</a>
<a href="javascript:void(0);" onclick="openDialog('topicDialog')">修改帖子</a>
<h1>${topic.title}</h1>
<div id="display">
</div>
<label><textarea id="content" style="display: none;">${topic.content}</textarea></label>
<div id="forumDialog" style="display: none;">
    <form action="${request.contextPath}/f/s" method="post">
        <label for="name">名称</label>
        <input type="text" name="name" id="name">
        <label for="parentId">父ID</label>
        <input type="text" name="parentId" id="parentId">
        <input type="button" value="确定" onclick="save('forumDialog');">
        <input type="button" value="取消" onclick="closeDialog('forumDialog');">
    </form>
</div>
<div id="topicDialog" style="display: none;">
    <form action="${request.contextPath}/t/s">
        <label for="title">标题</label>
        <input type="text" name="title" id="title">
        <label for="content">内容</label>
        <textarea name="content" id="content"></textarea>
        <label for="forumId">板块ID</label>
        <input type="text" name="forumId" id="forumId">
        <input type="button" value="确定" onclick="save('topicDialog');">
        <input type="button" value="取消" onclick="closeDialog('topicDialog');">
    </form>
</div>
<script src="//cdn.bootcss.com/marked/0.3.6/marked.min.js"></script>
<script src="//cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script>
    document.getElementById('display').innerHTML = marked(document.getElementById('content').value);

    function openDialog(dialog){
        $('#'+dialog).find('input textarea').val('');
        document.getElementById(dialog).style.display = '';
    }

    function closeDialog(dialog){
        document.getElementById(dialog).style.display = 'none';
    }

    function save(dialog){
        var form = $('#'+dialog+'').find('form');
        $.post(form.attr('action'), form.serialize(), function(){
            location.reload();
        });
    }
</script>
</body>
</html>