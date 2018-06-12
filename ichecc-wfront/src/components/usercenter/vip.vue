<!--  -->
<template>
<div>
<!--vip卡片-->
    <div class="vipcard">
        <div class="top">
            <div class="viplogo">
                <img src="../../assets/images/icon/icon_viplogo.png" class="logo">
            </div>
            <div class="vipname">
                <p>哈罗买车</p>
                <p class="vipname2">VIP会员卡</p>
            </div>
            <div class="vipno">
                <span>69500698</span>
            </div>
        </div>
        <div class="bottom">
            <span>
                剩余38天 
            </span>
        </div>
    </div>

    <hr class="hr">

    <!--操作-->
    <div class="vipinfo">
       <!-- <a href="../../mine/vip/vipcardinfo.html" class="href">-->
         <router-link :to="{path:'./vipCardInfo'}">
            <p>会员卡详情</p>
         </router-link>
        <!--</a>-->
        <hr class="hr2">
        <!--<a href="../../mine/vip/viprenewpay.html" class="href">-->
          <router-link :to="{path:'./vipRenewPay'}">
            <p>续费</p>
          </router-link>
        <!--</a>-->
        <hr class="hr2">
    </div>
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
@import ('../../../static/css/vip');
</style>
