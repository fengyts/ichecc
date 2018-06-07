var pageii;
$(function() {
	
	$("#addTopicItem").on('click', function(){
		var _topicId = $("#topicId").val();
		pageii = layer.open({
			type : 2,
			title : '专题商品添加',
			// shadeClose : true,
			shade : 0.3,
			maxmin : true,
			fix : false,
			scrollbar : false,
			area : [ '1000px', '600px' ],
			content : domain + '/topicItem/add.htm?topicId=' + _topicId,
		});
	});
	
	$(".editTopicItemBtn").on('click', function(){
		var _disable = $(this).attr("disabled");
		if(_disable){
			return;
		}
		var _id = $(this).attr("param");
		pageii = layer.open({
			type : 2,
			title : '专题商品编辑',
			// shadeClose : true,
			shade : 0.3,
			maxmin : true,
			fix : false,
			scrollbar : false,
			area : [ '1000px', '600px' ],
			content : domain + '/topicItem/edit.htm?id=' + _id,
		});
	});
	
	// 关联商品列表
	$("#selectItem").on('click', function() {
		pageii == layer.open({
			type : 2,
			title : '商品列表',
			// shadeClose : true,
			shade : 0.3,
			maxmin : true,
			fix : false,
			scrollbar : false,
			area : [ '800px', '450px' ],
			content : domain + '/topicItem/itemList.htm',
		});
	});
	
	
	$("#saveTopicItemBtn").on('click', function() {
		var _data = $("#topicItemAddForm").serializeArray();
		$.ajax({
			url: 'save',
			type: 'POST',
			secureuri: false,
			dataType: "text",
			data: _data,
			success: function(response) {
				var data = JSON.parse(response);
				if (data.result == 1) {
					layer.alert(data.message, {icon:1}, function(){
						parent.window.location.reload();
						parent.layer.close(parent.pageii);
					});
				} else {
					layer.alert(data.message, {icon:0});
				}
			},
			error: function() {
				layer.alert("请求失败", 1);
			}
		});
	});
	
	
	$("#updateTopicItemBtn").on('click', function() {
		var _data = $("#topicItemEditForm").serializeArray();
		$.ajax({
			url: 'update',
			type: 'POST',
			secureuri: false,
			dataType: "text",
			data: _data,
			success: function(response) {
				var data = JSON.parse(response);
				if (data.result == 1) {
					layer.alert(data.message, {icon:1}, function(){
						parent.window.location.reload();
						parent.layer.close(parent.pageii);
					});
				} else {
					layer.alert(data.message, {icon:0});
				}
			},
			error: function() {
				layer.alert("请求失败", 1);
			}
		});
	});
	
	
	
	
	/**
	 * 
	 * itemList js
	 * 
	 */
//	$("#selectAll").on('click', function(){
//		if($(this).is(":checked")){
//			$("#itemListData :checkbox").prop("checked", true);
//		} else {
//			$("#itemListData :checkbox").prop("checked", false);
//		}
//	});
//	$("input[name='checkItem']").on('click', function(){
//		if( $("#itemListData :checkbox:checked").length == $("#itemListData :checkbox").length ){
//			$("#selectAll").prop("checked", true);
//		} else {
//			$("#selectAll").prop("checked", false);
//		}
//	});
	
	/**
	 * 关联商品确认
	 */
	$("#checkItemConfirmBtn").on('click', function(){
		var _checkBox = $("#itemListData :radio:checked");
		if( _checkBox.length < 1 ){
			layer.alert("必须选择一个商品",{icon : 0});
			return;
		}
		var _tds = _checkBox.parent().nextAll();
		var _itemId = _checkBox.val();
		var _itemTitle = $(_tds[0]).text(), _marketPrice = $(_tds[1]).text(), _guidePrice = $(_tds[2]).text();
		window.parent.$("#itemId").val(_itemId);
		window.parent.$("#itemTitle").val(_itemTitle);
		window.parent.$("#marketPrice").val(_marketPrice);
		window.parent.$("#guidePrice").val(_guidePrice);
		
		var _index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
		parent.layer.close(_index); //再执行关闭   
	});
	
	// 关联商品属性列表
	$("#associateAttribute").on('click', function(){
		pageii == layer.open({
			type : 2,
			title : '商品属性列表',
			// shadeClose : true,
			shade : 0.3,
			maxmin : true,
			fix : false,
			scrollbar : false,
			area : [ '800px', '450px' ],
			content : domain + '/topicItem/attributeList.htm',
		});
	});
	
	// 全选/取消全选
	$("#checkAll").on('click', function(){
		if($(this).is(':checked')){
			$("#attributeDataList :checkbox").each(function(){
				this.checked = true;
			});
		}else {
			$("#attributeDataList :checkbox").each(function(){
				this.checked = false;
			});
		}
	});
	$(".checkAttribute").on('click', function(){
		if(this.checked){
			var allCheckedFlag = true;
			$("#attributeDataList input[type='checkbox']").each(function(){
				if(!this.checked){
					allCheckedFlag = false;
					return;
				}
			});
			if(allCheckedFlag){
				$("#checkAll").prop('checked', allCheckedFlag);
			}
		} else {
			$("#checkAll").prop('checked', false);
		}
	});
	
	$("#associateConfirm").on('click', function(){
		var _checkedList = $("#attributeDataList :checkbox:checked");
		if(_checkedList.length < 1){
			layer.tips("必须选中至少一个属性", "#associateConfirm", {tips:2, time: 1000});
			return;
		}
		
		var _parentChecked = window.parent.$("#attributeCheckedList tr");
		var _pArray = [];
		$.each(_parentChecked, function(i,v){
			_pArray.push($(v).children().eq(0).text());
		});
		
		var _trs = "";
		var _tds, _id, _name, _val;
		$.each(_checkedList, function(i, v){
			_tds = $(v).parent().nextAll();
			_id = _tds.eq(0).text();
			_name = _tds.eq(1).text();
			_val = _tds.eq(2).text();
			_trs = "<tr>" +
					"<td class='display'>" + _id + "</td>" +
					"<td>" + _name + "</td>" +
					"<td>" + _val + "</td>" +
					"<td><button type='button' class='btn btn-primary'>删除</button></td>" +
					"</tr>";
		});
		
		window.parent.$("#attributeCheckedList").append(_trs);
		var _index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
		parent.layer.close(_index); //再执行关闭   
		
	});
	
	
});