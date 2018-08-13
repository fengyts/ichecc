<#include "/common/common.ftl"/>

<@backend title="" 
js=[
'/statics/backend/depositConfig.js'
]
css=[
'/statics/plugins/bootstrap/bootstrap-3.3.7-dist/css/bootstrap.min.css'
]>


<div class="panel-body box_border">
<form id="deppositConfigEditForm" action="" class="form-horizontal dr-form-bordered form-inline">
	<div style="display:none;">
		<#if depositConfigDO.id?exists>
			<input type="hidden" id="id" name="id" value="${depositConfigDO.id}" />
		</#if>
	</div>
	<div class="input-group">
		<div style="padding-left:10px;color:red;">注：标注*为必填项</div>
	</div>
	<hr/>
	
	<div class="form-group">
		<label class="col-md-2 control-label">金额<span class="dr-asterisk requiredField">*</span></label>
		<div class="col-md-4">
			<input type="text" class="form-control" id="originalAmount" name="originalAmount" value="${depositConfigDO.originalAmount}"/>
		</div>
		<label class="col-md-2 control-label">折扣<font color="#ff0000">(0<折扣值<=1;默认值：1,即无折扣)</font><span class="dr-asterisk requiredField">*</span></label>
		<div class="col-md-4">
			<input type="text" class="form-control" id="discount" name="discount" value="${depositConfigDO.discount!1}" />
		</div>
	</div>
	
	<div class="form-group">
		<label class="col-md-2 control-label">有效期限(天/月,含充值当天)<span class="dr-asterisk requiredField">*</span></label>
		<div class="col-md-4">
			<input type="text" class="form-control" id="expiryDate" name="expiryDate" value="${depositConfigDO.expiryDate!1}" />
		</div>
		<label class="col-md-2 control-label">期限类型(非自然天/月)<span class="dr-asterisk requiredField">*</span></label>
		<div class="col-md-4">
			<label class="radio-inline">
			  <input type="radio" name="expiryType" value="01" <#if '01'==depositConfigDO.expiryType>checked</#if>> 按天
			</label>
			<label class="radio-inline">
			  <input type="radio" name="expiryType" value="02" <#if '02'==depositConfigDO.expiryType>checked</#if>> 按月
			</label>
		</div>
	</div>
	
	<div class="form-group">
		<label class="col-md-2 control-label">营销描述</label>
		<div class="col-md-4">
			<input type="text" class="form-control" id="attractDesc" name="attractDesc" value="${depositConfigDO.attractDesc}" />
		</div>
		<label class="col-md-2 control-label">状态<font color="#ff0000">(状态可用于删除配置)</font><span class="dr-asterisk requiredField">*</span></label>
		<div class="col-md-4">
			<label class="radio-inline">
			  <input type="radio" name="status" value="1" <#if true==depositConfigDO.status>checked</#if>> 有效
			</label>
			<label class="radio-inline">
			  <input type="radio" name="status" value="0" <#if true!=depositConfigDO.status>checked</#if>> 无效
			</label>
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
