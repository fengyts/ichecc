<#include "/common/common.ftl"/>
<@backend title="选车配置新增" 
js=[
'/statics/plugins/jqgrid/js/jquery.jqGrid.min.js',
'/statics/plugins/jqgrid/js/i18n/grid.locale-cn.js',
'/statics/backend/choice.js'
] 
css=[]
>

<div id="forms" class="mt10">
    <div class="box">
	    <div class="box_border">
	    
		   <form class="jqtransform" method="post" id="choiceConfigAddForm">
		   
		     <table class="form_table" border="0" cellpadding="0" cellspacing="0">
		     	<tr style="display:none;">
          			<td><input type="hidden" id="level" name="level" value="1" /></td>
          		 </tr>
		      	 <tr>
					<td>所属类别:</td>
					<td>
						<select name="parentId" id="parentId" class="select">
          		 			<option value="0" selected="selected">默认一级</option>
          		 			<#if listFirsts?default([])?size!=0>
          		 				<#list listFirsts as parent>
          		 					<option value="${parent.id}">${parent.name}</option>
          		 				</#list>
          		 			</#if>
          		 		</select>
					</td>
				 </tr>
				 <#--
				 <tr style="display:none;">
				 	<td>级别：</td>
				 	<td>
				 		<select name="level" id="level" class="select">
				 			<option value="1" selected="selected">一级</option>
				 			<option value='2'>二级</option>
				 		</select>
				 	</td>
				 </tr>
				 -->
				 <tr>
					<td valign="middle">名称:</td>
					<td><input type="text" name="name" class="input-text lh25" size="20" maxlength="50" /></td>
				 </tr>
				 <tr>
					<td>状态:</td>
					<td valign="middle" align="left">
						<input id="at1" type="radio" name="status" checked='checked' value="1" />
						<label for="at1" >有效</label>
						<input id="at2" type="radio" name="status" value="0" />
						<label for="at2" >无效</label>
					</td>
				 </tr>
				 <tr>
					<td valign="middle">备注:</td>
					<td><textarea name="remark" cols="50" rows="5" maxlength=200></textarea></td>
				 </tr>
				 
				 
				 <tr>
				    <td>
				       <div id="div1_submit" style="text-align:center;">
						   <input id="choiceConfigSaveBtn" class="btn btn82 btn_save2" type="button" value="保存">			         
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