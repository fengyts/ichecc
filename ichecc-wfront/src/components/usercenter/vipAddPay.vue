
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
      <!-- <button class="button_pay" id="vippay" @click="wxpay">立即支付</button> -->
    </div>
    <!--说明-->
    <div class="tips">
      <span class="tips_content">支付成功后不支持退款</span>
    </div>
  </div>
</template>


<script type="text/javascript">
import wx from 'weixin-js-sdk';
// import wx from 'jweixin';
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
      // console.log(_url);
      // if(_url.endsWith("/")){
      //   _url = _url.substring(0, _url.length - 1);
      // }
      console.log("_url:");
      console.log(_url);
      this.$http.get('/api/wechat/jsApiConfig', { url: _url }).then(response => {
        let _that = this;
        // this.wxInit(res);
        if (response.code === this.$resp_code) {
          let res = response.data;
          console.log(JSON.stringify(res));
          wx.config({
            debug: res.debug,
            appId: res.appid,
            timestamp: res.timestamp,
            nonceStr: res.nonceStr,
            signature: res.signature,
            // jsApiList: _that.setApiList(res.jsApiList)
            jsApiList: ['chooseWXPay']
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
        console.log(JSON.stringify(response));

        // return;

        if (response.code === this.$resp_code) {
          let res = response.data;
          console.log("wxpay param:");
          console.log(JSON.stringify(res));
          alert(JSON.stringify(res));
          wx.chooseWXPay({
            appId: res.appid,
            timeStamp: res.timestamp,
            nonceStr: res.nonceStr,
            package: res.pkage,
            signType: res.signType,
            paySign: res.paySign,
            success: function (res) {
              console.log("wechat pay success:");
              console.log(JSON.stringify(res));
              alert("haha, success");
              // 支付成功后的回调函数
            }
          });
        } else {
          alert("支付失败");
          return;
        }
      });
    },

    wxpay() {
      this.$http.post("/api/wechat/payOrder", { "depositAmount": "0.01" }).then(response => {
        if (response.code === this.$resp_code) {
          let res = response.data;
          console.log(55555555);
          console.log(res);
          // return;

          if (typeof WeixinJSBridge == "undefined"){
            if( document.addEventListener ){
                document.addEventListener('WeixinJSBridgeReady', onBridgeReady, false);
            }else if (document.attachEvent){
                document.attachEvent('WeixinJSBridgeReady', onBridgeReady); 
                document.attachEvent('onWeixinJSBridgeReady', onBridgeReady);
            }
          }else{
            onBridgeReady(res);
          }

          // onBridgeReady(res);
        }
      });
    },
    onBridgeReady(res) {
      WeixinJSBridge.invoke(
        'getBrandWCPayRequest', {
          "appId": res.appid,     //公众号名称，由商户传入     
          "timeStamp": res.timestamp,         //时间戳，自1970年以来的秒数     
          "nonceStr": res.nonceStr, //随机串     
          "package": res.pkage,
          "signType": res.signType,         //微信签名方式：     
          "paySign": res.paySign //微信签名 
        },
        function (res) {
          console.log(12345678888);
          console.log(res);
          if (res.err_msg == "get_brand_wcpay_request:ok") {
            // 使用以上方式判断前端返回,微信团队郑重提示：
            //res.err_msg将在用户支付成功后返回ok，但并不保证它绝对可靠。
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
