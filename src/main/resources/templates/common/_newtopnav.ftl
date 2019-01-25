<#macro newtopnav>
<div class="topnavbar col-md-12">
    <div class="newtopnav">
        <a href="/index">
            <img src="${CXT}/img/index/logo2-lucency.png" alt="logo2" style="height: -webkit-fill-available;">
        </a>
        <@shiro.user>
        <span class="topnavspan pull-right">
            <a href="javascript:void(0)" id="loginInfoBtn">
                <i class="glyphicon glyphicon-user"></i>&nbsp;
                <@shiro.principal property="trueName"/>
            </a>
            <ul class="dropdown-menu" id="loginInfo">
                <li><a href="#">个人信息</a></li>
                <li><a href="#">Lorem ipsum.</a></li>
                <li><a href="#">Lorem ipsum.</a></li>
                <li role="separator" class="divider"></li>
                <li><a href="/logout">退出</a></li>
            </ul>
        </span>
        </@shiro.user>
        <@shiro.guest>
        <#--<span class="topnavspan pull-right">
            <a href="login">
                <i class="glyphicon glyphicon-user"></i>&nbsp;登录</a>
        </span>-->
        </@shiro.guest>
    </div>
</div>
</#macro>