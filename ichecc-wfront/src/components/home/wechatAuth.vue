<!--  -->
<template>
  <div class="auth-req">
    <!-- 正在获取授权信息。。。 -->
  </div>
</template>

<script type="text/javascript">
export default {
  data() {
    return {
      rdPath: "/home/list" // 默认跳转到首页
    };
  },
  created() {
    let rdPathP = this.$route.params.rdPath; // 跳转指定页面
    if (rdPathP) {
      this.rdPath = rdPathP;
    }

    // 本地localStorage 保存了授权信息，直接重定向到跳转页(此判断步骤单纯为解决路径问题)
    let wechatAuth = this.$localStorage.getLocalStorage("wechatAuth");
    if (wechatAuth) {
      let redirect_tag = wechatAuth.redirect_tag;
      if (1 == redirect_tag) {
        this.$store.commit("setLoginState", 1);
        this.$localStorage.removeLocalStorage("wechatAuth");
        this.$router.push({ path: wechatAuth.rdPath });
        return;
      }
    }
    // 判断是否授权，授权并冲定向
    var loginState = this.$store.state.loginState;
    if (0 == loginState) {
      // 未授权
      let _code = this._getCode().code;
      let _rdPath = this.rdPath;
      if (_code) {
        // 已经授权获取了code
        let _wechatAuth = {};
        _wechatAuth.redirect_tag = 1;
        _wechatAuth.auth_code = _code;
        _wechatAuth.rdPath = _rdPath;
        this.$localStorage.setLocalStorage("wechatAuth", _wechatAuth);
        location.href = "/";
        return;
      } else {
        this.wechatAuth();
      }
    } else {
      // this.$router.push("/home/list");
      this.$router.push(this.rdPath);
    }
  },
  methods: {
    wechatAuth() {
      // var _authUrl = this.getAuthUrl();
      var _authUrl = this.getAuthUrl("test");
      location.href = _authUrl;
    },
    getAuthUrl(_envType) {
      let scope = "snsapi_userinfo",
        appid = "wxeec85623859fc30e", // 默认正式环境
        redirect_uri = encodeURIComponent(
          "http://www.checc.cc/mp/MP_verify_KfRYessrSJskNVws.txt"
        ),
        state = this.rdPath; // 跳转首页(默认)
      if (!state) {
        state = "/";
      }

      //测试环境
      if (_envType === "test") {
        appid = "wx11b8b11348ff6db3";
        // redirect_uri = encodeURIComponent("http://47.94.199.26/ichecc-front/");
        redirect_uri = encodeURIComponent("http://192.168.9.108:8080");
        // redirect_uri = encodeURIComponent("http://192.168.0.107:8080");
      }
      let _authUrl =
        `https://open.weixin.qq.com/connect/oauth2/authorize?` +
        `appid=${appid}&redirect_uri=${redirect_uri}` +
        `&response_type=code&scope=${scope}&state=${state}#wechat_redirect`;
      return _authUrl;
    },
    _getCode() {
      let rdParam = {};
      let _query = window.location.search;
      if (_query) {
        _query = _query.substring(1);
        let qs = _query.split("&");
        for (let i = 0; i < qs.length; i++) {
          let qi = qs[i].split("=");
          if ("code" === qi[0]) {
            rdParam.code = qi[1];
          }
          if ("state" === qi[0] || "STATE" === qi[0]) {
            rdParam.rdPath = decodeURIComponent(qi[1]);
          }
        }
      }
      return rdParam;
    }
  },
  components: {}
};
</script>

<style scoped lang="stylus">
</style>
