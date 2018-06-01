<template>
  <div id="app" style="height:100%">
    <div class="weui-tab">
      <!--页面内容-->
      <div class="weui-tab__bd" style="height:91%">
        <!--新车特卖-->
        <temailist v-on:closeTabbarC="closeTabbarP"></temailist>
        <!--帮你选车-->
        <choice></choice>
        <!--个人中心-->
        <usercenter></usercenter>
      </div>

      <!--底部导航-->
      <div class="weui-tabbar" style="height:9%;">
        <a href="#tab1" class="weui-tabbar__item weui-bar__item--on">
          <p class="weui-tabbar__label">新车特卖</p>
        </a>
        <a href="#tab2" class="weui-tabbar__item">
          <p class="weui-tabbar__label">帮你选车</p>
        </a>
        <a href="#tab3" class="weui-tabbar__item">
          <p class="weui-tabbar__label">个人中心</p>
        </a>
      </div>
    </div>
    <router-view></router-view>
  </div>
</template>

<script type="text/ecmascript-6">
import temailist from 'components/temai/list';
import choice from 'components/choice/choice';
import usercenter from 'components/usercenter/usercenter';
export default {
  name: "App",
  data() {
    return {
      closeTabbarFlag: true
    };
  },
  methods: {
    closeTabbarP(data) {
      // console.log(data);
      this.closeTabbarFlag = data;
    }
  },
  watch: {
    closeTabbarFlag: {
      handler: function (val, oldVal) {
        this.closeTabbarFlag = val;
      },
      deep: true,
      immediate: true
    }
  },
  components: {
    temailist, choice, usercenter
  }
};
</script>

<style lang="stylus" rel="stylesheet/stylus">
// @import ('../static/css/temailist');
// @import ('../static/css/xuanche');
// @import ('../static/css/mine');
.weui-tab
  display: flex;
  .weui-tab__bd
    flex: 1;
    background: #f3f1f1;
  .weui-tabbar
    position: absolute;
    flex: 0;
    left: 0;
    bottom: 0;
    height: 60px;
    .weui-tabbar__label
      font-size: 18px;
      display: inline-block;
      position: relative;
      line-height: 18px;
      top: 48%;
      vertical-align: top;
      margin-top: -9px;
</style>
