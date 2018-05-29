<template>
  <div id="app">
    <!-- <img src="./assets/logo.png"> -->
    <!-- <router-view/> -->
    <v-header></v-header>
    <div class="tab">
      <div class="tab-item">
        <router-link to="/home">首页</router-link>
      </div>
      <div class="tab-item">
        <router-link to="/choice">选车</router-link>
      </div>
      <div class="tab-item">
        <router-link to="/usercenter">我的</router-link>
      </div>
    </div>
    <router-view></router-view>
  </div>
</template>

<script>
import header from 'components/header';
export default {
  name: 'App',
  components: {
    'v-header': header
  }
}
</script>

<style lang="stylus" rel="stylesheet/stylus">
.tab
  position: fixed;
  bottom: 0;
  display: flex;
  height: 40px;
  line-height: 40px;
  width: 100%;
  .tab-item
    flex: 1;
    text-align: center;
    & > a
      display: block;
      font-size: 14px;
      color: rgb(77, 85, 93);
      &.active
        color: rgb(240, 20, 20);
        background: #eaeaea;
</style>
