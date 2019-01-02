/**
 * 返回顶部按钮js
 * TODO 再点击返回顶部按钮时，按钮消失之前会闪现，待解决
 * */
$(function() {
    $(".back-top").on('click', function() {
        /*滚动条500毫秒的速度滚动到顶端*/
        $("html,body").animate({scrollTop: 0}, 500);
    });
    $(window).on('scroll', function () {
        // console.log($(window).height()); // 这是当前可见窗口的高度
        // console.log($(document).height()); // 这是整个文档的高度
        // console.log($(window).scrollTop()); // 这是滚动条当前所在的位置
        if ($(window).scrollTop() > 500) {
            $(".back-top").fadeIn(200);
        } else {
            $(".back-top").fadeOut(200);
        }
    });

    /*出发滚动事件，避免刷新页面按钮显示*/
    $(window).trigger('scroll');
});