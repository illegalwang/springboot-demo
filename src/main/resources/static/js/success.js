$(function () {
    var countDown = 5;
    timeout();
    function timeout(){
        if (countDown != 0) {
            $("#smallSuccess").html(countDown + "秒后将跳转到登录界面。")
            countDown --;
        }
        setTimeout(timeout, 1000);
   }
});