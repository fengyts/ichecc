import Vue from 'vue'
import Router from 'vue-router'
import home from 'components/home/home'
import list from 'components/temai/list'
import temaidetail from 'components/temai/detail'
import choice from 'components/choice/choice'
import usercenter from 'components/usercenter/usercenter'
import vip from 'components/usercenter/vip'
import authentication from 'components/usercenter/authentication'
import bargainRecord from 'components/usercenter/bargainRecord'
import choiceRecord from 'components/usercenter/choiceRecord'
import help from 'components/other/help'

Vue.use(Router)

export default new Router({
  routes: [{
      path: '/',
      component: home,
      children: [{
          path: 'list',
          component: list
        }, {
          path: 'choice',
          component: choice
        },
        {
          path: 'usercenter',
          component: usercenter
        }
      ]
    }, {
      path: '/home',
      component: home,
      children: [{
          path: 'list',
          component: list
        }, {
          path: 'choice',
          component: choice
        },
        {
          path: 'usercenter',
          component: usercenter
        }
      ]
    }, {
      path: '/detail',
      component: temaidetail
    }, {
      path: '/vip',
      component: vip
    }, {
      path: '/authentication',
      component: authentication
    }, {
      path: '/bargainRecord',
      component: bargainRecord
    },
    {
      path: '/choiceRecord',
      component: choiceRecord
    },
    {
      path: '/help',
      component: help
    }
  ],
  linkActiveClass: '--active' // 指定超链接激活的样式,等同于class="active"
})
