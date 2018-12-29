<#include "_constants.ftl">
<#include "_newtopnav.ftl">
<#include "_footwrapper.ftl">
<#include "_bodywrapper.ftl">
<#include "_backtop.ftl">
<#-- 通用模板 -->
<#macro head title>
<!DOCTYPE html>
<html>
<head lang="zh-cn">
    <meta charset="UTF-8">
    <title>${title!""}</title>
    <link href="/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/css.css" rel="stylesheet">
<#-- 不定义nested指令，自定义标签之间的内容将被忽略，定义后就可以在标签之间加入新的东西 -->
    <#nested >
</head>
</#macro>
<#macro body>
<body>
    <#nested >
</body>
<script src="/jquery/jquery-3.3.1.min.js"></script>
<script src="/jquery/jquery.validate.min.js"></script>
<script src="/jquery/messages_zh.min.js"></script>
<script src="/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</#macro>
<#macro foot>
    <#nested >
</html>
</#macro>
