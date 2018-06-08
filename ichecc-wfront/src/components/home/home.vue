<!-- 特卖页 -->
<template>
  <div class="home" style="height:100%;">
    <div class="weui-tab">
      <!--页面内容-->
      <div class="weui-tab__bd" style="height:91%">
        <!-- 新车特卖 -->
        <!-- <temailist></temailist> -->
        <!--帮你选车-->
        <!-- <choice></choice> -->
        <!--个人中心-->
        <!-- <usercenter></usercenter> -->
        <router-view></router-view>
      </div>

      <!--底部导航-->
      <div class="weui-tabbar" style="height:9%;">
        <a href="#" class="weui-tabbar__item weui-bar__item--on">
          <p class="weui-tabbar__label">
            <router-link to="/home/list" tag="span">
              新车特卖
            </router-link>
          </p>
        </a>
        <a href="#" class="weui-tabbar__item weui-bar__item">
          <p class="weui-tabbar__label">
            <router-link to="/home/choice" tag="span">
              帮你选车
            </router-link>
          </p>
        </a>
        <a href="#" class="weui-tabbar__item weui-bar__item">
          <p class="weui-tabbar__label">
            <router-link to="/home/usercenter" tag="span">
              个人中心
            </router-link>
          </p>
        </a>
      </div>
    </div>
  </div>
</template>

<script type="text/javascript">
import temailist from "components/temai/list";
import choice from "components/choice/choice";
import usercenter from "components/usercenter/usercenter";
export default {
  props: {},
  data() {
    return {};
  },
  components: {
    temailist,
    choice,
    usercenter
  }
};
</script>

<style scoped lang="stylus">
// @import ('../../../static/css/weui.v1.1.2.min');
.weui-tab
  display: flex;
  .weui-tab__bd
    flex: 1;
    background: #f3f1f1;
  .weui-tabbar
    position: fixed;
    flex: 0;
    left: 0;
    bottom: 0;
    // height: 60px;
    .weui-tabbar__label
      font-size: 18px;
      display: inline-block;
      position: relative;
      line-height: 18px;
      top: 48%;
      vertical-align: top;
      margin-top: -9px;
</style>
