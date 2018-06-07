<#include "/common/common.ftl"/>

<@backend title="商品属性列表"
js=[
'/statics/backend/topicItem.js'
]
css=[
]>

<div class="box">
<form class="jqtransform" method="post" id="queryForm" action="${domain}/topicItem/attributeList.htm">
		<#-- 搜索表单模块 -->
		<div id="search_bar" class="box mt10">
			<div class="box_border">
				<div class="box_top">
					<b class="pl15">商品属性列表页面</b>
				</div>
				<div class="box_center pt10 pb10">
					<table class="form_table" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>属性名称</td>
						<td>
				  			<input type="text" id="name" name="name" value="${attributeDO.name}" class="input-text lh25" size="20">
						</td>
					</tr>
					</table>
				</div>
				<div class="box_bottom pb5 pt5 pr10 search_bar_btn" style="border-top:1px solid #dadada;">
				    <a href="javascript:void(0);">
				    	<input class="ml10 btn btn82 btn_search" onclick="$('#queryForm').submit();" type="button" value="查询" name="button" />
				    </a>
				    <input class="btn btn82 btn_add" type ="button" value="确定" id="associateConfirm" />
				</div>
			</div>
		</div>
		
		<#-- 数据显示块 -->
		<div id="table" class="mt10">
			<div class="box span10 oh">
			    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list_table" id="dataList">
			    	<thead>
			    	<tr>
			    		<th style="width:3%"><input type="checkbox" id="checkAll"></th>
			    		<th class="display">ID</th>
			    		<th>属性名称</th>
			    		<th>属性值</th>
			    		<th>排序</th>
			    	</tr>
			    	</thead>
			    	<tbody id="attributeDataList">
			    	<#if page.list?default([])?size!=0>
			    	<#list page.list as obj>
			    		<tr class="tr">
			    			<td><input type="checkbox" class="checkAttribute"></td>
			    			<td class="display">${obj.id}</td>
			    			<td class="td_center">${obj.name}</td>
			    			<td class="td_center">${obj.value}</td>
			    			<td class="td_center">${obj.sort}</td>
			    		</tr>
			    	</#list>
			    	</#if>
					</tbody>
			    </table>
			</div>
			
			<div style="font-size:16px">
				<#if noRecoders??>${noRecoders}</#if>
			</div>
		</div>
		

    <@pager pagination=page formId="queryForm" />
 
</form>
</div>

</@backend>