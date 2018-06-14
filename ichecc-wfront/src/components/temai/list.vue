<!-- 特卖页 -->
<template>
  <!--新车特卖-->
  <div id="tab1" class="weui-tab__bd-item weui-tab__bd-item--active">
    <div class="list-content">
      <!--头部区域-->
      <div class="xctm_top">
        <p class="xctm_top_title">本期特卖</p>
        <!-- <p class="xctm_top_time">期号 : H180602&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;时间 : 4.23 - 4.29</p> -->
        <p class="xctm_top_time" v-show="resData.periodNo!=''">期号 : {{resData.periodNo}}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 时间 : {{resData.startTime | formatDate}} - {{resData.endTime | formatDate}}</p>

      </div>

      <!--列表区域-->
      <div class="xctm_list" v-for="item in resData.itemList">
        <router-link :to="{path:'/detail/' + item.tiId}">
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
              <span class="xctm_list_canyu_num">{{item.participationNum || "0"}}人正在参与</span>
            </p>
          </div>
        </router-link>
      </div>

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
export default {
  data() {
    return {
      resData: {}
    };
  },
  filters: {
    formatDate: function(startTime) {
      var date = new Date(startTime);
      return formatDate(date, "M.dd");
    },
    formatMoney: function(money) {
      var fmt = money / 10000;
      return parseFloat(fmt).toFixed(2);
    }
  },
  created() {
    this.$http.get("/api/index/itemList").then(response => {
      var result = response.data;
      if (result.code === this.$error_code) {
        this.resData = result.data;
      }
    });
  },
  methods: {},
  components: {
    detail
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
