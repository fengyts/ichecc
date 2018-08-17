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
	
	$("#specialPrice").on('input porpertychange', function(){
		var _g = $("#guidePrice").val();
		if(!_g){
			$(this).val("");
			layer.tips("指导价不能为空", "#guidePrice", {tips : [2, '#666666']});
			return;
		}
		var _te = this.value;
		var _bamt = _g - _te;
		$("#bargainAmount").val(_bamt);
	});
	
	
	$("#saveTopicItemBtn").on('click', function() {
		var _gprice = $("#guidePrice").val(), _sprice = $("#specialPrice").val(), _bprice = $("#bargainAmount").val();
		if(!gprice || !_sprice || !_bprice){
			layer.msg("指导价|特卖价|允许砍价不能为空", {time: 1500});
			return;
		}
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
		
		window.parent.$("#specialPrice").prop("disabled", false);
		window.parent.$("#bargainAmount").prop("disabled", false);
		
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
			layer.tips("必须选中至少一个属性", "#associateConfirm", {tips:2, time: 1500});
			return;
		}
		
		var _parentChecked = window.parent.$(".attributes");
		var _pArray = [];
		$.each(_parentChecked, function(i,v){
			_pArray.push($(v).val());
		});
		var _trs = "", _isRepeat = false;
		var _tds, _id, _name, _val;
		$.each(_checkedList, function(i, v){
			_tds = $(v).parent().nextAll();
			_id = _tds.eq(0).text();
			var _inArray = $.inArray(_id, _pArray);
			if(-1 != _inArray){
				_isRepeat = true;
				return;
			}
			_name = _tds.eq(1).text();
			_val = _tds.eq(2).text();
			_trs += "<tr>" +
					"<td class='display'><input type='hidden' name='attributes' value='" + _id + "' class='attributes'/></td>" +
					"<td class='td_center'>" + _name + "</td>" +
					"<td class='td_center'>" + _val + "</td>" +
					"<td class='td_center'><button type='button' class='btn btn-primary deleteAttribute'>删除</button></td>" +
					"</tr>";
		});
		
		if(_isRepeat){
			layer.tips("属性已存在，请不要重复关联", "#associateConfirm", {tips:2, time: 1500});
			return;
		}
		
		window.parent.$("#attributeCheckedList").append(_trs);
		var _index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
		parent.layer.close(_index); //再执行关闭   
		
	});
	
	
	$("#attributeCheckedList").on('click', '.deleteAttribute', function(){
		$(this).parent().parent().remove();
	});
	
	
});

