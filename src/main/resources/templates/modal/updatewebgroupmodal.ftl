<#macro updategroupmodal>
<!-- 修改栏目Modal -->
<form class="form-horizontal" id="updateGroupForm" action="" method="post" enctype="multipart/form-data">
    <div class="modal fade" id="childrenModal" tabindex="-1" role="dialog" aria-labelledby="childrenModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">修改栏目</h4>
                </div>
                <div class="modal-body">
                    <input type="hidden" name="groupId" id="inputGroupId">
                    <table class="table table-hover" id="childrenTable">
                        <thead>
                        <tr>
                            <th><input type="checkbox" id="allChecked"></th>
                            <th>栏目项</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td><input type="checkbox" name="" id=""></td>
                            <td>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</td>
                            <td width="100px">
                                <div class="btn-group" role="group">
                                    <button class="btn btn-default btn-sm edit-web-btn" type="button">
                                        <i class="glyphicon glyphicon-pencil"></i>
                                    </button>
                                    <button class="btn btn-default btn-sm del-web-btn" type="button">
                                        <i class="glyphicon glyphicon-trash"></i>
                                    </button>
                                </div>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                        <button type="button" class="btn btn-danger" onclick="delSelect()">删除选中项</button>
                </div>
            </div>
        </div>
    </div>
</form>
</#macro>