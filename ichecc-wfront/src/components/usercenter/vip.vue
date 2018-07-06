<!--  -->
<template>
  <div v-if="resData.userId != undefined">
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
          <span>{{resData.vipCardNo}}</span>
        </div>
      </div>
      <div class="bottom">
        <span>
          剩余{{resData.expiryDate}}天
        </span>
      </div>
    </div>

    <hr class="hr">

    <!--操作-->
    <div class="vipinfo">
      <!-- <a href="../../mine/vip/vipcardinfo.html" class="href">-->
      <router-link :to="{path:'/vipCardInfo'}">
        <p class="cardinfo">会员卡详情</p>
      </router-link>
      <!--</a>-->
      <hr class="hr2">
      <!--<a href="../../mine/vip/viprenewpay.html" class="href">-->
      <router-link :to="{path:'/vipRenewPay'}">
        <p class="renew">续费</p>
      </router-link>
      <!--</a>-->
      <hr class="hr2">
    </div>
  </div>
</template>

<script type="text/javascript">
import Vue from "vue";
export default {
  data() {
    return {
      resData: {}
    };
  },
  created() {
    this.$http.post("/api/vip/vipinfo").then(res => {
      if (this.$resp_code === res.code) {
        this.resData = res.data;
      }
    });
  }
};
</script>

<style scoped lang="stylus">
@import ('../../../static/css/vip');
</style>
