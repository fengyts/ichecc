<!--  -->
<template>
  <!--个人中心-->
  <div id="tab3" class="weui-tab__bd-item">
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
        <p class="phone">未绑定手机 / 已绑定手机153*****678</p>
      </div>
    </div>

    <!--vip会员-->
    <a href="../../views/mine/vip/vipadd.html" class="href">
      <div class="vip">
        <div class="listicon">
          <img src="../../assets/images/icon/icon_nav_car.png" alt="" class="icon2">
        </div>
        <div class="title">
          <p>VIP会员</p>
        </div>
      </div>
    </a>
    <hr class="hr" />
    <!--身份认证-->
    <a href="./assets/views/mine/idconfirm.html" class="href">
      <div class="idconfirm">
        <div class="listicon">
          <img src="../../assets/images/icon/id.png" alt="" class="icon2">
        </div>
        <div class="title">
          <p>身份认证</p>
        </div>
      </div>
    </a>
    <!--砍价记录-->
    <a href="../../views/mine/kanjiarecord.html" class="href">
      <div class="kanjiarecord">
        <div class="listicon">
          <img src="../../assets/images/icon/kanjia.png" alt="" class="icon2">
        </div>
        <div class="title">
          <p>砍价记录</p>
        </div>
      </div>
    </a>
    <hr class="hr">
    <!--选车记录-->
    <a href="../../views/mine/xuancherecord.html" class="href">
      <div class="xuancherecord">
        <div class="listicon">
          <img src="../../assets/images/icon/xuanche.png" alt="" class="icon2">
        </div>
        <div class="title">
          <p>选车记录</p>
        </div>
      </div>
    </a>
    <!--常见问题-->
    <a href="../../views/mine/help.html" class="href">
      <div class="help">
        <div class="listicon">
          <img src="../../assets/images/icon/help.png" alt="" class="icon2">
        </div>
        <div class="title">
          <p>常见问题</p>
        </div>
      </div>
    </a>
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
</style>
