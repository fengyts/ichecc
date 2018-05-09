<#include "/common/common.ftl"/>
<@backend title="菜单管理" 
js=[
'/statics/plugins/select2/js/select2.js',
'/statics/plugins/select2/js/select2Util.js',
'/statics/plugins/select2/js/select2_locale_zh-CN.js',
'/statics/common/common-js/form.js',
'/statics/backend/sys/sysMenu.js'
] css=[
]>

<form class="jqtransform" method="post" id="sysMenuForm" action="${domain}/sys/sysMenu/list.htm">
	<div id="search_bar" class="mt10">
		<div class="box">
		
			<div class="box_border">
				<div class="box_top"><b class="pl15">后台菜单管理列表页面</b></div>
				
	            <div class="box_center pt10 pb10">
	              <table class="form_table" border="0" cellpadding="0" cellspacing="0">
	              	<tr>
		              	<td>菜单编号：</td>
		              	<td><input class="input-text lh25" type="text" id="menucode" name="id" value="${sysMenuDO.id}"/></td>
		              	<td>菜单名称：</td>
		              	<td><input class="input-text lh25" type="text" id="name" name="name" value="${sysMenuDO.name}"/></td>
		              	<td>是否有效：</td>
		              	<td>
		              		<#assign statusTemp=sysMenuDO.status/>
		              		<select name="status" class="select">
		              			<option value="" <#if statusTemp==null>selected="selected"</#if>>全部</option>
		              			<option value="1" <#if statusTemp??&&statusTemp?string=="true">selected="selected"</#if>>有效</option>
		              			<option value="0" <#if statusTemp??&&statusTemp?string=="false">selected="selected"</#if>>无效</option>
		              		</select>
		              	</td>
	              	</tr>
	              </table>
	            </div>
	            
	            <span id="nameInfo" class="error"></span>
           
	            <div class="box_bottom pb5 pt5 pr10" style="border-top:1px solid #dadada;">
	              <div class="search_bar_btn" style="text-align:center;">
		              <input class="btn btn82 btn_search" id="searthAtt" type="submit" value="查询" />
		              <input class="btn btn82 btn_res " type="button" value="重置"  onclick="dataReset('sysMenuForm')" />
		              <input id="menuAddBtn" class="btn btn82 btn_add " type="button" value="新增" name="button"/>
	              </div>
	            </div>
	            
	        </div>
	        
	        <div class="box_center pt10 pb10">
	            <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list_table" >
	            	<tr>
	            		   <th width="50">菜单编号</th>
		                   <th width="50">菜单名称</th>
		                   <th width="50">菜单类型</th>
		                   <th width="50">排序</th>
		                   <th width="150">菜单url</th>
		                   <th width="100">备注</th>
		                   <th width="80">状态</th>
		                   <th width="100">操作</th>
	            	</tr>
	            	<#if page.list?default([])?size !=0>
	            		<#list page.list as sysMenuDO>
	            		<tr class="tr">
		            		<td>${sysMenuDO.id}</td>
		            		<td>${sysMenuDO.name}</td>
		            		<td>
			            		<#list sysMenuTypes as sysMenuType>
			            			<#if sysMenuType.code==sysMenuDO.menuType>
										${sysMenuType.value}
					            		<#--也可以这样获取枚举值 <td width="50">${sysMenuType.getValue()}</td> -->
			            			</#if>
			            		</#list>
							</td>
							<td>${sysMenuDO.sort}</td>
		            		<td>${sysMenuDO.url}</td>
		            		<td>${sysMenuDO.remark}</td>
		            		<td>${(sysMenuDO.status!true)?string("有效","无效")}</td>
		            		<td>
		            			<#if sysMenuDO.menuType != '0'>
				            		<a href="javascript:void(0)" class="editcatabtn editSysMenu" param="${sysMenuDO.id}">[编辑]</a>&nbsp;
				            		<a href="javascript:void(0)" class="editcatabtn journalReview" param="${sysMenuDO.id}">[日志]</a>
			            		<#else>
			            			不可编辑
			            		</#if>
		            		</td>
	            		</tr>
	            		</#list>
	            	</#if>
	            </table>
	        </div>
	        <div class="box" style="font-size:16px;boder:1px">
    			<#if noRecoders??>${noRecoders}</#if>
    		</div>
	        
		</div>
	</div>
<@pager  pagination=page  formId="sysMenuForm" />

</form>


</@backend>
