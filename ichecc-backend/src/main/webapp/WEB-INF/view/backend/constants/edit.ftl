<#include "/common/common.ftl"/>

<@backend title="" 
js=[
'/statics/backend/constants.js'
]
css=[
'/statics/plugins/bootstrap/bootstrap-3.3.7-dist/css/bootstrap.min.css'
]>


<div class="panel-body box_border">
<form id="constantsEditForm" action="" class="form-horizontal dr-form-bordered form-inline">
	<div style="display:none;">
		<#if constantsDO.constKey?exists>
			<input type="hidden" id="constKey" name="constKey" value="${constantsDO.constKey}" />
		</#if>
	</div>
	<div class="input-group">
		<div style="padding-left:10px;color:red;">注：标注*为必填项</div>
	</div>
	<hr/>
	
	<div class="form-group">
		<label class="col-md-2 control-label">描述说明</label>
		<div class="col-md-4">
			<input type="text" class="form-control" id="description" name="description" value="${constantsDO.description}" disabled />
		</div>
		<label class="control-label col-md-2">内容</label>
		<div class="col-md-4">
			<textarea class="form-control" rows="10" id="constValue" name="constValue">${constantsDO.constValue}</textarea>
		</div>
	</div>
	
	
	<div>
		<div class="col-sm-12 panel-toolbar text-left dr-slash-text" id="operateBtn">
			<a href="javascript:void(0);" class="btn btn-primary" id="cancelBtn">取消</a>
			<a href="javascript:void(0);" class="btn btn-success" id="upadteBtn">保存</a>
		</div>
	</div>
	
</form>
</div>

</@backend>
