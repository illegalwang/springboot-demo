$(function(){
    $(".topnavspan").hover(function () {
        $("#loginInfo").slideDown(100);
    },function () {
        $("#loginInfo").slideUp(100);
    });
});