<!--  -->
<template>
  <div class="temai-detail-wrapper" ref="detailWrapper">
    <div class="temai-detail">
      <div class="tmxq_top">
        <!--车辆图片-->
        <div class="tmxq_img">
          <img src="../../assets/images/img/car_01.jpg" width="100%" alt="">
          <div class="back" @click="closeDetail($event)">
            <i class="icon-arrow_lift"></i>
          </div>
        </div>

        <!--车辆标题-->
        <div class="tmxq_title">
          <p>上汽斯柯达明锐 2018款 1.6L 自动舒适版</p>
        </div>
        <!--车辆价格-->
        <div class="tmxq_price1">
          <p class="price">
            <span>指导价 : </span>
            <span>13.69万</span>
          </p>
          <p class="price">
            <span>市场价 : </span>
            <span>10.69万</span>
          </p>
        </div>
      </div>
      <div class="tmxq_middle">
        <!--特卖价，参与按钮-->
        <div class="tmxq_price2">
          <span>
            <font class="price_temai">特卖价 : </font>
            <font class="price_num_temai">5.58万</font>&nbsp;
            <font class="xianzhi">仅限1辆</font>
          </span>
          <span class="canyu">
            <!-- <button type="button" class="button_canyu" onclick="javascript:window.location.href='./kanjia.html'">立即参与</button> -->
            <router-link :to="{path:'/detail/bargain'}">
              <button class="button_canyu">立即参与</button>
            </router-link>
          </span>
        </div>
        <!--特卖说明-->
        <div>
          <hr class="hr" />
        </div>
        <div class="tmxq_notice">
          <p class="notice">免购置税：购置税全部由平台代为缴纳</p>
          <p class="notice">送保险：免费赠送第一年保险</p>
          <p class="notice">0首付：按揭购车可享0首付，最高可分60期</p>
        </div>
        <div>
          <div class="tmxq_bottom">
            <p>本期特卖剩 3天19时50分28秒 结束<br>(本期特卖已结束)</p>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script type="text/javascript">
import BScroll from 'better-scroll';
export default {
  props: {
  },
  data() {
    return {
      showFlag: false
    }
  },
  created() {
    this.$nextTick(() => {
      this._initScroll();
    });
  },
  methods: {
    _initScroll() {
      if (!this.scroll) {
        this.scroll = new BScroll(this.$refs.detailWrapper, {
          click: true
        });
      } else {
        this.scroll.refresh();
      }
    },
    show(){
      this.showFlag = true;
    },
    closeDetail(event) {
      if (!event._constructed) {
        // 防止pc端重复点击
        return;
      }
      // this.showFlag = false;
      // window.history.go(-1);
      this.$router.go(-1);
    }
  }
}
</script>

<style scoped lang="stylus">
@import ('../../../static/css/temaidetail');
.temai-detail-wrapper
  position: fixed;
  top: 0;
  bottom: 0;
  left: 0;
  z-index: 630;
  background: #fff;
  width: 100%;
</style>
