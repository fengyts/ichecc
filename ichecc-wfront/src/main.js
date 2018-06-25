// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import $ from 'jquery'
import weui from 'jquery-weui/dist/js/jquery-weui.min'
import 'jquery-weui/dist/css/jquery-weui.min.css'
import axios from 'axios'
import wx from 'weixin-js-sdk'
import filters from './common/filters/filter'
import 'common/stylus/index'; // 全局自定义样式
import store from './store/store' // vuex store
import localStorage from './store/localStorage' // window localStorage
import crypto from './common/js/crypto'
import http from './common/js/http'

window.JQuery = $;
window.$ = $;

Vue.config.productionTip = false
// axios.defaults.baseURL = process.env.BASE_API_URL
axios.defaults.baseURL = process.env.NODE_ENV === 'production' ? process.env.BASE_API_URL : ''
axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
Vue.prototype.$axios = axios
Vue.prototype.$resp_code = "1"; // 接口错误代码: "1"-成功；"0"-失败
Vue.prototype.$localStorage = localStorage;
Vue.prototype.$crypto = crypto;
Vue.prototype.$http = http;

// 全局过滤器
for (let key in filters) {
  Vue.filter(key, filters[key]);
}


/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  components: {
    App
  },
  template: '<App/>'
})

// router.push('/home/list');
router.push('/wechatAuth');
