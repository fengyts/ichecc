import Vue from 'vue'
import Router from 'vue-router'
import home from 'components/home/home'
import choice from 'components/choice/choice'
import usercenter from 'components/usercenter/usercenter'

Vue.use(Router)

export default new Router({
  routes: [{
      path: '/',
      component: home
    },
    {
      path: '/home',
      component: home
    },
    {
      path: '/choice',
      component: choice
    },
    {
      path: '/usercenter',
      component: usercenter
    }
  ],
  linkActiveClass: 'active'// 指定超链接激活的样式,等同于class="active"
})
