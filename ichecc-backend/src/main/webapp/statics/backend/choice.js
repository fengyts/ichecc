var pageii;
$(function(){
	
	// 取消按钮 关闭当前弹窗
	$("#cancelbtn").on('click',function(){
		window.parent.layer.close(parent.pageii);
	});
	
	var colNames = ['ID','父级ID','名称', '级别','状态','备注','操作'];
	var colModel = [
	   	         {name:'id',index:'id', width:20, hidden:true},
	   	         {name:'parentId',index:'parentId', width:20, hidden:true},
		         {name:'name',index:'name', width:200, sortable:false, 
	   	        	 formatter:function(cellValue,options,rowObject){
	   	        		 return rowObject.name + "(" + rowObject.id +")";
	   	        	 }
		         },
		         {name:'level',index:'level', width:80, align:"center", sortable:false, 
		        	 formatter:function(cellValue,options,rowObject){
			        	 if(1 == cellValue){
			        		 return "<font style='color:red;font-weight:bolder'>一级</font>";
			        	 }else{
			        		 return "二级";
			        	 }
			         }
		         },
		         {name:'status',index:'status', width:50, align:"center", sortable:false,
		        	 formatter:function(cellValue,options,rowObject){
			        	 if(cellValue == true){
			        		 return "有效";
			        	  }else{
			        		 return "无效";
			        	  }
		        	 }
		         },
		         {name:'remark',index:'remark', width:80, align:"center", sortable:false},
		         {name:'操作', index:'操作', width:100, align:"center",
		        	 formatter:function(cellValue,options,rowObject){
		        		 var editOption = "<a href='javascript:void(0);' onclick='choiceConfigEdit(" + rowObject.id + ");'><font color='blue'>编辑</font></a> &nbsp";
		        		 return editOption;
		        	 }
		         }
		       ];
	
	var lastSel;
	$("#tree").jqGrid({
		treeGrid: true,  
	    treeGridModel: 'adjacency',
	    ExpandColumn: 'name',  
	    ExpandColClick: true,
	    
//	    datastr:jsonData,
//	    datatype: "jsonstring",
	    
		url:"jsonData",
		datatype: "json",
	    
		loadonce:true,
	    height: "600",
	    autowidth:true,
        colNames:colNames,
        colModel:colModel,
        rowNum:10,
        rowList:[5,10,20,30],
//        pager: '#pager',
        sortname: 'id',
        viewrecords: true,
//        sortorder: "desc",
	    multiselect: false,
	    
	    pager: "false",
	   // multiselect: true,
	    scrollrows:true,//使得选中的行显示到可视区域
	    //   caption: 'none',  
	    jsonReader: {  
	        root: "rows",  
	        repeatitems: false  
	    },
	    treeReader : {  
            level_field: "level",  
            parent_id_field: "parentId",
            leaf_field: "isLeaf",
            expanded_field: "expanded"
        },
        onSelectRow: function(id){
		      if(id && id!==lastSel){
		         $('#tree').restoreRow(lastSel);
		         lastSel=id;
		      } else{
		    	  $("#tree").resetSelection(); 
		    	  lastSel=null;
		      }
		 }
	    
	});
	
	
	//新增类别
	$("#choiceConfigAddBtn").on('click',function(){
		pageii = layer.open({
			type : 2,
			title : '选车配置管理-->新增',
			border: [3, 0.3, '#000'],
			shadeClose : false,
			shade: [0.3, '#000'],
			maxmin : true,
			scrollbar : false,
			move : false,
			area: ['500px', '450px'],
			content : domain + '/choiceConfig/add.htm'
		});
	});
	
	//保存新增
	$("#choiceConfigSaveBtn").on('click',function(){
		addChoiceConfig();
	});
	
	$("#parentId").change(this, function(){
		if(0 == this.value){
			$("#level").val(1);
//			$("#level option[value='1']").attr('selected', true);
//			$("#level option[value='2']").attr('selected', false);
		} else{
//			$("#level option[value='2']").attr('selected', true);
//			$("#level option[value='1']").attr('selected', false);
			$("#level").val(2);
		}
	});
	
	
});

function choiceConfigEdit(id){
	pageii=layer.open({
		type : 2,
		title : '选车配置管理-->编辑',
		border: [3, 0.3, '#000'],
		shadeClose : false,
		shade: [0.3, '#000'],
		maxmin : true,
		scrollbar : false,
		move : false,
		area: ['500px', '450px'],
		content : domain + '/choiceConfig/edit.htm?id=' + id
	});
}

function updateChoiceConfig(){
	$.ajax({
		url : 'update',
		dataType : 'text',
		data : $('#choiceConfigEditForm').serialize(),
		type : "post",
		cache : false,
		error : function(request){
			alert("Server Connection Failure...");
		},
		success : function(res) {
			var data = JSON.parse(res);
			if (1 == data.result) {// 成功
				layer.alert(data.message, 1, function() {
//					location.href = 'list.htm';
					parent.window.location.reload();
	            	parent.layer.close(parent.pageii);
				});
			} else {// 失败
				layer.alert(data.message, 8);
			}
		}
	});
	
}

function addChoiceConfig(){
	$.ajax({
		url : 'save',
		type : "post",
		dataType : 'text',
		data : $('#choiceConfigAddForm').serialize(),
		cache : false,
		error : function(request){
			alert("Server Connection Failure...");
		},
		success : function(res) {
			var data = JSON.parse(res);
			if (1 == data.result) {// 成功
				layer.alert(data.message, 1, function() {
//					location.href = 'list.htm';
					parent.window.location.reload();
	            	parent.layer.close(parent.pageii);
				});
			} else {// 失败
				layer.alert(data.message, 8);
			}
		}
	});
	
}