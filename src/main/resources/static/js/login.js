$(function () {
    $("#loginForm").validate({
        // 在键盘按下并释放及提交后验证提交表单
        // 定义为name而不是id
        rules: {
            username: "required",
            password: "required"
        },
        messages: {
            username: "用户名不能为空",
            password: "密码不能为空"
        }
    });
});
/*$.validator.setDefaults({
    submitHandler: function () {
        // 点击提交按钮会触发此事件
    }
});*/
