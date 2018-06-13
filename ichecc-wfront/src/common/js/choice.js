$("#pinpai").select({
  title: "品牌类型",
  items: ["国产品牌", "合资品牌", "进口品牌"]
});
$("#nengyuan").select({
  title: "能源类型",
  items: ["纯电动", "油电混合", "汽油", "柴油"]
});
$("#jibie").select({
  title: "车辆类型",
  items: ["轿车", "SUV", "MPV"]
});
$("#zuowei").select({
  title: "座位数量",
  items: ["5座", "7座"]
});
$("#jiegou").select({
  title: "车型结构",
  items: ["三厢", "两厢","掀背"]
});
$("#biansuxiang").select({
  title: "变速箱类型",
  items: ["自动", "手动"]
});

$(document).on("click", "#submit", function() {
  $.modal({
    title: "重要提示",
    text: "很抱歉，本服务为VIP会员专享！",
    buttons: [
      { text: "算了", onClick: function(){ $.closeModal();} },
      { text: "加入VIP", onClick: function(){ window.location.href="../mine/vip/vipadd.html"} },
    ]
  });
});