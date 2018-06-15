<!-- 用户中心 -->
<template>
  <!--个人中心-->
  <div id="tab3" class="weui-tab__bd-item" style="display:inline">
    <!--个人资料-->
    <div class="userinfo">
      <div class="usericon">
        <img src="../../assets/images/img/car_01.jpg" alt="" class="icon1">
      </div>
      <div class="username">
        <p>
          <span>实心梨子</span>
          <span class="viplogo"><input type="text" value="VIP" class="vipbg"></span>
        </p>
        <p class="tips">未进行身份认证 / 身份已认证</p>
      </div>
    </div>

    <!--vip会员-->
    <router-link :to="{path:'/vip'}">
      <div class="href vip">
        <div class="listicon">
          <img src="../../assets/images/icon/icon_nav_car.png" alt="" class="icon2">
        </div>
        <div class="title">
          <p>
            VIP会员
          </p>
        </div>
      </div>
    </router-link>

    <hr class="hr" />

    <!--身份认证-->
    <router-link :to="{path:'/authentication'}">
      <div class="href idconfirm">
        <div class="listicon">
          <img src="../../assets/images/icon/id.png" alt="" class="icon2">
        </div>
        <div class="title">
          <p>身份认证</p>
        </div>
      </div>
    </router-link>

    <!--砍价记录-->
    <router-link :to="{path:'/bargainRecord'}">
      <div class="href kanjiarecord">
        <div class="listicon">
          <img src="../../assets/images/icon/kanjia.png" alt="" class="icon2">
        </div>
        <div class="title">
          <p>砍价记录</p>
        </div>
      </div>
    </router-link>

    <hr class="hr" />

    <!--选车记录-->
    <router-link :to="{path:'/choiceRecord'}">
      <div class="href xuancherecord">
        <div class="listicon">
          <img src="../../assets/images/icon/xuanche.png" alt="" class="icon2">
        </div>
        <div class="title">
          <p>选车记录</p>
        </div>
      </div>
    </router-link>

    <!--常见问题-->
    <router-link :to="{path:'/help'}">
      <div class="href help">
        <div class="listicon">
          <img src="../../assets/images/icon/help.png" alt="" class="icon2">
        </div>
        <div class="title">
          <p>常见问题</p>
        </div>
      </div>
    </router-link>

    <router-view></router-view>
  </div>
</template>

<script type="text/javascript">
import Vue from "vue";
export default {
  props: {
  },
  data() {
    return {};
  },
};
</script>

<style scoped lang="stylus">
@import ('../../../static/css/mine');
#tab3
  display: flex;
</style>
