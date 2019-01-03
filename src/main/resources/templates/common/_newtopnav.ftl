<#macro newtopnav>
<div class="topnavbar col-md-12">
    <div class="newtopnav">
        <img src="${CXT}/img/index/logo2-lucency.png" alt="logo2" style="height: -webkit-fill-available;">
        <@shiro.user><span role="presentation" class="topnavspan pull-right dropdown">
            <a href="javascript:void(0)" class="dropdown-toggle" data-toggle="dropdown" role="button"
               aria-haspopup="true" aria-expanded="false">
                <i class="glyphicon glyphicon-user"></i>&nbsp;<@shiro.principal property="trueName"/>
            </a>

            <ul class="dropdown-menu">
                <li><a href="#">个人信息</a></li>
                <li><a href="#">Another action</a></li>
                <li><a href="#">Something else here</a></li>
                <li role="separator" class="divider"></li>
                <li><a href="logout">退出</a></li>
            </ul>
        </span></@shiro.user>
        <@shiro.guest><span class="topnavspan pull-right">
            <a href="login">
                <i class="glyphicon glyphicon-user"></i>&nbsp;登录</a>
        </span></@shiro.guest>
    </div>
</div>
</#macro>