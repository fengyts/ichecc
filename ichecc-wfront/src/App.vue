<template>
  <div id="app" style="height:100%">
    <router-view></router-view>
  </div>
</template>

<script type="text/ecmascript-6">
import temailist from "components/temai/list";
import choice from "components/choice/choice";
import usercenter from "components/usercenter/usercenter";
export default {
  name: "App",
  data() {
    return {
      closeTabbarFlag: true
    };
  },
  methods: {
    closeTabbarP(data) {
      // console.log(data);
      this.closeTabbarFlag = data;
    }
  },
  watch: {
    closeTabbarFlag: {
      handler: function(val, oldVal) {
        this.closeTabbarFlag = val;
      },
      deep: true,
      immediate: true
    }
  },
  components: {
    temailist,
    choice,
    usercenter
  }
};
</script>

<style lang="stylus" rel="stylesheet/stylus">
</style>
