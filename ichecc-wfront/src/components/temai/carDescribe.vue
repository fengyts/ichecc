<!--  -->
<template>
  <div>
    <!--大标题-->
    <div class="cxms_top">
      <p class="title">车型图片及配置</p>
      <p class="title2">（仅供参考，请以实车为准）</p>
    </div>
    <!--车型图片-->
    <div class="cxms_img" id="description">
      <!-- <img src="../../assets/images/img/car_01.jpg" width="100%" alt="" class="img">
      <img src="../../assets/images/img/car_01.jpg" width="100%" alt="" class="img">
      <img src="../../assets/images/img/car_01.jpg" width="100%" alt="" class="img">
      <img src="../../assets/images/img/car_01.jpg" width="100%" alt="" class="img"> -->
      <!-- {{description}} -->
    </div>
    <!--底部提示-->
    <div class="cxms_tips">
      <p>图片均来源于网络</p>
      <p>如有侵权，请联系我们删除</p>
    </div>
  </div>
</template>

<script type="text/javascript">
export default {
  data() {
    return {
      description: ""
    };
  },
  created() {
    this.$axios
      .get("/api/topicItem/itemDesc/" + this.$route.params.itemId)
      .then(response => {
        let result = response.data;
        if (this.$resp_code === result.code) {
          this.description = result.data;
          this.$nextTick(() => {
            document.getElementById("description").innerHTML = result.data;
            $("img").css("width", "100%");
          });
        }
      });
  }
};
</script>

<style scoped lang="stylus">
@import ('../../../static/css/cardescribe');
</style>
