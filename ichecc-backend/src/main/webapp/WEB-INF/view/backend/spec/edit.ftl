<#include "/common/common.ftl"/>

<@backend title="规格编辑" 
js=[
'/statics/backend/spec.js'
]
css=[
'/statics/plugins/bootstrap/bootstrap-3.3.7-dist/css/bootstrap.min.css'
]>


<div class="panel-body box_border">
<form id="specEditForm" action="" class="form-horizontal dr-form-bordered form-inline">
	<div style="display:none;">
		<#if specDO.id?exists>
			<input type="hidden" id="id" name="id" value="${specDO.id}" />
		</#if>
	</div>
	<div class="input-group">
		<div style="padding-left:10px;color:red;">注：标注*为必填项</div>
	</div>
	<hr/>
	
	<div class="form-group">
		<label class="col-md-2 control-label">规格名称<span class="dr-asterisk requiredField">*</span></label>
		<div class="col-md-4">
			<input type="text" class="form-control" id="specValue" name="specValue" value="${specDO.specValue}"/>
		</div>
		<label class="col-md-2 control-label">排序</label>
		<div class="col-md-4">
			<input type="text" class="form-control" id="sort" name="sort" value="${specDO.sort!0}" />
		</div>
	</div>
	
	<div class="form-group">
		<label class="col-md-2 control-label">规格状态<span class="dr-asterisk requiredField">*</span></label>
		<div class="col-md-4">
			<label class="radio-inline">
			  <input type="radio" name="status" id="status" value="1" <#if specDO.status=='true'>checked</#if>> 有效
			</label>
			<label class="radio-inline">
			  <input type="radio" name="status" id="status" value="0" <#if specDO.status!='true'>checked</#if>> 无效
			</label>
		</div>
	</div>
	
	<div class="form-group">
		<label class="control-label col-md-2">备注</label>
		<div class="col-md-4">
			<textarea class="form-control" rows="2" id="remark" name="remark">${specDO.remark}</textarea>
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
