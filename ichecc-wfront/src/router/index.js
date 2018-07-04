import Vue from 'vue'
import Router from 'vue-router'

// 授权页
import wechatAuth from 'components/home/wechatAuth'
import home from 'components/home/home'

// tabbar路由 -特卖
import temaiList from 'components/temai/list'
// 特卖模块
import temaiDetail from 'components/temai/detail'
import carDescribe from 'components/temai/carDescribe'
import bargain from 'components/temai/bargain'
import helpBargain from 'components/temai/helpBargain'

// tabbar路由 -选车
import choice from 'components/choice/choice'

// tabbar路由 -用户中心
import usercenter from 'components/usercenter/usercenter'
// 用户中心模块
// 用户中心-vip
import vip from 'components/usercenter/vip'
import vipAdd from 'components/usercenter/vipAdd'
import vipAddPay from 'components/usercenter/vipAddPay'
import vipAddResult from 'components/usercenter/vipAddResult'
import vipCardInfo from 'components/usercenter/vipCardInfo'
import vipRenewPay from 'components/usercenter/vipRenewPay'
import vipRenewResult from 'components/usercenter/vipRenewResult'
// 用户中心-身份认证
import authentication from 'components/usercenter/authentication'
import authenticationDid from 'components/usercenter/authenticationDid'
// 用户中心-砍价
import bargainRecord from 'components/usercenter/bargainRecord'
import bargainDetail from 'components/usercenter/bargainDetail'
// 用户中心-选车
import choiceRecord from 'components/usercenter/choiceRecord'
import choiceDetail from 'components/usercenter/choiceDetail'
// 其他模块
import help from 'components/other/help'


Vue.use(Router);

const router = new Router({
  // mode: 'history',
  routes: [
    {path:'/wechatAuth', name:'wechatAuth', component: wechatAuth},
    // {path: "*", component: notfound},
    // {
    //   path: '/',
    //   component: home,
    //   children: [
    //     {path: 'list', component: list}, 
    //     {path: 'choice', component: choice},
    //     {path: 'usercenter', component: usercenter}
    //   ]
    // }, 
    {
      path: '/home',
      component: home,
      children: [
        {path: 'list', name:'homeList', component: temaiList}, 
        {path: 'choice', component: choice},
        {path: 'usercenter', component: usercenter}
      ]
    }, 
    {path: '/detail/:tiId', component: temaiDetail}, 
    {path: '/carDescribe', name: 'carDescribe', component: carDescribe},
    {path: '/bargain/:tiId', component: bargain, meta: {requireAuth: true}},
    {path: '/helpBargain', component: helpBargain},

    {path: '/vipAdd', component: vipAdd}, 
    {path: '/vip', component: vip}, 
    {path: '/vipAddPay', component: vipAddPay}, 
    {path: '/vipAddResult', component: vipAddResult}, 
    {path: '/vipCardInfo', component: vipCardInfo}, 
    {path: '/vipRenewPay', component: vipRenewPay}, 
    {path: '/vipRenewResult', component: vipRenewResult}, 

    {path: '/authentication', component: authentication, meta: {requireAuth: true}}, 
    {path:'/authenticationDid', component: authenticationDid, meta: {requireAuth: true}},

    {path: '/bargainRecord', component: bargainRecord, meta: {requireAuth: true}},
    {path: '/bargainDetail', component: bargainDetail, meta: {requireAuth: true}},

    {path: '/choiceRecord', component: choiceRecord, meta: {requireAuth: true}},
    {path: '/choiceDetail/:orderId', component: choiceDetail, props: true, meta: {requireAuth: true}},

    {path: '/help', component: help},
  ],
  linkActiveClass: '--active' // 指定超链接激活的样式,等同于class="active"
})

router.beforeEach((to, from, next) => {
  // 判断是否需要登录
  // if (to.meta.requireAuth) {
  if (to.matched.some(m => m.meta.requireAuth)) {
    // console.log(this);
    // console.log(this.a.app.$localStorage);
    let _user = JSON.parse(window.localStorage._icheccwf_)["icheccuser"];
    // 判断是否已经登录
    if (_user && Object.keys(_user).length > 0) {
      next();
    } else {
      next({
        name: "wechatAuth",
        params: {
          "rdPath": from
        }
      });
    }
  } else {
    next();
  }
});

export default router;
