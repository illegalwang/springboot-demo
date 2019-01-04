<#include "../common/_layout.ftl">
<#include "useragreement.ftl">
<@head title="注册"></@head>
<@body>
<div class="container-fluid register-page">
    <div class="row">
        <div class="col-md-4">
        <#-- 轮询图片,加上data-ride='carousel'才会自动播放。 -->
            <div id="myCarousel" class="carousel slide" data-ride="carousel" data-interval="5000">
                <!-- 轮播（Carousel）项目 -->
                <div class="carousel-inner">
                    <div class="item active">
                        <img src="${CXT}/img/index/01-1.jpg" alt="slide1"></div>
                    <div class="item">
                        <img src="${CXT}/img/index/01-2.jpg" alt="slide2"></div>
                    <div class="item">
                        <img src="${CXT}/img/index/01-3.jpg" alt="slide3"></div>
                    <div class="item">
                        <img src="${CXT}/img/index/01-4.jpg" alt="slide4"></div>
                </div>
            </div>
        <#-- 轮询图片 -->
        </div>
        <div class="col-md-8"  style="overflow-y: auto;">
            <div class="row" style="height: 70px!important;">
                <div class="col-md-12" style="height: 70px!important;">
                    <a href="/"><img class="pull-right" src="${CXT}/img/index/logo2.png" alt="logo2"></a>
                </div>
            </div>
            <div class="row" style="height: auto!important;">
                <div class="col-md-10 col-md-offset-2">
                    <form class="form-horizontal" action="">
                        <div class="form-group" style="margin-bottom: 50px;">
                            <h1 class="col-md-12">欢迎注册IT模块<br>
                                <small>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;随心所欲，创建你的模块
                                </small>
                            </h1>
                        </div>
                        <div class="form-group">
                            <label for="" class="col-md-2 control-label">用户名</label>
                            <div class="col-md-7">
                                <div class="input-group">
                                    <input type="text" class="form-control input-lg" placeholder="用户名">
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="" class="col-md-2 control-label">密码</label>
                            <div class="col-md-7">
                                <div class="input-group">
                                    <input type="password" class="form-control input-lg" placeholder="密码">
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="" class="col-md-2 control-label">确认密码</label>
                            <div class="col-md-7">
                                <div class="input-group">
                                    <input type="password" class="form-control input-lg" placeholder="确认密码">
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-ok-sign"></i></span>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="" class="col-md-2 control-label">邮箱</label>
                            <div class="col-md-7">
                                <div class="input-group">
                                    <input type="email" class="form-control input-lg" placeholder="电子邮箱">
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-7 col-md-offset-2">
                                <button class="btn btn-default" type="button">
                                    点击邮箱获取验证码
                                </button>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="" class="col-md-2 control-label">邮箱验证码</label>
                            <div class="col-md-7">
                                <div class="input-group">
                                    <input type="email" class="form-control input-lg" placeholder="验证码">
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-send"></i></span>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-7 col-md-offset-2">
                                <button class="btn btn-primary btn-lg col-md-12" type="submit">
                                    注&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;册
                                </button>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-7 col-md-offset-2 text-center">
                                <span>“注册”按钮，即表示同意并遵守&nbsp;
                                    <a href="javascript:void (0)" type="button" data-toggle="modal" data-target="#agreementModal">用户协议</a>。
                                </span>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<@useragreement></@useragreement>
</@body>
<@foot>
<script type="text/javascript" src="${CXT}/js/login.js"></script>
</@foot>