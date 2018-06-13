<!--  -->
<template>
  <div>
    <div class="content">
      <div class="title">
        <p>VIP会员介绍</p>
      </div>
      <P class="quanyi">
        会员权益
      </P>
      <P class="quanyides">
        会员权益详细说明会员权益详细说明会员权益详细说明会员权益详细说明会员权益详细说明会员权益详细说明 会员权益详细说明会员权益详细说明会员权益详细说明会员权益详细说明会员权益详细说明会员权益详细说明
      </P>
      <P class="notice">
        注意事项
      </P>
      <P class="noticedes">
        注意事项详细说明注意事项详细说明注意事项详细说明注意事项详细说明注意事项详细说明注意事项详细说明注意事项详细说明注意事项详细说明
      </P>
    </div>
    <!--加入按钮-->
    <div class="addvip">
      <router-link :to="{path:'/vipAddPay'}">
        <button class="button_add" id="addvip" onclick="">加入VIP</button>
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
@import ('../../../static/css/vipadd');
</style>
