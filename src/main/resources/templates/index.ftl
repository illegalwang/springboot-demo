<#include "common/_layout.ftl">
<#include "common/_topnav.ftl">
<@head title="主页"></@head>
<@body>
    <div class="col-md-12">
    <@topnav></@topnav>
    </div>
    <div class="col-md-12">
        <table class="table table-bordered text-center" style="position: relative; top: 70px;">
            <thead>
                <tr class="thead">
                    <td><b>hhh</b></td>
                    <td><b>hhh</b></td>
                </tr>
            </thead>
            <tbody>
                <tr class="tbody">
                    <td>xxx</td>
                    <td>xxx</td>
                </tr>
            </tbody>
            <tfoot>
                <tr>
                    <td colspan="2">
                        <button class="btn btn-default btn-sm pull-left" id="addTd">添加</button>
                    </td>
                </tr>
            </tfoot>
        </table>
    </div>
</@body>
<@foot>
    <script>
        $(function() {
            /**
             * 添加分类
             * */
            $("#addTd").on("click", function () {
                $(".thead").append("<td><a href='#'><b>标题</b></a></td>");
                $(".tbody").append("<td><a href='#'>你好</a></td>");
            });
        });
    </script>
</@foot>