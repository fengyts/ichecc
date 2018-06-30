<#include "/common/common.ftl"/>

<@backend title="选车订单列表"
js=[
'/statics/backend/choiceOrder.js'
]
css=[
]>

<style>
	.tafixed {
		table-layout: fixed;
	}
	.rqcontent {
		max-width: 300px;
		min-width: 100px;
		width: 300px;
		white-space: nowrap;
		overflow: hidden;
		text-overflow: ellipsis;
		-moz-text-overflow: ellipsis;
	}
	td {
		white-space: nowrap;
		overflow: hidden;
	}
</style>

<div class="box">
<form class="jqtransform" method="post" id="choiceOrderForm" action="${domain}/choiceOrder/list.htm">
		<#-- 搜索表单模块 -->
		<div id="search_bar" class="box mt10">
			<div class="box_border">
				<div class="box_top">
					<b class="pl15">选车订单列表页面</b>
				</div>
				<div class="box_center pt10 pb10">
					<table class="form_table" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>选车订单编号</td>
						<td>
				  			<input type="text" id="orderNo" name="orderNo" value="${orderDO.orderNo}" class="input-text lh25" size="20">
						</td>
						<td>选车订单状态</td>
						<td>
				  			<select class="select" id="status" name="status" style="width:80px;">
				  				<option value=''      <#if  orderDO.status==null>selected='selected'</#if>>--全部--</option>
		                        <option value="01"  <#if orderDO.status??&&orderDO.status=='01'>selected='selected'</#if>>待处理</option> 
		                        <option value="02" <#if orderDO.status??&&orderDO.status=='02'>selected='selected'</#if>>已处理</option> 
				  			</select>
						</td>
					</tr>
					</table>
				</div>
				<div class="box_bottom pb5 pt5 pr10 search_bar_btn" style="border-top:1px solid #dadada;">
				    <a href="javascript:void(0);">
				    	<input class="ml10 btn btn82 btn_search" onclick="$('#choiceOrderForm').submit();" type="button" value="查询" name="button" />
				    </a>
				</div>
			</div>
		</div>
		
		<#-- 数据显示块 -->
		<div id="table" class="mt10">
			<div class="box span10 oh">
			    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list_table tafixed" id="dataList">
			    	<tr>
			    		<th style="width:3%">ID</th>
			    		<th>订单编号</th>
			    		<th>选车需求</th>
			    		<th>提交时间</th>
			    		<th>状态</th>
			    		<th>处理时间</th>
			    		<th>处理结果</th>
			    		<th>操作</th>
			    	</tr>
			    	<#if page.list?default([])?size!=0>
			    	<#list page.list as obj>
			    		<tr class="tr">
			    			<td class="td_center">${obj.id}</td>
			    			<td class="td_center">${obj.orderNo}</td>
			    			<td class="td_center rqcontent" title=${obj.choiceRequirement}>${obj.choiceRequirement}</td>
							<td>${obj.createTime?string('yyyy-MM-dd HH:mm:ss')}</td>
							<td class="td_center">
			    				<#if obj.status == '01'>待处理<#else>已处理</#if>
							</td>
							<td>${(obj.modifyTime?string('yyyy-MM-dd HH:mm:ss'))!}</td>
							<td class="td_center rqcontent" title=${obj.result}>${obj.result}</td>
			    			<td class="td_center">
			    				<#if obj.status == '01'>
		    					<a href="javascript:void(0);" style="color:blue;" class="editcatabtn editBtn" param="${obj.id}">[处理]</a>
			    				<#else>
			    				已处理
			    				</#if>
			    			</td>
			    		</tr>
			    	</#list>
			    	</#if>
			    </table>
			</div>
			
			<div style="font-size:16px">
				<#if noRecoders??>${noRecoders}</#if>
			</div>
		</div>
		

    <@pager pagination=page  formId="choiceOrderForm" />
 
</form>
</div>

</@backend>