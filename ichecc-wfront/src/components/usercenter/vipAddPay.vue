<template>
  <div>
    <div class="title">
      <p>请选择并支付</p>
      <hr class="hr">
    </div>
    <div class="vipinfo">
      <div class="config-wrapper">
        <div v-for="(item, index) in depositConfig" class="config-item" :class="{'config-item-checked':currentConfig===item.id}" :id="'item' + item.id" @click="selectedConfig($event, item.id)">
          <p :class="{'price_num_checked':currentConfig===item.id,'price_num':currentConfig!==item.id}">¥{{item.amount | formatMoney('0')}}</p>
          <p :class="{'viptype_checked':currentConfig===item.id,'viptype':currentConfig!==item.id}">{{item.expiryDate}}{{item.expiryType === "01" ? '天' : '月'}}</p>
          <div class="attract-wrapper" v-if="item.attractDesc != '' && item.attractDesc != undefined">
            <span>&nbsp;{{item.attractDesc}}&nbsp;</span>
          </div>
        </div>
        <!-- <div class="cl"></div> -->
      </div>

      <!-- <div class="line1">
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
      </div> -->

    </div>
    <!--支付按钮-->
    <div class="vippay">
      <!-- <button class="button_pay" id="vippay" @click="wxPayCall">立即支付</button> -->
      <button class="button_pay" id="vippay" @click="wxPay">立即支付</button>
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
      depositConfig: [],
      currentConfig: ''
    }
  },
  mounted() {
    this.$nextTick(function () {
      this.getJsApiConfig();
    })
  },
  created() {
    this.$nextTick(function () {
      this.getDepositConfig();
    })
  },
  methods: {
    getJsApiConfig() {
      let _url = location.href.split('#')[0] //获取锚点之前的链接
      this.$http.get('/api/wechat/jsApiConfig', { url: _url }).then(response => {
        let _that = this;
        if (response.code === this.$resp_code) {
          let res = response.data;
          let jsApiConfig = res.jsApiConfig;
          wx.config({
            // debug: jsApiConfig.debug,
            debug: true,
            appId: jsApiConfig.appid,
            timestamp: jsApiConfig.timestamp,
            nonceStr: jsApiConfig.nonceStr,
            signature: jsApiConfig.signature,
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
    getDepositConfig() {
      this.$http.get('/api/depositConfig/listConfig').then(response => {
        let _that = this;
        if (response.code === this.$resp_code) {
          this.depositConfig = response.data;
          this.currentConfig = response.data[0].id;
        }
      });
    },
    selectedConfig(event, cfgId) {
      this.currentConfig = cfgId;
    },

    // 该方法废弃，请使用wxPay()方法
    wxPayCall() {
      this.$http.post("/api/wechat/payOrder", { "configId": this.currentConfig }).then(response => {
        if (response.code === this.$resp_code) {
          let res = response.data;
          wx.chooseWXPay({
            "appId": res.appid,
            "timestamp": res.timestamp,
            "nonceStr": res.nonceStr,
            "package": res.pkage,
            "signType": res.signType,
            "paySign": res.paySign,
            success: function (res) {
              // 支付成功后的回调函数
            }
          });
        } else {
          $.toast("支付失败", "text");
          return;
        }
      });
    },

    wxPay() {
      this.$http.post("/api/wechat/payOrder", { "configId": this.currentConfig }).then(response => {
        if (response.code === this.$resp_code) {
          let res = response.data;
          if (typeof WeixinJSBridge == "undefined") {
            if (document.addEventListener) {
              document.addEventListener('WeixinJSBridgeReady', onBridgeReady, false);
            } else if (document.attachEvent) {
              document.attachEvent('WeixinJSBridgeReady', onBridgeReady);
              document.attachEvent('onWeixinJSBridgeReady', onBridgeReady);
            }
          } else {
            this.onBridgeReady(res);
          }
        }
      });
    },
    onBridgeReady(res) {
      let _that = this;
      let wxpayConfig = res.wxPayConfig;
      WeixinJSBridge.invoke(
        'getBrandWCPayRequest',
        {
          "appId": wxpayConfig.appid, //公众号名称，由商户传入     
          "timeStamp": wxpayConfig.timestamp, //时间戳，自1970年以来的秒数     
          "nonceStr": wxpayConfig.nonceStr, //随机串     
          "package": wxpayConfig.pkage,
          "signType": wxpayConfig.signType, //微信签名方式：     
          "paySign": wxpayConfig.paySign //微信签名 
        },
        function (resPay) {
          if (resPay.err_msg == "get_brand_wcpay_request:ok") {
            // 使用以上方式判断前端返回,微信团队郑重提示：
            //resPay.err_msg将在用户支付成功后返回ok，但并不保证它绝对可靠。
            _that.$http.get("/api/wechat/orderQuery", { "orderNo": res.orderNo }).then(response => {
              if (response.code === _that.$resp_code) {
                _that.$router.push({ "name": "vipAddResult", params: { "vipInfo": response.data } });
                return;
              } else {
                $.toast("支付异常，请联系客服", "text");
                return;
              }
            });
          }
          if (resPay.err_msg == "get_brand_wcpay_request:cancel" || resPay.err_msg == "brand_wcpay_request:fail") {
            _that.$http.get("/api/wechat/orderQuery", { "orderNo": res.orderNo }).then(response => {
              if (response.code === _that.$resp_code) {
                $.toast("支付失败", "text");
                return;
              }
            });
          }
        });
    }
  }

}
</script>

<style scoped lang="stylus">
@import ('../../../static/css/vippay');
.config-wrapper
  width: 100%;
  margin-bottom: 20px;
  overflow: hidden;
  text-align: center;
  line-height: 20px;
  .config-item-checked
    border: 1px solid #2aa515 !important;
  .config-item
    position: relative;
    display: block;
    float: left;
    width: 40%;
    margin-right: 4%;
    padding-top: 7px;
    border: 1px solid #bdbaba;
    text-align: center;
    vertical-align: middle;
    height: 45px;
    .attract-wrapper
      position: absolute;
      top: -12px;
      right: 0;
      background: #2aa515;
      color: white;
      font-size: 12px;
      display: inline-block;
.config-wrapper div:nth-child(even)
  margin-left: 2%;
.config-wrapper div:nth-child(n+3)
  margin-top: 12px;
.cl
  clear: both;
</style>
