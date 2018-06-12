<!--  -->
<template>
  <span :id="generateId()"></span>
</template>

<script type="text/javascript">
export default {
  props: {
    itemId: {
      type: Number,
      default: 10
    },
    // 毫秒数
    surplusTime: {
      type: Number,
      default: 60
    },
  },
  data() {
    return {
      _mss: this.surplusTime, // 毫秒数
      _timeFlag: false,
      ctr: "00天00时00分00秒",
      timer: []
    };
  },
  created() {
    this.$http.get("/api/topicItem/countdownTime").then(response => {
      var result = response.data;
      if (result.code === this.$error_code) {
        this._mss = result.data / 1000;
        this.$nextTick(() => {
          this.countdown(this._mss); //结束时间到开始时间的时间差，单位秒
        });
      }
    });
  },
  methods: {
    generateId() {
      return "time-countdown-wrapper_" + this.itemId;
    },
    countdown(mss) {
      var _that = this;
      let interval = setInterval(function() {
        var ctr = _that.fmtTime(mss);
        this.ctr = ctr;
        document.getElementById(_that.generateId()).innerHTML = ctr;
        if (!mss--) {
          clearInterval(interval);
        }
      }, 1000);
      this.timer.push(interval);
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
  destroyed() {
    //全部清除方法
    let that = this;
    for (let i in this.timer) {
      clearInterval(that.timer[i]);
    }
  }
};
</script>

<style scoped lang="stylus">
</style>
