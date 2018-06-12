<#include "/common/common.ftl"/>

<@backend title="商品属性列表"
js=[
'/statics/backend/attribute.js'
]
css=[
]>

<div class="box">
<form class="jqtransform" method="post" id="queryForm" action="${domain}/itemAttribute/list.htm">
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
						<#--
						<td>属性状态</td>
						<td>
				  			<select class="select" id="status" name="status" style="width:80px;">
				  				<option value=''      <#if  attributeDO.status==null>selected='selected'</#if>>--全部--</option>
		                        <option value="true"  <#if attributeDO.status??&&attributeDO.status?string=='true'>selected='selected'</#if>>有效</option> 
		                        <option value="false" <#if attributeDO.status??&&attributeDO.status?string=='false'>selected='selected'</#if>>无效</option> 
				  			</select>
						</td>
						-->
					</tr>
					</table>
				</div>
				<div class="box_bottom pb5 pt5 pr10 search_bar_btn" style="border-top:1px solid #dadada;">
				    <a href="javascript:void(0);">
				    	<input class="ml10 btn btn82 btn_search" onclick="$('#queryForm').submit();" type="button" value="查询" name="button" />
				    </a>
				    <input class="btn btn82 btn_add" type ="button" value="新增" id="addBtn" />
				</div>
			</div>
		</div>
		
		<#-- 数据显示块 -->
		<div id="table" class="mt10">
			<div class="box span10 oh">
			    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list_table" id="dataList">
			    	<tr>
			    		<th style="width:3%">ID</th>
			    		<th>属性名称</th>
			    		<th>属性值</th>
			    		<th>排序</th>
			    		<th style="width:100px;">操作</th>
			    	</tr>
			    	<#if page.list?default([])?size!=0>
			    	<#list page.list as obj>
			    		<tr class="tr">
			    			<td class="td_center">${obj.id}</td>
			    			<td class="td_center">${obj.name}</td>
			    			<td class="td_center">${obj.value}</td>
			    			<td class="td_center">${obj.sort}</td>
			    			<td class="td_center">
		    					<a href="javascript:void(0);" style="color:blue;" class="editcatabtn editBtn" param="${obj.id}">[编辑]</a>
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
		

    <@pager pagination=page formId="queryForm" />
 
</form>
</div>

</@backend>