<#include "/common/common.ftl"/>

<@backend title="商品属性编辑" 
js=[
'/statics/backend/attribute.js'
]
css=[
'/statics/plugins/bootstrap/bootstrap-3.3.7-dist/css/bootstrap.min.css'
]>


<div class="panel-body box_border">
<form id="editForm" action="" class="form-horizontal dr-form-bordered form-inline">
	<div style="display:none;">
		<#if attributeDO.id?exists>
			<input type="hidden" id="id" name="id" value="${attributeDO.id}" />
		</#if>
	</div>
	<div class="input-group">
		<div style="padding-left:10px;color:red;">注：标注*为必填项</div>
	</div>
	<hr/>
	
	<div class="form-group">
		<label class="col-md-2 control-label">属性名称<span class="dr-asterisk requiredField">*</span></label>
		<div class="col-md-4">
			<input type="text" class="form-control" id="name" name="name" value="${attributeDO.name}"/>
		</div>
		<label class="col-md-2 control-label">属性值<span class="dr-asterisk requiredField">*</span></label>
		<div class="col-md-4">
			<input type="text" class="form-control" id="value" name="value" value="${attributeDO.value}"/>
		</div>
	</div>
	
	<div class="form-group">
		<label class="col-md-2 control-label">排序</label>
		<div class="col-md-4">
			<input type="text" class="form-control" id="sort" name="sort" value="${attributeDO.sort!0}" />
		</div>
	</div>
	
	<#--
	<div class="form-group">
		<label class="control-label col-md-2">备注</label>
		<div class="col-md-4">
			<textarea class="form-control" rows="2" id="remark" name="remark">${attributeDO.remark}</textarea>
		</div>
	</div>
	-->
	
	<div>
		<div class="col-sm-12 panel-toolbar text-left dr-slash-text" id="operateBtn">
			<a href="javascript:void(0);" class="btn btn-primary" id="cancelBtn" onclick="cancelButton()">取消</a>
			<a href="javascript:void(0);" class="btn btn-success" id="upadteBtn">保存</a>
		</div>
	</div>
	
</form>
</div>

</@backend>
