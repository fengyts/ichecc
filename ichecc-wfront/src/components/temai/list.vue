<!-- 特卖页 -->
<template>
  <!--新车特卖-->
  <div id="tab1" class="weui-tab__bd-item weui-tab__bd-item--active">
    <div class="list-content">
      <!--头部区域-->
      <div class="xctm_top">
        <p class="xctm_top_title">本期特卖</p>
        <p class="xctm_top_time">期号 : H180602&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;时间 : 4.23 - 4.29</p>
        <!--<p class="xctm_top_time" v-show="resData.periodNo!=''">期号 : {{resData.periodNo}}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;时间 : {{resData.startTime | formatDate}} ~ {{resData.endTime | formatDate}}</p>-->
      </div>

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

      <!--列表区域-->
      <!-- <div class="xctm_list" v-for="item in resData.itemList">
        <router-link :to="{path:'/detail'}">
          <div class="xctm_list_href">
            <div class="xctm_list_img">
              <img :src="item.picture" width="100%" alt="">
            </div>
            <div class="xctm_list_title">
              <p>{{item.itemTitle}}</p>
            </div>
            <div class="xctm_list_price">
              <p class="price">
                <span>指导价 : </span>
                <span class="price_num_zhidao">{{item.guidePrice | formatMoney}}万</span>
              </p>
              <p class="price">
                <span>市场价 : </span>
                <span class="price_num_shichang">{{item.marketPrice | formatMoney}}万</span>
              </p>
              <p class="price">
                <span>特卖价 : </span>
                <span class="price_num_temai">{{item.specialPrice | formatMoney}}万</span>
              </p>
            </div>
            <div class="xctm_list_canyu">
              <hr class="hr" />
              <p class="xctm_list_canyu_content">
                <span class="xctm_list_canyu_num">{{item.participationNum || "0"}}人已参与</span>
                <span class="xctm_list_canyu_time">剩
                  <span class="countdownTime">
                    <timecountdown :surplusTime="surplusTime" :itemId="item.tiId"></timecountdown>
                  </span>
                  结束
                </span>
              </p>
            </div>
          </div>
        </router-link>
      </div> -->

      <!--尾部区域-->
      <div class="xctm_bottom">
        <p>- 没有更多了 -</p>
      </div>

    </div>
  </div>
</template>

<script type="text/javascript">
import { formatDate } from "../../common/js/date.js";
import detail from "../temai/detail";
import timecountdown from "../other/time-countdown";
export default {
  data() {
    return {
      resData: {},
      surplusTime: 60,
      interval: ""
    };
  },
  filters: {
    formatDate: function (startTime) {
      var date = new Date(startTime);
      return formatDate(date, "M.dd");
    },
    formatMoney: function (money) {
      var fmt = money / 10000;
      return parseFloat(fmt).toFixed(2);
    }
  },
  created() {
    // this.$http.post("/api/index/itemList").then(response => {
    //   var result = response.data;
    //   if (result.code === this.$error_code) {
    //     this.resData = result.data;
    //     this.surplusTime = result.data.countDownTime / 1000;
    //     //倒计时
    //     this.$nextTick(() => {
    //       this.countdown(this.surplusTime); //结束时间到开始时间的时间差，单位秒
    //     });
    //   }
    // });
  },
  methods: {
    generateId(itemId) {
      return "time-countdown-wrapper" + itemId;
    },
    countdown(mss) {
      var _that = this;
      this.interval = setInterval(function () {
        var ctr = _that.fmtTime(mss);
        this.ctr = ctr;
        $(".countdownTime").each(function () {
          $(this).html(ctr);
        });
        if (!mss--) {
          clearInterval(_that.interval);
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
    }
  },
  components: {
    detail,
    timecountdown
  },
  destroyed() {
    //全部清除方法
    let that = this;
    clearInterval(that.interval);
  }
};
</script>

<style scoped lang="stylus">
@import ('../../../static/css/temailist');
#tab1
  padding-bottom: 36px;
  .list-content
    background: #f3f1f1;
</style>
