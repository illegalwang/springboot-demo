<#include "common/_layout.ftl">
<#include "modal/addwebchildmodal.ftl">
<#include "modal/addwebgroupmodal.ftl">
<#include "modal/updatewebgroupmodal.ftl">
<@head title="WJ改变你的网站收藏夹"></@head>
<@body>
    <@newtopnav></@newtopnav>
    <@bodywrapper>
    <#--<div class="alert alert-warning">
        <a href="#" class="close" data-dismiss="alert">&times;</a>
        <strong>说明！</strong>
        在这里您可以记录您常用的网站，并对常用网站进行分类，添加描述。不要犹豫，开始使用吧！
    </div>-->
        <@shiro.user>
        <div class="top-btn-div col-md-12">
            <a href="/dump" class="btn btn-danger pull-right" title="垃圾站">
                <i class="glyphicon glyphicon-trash"></i>
            </a>
            <button type="button" class="btn btn-primary pull-right" data-toggle="modal" data-target="#groupModal">
                创建栏目
            </button>
        </div>
        </@shiro.user>
    <div class="row">
        <#if webBean??>
            <#list 1..webBean.theme as x>
                <div class="col-md-${12/webBean.theme} group-div">
                    <#if webBean.group?? && webBean.group?size &gt; 0>
                        <#list webBean.group as web>
                            <#if web.theme == x>
                                <div class="group-child">
                                    <div class="titleH3" data-title="${web.title}" data-small="${web.littleTitle!''}"
                                        data-id="${web.groupId}">
                                        <h3>${web.title}
                                            <#if web.littleTitle??>
                                                <small>${web.littleTitle}</small>
                                            </#if>
                                        </h3>
                                    </div>
                                    <img src="${CXT}${web.image!""}" onerror="src='${CXT}/img/webgroup/itwjimg.jpg'">
                                    <#-- ondragover事件规定在何处放置被拖动的数据 -->
                                    <ul id="${web.groupId}" ondragover="allowDrop(event)" ondrop="drop(this)">
                                        <li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
                                        <#if web.children?? && (web.children?size>0)>
                                            <#list web.children as child>
                                                <li id="${child.webId}" <#if child?index gte 7>class="li-hidden"
                                                    style="display: none;"</#if> draggable="true" ondragstart="drag(this)"><h5>
                                                    <img src="${child.webIcon!""}"
                                                         onerror="src='${CXT}/img/webgroup/earth_service.png'">
                                                    <a href="${child.webUrl}" target="_blank">${child.webName}</a>
                                                    <#if child.ifDes == 1>
                                                        <a class="omit text-muted pull-right" href="#"><i
                                                                class="glyphicon glyphicon-option-horizontal"></i></a>
                                                    </#if>
                                                </h5></li>
                                            </#list>
                                        </#if>
                                    </ul>
                                    <div class="group-foot">
                                        <#if web.children?size-7 &gt; 0>
                                            <a class="showMoreBtn text-muted" href="javascript:void(0)">
                                                <i class="glyphicon glyphicon-triangle-bottom"></i>
                                                <span>&nbsp;${web.children?size-7}&nbsp;more</span>
                                                <span style="display: none;">&nbsp;close&nbsp;</span>
                                            </a>
                                        <#else>
                                            <span style="cursor: default;">&nbsp;</span>
                                        </#if>
                                        <span class="pull-right">
                                        <@shiro.user><#-- 这个标签表示登录和记住我的用户都可以访问 -->
                                            <a href="javascript:void(0)" data-toggle="modal" title="添加条目" data-target="#childModal"
                                               onclick="getGroupId(${web.groupId})"><i class="glyphicon glyphicon-plus">&nbsp;</i></a>
                                        </@shiro.user>
                                        <@shiro.authenticated><#-- 这个标签表示只有登录的用户才能访问，排除记住我 -->
                                            <a href="javascript:void(0)" data-toggle="modal" title="编辑" data-target="#childrenModal"
                                                onclick="editGroup(${web.groupId})"><i class="glyphicon glyphicon-pencil"></i></a>
                                        </@shiro.authenticated>
                                        </span>
                                    </div>
                                </div>
                            </#if>
                        </#list>
                    </#if>
                </div>
            </#list>
        </#if>
    </div>

<@addgroupmodal></@addgroupmodal>
<@addchildmoal></@addchildmoal>
<@updategroupmodal></@updategroupmodal>
    </@bodywrapper>
    <@footwrapper></@footwrapper>
    <@backtop></@backtop>
</@body>
<@foot>
<script type="text/javascript" src="${CXT}/js/index.js"></script>
<script type="text/javascript" src="${CXT}/js/updategroup.js"></script>
<#-- 返回顶部js -->
<script type="text/javascript" src="${CXT}/js/gotop.js"></script>
</@foot>