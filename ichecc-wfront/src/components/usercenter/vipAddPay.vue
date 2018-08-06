
<template>
  <div>
    <div class="title">
      <p>请选择VIP期限并支付</p>
      <hr class="hr">
    </div>
    <div class="vipinfo">
      <div class="line1">
        <div class="one">
          <p class="price_num_checked">¥8.80</p>
          <p class="viptype_checked">1天</p>
        </div>
        <div class="three">
          <p class="price_num">¥18.80</p>
          <p class="viptype">7天</p>
          <div class="tuijian">
            <span>&nbsp;推荐&nbsp;</span>
          </div>
        </div>
      </div>
      <div class="line2">
        <div class="six">
          <p class="price_num">¥188.0</p>
          <p class="viptype">30天</p>
        </div>
        <div class="twelve">
          <p class="price_num">¥198.00</p>
          <p class="viptype">90天</p>
          <div class="tuijian">
            <span>&nbsp;超值&nbsp;</span>
          </div>
        </div>

      </div>
    </div>
    <!--支付按钮-->
    <div class="vippay">
      <!-- <router-link :to="{path:'/vipAddResult'}"> -->
      <!-- <button class="button_pay" id="vippay" onclick="">立即支付</button> -->
      <!-- </router-link> -->
      <button class="button_pay" id="vippay" @click="wexinPayCall">立即支付</button>
    </div>
    <!--说明-->
    <div class="tips">
      <span class="tips_content">支付成功后不支持退款</span>
    </div>
  </div>
</template>

<script type="text/javascript">
import wx from 'weixin-js-sdk';
export default {
  data() {
    return {

    }
  },
  mounted() {
    this.$nextTick(function () {
      this.getConfig();
    })
  },
  methods: {
    getConfig() {
      let _url = location.href.split('#')[0] //获取锚点之前的链接
      // if(_url.endsWith("/")){
      //   _url = _url.substring(0, _url.length - 1);
      // }
      this.$http.get('/api/wechat/jsApiConfig', { url: _url }).then(response => {
        let _that = this;
        // this.wxInit(res);
        if (response.code === this.$resp_code) {
          let res = response.data;
          console.log(res);
          wx.config({
            debug: res.debug,
            appId: res.appid,
            timestamp: res.timestamp,
            nonceStr: res.nonceStr,
            signature: res.signature,
            jsApiList: _that.setApiList(res.jsApiList)
          });
        } else {
          $.toast("服务器连接异常，请稍后再试", "text");
          return;
        }
      });

      // wx.checkJsApi({
      //   jsApiList: ['chooseWXPay'], // 需要检测的JS接口列表，所有JS接口列表见附录2,
      //   success: function(res) {
      //     console.log("checkJsApi:");
      //     console.log(res);
      //   // 以键值对的形式返回，可用的api值true，不可用为false
      //   // 如：{"checkResult":{"chooseImage":true},"errMsg":"checkJsApi:ok"}
      //   }
      // });
    },
    setApiList(_list) {
      if (null == _list || undefined == _list) {
        _list = [];
      }
      _list.push('chooseWXPay');
    },
    wexinPayCall() {
      this.$http.post("/api/wechat/payOrder", { "depositAmount": "0.01" }).then(response => {
        console.log("wx pay order:");
        console.log(response);

        // return;

        if (response.code === this.$resp_code) {
          let res = response.data;
          console.log(res);
          wx.chooseWXPay({
            appId: res.appid,
            timeStamp: res.timestamp,
            nonceStr: res.nonceStr,
            package: res.pkage,
            signType: res.signType,
            paySign: res.paySign,
            success: function (res) {
              console.log("wechat pay success:");
              console.log(res);
              alert("haha, success");
              // 支付成功后的回调函数
            }
          });
        } else {
          alert("支付失败");
          return;
        }
      });
    }
  },
  components: {
  }
}
</script>

<style scoped lang="stylus">

@import ('../../../static/css/vippay');
</style>
