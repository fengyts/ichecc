import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex);


export default new Vuex.Store({
  state: {
    user: {},
    loginState: 1,
    code: "",
    openid: ""
  },
  mutations: {
    setLoginState(state, loginState) {
      state.loginState = loginState;
    },
    cacheCode(state, code) {
      state.code = code;
    }
  }
})
