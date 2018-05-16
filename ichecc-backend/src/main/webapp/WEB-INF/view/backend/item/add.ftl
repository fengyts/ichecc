<#include "/common/common.ftl" />

<@backend title="商品新增spu" 
js=[
'/statics/common/common-js/jquery-1.9.1.min.js',
'/statics/plugins/editor/kindeditor-all-min.js',
'/statics/common/common-js/editorUtil.js',
'/statics/plugins/baidu_webuploader/webuploader.min.js',
'/statics/common/imgupload/upload.js',
'/statics/common/common-js/ajaxfileupload.js',
'/statics/backend/item.js'
]
css=[
'/statics/plugins/bootstrap/bootstrap-3.3.7-dist/css/bootstrap.min.css',
'/statics/plugins/editor/themes/custom/style.css',
'/statics/plugins/baidu_webuploader/webuploader.css',
'/statics/plugins/baidu_webuploader/image-upload/style.css'
]>


<div class="panel-body box_border">
<input type="hidden" id="listIframeName" value="${listIframeName}">
<form id="itemInfoAddForm" action="" class="form-horizontal dr-form-bordered">
	<div style="display:none;">
		<#if itemDO.id?exists>
			<input type="hidden" id="id" name="id" value="${itemDO.id}" />
		</#if>
	</div>
	<div class="input-group">
		<div style="padding-left:10px;color:red;">注：标注*为必填项</div>
	</div>
	<hr/>
	
	<div class="form-group">
		<label class="col-md-2 control-label">商品名称<span class="dr-asterisk requiredField">*</span></label>
		<div class="col-md-4">
			<input type="text" class="form-control" id="itemTitle" name="itemTitle" value="${itemDO.itemTitle}"/>
		</div>
		<label class="col-md-2 control-label">副标题</label>
		<div class="col-md-4">
			<input type="text" class="form-control" id="subTitle" name="subTitle" value="${itemDO.subTitle}"/>
		</div>
	</div>
	
	<div class="form-group">
		<label class="col-md-2 control-label">市场价<span class="dr-asterisk requiredField">*</span></label>
		<div class="col-md-4">
			<input type="text" class="form-control" id="marketPrice" name="marketPrice" value="${itemDO.marketPrice!0.00}"/>
		</div>
		<label class="col-md-2 control-label">指导价<span class="dr-asterisk requiredField">*</span></label>
		<div class="col-md-4">
			<input type="text" class="form-control" id="guidePrice" name="guidePrice" value="${itemDO.guidePrice!0.00}"/>
		</div>
	</div>
	<div class="form-group">
		<label class="col-md-2 control-label">商品状态<span class="dr-asterisk requiredField">*</span></label>
		<div class="col-md-4">
			<select class="form-control" id="status" name="status">
				<#list itemStatus as itemStatus>
					<option value="${itemStatus.code}">${itemStatus.desc}</option>
				</#list>
			</select>
		</div>
	</div>
	
	<div class="form-group">
		<label class="control-label col-md-2">备注</label>
		<div class="col-md-4">
			<textarea class="form-control" rows="2" id="remark" name="remark"></textarea>
		</div>
	</div>
	
	<#-- 商品上传图片 -->
	<div class="form-group">
		<#include "/backend/item/upload_picture.ftl"/>
		<div class="col-md-12">
		</div>
	</div>
	
	<div class="box_top" style="margin-bottom:5px;">
		<b class="pl15">商品描述信息</b>
	</div>
	<div class="form-group">
		<div class="col-md-12">
			<#include "/common/description.ftl"/>
		</div>
	</div>
	
	<hr/>
	<div>
		<div class="col-sm-12 panel-toolbar text-left dr-slash-text" id="operateBtn">
			<a href="javascript:void(0);" class="btn btn-primary" id="cancelAddTabBtn">取消</a>
			<a href="javascript:void(0);" class="btn btn-success" id="saveBtn">保存</a>
		</div>
	</div>
	
</form>
</div>

</@backend>
