<#include "/common/common.ftl" />

<@backend title="专题商品新增" 
js=[
'/statics/plugins/My97DatePicker/WdatePicker.js',
'/statics/backend/topicItem.js'
]
css=[
'/statics/plugins/bootstrap/bootstrap-3.3.7-dist/css/bootstrap.min.css'
]>


<div class="panel-body box_border">
<input type="hidden" id="listIframeName" value="${listIframeName}">
<form id="topicItemAddForm" action="" class="form-horizontal dr-form-bordered" method="post" enctype="multipart/form-data">
	<div style="display:none;">
		<input type="hidden" id="topicId" name="topicId" value="${topicId}" />
	</div>
	<div class="form-group">
		<div class="col-md-4" style="padding-left:50px;color:red;">注：标注*为必填项</div>
	</div>
	
	<div class="box_top" style="margin-bottom:20px;">
		<b class="pl15">专题商品信息</b>
	</div>
	
	<div class="form-group">
		<label class="col-md-2 control-label">商品名称<span class="dr-asterisk requiredField">*</span></label>
		<div class="col-md-4">
			<div class="input-group">
				<input type="text" class="form-control" readonly="readonly" id="itemTitle" name="itemTitle" placeholder="请选择商品" value="${topicItemDO.itemTitle}">
				<input type="hidden" id="itemId" name="itemId" value="${topicItemDO.itemId}"/>
				<span class="btn btn-default btn-sm input-group-addon" id="selectItem">
					<span class="glyphicon glyphicon-plus"></span>
					选择商品
				</span>
			</div>
		</div>
		<label class="col-md-2 control-label">市场价</label>
		<div class="col-md-4">
			<input type="text" class="form-control" readonly id="marketPrice" name="marketPrice" value="${topicItemDO.marketPrice}" />
		</div>
	</div>
	<div class="form-group">
		<label class="col-md-2 control-label">指导价<span class="dr-asterisk requiredField">*</span></label>
		<div class="col-md-4">
			<input type="text" class="form-control" id="guidePrice" name="guidePrice" value="${topicItemDO.guidePrice}" />
		</div>
	</div>
	
	<hr/>
	<div class="form-group">
		<label class="col-md-2 control-label">特卖价<span class="dr-asterisk requiredField">*</span></label>
		<div class="col-md-4">
			<input type="text" class="form-control" id="specialPrice" name="specialPrice" value="${topicItemDO.specialPrice}" />
		</div>
		<label class="col-md-2 control-label">砍价最大次数(次)<span class="dr-asterisk requiredField">*</span></label>
		<div class="col-md-4">
			<input type="text" class="form-control" id="bargainMaxTimes" name="bargainMaxTimes" value="${topicItemDO.bargainMaxTimes!100}" />
		</div>
	</div>
	<div class="form-group">
		<label class="col-md-2 control-label">商品排序值</label>
		<div class="col-md-4">
			<input type="text" class="form-control" id="sort" name="sort" value="${topicItemDO.sort!0}" />
		</div>
		<label class="col-md-2 control-label">商品状态</label>
		<div class="radio col-md-4">
			<label>
				<input type="radio" name="status" id="status" value="1" checked>有效
			</label>
			<label>
				<input type="radio" name="status" id="status" value="0">无效
			</label>
		</div>
	</div>
	
	
	<hr/>
	<div>
		<div class="col-sm-12 panel-toolbar text-left dr-slash-text" id="operateBtn">
			<div class="col-md-4"></div>
			<div>
				<a href="javascript:void(0);" class="btn btn-info" id="btnCancel" onclick='cancelButton();'>取消</a>
				<a href="javascript:void(0);" class="btn btn-primary" id="saveTopicItemBtn">保存</a>
			</div>
		</div>
	</div>
	
</form>
</div>

</@backend>
