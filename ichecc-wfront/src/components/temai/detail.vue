<!--  -->
<template>
  <div class="temai-detail-wrapper" ref="detailWrapper" v-if="resData.detail != undefined">
    <div class="temai-detail">
      <div class="tmxq_top">
        <!--车辆图片-->
        <div class="tmxq_img">
          <img :src="resData.detail.picture" width="100%" alt="">
          <div class="back" @click="goback($event)">
            <i class="icon-arrow_lift"></i>
          </div>

          <div class="time">
            <div class="time_bg">
            </div>
            <div class="time_content">
              <span v-if="resData.detail.status === '02'">剩
                <span id="time-countdown-wrapper">{{fmtTime(resData.countDownTime / 1000)}}</span> 结束</span>
              <span v-else>已结束</span>
            </div>
          </div>

        </div>

        <!--车辆标题-->
        <div class="tmxq_title">
          <p>{{resData.detail.itemTitle}}</p>
        </div>
        <!--车辆价格-->
        <div class="tmxq_price1">
          <p class="price">
            <span>指导价 : </span>
            <span>{{resData.detail.guidePrice | formatMoney}}万</span>
          </p>
          <p class="price">
            <span>市场价 : </span>
            <span>{{resData.detail.marketPrice | formatMoney}}万</span>
          </p>
        </div>
      </div>
      <div class="tmxq_middle">
        <!--特卖价-->
        <div class="tmxq_price2">
          <span class="price_canyu">
            <font class="price_temai">特卖价 : </font>
            <font class="price_num_temai">{{resData.detail.specialPrice | formatMoney}}万</font>&nbsp;
            <font class="xianzhi">&nbsp;仅限1辆&nbsp;</font>
          </span>
        </div>
        <!--特卖说明-->
        <div>
          <hr class="hr" />
        </div>
        <div class="tmxq_notice">
          <p class="notice" v-for="item in resData.attrs">
            {{item}}
          </p>
        </div>
      </div>

      <!-- query只能用path来引入，params只能用name来引入，
        接收参数都是类似的，分别是this.$route.query.name和this.$route.params.name
        注意接收参数的时候，已经是$route而不是$router -->
      <router-link :to="{name:'carDescribe', params:{itemId : resData.detail.itemId}}">
        <div class="tmxq_jieshao">
          <p class="jieshao">查看车型介绍</p>
        </div>
      </router-link>

      <div class="tmxq_bottom">
        <p>- 没有更多了 -</p>
      </div>

    </div>

    <!--立即参与按钮-->
    <div class="canyu">
      <router-link :to="{path:'/bargain'}">
        <button class="button_canyu">立即参与</button>
      </router-link>
    </div>

  </div>
</template>

<script type="text/javascript">
import BScroll from "better-scroll";
export default {
  data() {
    return {
      resData: {},
      interval: ""
    };
  },
  created() {
    this.$http
      .get("/api/topicItem/itemDetail/" + this.$route.params.tiId)
      .then(response => {
        let result = response.data;
        if (this.$error_code === result.code) {
          this.resData = result.data;
          this.$nextTick(() => {
            this.countdown(result.data.countDownTime / 1000);
            this._initScroll();
          });
        }
      });
  },
  methods: {
    countdown(mss) {
      var _that = this;
      this.interval = setInterval(function() {
        var ctr = _that.fmtTime(mss);
        document.getElementById("time-countdown-wrapper").innerHTML = ctr;
        if (!mss--) {
          clearInterval(this.interval);
        }
      }, 1000);
    },
    fmtTime(mss) {
      var ss = 1,
        mi = ss * 60,
        hh = mi * 60,
        dd = hh * 24;
      var _days = Math.floor(mss / dd);
      var _hours = Math.floor((mss % dd) / hh);
      var _minutes = Math.floor((mss % hh) / mi);
      var _seconds = Math.floor((mss % mi) / ss);

      if (_days == 0) {
        _days = "";
      } else if (_days > 0 && _days < 10) {
        _days = "0" + _days + "天";
      } else {
        _days += "天";
      }

      if (_hours < 10) {
        _hours = "0" + _hours;
      }
      if (_minutes < 10) {
        _minutes = "0" + _minutes;
      }
      if (_seconds < 10) {
        _seconds = "0" + _seconds;
      }

      var ctr = `${_days}${_hours}时${_minutes}分${_seconds}秒`;
      return ctr;
    },
    _initScroll() {
      if (!this.scroll) {
        this.scroll = new BScroll(this.$refs.detailWrapper, {
          click: true
        });
      } else {
        this.scroll.refresh();
      }
    },
    goback(event) {
      // 防止pc端重复点击
      if (!event._constructed) {
        return;
      }
      this.$router.go(-1);
    }
  },
  destroyed() {
    clearInterval(this.interval);
  }
};
</script>

<style scoped lang="stylus">
@import ('../../../static/css/temaidetail');
.temai-detail-wrapper
  position: fixed;
  top: 0;
  bottom: 0;
  left: 0;
  z-index: 630;
  background: #f3f1f1;
  width: 100%;
</style>
