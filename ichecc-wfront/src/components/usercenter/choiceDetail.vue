<!--  -->
<template>
  <div class="detail">
    <p class="titile">选车需求</p>
    <p class="content">
      {{resData.choiceRequirement}}
    </p>
    <p class="titile">提交时间</p>
    <p class="content">{{resData.choiceOrderTime | formatDate('yyyy-MM-dd hh:mm:ss')}}</p>
    <p class="titile">选车状态</p>
    <p class="content2">{{resData.orderStatusDesc}}</p>
    <div v-show="resData.orderStatus === '02'">
      <p class="titile">完成时间</p>
      <p class="content">{{resData.handleTime | formatDate('yyyy-MM-dd hh:mm:ss')}}</p>
      <p class="titile">选车结果</p>
      <p class="content3">
        {{resData.result}}
      </p>
    </div>
    <div style="height:45px;"></div>
  </div>
</template>

<script type="text/javascript">
export default {
  props: {
    orderId: {
      type: String
    }
  },
  data() {
    return {
      resData: {}
    }
  },
  created() {
    this.$http.get("/api/choice/choiceOrderDetail", { params: { "orderId": this.orderId } }).then(response => {
      var result = response;
      if (result.code === this.$resp_code) {
        this.resData = result.data;
      }
    });
  }
}
</script>

<style scoped lang="stylus">
@import ('../../../static/css/xuanchedetail');
</style>
