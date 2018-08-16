<template>
  <div class="body" id="body" v-if="resData.tiId != undefined">
    <!--蒙版-->
    <div class="share" id="share" @click="shutdown">
      <div class="sharearrow">
        <img src="../../assets/images/icon/sharearrow.png" alt="" class="arrow">
      </div>
      <div class="notice">
        <p class="content">
          还差
          <font style="color:#2aa515;font-size:22px">57244.46</font>元，发送给朋友</p>
        <p class="content">让大家一起帮你砍价吧~</p>
        <p class="content">（ 时间有限，要抓紧噢！）</p>
        <div class="close">
          点击关闭
        </div>
      </div>
    </div>

    <!--页面内容-->
    <div class="bargain">
      <!--图像区-->
      <div class="userinfo">
        <img :src="resData.headimgurl" alt="" class="userimg">
        <p class="name">{{resData.nickname}}</p>
      </div>
      <!--砍价信息区-->
      <div class="kanjia_info">
        <div class="kanjia_info2">
          <div class="kanjia_info_carimg">
            <img :src="resData.picture" class="carimg">
          </div>
          <div class="kanjia_info_carmess">
            <p>
              <font class="carmess_title">{{resData.itemTitle}}</font>
              <font class="carmess_more">【{{resData.subTitle}}】</font>
            </p>
            <p>
              <span>
                <font class="carmess_dijia">{{resData.guidePrice | formatMoney}}万</font>&nbsp;
                <font class="carmess_shichangjia">{{resData.marketPrice | formatMoney}}万</font>
                <font class="carmess_kanjianum">剩{{resData.residueTimes}}次 / 限砍{{resData.bargainMaxTimes}}次</font>
              </span>
            </p>
          </div>
        </div>
      </div>
      <!--中部-->
      <div class="kanjia_middle">
        <div class="kanjia_price">
          <p class="kanjia_price_des">已砍
            <font class="kanjia_price_num1">{{resData.alreadyBargainAmt||'0' | formatMoney('0')}}</font>元，还差
            <font class="kanjia_price_num2">{{resData.shortBargainAmt | formatMoney('0')}}</font>元</p>
        </div>
        <div class="kanjia_guize">
          <div @click="guize" id="guize">规则说明</div>
        </div>

        <div class="kanjia_button">
          <p>
            <button type="button" class="kanjia_button1" id="zijikan" @click="bargain">自己砍价</button>
          </p>
          <p>
            <!-- <router-link :to="{path:'/helpBargain'}">-->
            <button type="button" class="kanjia_button1" @click="shareFriends">喊好友帮忙砍价</button>
            <!--</router-link>-->
          </p>

          <!--测试好友帮砍-->
          <p>
            <router-link :to="{path:'/helpBargain'}">
              <button type="button" class="kanjia_button1" @click="">测试好友帮砍页面</button>
            </router-link>
          </p>

        </div>
        <div class="kanjia_time">
          <span><img src="../../assets/images/icon/icon_time.png" class="kanjia_time_icon"></span>
          <!-- <span class="kanjia_time_num">&nbsp;18 : 26 : 59 . 008</span> -->
          <span class="kanjia_time_num" id="time-countdown-wrapper">{{fmtTime(resData.countDownTime / 1000)}}</span>
        </div>
      </div>
      <!--底部-->
      <div class="bargain_records_wrapper" v-if="resData.recordVO != undefined">
        <div class="kanjia_bottom_title">
          <p class="kanjia_record_title1">砍价记录</p>
          <p class="kanjia_record_title2">（自己砍{{resData.recordVO.bargainCountSelf}}次，好友共帮砍{{resData.recordVO.bargainCountOther}}次）</p>
        </div>
        <div class="kanjia_bottom_list">
          <div class="kanjia_bottom_list_content" v-for="item in resData.recordVO.records">
            <div class="kanjia_bottom_list_userlogo">
              <img :src="item.headimgurl" class="logo" alt="">
            </div>
            <div class="kanjia_bottom_list_usermess">
              <p class="username">{{item.nickname}}</p>
              <p class="time">{{item.bargainTime | formatDate('MM-dd hh:mm:ss')}}</p>
            </div>
            <div class="kanjia_bottom_list_usernum">
              <span class="num">砍掉{{item.bargainAmount | formatMoney('0')}}元</span>
            </div>
          </div>

          <!-- <div class="kanjia_bottom_list_content">
            <div class="kanjia_bottom_list_userlogo">
              <img src="../../assets/images/img/car_01.jpg" class="logo" alt="">
            </div>
            <div class="kanjia_bottom_list_usermess">
              <p class="username">旗嘉科技</p>
              <p class="time">04-10 10:50:29.123</p>
            </div>
            <div class="kanjia_bottom_list_usernum">
              <span class="num">砍掉888.66元</span>
            </div>
          </div> -->
        </div>
      </div>

      <div class="tips">
        <p>- 没有更多了 - </p>
      </div>
    </div>

  </div>
</template>
<script type="text/javascript">
import timeCountdown from 'components/other/timeCountdown';
export default {
  data() {
    return {
      resData: {},
      interval: ""
    }
  },
  created() {
    this.$http.get("/api/bargain/participationHiggle", { 'tiId': this.$route.params.tiId }).then(res => {
      if (res.code === this.$resp_code) {
        this.resData = res.data;
        this.$nextTick(() => {
          if(res.data.progress === '01'){
            this.countdown(result.data.countDownTime / 1000);
          }
        });
      }
    });
  },
  methods: {
    bargain() {
      $(document).on("click", "#zijikan", function () {
        $.toast("恭喜！成功砍掉888元", "text");
      });
    },

    shareFriends() {
      document.getElementById("share").style.display = "block";
      document.getElementById("body").style.position = "fixed";
    },
    shutdown() {
      document.getElementById("share").style.display = "none";
      document.getElementById("body").style.position = "absolute";
    },

    guize() {
      let _that = this;
      $.alert({
        title: '砍价规则说明',
        // text: '1、在限砍次数内以及时间结束之前，最先将价格砍至特卖价的那位用户为砍价成功，此时砍价宣布结束，其余用户均砍价失败；' +
        //   '2、每次砍价，能砍掉的金额均为随机，能否砍价成功，全看用户的运气；' + '3、用户可以自己砍价，或者邀请好友帮忙砍价，在规定时间内，砍价次数越多，砍价成功的概率越高；' +
        //   '4、砍价记录可在个人中心里查看，如果砍价成功，我们会尽快安排你到店购车。',
        text: _that.resData.bargainRules,
        onOK: function () {
          //点击确认
        }
      });
    },

    countdown(mss) {
      if (!mss) {
        document.getElementById("time-countdown-wrapper").innerHTML = "00天00时00分00秒"
      }
      var _that = this;
      var itv = setInterval(function () {
        var ctr = _that.fmtTime(mss);
        ctr = ctr == undefined ? "" : ctr;
        document.getElementById("time-countdown-wrapper").innerHTML = ctr;
        if (!mss--) {
          clearInterval(itv);
        }
      }, 1000);
      this.interval = itv;
    },
    // fmt: 1-时分秒格式,eg:01天10时11分31秒，默认格式，可缺省；0-冒号格式：10:11:31
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
    timeCountdown
  },
  destroyed() {
    clearInterval(this.interval);
  }
}
</script>

<style scoped lang="stylus">
@import ('../../../static/css/kanjia');
</style>
