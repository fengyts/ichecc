<!--  -->
<template>
  <div class="time-countdown">
    倒计时：
    <div id="timehs"></div>
  </div>
</template>

<script type="text/javascript">
export default {
  props: {
    datetime: {
      type: Number
    }
  },
  data() {
    return {
      _mss: 0, // 毫秒数
      _timeFlag: false
    };
  },
  created() {
    this.$nextTick(() => {
      this.countdown(10); //结束时间到开始时间的时间差，单位秒
    });
  },
  methods: {
    countdown(mss) {}
  }
};
</script>

<style scoped lang="stylus">
</style>
