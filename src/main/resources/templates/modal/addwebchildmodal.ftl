<#macro addchildmoal>
<#-- 添加条目modal -->
<form class="form-horizontal" id="childForm" action="group/child" method="post">
    <div class="modal fade" id="childModal" tabindex="-1" role="dialog" aria-labelledby="childModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">添加条目</h4>
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
</#macro>