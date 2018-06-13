<!--  -->
<template>
  <div class="choiceRecord">
      <router-link :to="{path:'/choiceDetail'}"> 
        <div class="list">
            <div class="href top">
              <span class="time">2018-04-26 16:29:58</span>
              <span class="status">处理中</span>
            </div>
            <div class="bottom">
              <p class="request">
                15-25万，合资品牌，SUV，5座，自动档，不考虑日本车，意向品牌大众、别克，空间大，后备箱大，全景天...
              </p>
            </div>
        </div>
      </router-link>

    <div class="tips">
      <p>- 没有更多了 -</p>
    </div>
  </div>
</template>

<script type="text/javascript">
export default {
  data() {
    return {

    }
  }
}
</script>

<style scoped lang="stylus">
@import ('../../../static/css/xuancherecord');
</style>
