var pageii;
$(function() {
	
	$("#addBtn").on('click', function(){
		pageii = layer.open({
			type : 2,
			title : '商品属性添加',
			// shadeClose : true,
			shade : 0.3,
			maxmin : true,
			fix : false,
			scrollbar : false,
			area : [ '500px', '500px' ],
			content : domain + '/itemAttribute/add.htm',
		});
	});
	
	$(".editBtn").on('click', function(){
		var id = $(this).attr("param");
		pageii = layer.open({
			type : 2,
			title : '商品属性编辑',
			// shadeClose : true,
			shade : 0.3,
			maxmin : true,
			fix : false,
			scrollbar : false,
			area : [ '500px', '500px' ],
			content : domain + '/itemAttribute/edit.htm?id=' + id,
		});
	});
	
	$("#saveBtn").on('click', function() {
		var _data = $("#addForm").serializeArray();

		$.ajax({
			url : 'save',
			type : 'POST',
			secureuri : false,
			dataType : "text",
			data : _data,
			success : function(response) {
				var data = JSON.parse(response);
				if (data.result == 1) {
					layer.alert(data.message, {
						icon : 1
					}, function() {
						parent.window.location.reload();
						parent.layer.close(parent.pageii);
					});
				} else {
					layer.alert(data.message, {icon : 0});
				}
			},
			error : function() {
				layer.alert("请求失败", 1);
			}
		});

	});
	
	$("#upadteBtn").on('click', function() {
		var _data = $("#editForm").serializeArray();

		$.ajax({
			url : 'update',
			type : 'POST',
			secureuri : false,
			dataType : "text",
			data : _data,
			success : function(response) {
				var data = JSON.parse(response);
				if (data.result == 1) {
					layer.alert(data.message, {
						icon : 1
					}, function() {
						parent.window.location.reload();
						parent.layer.close(parent.pageii);
					});
				} else {
					layer.alert(data.message, {icon : 0});
				}
			},
			error : function() {
				layer.alert("请求失败", 1);
			}
		});

	});

});