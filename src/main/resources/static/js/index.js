/*
 * 连接后面的省略号显示隐藏
 * */
$(".body-inside-div .group-child ul h5").hover(function () {
    $(this).children(".omit").show();
}, function () {
    $(this).children(".omit").hide();
});

$("form input[type='file']").change(function() {
    console.log("sssssssssssssssss");
});