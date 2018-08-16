<#include "/common/common.ftl"/>

<@backend title=""
js=[
'/statics/backend/constants.js'
]
css=[
]>

<div class="box">
<form class="jqtransform" method="post" id="configForm" action="${domain}/constants/list.htm">
		<#-- 搜索表单模块 -->
		<div id="search_bar" class="box mt10">
			<div class="box_border">
				<div class="box_top">
					<b class="pl15">文案配置列表页面</b>
				</div>
				<div class="box_center pt10 pb10">
					<table class="form_table" border="0" cellpadding="0" cellspacing="0">
					<tr>
					</tr>
					</table>
				</div>
				<div class="box_bottom pb5 pt5 pr10 search_bar_btn" style="border-top:1px solid #dadada;">
				</div>
			</div>
		</div>
		
		<#-- 数据显示块 -->
		<div id="table" class="mt10">
			<div class="box span10 oh">
			    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list_table" id="dataList">
			    	<tr>
			    		<th style="width:230px;">内容</th>
			    		<th style="width:10%;">描述说明</th>
			    		<th style="width:10%;">操作</th>
			    	</tr>
			    	<#if page.list?default([])?size!=0>
			    	<#list page.list as obj>
			    		<tr class="tr">
			    			<td class="td_center">${obj.constValue}</td>
			    			<td class="td_center">${obj.description}</td>
			    			<td class="td_center">
		    					<a href="javascript:void(0);" style="color:blue;" class="editcatabtn editBtn" param="${obj.constKey}">[编辑]</a>
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