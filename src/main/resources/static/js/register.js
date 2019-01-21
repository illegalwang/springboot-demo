var currentValidator;
$(function() {
    /* TODO 可以添加自定义方法，http://www.runoob.com/jquery/jquery-plugin-validate.html
    $.validator.addMethod("validateName", function() {
        var v_regex=/^[\u4E00-\u9FA5]+(?:·[\u4E00-\u9FA5]+)*$/;
        value=""+value;
        if(value){
            if(!v_regex.test(value)){
                return false;
            }else{
                return true;
            }
        }else{
            return null;
        }
    }, "用户名为中文");*/
    currentValidator = $("#registerForm").validate({
        rules: {
            username: {
                required: true,
                rangelength: [6, 18],
                // TODO 异步验证用户名是否重复，每次键盘按键抬起都会触发，影响性能
                remote: {
                    url: "/register/sameUser",
                    type: "post",
                    dataType: "json",
                    data:{
                        username: function () {
                            return $("#inputUsername").val();
                        }
                    },
                    dataFilter: function (data) {
                        return data;
                    }
                }
            },
            password: {
                required: true,
                minlength: 6
            },
            checkPass: {
                required: true,
                equalTo: "#inputPassword"
            },
            email: {
                required: true,
                email: true
            },
            authCode: {
                required: true,
                equalTo: "#inputCurrentAuthCode"
            }
        },
        messages: {
            username: {
                required: "用户名不能为空",
                rangelength: "用户名必须在6~18字符之间",
                remote: "用户名已存在"
            },
            password: {
                required: "密码不能为空",
                minlength: "密码不能小于6个字符"
            },
            checkPass: {
                required: "确认密码不能为空",
                equalTo: "两次密码不一致"
            },
            email: {
                required: "邮箱不能为空",
                email: "邮箱格式不正确"
            },
            authCode: {
                required: "验证码不能为空",
                equalTo: "验证码错误"
            }
        },
        onkeyup: false
    });
});

/**
 * 点击获取验证码。
 */
$("#buttonAuthCode").click(function() {
    var email = $("#inputEmail").val();
    if (!currentValidator.element("#inputEmail")) {
        $("#inputEmail").focus();
    } else {
        $.ajax({
            url: "/register/emailAuthCode",
            type: "post",
            data: {email: email},
            success: function (result) {
                $("#inputCurrentAuthCode").val(result);
            }
        });
        countDown();
    }
});
// 倒计时3分钟
var countDownNum = 180;
function countDown() {
    if (countDownNum == 0) {
        $("#buttonAuthCode").attr("disabled", false);
        $("#buttonAuthCode").html("点击获取邮箱验证码");
        // 重置验证码
        $("#inputCurrentAuthCode").val("");
        countDownNum = 180;
        return;
    } else {
        $("#buttonAuthCode").attr("disabled", true);
        $("#buttonAuthCode").html("重新发送（" + countDownNum + "）秒");
        countDownNum --;
    }
    setTimeout(countDown, 1000);
}
