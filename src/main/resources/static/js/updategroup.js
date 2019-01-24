/**
 * Created by wj on 2019/1/22.
 */
$(function () {
    // 所有checkbox，不包括第一个
    // var allCheck = $("#childrenModal tbody input[type='checkbox']");

    /*全选反选*/
    $("#allChecked").click(function () {
        if ($(this).prop("checked")) {
            $("#childrenModal tbody input[type='checkbox']").prop("checked", true);
        } else {
            $("#childrenModal tbody input[type='checkbox']").prop("checked", false);
        }
    });

});

/*点击行checkbox选中*/
/*$("#childrenModal table tbody tr").click(function () {
 var cb = $(this).find("input[type='checkbox']");
 if (cb.prop("checked")) {
 cb.prop("checked", false);
 } else {
 cb.prop("checked", true);
 }
 });*/
/**
 * 点击行checkbox选中
 * @param o
 */
function trClick(o) {
    var cb = o.getElementsByTagName("input")[0];
    if (cb.checked) {
        cb.checked = false;
    } else {
        cb.checked = true;
    }
}
/**
 * 复选框
 * @param event
 */
function checkBtn(event) {
    event.stopPropagation();
}
/**
 * 编辑按钮
 * @param event
 */
function editClick(event, o) {
    // 可以阻止事件冒泡
    event.stopPropagation();
}

/**
 * 删除按钮
 * @param event
 */
function delClick(event, o) {
    // 可以阻止事件冒泡
    event.stopPropagation();
    if (confirm("确定删除次条目吗？")) {
        var id = o.id;
        var groupId = $("#inputGroupId").val();
        $.ajax({
            url: "/group/child/single",
            type: "DELETE",
            data: {webId: id, groupId: groupId},
            dataType: "json",
            success: function (result) {
                if (result) {
                    window.location.reload();
                }
            }
        });
    } else {
        return;
    }
}

/**
 * 删除选中项按钮
 */
function delSelect() {
    if (confirm("确定要删除吗？")) {
        var checkArr = $("#childrenModal tbody :checked");
        var groupId = $("#inputGroupId").val();
        var webIds = [];
        console.log("groupId: " + groupId);
        $.each(checkArr, function (i, n) {
            console.log("i: " + i + "n: " + n.id);
            webIds.push(n.id);
        });
        console.log(webIds);
        $.ajax({
            url: "/group/child",
            type: "DELETE",
            data: {groupId: groupId, webIds: webIds},
            dataType: "json",
            success: function (result) {
                if (result) {
                    window.location.reload();
                }
            }
        });
    } else {
        return;
    }
}



