<#include "/common/common.ftl"/>

<@backend title="规格列表"
js=[
'/statics/backend/spec.js'
]
css=[
]>

<div class="box">
<form class="jqtransform" method="post" id="specForm" action="${domain}/spec/list.htm">
		<#-- 搜索表单模块 -->
		<div id="search_bar" class="box mt10">
			<div class="box_border">
				<div class="box_top">
					<b class="pl15">规格列表页面</b>
				</div>
				<div class="box_center pt10 pb10">
					<table class="form_table" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>规格名称</td>
						<td>
				  			<input type="text" id="specValue" name="specValue" value="${specDO.specValue}" class="input-text lh25" size="20">
						</td>
						<td>规格状态</td>
						<td>
				  			<select class="select" id="status" name="status" style="width:80px;">
				  				<option value=''      <#if  specDO.status==null>selected='selected'</#if>>--全部--</option>
		                        <option value="true"  <#if specDO.status??&&specDO.status?string=='true'>selected='selected'</#if>>有效</option> 
		                        <option value="false" <#if specDO.status??&&specDO.status?string=='false'>selected='selected'</#if>>无效</option> 
				  			</select>
						</td>
					</tr>
					</table>
				</div>
				<div class="box_bottom pb5 pt5 pr10 search_bar_btn" style="border-top:1px solid #dadada;">
				    <a href="javascript:void(0);">
				    	<input class="ml10 btn btn82 btn_search" onclick="$('#specForm').submit();" type="button" value="查询" name="button" />
				    </a>
				    <input class="btn btn82 btn_add" type ="button" value="新增" id="addSpec" />
				</div>
			</div>
		</div>
		
		<#-- 数据显示块 -->
		<div id="table" class="mt10">
			<div class="box span10 oh">
			    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list_table" id="dataList">
			    	<tr>
			    		<th style="width:3%">ID</th>
			    		<th style="width:230px;">规格名称</th>
			    		<th>排序</th>
			    		<th>状态</th>
			    		<th>备注</th>
			    		<th style="width:100px;">操作</th>
			    	</tr>
			    	<#if page.list?default([])?size!=0>
			    	<#list page.list as obj>
			    		<tr class="tr">
			    			<td class="td_center">${obj.id}</td>
			    			<td class="td_center">${obj.specValue}</td>
			    			<td class="td_center">${obj.sort}</td>
			    			<td class="td_center">
			    				<#if obj.status == 'true'>有效<#else>无效</#if>
							</td>
			    			<td class="td_center">${obj.remark}</td>
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
		

    <@pager pagination=page  formId="specForm" />
 
</form>
</div>

</@backend>