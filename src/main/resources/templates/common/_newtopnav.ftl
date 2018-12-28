<#macro newtopnav>
<div class="topnavbar col-md-12">
    <div class="newtopnav">
        <img src="/img/index/logo2-lucency.png" alt="logo2" style="height: -webkit-fill-available;">
        <@shiro.user><span class="topnavspan pull-right"><a href="logout">退出</a></span></@shiro.user>
        <@shiro.guest><span class="topnavspan pull-right"><a href="login">登录</a></span></@shiro.guest>
    </div>
</div>
</#macro>