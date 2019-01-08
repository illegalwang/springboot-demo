$(function () {
    $("#loginForm").validate({
        // 在键盘按下并释放及提交后验证提交表单
        // 定义为name而不是id
        rules: {
            username: "required",
            password: "required"
        },
        messages: {
            username: "请输入用户名",
            password: "请输入密码"
        }
    });
});
/*$.validator.setDefaults({
    submitHandler: function () {
        // 点击提交按钮会触发此事件
    }
});*/
