<#include "/common/common.ftl"/>

<@backend title="选车订单处理" 
js=[
'/statics/backend/choiceOrder.js'
]
css=[
'/statics/plugins/bootstrap/bootstrap-3.3.7-dist/css/bootstrap.min.css'
]>


<div class="panel-body box_border">
<form id="choiceOrderEditForm" action="" class="form-horizontal dr-form-bordered form-inline">
	<div style="display:none;">
		<#if choiceOrderDO.id?exists>
			<input type="hidden" id="id" name="id" value="${choiceOrderDO.id}" />
		</#if>
	</div>
	<div class="input-group">
		<div style="padding-left:10px;color:red;">注：标注*为必填项</div>
	</div>
	<hr/>
	
	<div>
		<table class="table" style="background-color:#f2f2f2;">
		    <caption>订单需求详情</caption>
		    <thead>
				<tr>
				  <th style="width: 120px;">选项</th>
				  <th>需求</th>
				</tr>
			</thead>
			<tbody>
				<tr>
				  <td>预算</td>
				  <td>${choiceOrderDO.budget}万元</td>
				</tr>
				<tr>
				  <td>品牌</td>
				  <td>${choiceOrderDO.brand}</td>
				</tr>
				<tr>
				  <td>能源类型</td>
				  <td>${choiceOrderDO.energy}</td>
				</tr>
				<tr>
				  <td>车辆类型</td>
				  <td>${choiceOrderDO.type}</td>
				</tr>
				<tr>
				  <td>座位类型</td>
				  <td>${choiceOrderDO.seat}</td>
				</tr>
				<tr>
				  <td>车型结构</td>
				  <td>${choiceOrderDO.structure}</td>
				</tr>
				<tr>
				  <td>变速箱</td>
				  <td>${choiceOrderDO.gearbox}</td>
				</tr>
				<tr>
				  <td>其他需求</td>
				  <td>${choiceOrderDO.otherRequirement}</td>
				</tr>
				<tr>
				  <td>下单时间</td>
				  <td>${choiceOrderDO.createTime?string('yyyy-MM-dd HH:mm:ss')}</td>
				</tr>
			</tbody>
		</table>
	</div>
	
	<div class="form-group">
		<label class="control-label col-md-2">处理结果</label>
		<div class="col-md-4">
			<textarea class="form-control" rows="8" id="result" name="result">${choiceOrderDO.result}</textarea>
		</div>
	</div>
	
	<div>
		<div class="col-sm-12 panel-toolbar text-left dr-slash-text" id="operateBtn">
			<a href="javascript:void(0);" class="btn btn-primary" id="cancelBtn">取消</a>
			<a href="javascript:void(0);" class="btn btn-success" id="saveBtn">保存</a>
		</div>
	</div>
	
</form>
</div>

</@backend>
