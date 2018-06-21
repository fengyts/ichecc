<!--  -->
<template>
  <div class="auth-req">
    <!-- 正在获取授权信息。。。 -->
  </div>
</template>

<script type="text/javascript">
export default {
  data() {
    return {};
  },
  created() {
    var loginState = this.$store.state.loginState;
    if (0 == loginState) {
      var _code = this._getCode();
      console.log("code:" + _code);
      if(_code){
        // this.code = _code;
        console.log(this.$router);
        this.$store.commit("setLoginState", 1);
        this.$router.push("/home/list");
        return;
      }
      this.wechatAuth();
    } else {
      this.$router.push("/home/list");
    }
  },
  methods: {
    wechatAuth() {
      // 公众号测试账号:
      // appid:wx11b8b11348ff6db3
      // secret:d2c1fd6715f20dc1b1b15ffabcd2fb25
      // 正式公众号：
      // appid:wxeec85623859fc30e
      // secret:ef80f395bfbd63e7b61b6972179ad4cb

      // var _authUrl = this.getAuthUrl();
      var _authUrl = this.getAuthUrl("test");
      location.href = _authUrl;
      var storeTest = this.$store.state.loginState;
      console.log(storeTest);
    },
    getAuthUrl(_envType) {
      var scope = "snsapi_userinfo";
      // 默认正式环境
      var appid = "wxeec85623859fc30e",
        redirect_uri = encodeURIComponent(
          "http://www.checc.cc/mp/MP_verify_KfRYessrSJskNVws.txt"
        ),
        state = "/wechatAuth";
      //测试环境
      if (_envType === "test") {
        appid = "wx11b8b11348ff6db3";
        // redirect_uri = encodeURIComponent("http://47.94.199.26/ichecc-front/");
        // redirect_uri = encodeURIComponent("http://192.168.9.108:8080");
        redirect_uri = encodeURIComponent("http://192.168.0.107:8080");
      }
      var _authUrl =
        `https://open.weixin.qq.com/connect/oauth2/authorize?` +
        `appid=${appid}&redirect_uri=${redirect_uri}` +
        `&response_type=code&scope=${scope}&state=${state}#wechat_redirect`;
      return _authUrl;
    },
    _getCode() {
      var _query = window.location.search;
      if (_query) {
        _query = _query.substring(1);
        var qs = _query.split("&");
        for (var i = 0; i < qs.length; i++) {
          let qi = qs[i].split("=");
          if ("code" === qi[0]) {
            return qi[1];
          }
        }
      }
    }
  },
  components: {}
};
</script>

<style scoped lang="stylus">
</style>
