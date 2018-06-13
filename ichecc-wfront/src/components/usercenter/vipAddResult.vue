<!--  -->
<template>
  <div class="vipdid">
    <!--状态-->
    <div class="status">
      <p>加入VIP会员成功</p>
    </div>

    <!--明细-->
    <div class="vipinfo">
      <p>
        <span class="title">会员期限</span>
        <span class="content">30天</span>
      </p>
      <p>
        <span class="title">有效期剩</span>
        <span class="content">30天</span>
      </p>
      <p>
        <span class="title">支付金额</span>
        <span class="content">¥188.00</span>
      </p>
      <p>
        <span class="title">支付时间</span>
        <span class="content">2018-04-19 11:36:28</span>
      </p>
    </div>

    <!--完成-->
    <div class="did">
      <router-link :to="{path:'/list'}">
        <button class="button_did" onclick="">返回首页</button>
      </router-link>
      &nbsp;&nbsp;
      <router-link :to="{path:'/vip'}">
        <button class="button_did" onclick="">我的VIP</button>
      </router-link>
    </div>
  </div>
</template>

<script type="text/javascript">
export default {
  data() {
    return {

    }
  },
  components: {
  }
}
</script>

<style scoped lang="stylus">
@import ('../../../static/css/vipresult');
</style>
