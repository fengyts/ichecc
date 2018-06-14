// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import $ from 'jquery'
import weui from 'jquery-weui/dist/js/jquery-weui.min'
import 'jquery-weui/dist/css/jquery-weui.min.css'
import axios from 'axios'
import filter from './common/filters/filter'

window.JQuery = $;
window.$ = $;

import 'common/stylus/index';

Vue.config.productionTip = false
// axios.defaults.baseURL = process.env.BASE_API_URL
axios.defaults.baseURL = process.env.NODE_ENV === 'production' ? process.env.BASE_API_URL : ''
Vue.prototype.$http = axios
Vue.prototype.$error_code = "1"; // 接口错误代码

for(let key in filter){
  Vue.filter(key, filter[key]);
}

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})

router.push('/home/list');
