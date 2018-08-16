var pageii;

$(function() {

	$("#cancelBtn").on('click', function() {
		parent.window.layer.close(parent.pageii);
	});

	
	$(".editBtn").on('click', function(){
		var key = $(this).attr("param");
		pageii = layer.open({
			type : 2,
			title : '充值配置编辑',
			// shadeClose : true,
			shade : 0.3,
			maxmin : true,
			fix : false,
			scrollbar : false,
			area : [ '600px', '550px' ],
			content : domain + '/constants/edit.htm?constKey=' + key,
		});
	});

	
	$("#upadteBtn").on('click', function() {
		var _constValue = $("#constValue").val();
		if(!_constValue){
			layer.msg("内容不能为空", {time : 1500});
			return;
		}
		var _data = $("#constantsEditForm").serializeArray();
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

