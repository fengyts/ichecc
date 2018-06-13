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
      <!-- <div>
        点击选择日期和时间:<input type="text" id="datetime-picker" v-on:focus="datepicker" />
      </div> -->
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
            <input id="pinpai" class="weui-input" type="text" placeholder="请选择品牌类型" v-on:focus="selectOption('pinpai', '品牌类型', 'brand')" readonly>
          </div>
        </div>
      </div>
      <div class="weui-cells__title">能源类型</div>
      <div class="weui-cells">
        <div class="weui-cell">
          <div class="weui-cell__bd">
            <input id="nengyuan" class="weui-input" type="text" placeholder="请选择能源类型" v-on:focus="selectOption('nengyuan', '能源类型', 'energy')" readonly>
          </div>
        </div>
      </div>
      <div class="weui-cells__title">车辆类型</div>
      <div class="weui-cells">
        <div class="weui-cell">
          <div class="weui-cell__bd">
            <input id="jibie" class="weui-input" type="text" placeholder="请选择车辆类型" onclick="select();" readonly>
          </div>
        </div>
      </div>
      <div class="weui-cells__title">座位数量</div>
      <div class="weui-cells">
        <div class="weui-cell">
          <div class="weui-cell__bd">
            <input id="zuowei" class="weui-input" type="text" placeholder="请选择座位数量" onclick="select();" readonly>
          </div>
        </div>
      </div>
      <div class="weui-cells__title">车型结构</div>
      <div class="weui-cells">
        <div class="weui-cell">
          <div class="weui-cell__bd">
            <input id="jiegou" class="weui-input" type="text" placeholder="请选择车型结构" onclick="select();" readonly>
          </div>
        </div>
      </div>
      <div class="weui-cells__title">变速箱类型</div>
      <div class="weui-cells">
        <div class="weui-cell">
          <div class="weui-cell__bd">
            <input id="biansuxiang" class="weui-input" type="text" placeholder="请选择变速箱类型" onclick="select();" readonly>
          </div>
        </div>
      </div>
      <div class="weui-cells__title">其他需求</div>
      <div class="weui-cells weui-cells_form">
        <div class="weui-cell">
          <div class="weui-cell__bd">
            <textarea class="weui-textarea" placeholder="请输入具体的购车需求" rows="3"></textarea>
            <div class="weui-textarea-counter">
              <span>0</span>/200</div>
          </div>
        </div>
      </div>
    </div>
    <!--提交按钮-->
    <div class="submit">
      <button class="button" id="submit" onclick="modal();">提交</button>
    </div>
    <!--提示信息-->
    <div class="tips">
    </div>
  </div>
</template>

<script type="text/javascript">
import $ from "jquery";
// import weui from '../../assets/plugins/jquery-weui/js/jquery-weui.min.js';
// import swiper from '../../assets/plugins/jquery-weui/js/swiper.min.js';
// import weui from "jquery-weui/dist/js/jquery-weui.min";
import picker from "jquery-weui/dist/js/city-picker.min";
export default {
  props: {},
  data() {
    return {
      typeList: {
        brand: "brand", //品牌类型
        energy: "energy" //能源类型
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
        // title: "品牌类型",
        // items: ["国产品牌", "合资品牌", "进口品牌"]
        closeByOutsideClick: true,
        title: _title,
        items: _that._getListData(_type)
      });
    },
    // datepicker: function() {
    //   $("#datetime-picker").calendar({ closeByOutsideClick: true });
    // },
    _getListData(type) {
      let arr = [];
      let temp = this.configData[type];
      for(var i = 0;i < temp.length; i++){
         arr.push(temp[i].name);
      }
      return arr;
    }
  }
};
</script>

<style scoped lang="stylus">
@import ('../../../static/css/xuanche');
@import ('../../assets/plugins/jquery-weui/css/jquery-weui.min.css');
</style>
