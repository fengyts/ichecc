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

    // 判断是否已经登录
    // let _user = this.$store.state.user;
    let _user = this.$localStorage.getLocalStorage("icheccuser");
    if (_user && Object.keys(_user).length > 0) {
      this.$router.push(this.rdPath);
      return;
    }

    // 获取url params参数
    let wrdParam = this._getCode();
    let _code, _rdPath;
    if (wrdParam) {
      _code = wrdParam.code;
      _rdPath = wrdParam.rdPath;
    }

    // code存在，获取code，并发送到后台获取用户信息
    if (_code) {
      let params = new URLSearchParams();
      params.append("code", this.$crypto.encryptAes(_code));
      let _that = this;
      this.$axios.post("/api/wechat/authorize", params).then(res => {
        let result = res.data;
        if (result.code === _that.$resp_code) {
          let user = result.data;
          _that.$localStorage.setLocalStorage("icheccuser", user);
          _that.$store.commit("setUser", result.data);
          window.location.href = "/#" + _that.rdPath;
          return;
        } else {
          // 后台获取用户信息失败后重新发起授权
          this.wechatAuth();
        }
      });
    } else {
      // 调用微信授权接口获取code
      this.wechatAuth();
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
