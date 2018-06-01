import Vue from 'vue'
import Router from 'vue-router'
import home from 'components/home/home'
import choice from 'components/choice/choice'
import usercenter from 'components/usercenter/usercenter'
import temaidetail from 'components/temai/detail'

Vue.use(Router)

export default new Router({
  routes: [
    // {
    //   path: '/',
    //   component: app
    // },
    // {
    //   path: '/home',
    //   component: home
    // },
    // {
    //   path: '/choice',
    //   component: choice
    // },
    // {
    //   path: '/usercenter',
    //   component: usercenter
    // }
    {
      path: '/detail',
      component: temaidetail
    }
  ],
  linkActiveClass: 'active' // 指定超链接激活的样式,等同于class="active"
})
