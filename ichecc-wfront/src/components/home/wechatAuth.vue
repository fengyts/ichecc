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
      let _that = this;
      //authSymbol: 登陆标识, 仅用于登陆发送ajax请求判断是否携带user信息用
      let data = {
        "code": _that.$crypto.encryptAes(_code),
        "authSymbol": 1
      };
      console.log("send code:----");
      console.log(_code);
      // return;
      this.$http.post("/api/wechat/authorize", data).then(res => {
        let result = res;

        if (result.code === _that.$resp_code) {
          let user = result.data;
          _that.$localStorage.setLocalStorage("icheccuser", user);
          _that.$store.commit("setUser", result.data);
          window.location.href = "/#" + _that.rdPath;
          return;
        } else {
          this.wechatAuth(); // 后台获取用户信息失败后重新发起授权
        }
      });
    } else {
      this.wechatAuth(); // 调用微信授权接口获取code
    }
  },
  methods: {
    wechatAuth() {
      // var isTest = process.env === 'production' ? "1" : "0"; // 1:线上；0-开发/测试环境
      var isTest = '1';
      var _authUrl = this.getAuthUrl(isTest);
      location.href = _authUrl;
    },
    getAuthUrl(_envType) {
      let scope = "snsapi_userinfo",
        appid = "wxeec85623859fc30e", // 默认正式环境
        redirect_uri = encodeURIComponent(
          "http://icweb.checc.cc"
        ),
        state = this.rdPath; // 跳转首页(默认)
      if (!state) {
        state = "/";
      }
      state = encodeURIComponent(state);

      //开发/测试环境
      if (_envType === "0") {
        appid = "wx11b8b11348ff6db3";
        redirect_uri = encodeURIComponent(process.env.BASE_WEB_URL);
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
  }
};
</script>

<style scoped lang="stylus">
</style>
