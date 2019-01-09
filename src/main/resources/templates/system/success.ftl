<#include "../common/_layout.ftl">
<@head title="注册成功">
    <meta http-equiv="refresh" content="5;/login">
</@head>
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
            <div class="row" style="height: auto!important;padding-top: 150px;">
                <div class="col-md-10 col-md-offset-4">
                    <div>
                        <h1>恭喜您注册成功！</h1>
                        <h1>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <small id="smallSuccess"></small></h1>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</@body>
<@foot>
<script type="text/javascript" src="${CXT}/js/success.js"></script>
</@foot>