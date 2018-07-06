<!--  -->
<template>
  <div class="vipinfo" v-if="resData.vipInfo != undefined">
    <p class="notice">VIP会员详情</p>
    <p class="title">会员权益</p>
    <p class="content">{{resData.vipBenefit}}</p>
    <p class="title">有效期</p>
    <p class="content">剩余{{resData.vipInfo.expiryDate}}天</p>
    <p class="title">会员编号</p>
    <p class="content">{{resData.vipInfo.vipCardNo}}</p>
    <p class="title">注意事项</p>
    <p class="content">{{resData.vipNotice}}</p>
    <p class="bottom"></p>
  </div>
</template>

<script type="text/javascript">
export default {
  data() {
    return {
      resData: {}
    }
  },
  created() {
    this.$http.post("/api/vip/vipinfoDetail").then(res => {
      if (this.$resp_code === res.code) {
        this.resData = res.data;
      }
    });
  }
}
</script>

<style scoped lang="stylus">
@import ('../../../static/css/vipcardinfo');
</style>
