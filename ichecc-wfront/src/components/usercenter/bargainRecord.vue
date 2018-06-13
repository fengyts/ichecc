<!--  -->
<template>
  <div class="bargainRecord">
    <router-link :to="{path:'/bargainDetail'}">
      <div class="list">
      
          <div class="record">
            <div class="left">
              <img src="../../assets/images/img/car_01.jpg" class="img">
            </div>
            <div class="right">
              <p class="title">
                东风本田思域 2016款 220TURBO CVT豪华版
              </p>
              <p class="status">
                <span class="success">砍价成功</span>
                <span class="time">有效期至：2018-06-30</span>
              </p>
            </div>
          </div>    
      </div>
     </router-link>

    <div class="tips">
      <span>~ 没有更多了 ~</span>
    </div>
  </div>
</template>

<script type="text/javascript">
export default {
  data() {
    return {

    }
  }
}
</script>

<style scoped lang="stylus">
@import ('../../../static/css/kanjiarecord');
</style>
