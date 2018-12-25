/*
 * 连接后面的省略号显示隐藏
 * */
$(".body-inside-div .group-child ul h5").hover(function () {
    $(this).children(".omit").show();
}, function () {
    $(this).children(".omit").hide();
});

/**
 * 上传图片前展示图片
 */
$("#inputImage").change(function(o) {
    var files = o.target.files;
    var file;
    if (files && files.length > 0) {
        // 获取当前上传的文件
        file = files[0];
        if (file.size > 1024 * 1024 * 2){
            alert("图片大小不能超过2MB");
            return false;
        }
        var url = window.URL || window.webkitURL;
        // 通过 file 生成目标 url
        var imgUrl = url.createObjectURL(file);
        $("#inputImgPath").val(file.name);
        $("#imageShow").attr("src", imgUrl);
    }
});