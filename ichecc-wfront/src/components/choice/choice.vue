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
            <input class="weui-input" type="text" placeholder="请输入预算金额（万元）" id="yusuan">
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
            <input id="jibie" class="weui-input" type="text" placeholder="请选择车辆类型" @focus="selectOption('jibie', typeList.car)" readonly>
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
            <input id="jiegou" class="weui-input" type="text" placeholder="请选择车型结构" @focus="selectOption('jiegou', typeList.carStructure)" readonly>
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
        brand: { type: "brand", desc: "品牌类型" },
        energy: { type: "energy", desc: "能源类型" },
        car: { type: "car", desc: "车辆类型" },
        seat: { type: "seat", desc: "座位数量" },
        carStructure: { type: "carStructure", desc: "车型结构" },
        gearbox: { type: "gearbox", desc: "变速箱类型" }
      },
      resData: {}
      // selectedData: {}
    };
  },
  created() {
    this.$http.get("/api/choice/choiceConfig").then(response => {
      var result = response.data;
      if (result.code === this.$error_code) {
        this.resData = result.data;
      }
    });
  },
  methods: {
    choiceSubmit() {
      // 公众号测试账号:
      // appid:wx11b8b11348ff6db3
      // secret:d2c1fd6715f20dc1b1b15ffabcd2fb25
      // 正式公众号：
      // appid:wxeec85623859fc30e
      // secret:ef80f395bfbd63e7b61b6972179ad4cb

      // var _authUrl = this.getAuthUrl();
      var _authUrl = this.getAuthUrl('test');
      location.href = _authUrl;
      var storeTest = this.$store.state.loginState
      console.log(storeTest);
    },
    getAuthUrl(_envType) {
      var scope = "snsapi_userinfo";
      // 默认正式环境
      var appid = "wxeec85623859fc30e",
        redirect_uri = encodeURIComponent(
          "http://www.checc.cc/mp/MP_verify_KfRYessrSJskNVws.txt"
        );
      //测试环境
      if (_envType === "test") {
        appid = "wx11b8b11348ff6db3";
        // redirect_uri = encodeURIComponent("http://47.94.199.26/ichecc-front/");
        redirect_uri = encodeURIComponent("http://192.168.9.108:8080");
      }
      var _authUrl =
        `https://open.weixin.qq.com/connect/oauth2/authorize?` +
        `appid=${appid}&redirect_uri=${redirect_uri}` +
        `&response_type=code&scope=${scope}&state=STATE#wechat_redirect`;
      return _authUrl;
    },
    selectOption(_id, _type) {
      var _that = this;
      $("#" + _id).select({
        title: _type.desc,
        items: _that._getListData(_type.type),
        onChange: function(res) {
          _type.selected = res.titles;
        }
      });
    },
    _getListData(type) {
      let arr = [];
      let temp = this.resData[type];
      for (var i = 0; i < temp.length; i++) {
        let item = {};
        item.title = temp[i].name;
        item.value = temp[i].id;
        arr.push(item);
      }
      return arr;
    }
  }
};
</script>


<style scoped lang="stylus">
@import ('../../../static/css/xuanche');
</style>
