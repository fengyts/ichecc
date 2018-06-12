<!-- 特卖页 -->
<template>
  <!--新车特卖-->
  <div id="tab1" class="weui-tab__bd-item weui-tab__bd-item--active">
    <div>
      <!--头部区域-->
      <div class="xctm_top">
        <p class="xctm_top_title">本期特卖</p>
        <p class="xctm_top_time">期号 : H180404&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;时间 : 4.23 - 4.29</p>
      </div>

      <!--列表区域-->
      <div class="xctm_list">
        <router-link :to="{path:'/detail'}">

        <!-- <div class="xctm_list_href" @click="showDetail($event)"> -->
          <!--车辆图片-->
          <div class="xctm_list_img">
            <img src="../../assets/images/img/car_01.jpg" width="100%" alt="">
          </div>
      
          <!--车辆标题-->
          <div class="xctm_list_title">
            <p>上汽斯柯达明锐 2018款 1.6L 自动舒适版</p>
          </div>
          <!--车辆价格-->
          <div class="xctm_list_price">
            <p class="price">
              <span>指导价 : </span>
              <span class="price_num_zhidao">13.69万</span>
            </p>
            <p class="price">
              <span>市场价 : </span>
              <span class="price_num_shichang">10.69万</span>
            </p>
            <p class="price">
              <span>特卖价 : </span>
              <span class="price_num_temai">5.88万</span>
              <span class="xctm_list_canyu_num">578人正在参与</span>
            </p>
          </div>

        </router-link>
      </div>

      <!--尾部区域-->
      <div class="xctm_bottom">
        <p>- 没有更多了 -</p>
      </div>

    </div>
    <!-- <detail ref="detailC"></detail> -->
  </div>
</template>

<script type="text/javascript">
import detail from '../temai/detail';
export default {
  data() {
    return {
    };
  },
  methods: {
    showDetail(event) {
      // if (!event._constructed) {
      //   return;
      // }
      // this.$refs.detailC.show();
    }
  },
  components: {
    detail
  }
};
</script>

<style scoped lang="stylus">
@import ('../../../static/css/temailist');
</style>
