var pageii;
$(function() {
	
	$(".editBtn").on('click', function(){
		let orderId = $(this).attr('param');
		pageii = layer.open({
			type : 2,
			title : '处理选车订单',
			// shadeClose : true,
			shade : 0.3,
			maxmin : true,
			fix : false,
			scrollbar : false,
			area : [ '600px', '550px' ],
			content : domain + '/choiceOrder/edit.htm?orderId=' + orderId,
		});
	});
	
	$("#cancelBtn").on('click', function(){
		window.parent.layer.close(parent.pageii);
	});
	
	$("#saveBtn").on('click', function(){
		var result = $("#result").val();
		if(null == result || '' == result){
			var _that = this;
			layer.tips("处理结果不能为空", _that, {tpis: 2, time: 1500});
			return;
		}
		var _data = {};
		_data.orderId = $("#id").val();
		_data.result = result;
		
		$.ajax({
			url:'handleOrder',
			type: 'POST',
			secureuri: false,
			dataType: 'text',
			data: _data,
			success: function(res) {
				var data = JSON.parse(res);
				if (1 == data.result) {// 成功
					layer.alert(data.message, {icon: 1}, function() {
						parent.window.location.reload();
						parent.layer.close(parent.pageii);
					});
				} else {// 失败
					layer.alert(data.message, {icon: 0});
				}
			}
		});
		
	});
	
});