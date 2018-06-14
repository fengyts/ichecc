<!-- 选车页 -->
<template>
  <!--帮你选车-->
  <div id="tab2" class="weui-tab__bd-item" style="display:inline">

    <!--大标题-->
    <div class="choice_top">
      <p class="title1">请提交你的购车需求</p>
      <p class="title2">（将在24小时内处理完毕）</p>
    </div>
    <!--表单-->
    <div class="form">
      <div class="weui-cells__title">购车预算</div>
      <div class="weui-cells">
        <div class="weui-cell">
          <div class="weui-cell__bd">
            <input class="weui-input" type="text" placeholder="请输入预算金额（万元）" value="100" id="yusuan">
          </div>
        </div>
      </div>
      <div class="weui-cells__title">品牌类型</div>
      <div class="weui-cells">
        <div class="weui-cell">
          <div class="weui-cell__bd">
            <input id="pinpai" class="weui-input" type="text" placeholder="请选择品牌类型" v-on:focus="selectOption('pinpai', '品牌类型', typeList.brand)" readonly>
          </div>
        </div>
      </div>
      <div class="weui-cells__title">能源类型</div>
      <div class="weui-cells">
        <div class="weui-cell">
          <div class="weui-cell__bd">
            <input id="nengyuan" class="weui-input" type="text" placeholder="请选择能源类型" @focus="selectOption('nengyuan', '能源类型', typeList.energy)" readonly>
          </div>
        </div>
      </div>
      <div class="weui-cells__title">车辆类型</div>
      <div class="weui-cells">
        <div class="weui-cell">
          <div class="weui-cell__bd">
            <input id="jibie" class="weui-input" type="text" placeholder="请选择车辆类型" @focus="selectOption('jibie', '车辆类型', typeList.car)" readonly>
          </div>
        </div>
      </div>
      <div class="weui-cells__title">座位数量</div>
      <div class="weui-cells">
        <div class="weui-cell">
          <div class="weui-cell__bd">
            <input id="zuowei" class="weui-input" type="text" placeholder="请选择座位数量" @focus="selectOption('zuowei', '座位数量', typeList.seat)" readonly>
          </div>
        </div>
      </div>
      <div class="weui-cells__title">车型结构</div>
      <div class="weui-cells">
        <div class="weui-cell">
          <div class="weui-cell__bd">
            <input id="jiegou" class="weui-input" type="text" placeholder="请选择车型结构" @focus="selectOption('jiegou', '车型结构', typeList.carStructure)" readonly>
          </div>
        </div>
      </div>
      <div class="weui-cells__title">变速箱类型</div>
      <div class="weui-cells">
        <div class="weui-cell">
          <div class="weui-cell__bd">
            <input id="biansuxiang" class="weui-input" type="text" placeholder="请选择变速箱类型" @focus="selectOption('biansuxiang', '变速箱类型', typeList.gearbox)" readonly>
          </div>
        </div>
      </div>
      <div class="weui-cells__title">其他需求</div>
      <div class="weui-cells weui-cells_form">
        <div class="weui-cell">
          <div class="weui-cell__bd">
            <textarea class="weui-textarea" placeholder="请输入具体的购车需求" rows="4"></textarea>
            <div class="weui-textarea-counter">
              <span>0</span>/100
            </div>
          </div>
        </div>
      </div>
    </div>
    <!--提交按钮-->
    <div class="submit">
      <router-link :to="{path:'/vipAdd'}">
        <button class="button" id="submit" onclick="modal();">提交</button>
      </router-link>
    </div>
    <!--提示信息-->
    <div class="tips">
    </div>
  </div>
</template>

<script type="text/javascript">
export default {
  props: {},
  data() {
    return {
      typeList: {
        brand: "brand", //品牌类型
        energy: "energy", //能源类型
        car: "car", // 车辆类型
        seat: "seat", // 座位数量
        carStructure: "carStructure", //车型结构
        gearbox: "gearbox" // 变速箱类型
      },
      configData: {}
    };
  },
  created() {
    this.$http.get("/api/choice/choiceConfig").then(response => {
      var result = response.data;
      if (result.code === this.$error_code) {
        this.configData = result.data;
      }
    });
  },
  methods: {
    selectOption(_id, _title, _type) {
      var _that = this;
      $("#" + _id).select({
        title: _title,
        items: _that._getListData(_type)
      });
    },
    _getListData(type) {
      let arr = [];
      let temp = this.configData[type];
      for (var i = 0; i < temp.length; i++) {
        arr.push(temp[i].name);
      }
      return arr;
    }
  }
};
</script>


<style scoped lang="stylus">
@import ('../../../static/css/xuanche');
</style>
