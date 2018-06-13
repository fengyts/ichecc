import Vue from 'vue'
import Router from 'vue-router'
import home from 'components/home/home'
import list from 'components/temai/list'
import temaidetail from 'components/temai/detail'
import choice from 'components/choice/choice'
import usercenter from 'components/usercenter/usercenter'
import vip from 'components/usercenter/vip'
import authentication from 'components/usercenter/authentication'
import authenticationDid from 'components/usercenter/authenticationDid'
import bargainRecord from 'components/usercenter/bargainRecord'
import bargainDetail from 'components/usercenter/bargainDetail'
import choiceRecord from 'components/usercenter/choiceRecord'
import choiceDetail from 'components/usercenter/choiceDetail'
import help from 'components/other/help'
import carDescribe from 'components/temai/carDescribe'
import bargain from 'components/temai/bargain'
import helpBargain from 'components/temai/helpBargain'


Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      component: home,
      children: [
        {path: 'list', component: list}, 
        {path: 'choice', component: choice},
        {path: 'usercenter', component: usercenter}
      ]
    }, 
    {
      path: '/home',
      component: home,
      children: [
        {path: 'list', component: list}, 
        {path: 'choice', component: choice},
        {path: 'usercenter', component: usercenter}
      ]
    }, 
    {path: '/detail', component: temaidetail}, 
    {path: '/vip', component: vip}, 
    {path: '/authentication', component: authentication}, 
    {path: '/bargainRecord', component: bargainRecord},
    {path: '/bargainDetail', component: bargainDetail},
    {path: '/choiceRecord', component: choiceRecord},
    {path: '/choiceDetail', component: choiceDetail},
    {path: '/help', component: help},
    {path: '/carDescribe', component: carDescribe},
    {path: '/bargain', component: bargain},
    {path: '/helpBargain', component: helpBargain},
    {path: '/authenticationDid', component: authenticationDid}
  ],
  linkActiveClass: '--active' // 指定超链接激活的样式,等同于class="active"
})
