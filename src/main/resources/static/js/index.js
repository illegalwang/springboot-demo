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
$("#inputImage").change(function (o) {
    var files = o.target.files;
    var file;
    if (files && files.length > 0) {
        // 获取当前上传的文件
        file = files[0];
        if (file.size > 1024 * 1024 * 2) {
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

/**
 * groupModal取消按钮
 * */
$("#groupCancelBtn").on('click', function () {
    $("#groupForm")[0].reset();
    $("#imageShow").attr("src", "");
});

/**
 * childModal取消按钮
 * */
$(".childCancelBtn").on('click', function () {
    $("#childForm")[0].reset();
});

/**
 * 添加栏目项a标签
 * */
function getGroupId(groupId) {
    $("#childForm #inputGroupId").val(groupId);
}

/**
 * 显示更多的a标签
 * */
$(function () {
    $(".showMoreBtn").on('click', function () {
        $(this).parents(".group-child").children("ul").children(".li-hidden").slideToggle(200);
        $(this).children("i").attr("class", $(this).children("i").attr("class") == "glyphicon glyphicon-triangle-top" ?
            "glyphicon glyphicon-triangle-bottom" : "glyphicon glyphicon-triangle-top");
        $(this).children("span").toggle();
    });
});

/**
 * 拖动
 * */
var data;
// 拖动到何处触发
function allowDrop(ev) {
    ev.preventDefault();
}
// 拖起时触发
function drag(ev) {
    // 规定了被拖动的数据
    // ev.dataTransfer.setData("Text",ev.target.id);
    data = ev;
}
// 放置被拖动数据时触发
function drop(ev) {
    // ev.preventDefault();
    // var data=ev.dataTransfer.getData("Text");
    ev.appendChild(data);
    var webId = data.id;
    var groupId = ev.id;
    $.ajax({
        url: "group/child",
        type: "PUT",
        data: {"webId": webId, "groupId": groupId},
        dataType: "json",
        success: function (result) {
            if (!result) {
                console.log("child分组修改失败！");
            }
        }
    });
}

/**
 * 修改标题
 */
$(".titleH3").on("dblclick", function () {
    var $parent = $(this);
    var title = $parent.data("title");
    var small = $parent.data("small");
    var id = $parent.data("id");

    var htmlText = "<div class='form-group-sm' style='padding: 5px;margin-left: 5px;'>"
        + "<label for='updateTitle' class='col-sm-3 control-label'>标题：</label>"
        + "<div class='col-sm-8'>"
        + "<input class='form-control update-title' type='text' id='updateTitle' value='" + title + "'></div>"
        + "</div>"
        + "<div class='form-group-sm' style='padding: 5px;margin-left: 5px;'>"
        + "<label for='updateSmall' class='col-sm-3 control-label'>备注：</label>"
        + "<div class='col-sm-8'>"
        + "<input class='form-control update-small' type='text' id='updateSmall' value='" + small + "'></div>"
        + "</div>";
    $parent.html(htmlText);
    $parent.find(".update-title").focus();
    $parent.find(".update-title").blur(function () {
        $parent.find(".update-small").focus();
    });
    $parent.find(".update-small").blur(function () {
        var updateTitle = $parent.find(".update-title").val();
        var updateSmall = $parent.find(".update-small").val();
        var htmlH3 = "<h3>" + updateTitle
                        + "   <small>" + updateSmall + "</small>"
                   + "</h3>";
        $parent.html(htmlH3);
        if (title != updateTitle || small != updateSmall) {
            $.ajax({
                url: "/group",
                type: "PUT",
                data: {"title": updateTitle, "littleTitle": updateSmall, "groupId": id},
                dataType: "json",
                success: function (result) {

                }
            });
        }
    });
});

/**
 * 编辑栏目组按钮点击事件
 * @param groupId
 */
function editGroup(groupId) {
    $("#inputGroupId").val(groupId);
    var $tbody = $("#childrenModal #childrenTable tbody");
    $.ajax({
        url: "/group/child",
        type: "GET",
        data: {"groupId": groupId},
        dataType: "json",
        success: function (result) {
            var htmlStr = "";
            var iconSrc = window.document.location.href + "img/webgroup/earth_service.png";
            $.each(result, function (i, n) {
                htmlStr += "<tr onclick='trClick(this)'>"
                    + "<td><input type='checkbox' name='' id='" + n.webId + "' onclick='checkBtn(event)'></td>"
                    + "<td><img src='" + n.webIcon + "' width='16px' height='16px' onerror='src=\""+ iconSrc
                    + "\"'> " + n.webName + "</td>"
                    + "<td width='100px'>"
                    + "<div class='btn-group' role='group'>"
                    + "<button class='btn btn-default btn-sm edit-web-btn' type='button' id='" + n.webId + "' onclick='editClick(event, this)'>"
                    + "<i class='glyphicon glyphicon-pencil'></i>"
                    + "</button>"
                    + "<button class='btn btn-default btn-sm del-web-btn' type='button' id='" + n.webId + "' onclick='delClick(event, this)'>"
                    + "<i class='glyphicon glyphicon-trash'></i>"
                    + "</button>"
                    + "</div>"
                    + "</td>"
                    + "</tr>";
            });
            $tbody.html(htmlStr);
        }
    });
}

