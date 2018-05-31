<template>
  <div id="app" style="height:100%">
    <div class="weui-tab">
      <!--页面内容-->
      <div class="weui-tab__bd" style="height:91%">
        <!--新车特卖-->
        <temailist></temailist>
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
    };
  },
  components: {
    temailist, choice, usercenter
  }
};
</script>

<style lang="stylus" rel="stylesheet/stylus">
@import ('../static/css/temailist');
@import ('../static/css/xuanche');
@import ('../static/css/mine');
</style>
