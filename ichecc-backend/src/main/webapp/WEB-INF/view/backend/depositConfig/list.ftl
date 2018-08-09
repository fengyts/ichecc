<#include "/common/common.ftl"/>

<@backend title="充值配置列表"
js=[
'/statics/backend/depositConfig.js'
]
css=[
]>

<div class="box">
<form class="jqtransform" method="post" id="configForm" action="${domain}/depositConfig/list.htm">
		<#-- 搜索表单模块 -->
		<div id="search_bar" class="box mt10">
			<div class="box_border">
				<div class="box_top">
					<b class="pl15">充值配置列表页面</b>
				</div>
				<div class="box_center pt10 pb10">
					<table class="form_table" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>充值配置状态</td>
						<td>
				  			<select class="select" id="status" name="status" style="width:80px;">
				  				<option value=''      <#if  configDO.status==null>selected='selected'</#if>>--全部--</option>
		                        <option value="true"  <#if configDO.status??&&configDO.status?string=='true'>selected='selected'</#if>>有效</option> 
		                        <option value="false" <#if configDO.status??&&configDO.status?string=='false'>selected='selected'</#if>>无效</option> 
				  			</select>
						</td>
					</tr>
					</table>
				</div>
				<div class="box_bottom pb5 pt5 pr10 search_bar_btn" style="border-top:1px solid #dadada;">
				    <a href="javascript:void(0);">
				    	<input class="ml10 btn btn82 btn_search" onclick="$('#configForm').submit();" type="button" value="查询" name="button" />
				    </a>
				    <input class="btn btn82 btn_add" type ="button" value="新增" id="addDepositConfig" />
				</div>
			</div>
		</div>
		
		<#-- 数据显示块 -->
		<div id="table" class="mt10">
			<div class="box span10 oh">
			    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list_table" id="dataList">
			    	<tr>
			    		<th style="width:3%">ID</th>
			    		<th style="width:230px;">金额</th>
			    		<th>折扣</th>
			    		<th>有效期限</th>
			    		<th>期限类型</th>
			    		<th>状态</th>
			    		<th style="width:100px;">操作</th>
			    	</tr>
			    	<#if page.list?default([])?size!=0>
			    	<#list page.list as obj>
			    		<tr class="tr">
			    			<td class="td_center">${obj.id}</td>
			    			<td class="td_center">${obj.amount}</td>
			    			<td class="td_center">${obj.discount}</td>
			    			<td class="td_center">${obj.expiryDate}${(obj.expiryType=='01')?string('天', '月')}</td>
			    			<td class="td_center">${(obj.expiryType=='01')?string('按天', '按月')}</td>
			    			<td class="td_center">
			    				<#if obj.status == 'true'>有效<#else>无效</#if>
							</td>
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
		

    <@pager pagination=page  formId="configForm" />
 
</form>
</div>

</@backend>