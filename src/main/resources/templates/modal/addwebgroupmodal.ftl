<#macro addgroupmodal>
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
</#macro>