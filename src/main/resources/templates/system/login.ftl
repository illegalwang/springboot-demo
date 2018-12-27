<#include "../common/_layout.ftl">
<@head title="登录"></@head>
<@body>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-4 col-md-offset-4 text-center">
            <img class="login-img" src="/img/index/logo2-lucency.png" alt="logo">
        </div>
    </div>
    <div class="row">
        <div class="col-md-4 col-md-offset-4 text-center">
            <div class="login-div">
                <form class="form-horizontal" id="loginForm" action="login" method="POST">
                    <div class="form-group">
                        <div class="col-sm-12">
                            <input type="text" class="form-control" id="" name="" placeholder="邮箱">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-12">
                            <input type="text" class="form-control" id="" name="" placeholder="密码">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-12">
                            <button type="submit" class="login-btn btn btn-default btn-primary">
                                登&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;录</button>
                        </div>
                    </div>
                </form>
                <div>
                    <span class="pull-left"><a href="#">忘记密码？</a></span>
                    <span class="pull-right"><a href="#">注册</a></span>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-4 col-md-offset-4 text-center">
            <#-- TODO 暂时还没什么东西 -->
        </div>
    </div>
</div>
</@body>
<@foot></@foot>