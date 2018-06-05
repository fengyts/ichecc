<#include "/common/common.ftl"/>
<@backend title="选车配置编辑" 
js=[
'/statics/plugin/jqgrid/js/jquery.jqGrid.min.js',
'/statics/plugin/jqgrid/js/i18n/grid.locale-cn.js',
'/statics/backend/choice.js'
] 
css=[
'/statics/plugin/jqgrid/css/ui.jqgrid.css',
'/statics/plugin/jquery/jqueryui/css/cupertino/jquery-ui-1.9.2.custom.min.css'
]
>

<div id="forms" class="mt10">
    <div class="box">
	    <div class="box_border"> 
	    
		   <form class="jqtransform" method="post" id="choiceConfigEditForm">
		   
		     <table class="form_table" border="0" cellpadding="0" cellspacing="0">
		      	 <tr style="display:none;">
          			<td><input type="hidden" name="id" value="${choiceConfigDO.id}" /></td>
          			<td><input type="hidden" id="level" name="level" value="${choiceConfigDO.level}" /></td>
          		 </tr>
          		 <tr>
          		 	<td>所属类别</td>
          		 	<td>
          		 		<select name="parentId" id="parentId" class="select" disabled>
          		 			<option value="0" selected="selected">默认一级</option>
          		 			<#if listFirsts?default([])?size!=0>
          		 				<#list listFirsts as parent>
          		 					<option value="${parent.id}" <#if choiceConfigDO.parentId == parent.id>selected</#if>>${parent.name}</option>
          		 				</#list>
          		 			</#if>
          		 		</select>
          		 	</td>
          		 </tr>
		      	 <tr>
					<td>名称:</td>
					<td><input type="text" name="name" class="input-text lh25" size="20" maxlength="50" value="${choiceConfigDO.name}" /></td>
				 </tr>
				 <tr>
					<td>状态:</td>
					<td>
						有效: <input type="radio" name="status" value="1" <#if choiceConfigDO.status=="true">checked='checked'</#if> />&nbsp;&nbsp;
						无效: <input type="radio" name="status" value="0" <#if choiceConfigDO.status!="true">checked='checked'</#if> /> 
					</td>
				 </tr>
				 <tr>
					<td>备注:</td>
					<td><textarea name="remark" cols="50" rows="5" maxlength=200>${choiceConfigDO.remark}</textarea></td>
				 </tr>
				 
				 
				 <tr>
				    <td>
				       <div id="div1_submit" style="text-align:center;">
						   <input id="choiceConfigUpdateBtn" class="btn btn82 btn_save2" type="button" value="保存" onclick="updateChoiceConfig();">			         
					   </div>
				    </td>
				    <td>
				       <div id="div1_submit" style="text-align:center;">
				           <input id="cancelbtn" class="btn btn82 btn_del closebtn" type="button" value="取消" name="button">
					   </div>
				    </td>
				 </tr>
				  
		     </table>
		       
		   </form>
	      
	    </div>
	</div>
</div>

</@backend>