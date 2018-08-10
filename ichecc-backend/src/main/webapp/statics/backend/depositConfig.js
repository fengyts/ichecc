var pageii;

$(function() {

	$("#cancelBtn").on('click', function() {
		parent.window.layer.close(parent.pageii);
	});

	$("#addDepositConfig").on('click', function() {
		pageii = layer.open({
			type : 2,
			title : '充值配置添加',
			// shadeClose : true,
			shade : 0.3,
			maxmin : true,
			fix : false,
			scrollbar : false,
			area : [ '600px', '550px' ],
			content : domain + '/depositConfig/add.htm',
		});
	});
	
	$(".editBtn").on('click', function(){
		var id = $(this).attr("param");
		pageii = layer.open({
			type : 2,
			title : '充值配置编辑',
			// shadeClose : true,
			shade : 0.3,
			maxmin : true,
			fix : false,
			scrollbar : false,
			area : [ '600px', '550px' ],
			content : domain + '/depositConfig/edit.htm?id=' + id,
		});
	});

	$("#saveBtn").on('click', function() {
		if(!validate()){
			return;
		}
		var _data = $("#depositConfigAddForm").serializeArray();
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
		if(!validate()){
			return;
		}
		var _data = $("#deppositConfigEditForm").serializeArray();
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

function validate(){
	var _amt = $("#amount").val(), 
		_discount = $("#discount").val(),
		_expiryDate = $("#expiryDate").val();
	if(!_amt || !_discount || !_expiryDate){
		layer.msg("金额|折扣|有效期 都不能为空", {time: 1500});
		return false;
	}
	if(_amt < 0.01){
		layer.msg("金额必须大于0.01元", {time: 1500});
		return false;
	}
	if(_discount <= 0 || _discount > 1){
		layer.msg("折扣必须大于0且小于等于1", {time: 1500});
		return false;
	}
	var _regex = /^[1-9]\d*$/;
	if(_expiryDate < 1 || !_regex.test(_expiryDate)){
		layer.msg("有效期必须为正整数", {time: 1500});
		return false;
	}
	return true;
}