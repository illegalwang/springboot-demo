<#include "../common/_layout.ftl">
<@head title="WJ改变你的网站收藏夹-垃圾站"></@head>
<@body>
    <@newtopnav></@newtopnav>
    <@bodywrapper>
    <#if children?? && (children?size>0)>
        <#list children as child>
        <div class="row">
            <div class="col-md-8 col-md-offset-2 dump-list">
                <img src="${child.webIcon}" alt="ICON" width="34" height="30" style="margin: 5px;"
                    onerror="src='${CXT}/img/webgroup/earth_service.png'">
                <label style="margin: 5px;"> ${child.webName}</label>
                <div class="pull-right" style="margin: 5px;">
                    <button class="btn btn-default btn-sm" type="button">
                        <i class="glyphicon glyphicon-pencil"></i></button>
                    <button class="btn btn-default btn-sm" type="button">
                        <i class="glyphicon glyphicon-trash"></i></button>
                    <button class="btn btn-default btn-sm dropdown-toggle" type="button" data-toggle="dropdown"
                        aria-haspopup="true" aria-expanded="false">
                        <i class="glyphicon glyphicon-floppy-save"></i></button>
                    <ul class="dropdown-menu">
                        <#if groups?? && groups?size &gt; 0>
                            <#list groups as group>
                                <li><a href="javascript:void(0)" id="${group.groupId}">${group.title}</a></li>
                            </#list>
                        </#if>
                    </ul>
                </div>
            </div>
        </div>
        </#list>
        <div class="row">
            <div class="col-md-8 col-md-offset-2">
                <span class="text-muted" style="position: absolute;margin-top: 7px;">总条数： ${children?size} 条</span>
                <nav class="pull-right" aria-label="Page navigation">
                    <ul class="pagination" style="margin: 0px;">
                        <li>
                            <a href="#" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                        <li><a href="#">1</a></li>
                        <li><a href="#">2</a></li>
                        <li><a href="#">3</a></li>
                        <li><a href="#">4</a></li>
                        <li><a href="#">5</a></li>
                        <li>
                            <a href="#" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
    </#if>
    </@bodywrapper>
    <@footwrapper></@footwrapper>
    <@backtop></@backtop>
</@body>
<@foot>
<#-- 返回顶部js -->
<script type="text/javascript" src="${CXT}/js/gotop.js"></script>
</@foot>