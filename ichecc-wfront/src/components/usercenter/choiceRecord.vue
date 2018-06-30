<!--  -->
<template>
  <div class="records-wrapper" v-if="resData != undefined">
    <div class="choiceRecord" v-for="item in resData">
      <router-link :to="{path: '/choiceDetail/' + item.orderId}">
        <div class="list">
          <div class="href top">
            <span class="time">{{item.choiceOrderTime | formatDate('yyyy-MM-dd hh:mm:ss')}}</span>
            <span class="status">{{item.orderStatusDesc}}</span>
          </div>
          <div class="bottom">
            <p class="request">
              {{item.choiceRequirement}}
            </p>
          </div>
        </div>
      </router-link>
    </div>

    <div class="tips">
      <p>- 没有更多了 -</p>
    </div>
  </div>
</template>

<script type="text/javascript">
export default {
  data() {
    return {
      resData: []
    }
  },
  created() {
    this.$http.get("/api/choice/choiceOrderList").then(response => {
      var result = response;
      if (result.code === this.$resp_code) {
        this.resData = result.data;
      }
    });
  }
}
</script>

<style scoped lang="stylus">
@import ('../../../static/css/xuancherecord');
</style>
