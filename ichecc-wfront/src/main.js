// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import $ from 'jquery'
import weui from 'jquery-weui/dist/js/jquery-weui.min'
import 'jquery-weui/dist//css/jquery-weui.min.css'
import picker from 'jquery-weui/dist/js/city-picker.min'

Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})

// router.push('/home');
