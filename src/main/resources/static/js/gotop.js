/**
 * 返回顶部按钮js
 * */
$(function() {
    $(".back-top").on('click', function() {
        /*滚动条500毫秒的速度滚动到顶端*/
        $("html,body").animate({scrollTop: 0}, 500);
    });

    $(window).on('scroll', function () {
        if ($(window).scrollTop() > 500) {
            $(".back-top").fadeIn(200);
        } else {
            $(".back-top").fadeOut(200);
        }
    });
    /*出发滚动事件，避免刷新页面按钮显示*/
    $(window).trigger('scroll');
});