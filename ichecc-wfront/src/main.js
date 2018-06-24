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

window.JQuery = $;
window.$ = $;

Vue.config.productionTip = false
// axios.defaults.baseURL = process.env.BASE_API_URL
axios.defaults.baseURL = process.env.NODE_ENV === 'production' ? process.env.BASE_API_URL : ''
axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
// axios.prototype.apiPost = function (url, data) {
//   let params = new URLSearchParams();
//   for (let key in data) {
//     params.append(key, data[key]);
//   }
//   console.log("axios:");
//   console.log(axios);
//   return new Promise((resolve, reject) => {
//     this.$axios.post(url, params).then((response) => {
//       resolve(response.data);
//     }).catch((response) => {
//       console.log('f', response)
//     })
//   })
// }
Vue.prototype.$axios = axios
Vue.prototype.$error_code = "1"; // 接口错误代码: "1"-成功；"0"-失败
Vue.prototype.$localStorage = localStorage;
Vue.prototype.$crypto = crypto;

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
