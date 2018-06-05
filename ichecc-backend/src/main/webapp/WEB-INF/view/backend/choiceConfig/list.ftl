<#include "/common/common.ftl"/>
<@backend title="选车配置列表" js=[
'/statics/plugins/jqgrid/js/jquery.jqGrid.min.js',
'/statics/plugins/jqgrid/js/i18n/grid.locale-cn.js',
'/statics/backend/choice.js'
] css=[
'/statics/plugins/jqgrid/css/ui.jqgrid.css',
'/statics/plugins/jquery/jqueryui/css/cupertino/jquery-ui-1.9.2.custom.min.css'
]>

<style>
	/* jqgrid 表格内容换行  */
	.ui-jqgrid tr.jqgrow td {
		  white-space: normal !important;
	   /* height:auto; */
		  vertical-align:text-top;
		  padding-top:2px;
	 }
</style>

<form class="jqtransform" method="post" id="choiceConfigListForm" action="${domain}/choiceConfig/list.htm">
	<div id="search_bar" class="mt10">
		<div class="box">
		
			<div class="box_border">

			<div class="box_bottom pb5 pt5 pr10" style="border-top:1px solid #dadada;">
		        <div class="search_bar_btn" style="text-align:center;">
		              <input class="btn btn82 btn_search" id="searthAtt" type="submit" value="查询" />
		              <input class="btn btn82 btn_res " type="button" value="重置"  onclick="dataReset('choiceConfigListForm')" />
		              <input id="choiceConfigAddBtn" class="btn btn82 btn_add " type="button" value="新增" name="button"/>
		        </div>
            </div>
            
            </div>
        </div>
    </div>
</form>


<table id="tree"></table>
<div id="pager"></div>


</@backend>