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
<a href="javascript:void(0);" onclick="openDialog('saveForumDialog');">新增板块</a>
<a href="javascript:void(0);" onclick="openDialog('saveTopicDialog')">新增帖子</a>
<ol>
    <#list forum as item>
    <li><a href="${request.contextPath}/f/${item.id}">${item.name}</a></li>
    </#list>
</ol>

<ol>
    <#list topic as item>
        <li><a href="${request.contextPath}/t/${item.id}">${item.title}</a></li>
    </#list>
</ol>
<div id="saveForumDialog" style="display: none;">
    <form action="${request.contextPath}/f/s" method="post">
        <label for="name">名称</label>
        <input type="text" name="name" id="name">
        <label for="parentId">父ID</label>
        <input type="text" name="parentId" id="parentId">
        <input type="button" value="确定" onclick="save('saveForumDialog');">
    </form>
</div>
<div id="saveTopicDialog" style="display: none;">
    <form action="${request.contextPath}/t/s">
        <label for="title">标题</label>
        <input type="text" name="title" id="title">
        <label for="content">内容</label>
        <textarea name="content" id="content"></textarea>
        <label for="forumId">板块ID</label>
        <input type="text" name="forumId" id="forumId">
        <input type="button" value="确定" onclick="save('saveTopicDialog');">
    </form>
</div>
<script src="//cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script>
    function openDialog(dialog){
        document.getElementById(dialog).style.display = '';
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