<#include "common/_layout.ftl">
<#include "common/_newtopnav.ftl">
<#include "common/_footwrapper.ftl">
<#include "common/_bodywrapper.ftl">
<@head title="wj改变你的网站收藏夹"></@head>
<@body>
    <@newtopnav></@newtopnav>
    <@bodywrapper>
    <div class="alert alert-warning">
        <a href="#" class="close" data-dismiss="alert">&times;</a>
        <strong>说明！</strong>
        在这里您可以记录您常用的网站，并对常用网站进行分类，添加描述。不要犹豫，开始使用吧！
    </div>
    <div class="row">
        <#if webBean??>
            <#list 1..webBean.theme as x>
                <div class="col-md-${12/webBean.theme} group-div">
                    <#if webBean.group?? && webBean.group?size &gt; 0>
                        <#list webBean.group as web>
                        <#if web.theme == x>
                            <div class="group-child">
                                <h3>${web.title}
                                    <#if web.littleTitle??>
                                        <small>${web.littleTitle}</small>
                                    </#if>
                                </h3>
                                <img src="${web.image!""}" onerror="src='/img/webgroup/itwjimg.jpg'">
                                <#if web.children?? && (web.children?size>0)>
                                    <ul>
                                        <#list web.children as child>
                                        <li><h5>
                                            <img src="${child.webIcon!""}"  onerror="src='/img/webgroup/earth_service.png'">
                                            <a href="${child.webUrl}" target="_blank">${child.webName}</a>
                                            <#if child.ifDes == 1>
                                                <a class="omit text-muted pull-right" href="#"><i class="glyphicon glyphicon-option-horizontal"></i></a>
                                            </#if>
                                        </h5></li>
                                        </#list>
                                    </ul>
                                </#if>
                                <div class="group-foot">
                                    <#if web.children?size-2 &gt; 0>
                                        <a class="text-muted" href="#">
                                            <i class="glyphicon glyphicon-triangle-bottom"></i>&nbsp;${web.children?size-2}&nbsp;more
                                        </a>
                                    <#else>
                                        <span style="cursor: default;">&nbsp;</span>
                                    </#if>
                                    <span class="pull-right">
                                        <a href="#"><i class="glyphicon glyphicon-plus">&nbsp;</i></a>
                                        <a href="#"><i class="glyphicon glyphicon-pencil"></i></a>
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
    </@bodywrapper>
    <@footwrapper></@footwrapper>
</@body>
<@foot>
<script type="text/javascript" src="/js/index.js"></script>
</@foot>