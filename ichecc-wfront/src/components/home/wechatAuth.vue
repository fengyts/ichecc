<!--  -->
<template>
  <div class="auth">
    正在授权登录。。。
  </div>
</template>

<script type="text/javascript">
export default {
  data() {
    return {};
  },
  created() {
    var loginState = this.$store.state.loginState;
    if(1 == loginState){
      this.$router.push("/home/list");
    }else {
      this.choiceSubmit();
    }
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
  },
  components: {}
};
</script>

<style scoped lang="stylus">
</style>
