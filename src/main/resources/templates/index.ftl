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
    <div class="top-btn-div col-md-12">
        <button type="button" class="btn btn-primary pull-right" data-toggle="modal" data-target="#groupModal">
            创建栏目
        </button>
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
                                                <li <#if child?index gte 7>class="li-hidden" style="display: none;"</#if>><h5>
                                                    <img src="${child.webIcon!""}"
                                                         onerror="src='/img/webgroup/earth_service.png'">
                                                    <a href="${child.webUrl}" target="_blank">${child.webName}</a>
                                                    <#if child.ifDes == 1>
                                                        <a class="omit text-muted pull-right" href="#"><i
                                                                class="glyphicon glyphicon-option-horizontal"></i></a>
                                                    </#if>
                                                </h5></li>
                                            </#list>
                                        </ul>
                                    </#if>
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
                                        <a href="javascript:void(0)" data-toggle="modal" data-target="#childModal"
                                           onclick="getGroupId(${web.groupId})"><i class="glyphicon glyphicon-plus">&nbsp;</i></a>
                                        <a href="javascript:void(0)"><i class="glyphicon glyphicon-pencil"></i></a>
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

    <!-- 创建栏目Modal -->
    <form class="form-horizontal" id="groupForm" action="group" method="post" enctype="multipart/form-data">
        <div class="modal fade" id="groupModal" tabindex="-1" role="dialog" aria-labelledby="groupModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">创建栏目</h4>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label for="inputTitle" class="col-sm-2 control-label">标题</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="inputTitle" name="title" placeholder="标题">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputLittleTitle" class="col-sm-2 control-label">小标题</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="inputLittleTitle" name="littleTitle"
                                       placeholder="小标题">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputImage" class="col-sm-2 control-label">图片</label>
                            <div class="col-sm-10">
                            <#-- accept="image/*"  只能上传图片格式 -->
                                <input type="file" class="btn-default" id="inputImage" name="imgFile" accept="image/*"
                                       style="display: none;">
                                <div class="input-group">
                                      <span class="input-group-btn">
                                        <button class="btn btn-default" type="button"
                                                onclick="$('#inputImage').click()">上传图片</button>
                                      </span>
                                    <input type="text" id="inputImgPath" class="form-control" disabled>
                                </div>
                            </div>
                            <div class="col-md-10 col-md-offset-2 imgDiv text-center">
                                <img id="imageShow" src="">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputTheme" class="col-sm-2 control-label">上级栏目</label>
                            <div class="col-sm-10">
                                <select class="form-control" id="inputTheme" name="theme">
                                    <option class="text-muted" value="">--请选择上级栏目--</option>
                                    <option value="1">左侧</option>
                                    <option value="2">中间</option>
                                    <option value="3">右侧</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" id="groupCancelBtn" data-dismiss="modal">取消
                        </button>
                        <button type="submit" class="btn btn-primary">保存</button>
                    </div>
                </div>
            </div>
        </div>
    </form>

    <#-- 添加栏目项modal -->
    <form class="form-horizontal" id="childForm" action="group/child" method="post">
        <div class="modal fade" id="childModal" tabindex="-1" role="dialog" aria-labelledby="childModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">添加栏目项</h4>
                    </div>
                    <div class="modal-body">
                        <input type="hidden" id="inputGroupId" name="groupId">
                        <div class="form-group">
                            <label for="inputWebName" class="col-sm-2 control-label">描述</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="inputWebName" name="webName"
                                       placeholder="描述">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputWebUrl" class="col-sm-2 control-label">URL</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="inputWebUrl" name="webUrl"
                                       placeholder="访问地址">
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="childCancelBtn btn btn-default" data-dismiss="modal">取消</button>
                        <button type="submit" class="btn btn-primary">保存</button>
                    </div>
                </div>
            </div>
        </div>
    </form>
    </@bodywrapper>
    <@footwrapper></@footwrapper>
</@body>
<@foot>
<script type="text/javascript" src="/js/index.js"></script>
</@foot>