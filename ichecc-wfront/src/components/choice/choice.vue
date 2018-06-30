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
            <input class="weui-input" type="text" placeholder="请输入预算金额（万元）" id="yusuan" v-model="selectedData.budget">
          </div>
        </div>
      </div>
      <div class="weui-cells__title">品牌类型</div>
      <div class="weui-cells">
        <div class="weui-cell">
          <div class="weui-cell__bd">
            <input id="pinpai" class="weui-input" type="text" placeholder="请选择品牌类型" v-on:focus="selectOption('pinpai', typeList.brand)" readonly>
          </div>
        </div>
      </div>
      <div class="weui-cells__title">能源类型</div>
      <div class="weui-cells">
        <div class="weui-cell">
          <div class="weui-cell__bd">
            <input id="nengyuan" class="weui-input" type="text" placeholder="请选择能源类型" @focus="selectOption('nengyuan', typeList.energy)" readonly>
          </div>
        </div>
      </div>
      <div class="weui-cells__title">车辆类型</div>
      <div class="weui-cells">
        <div class="weui-cell">
          <div class="weui-cell__bd">
            <input id="jibie" class="weui-input" type="text" placeholder="请选择车辆类型" @focus="selectOption('jibie', typeList.type)" readonly>
          </div>
        </div>
      </div>
      <div class="weui-cells__title">座位数量</div>
      <div class="weui-cells">
        <div class="weui-cell">
          <div class="weui-cell__bd">
            <input id="zuowei" class="weui-input" type="text" placeholder="请选择座位数量" @focus="selectOption('zuowei', typeList.seat)" readonly>
          </div>
        </div>
      </div>
      <div class="weui-cells__title">车型结构</div>
      <div class="weui-cells">
        <div class="weui-cell">
          <div class="weui-cell__bd">
            <input id="jiegou" class="weui-input" type="text" placeholder="请选择车型结构" @focus="selectOption('jiegou', typeList.structure)" readonly>
          </div>
        </div>
      </div>
      <div class="weui-cells__title">变速箱类型</div>
      <div class="weui-cells">
        <div class="weui-cell">
          <div class="weui-cell__bd">
            <input id="biansuxiang" class="weui-input" type="text" placeholder="请选择变速箱类型" @focus="selectOption('biansuxiang', typeList.gearbox)" readonly>
          </div>
        </div>
      </div>
      <div class="weui-cells__title">其他需求</div>
      <div class="weui-cells weui-cells_form">
        <div class="weui-cell">
          <div class="weui-cell__bd">
            <textarea class="weui-textarea" placeholder="请输入具体的购车需求" rows="4" v-model="selectedData.otherRequirement"></textarea>
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
        <!-- <button class="button" id="submit" onclick="modal();">提交</button> -->
      </router-link>
      <button class="button" id="submit" @click="choiceSubmit()">提交</button>
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
        budget: { type: "budget", desc: "购车预算" },
        brand: { type: "brand", desc: "品牌类型" },
        energy: { type: "energy", desc: "能源类型" },
        type: { type: "type", desc: "车辆类型" },
        seat: { type: "seat", desc: "座位数量" },
        structure: { type: "structure", desc: "车型结构" },
        gearbox: { type: "gearbox", desc: "变速箱类型" }
      },
      resData: {},
      selectedData: {
        budget: "",
        brand: "",
        energy: "",
        type: "",
        seat: "",
        structure: "",
        gearbox: "",
        otherRequirement: ""
      }
    };
  },
  created() {
    this.$http.get("/api/choice/choiceConfig").then(response => {
      var result = response;
      if (result.code === this.$resp_code) {
        this.resData = result.data;
      }
    });
  },
  methods: {
    selectOption: function (_id, _type) {
      var _that = this;
      jQuery("#" + _id).select({
        title: _type.desc,
        items: _that._getListData(_type.type),
        onChange: function (res) {
          // _type.selected = res.titles;
          _that.selectedData[_type.type] = res.titles;
        }
      });
    },
    _getListData: function (type) {
      let arr = [];
      let temp = this.resData[type];
      for (var i = 0; i < temp.length; i++) {
        let item = {};
        item.title = temp[i].name;
        item.value = temp[i].id;
        arr.push(item);
      }
      return arr;
    },
    checkSubmitData: function () {
      let submitData = this.selectedData;
      for (let key in submitData) {
        if (key === 'otherRequirement') { continue; }
        if (submitData[key] === "" || submitData[key] == undefined) {
          return this.typeList[key].desc + "不能为空";
        }
      }
      return "OK";
    },
    choiceSubmit: function () {
      let _check = this.checkSubmitData();
      if ("OK" != _check) {
        $.toptip(_check, 'error');
        return;
      }
      let _that = this;
      this.$http.post("/api/choice/choiceSubmit", this.selectedData).then(res => {
        if (res.code === '200001') {
          $.toast("只有vip会员才有权限", 1500);
          this.$router.push("/vipAdd");
          return;
        }
        if (res.code === this.$resp_code) {
          $.toast("提交成功", 1000, function(){
            _that.$router.push("/choiceRecord");
          });
        } else {
          $.toast(res.message, "text");
          this.$router.go(0);
        }
      });
    }
  }
};
</script>


<style scoped lang="stylus">
@import ('../../../static/css/xuanche');
</style>
