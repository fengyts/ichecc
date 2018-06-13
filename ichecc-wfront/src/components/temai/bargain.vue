<template>
  <div class="body" id="body">
    <!--蒙版-->
    <div class="share" id="share" @click="shutdown">
      <div class="sharearrow">
        <img src="../../assets/images/icon/sharearrow.png" alt="" class="arrow">
      </div>
      <div class="notice">
        <p class="content">
          还差<font style="color:#2aa515;font-size:22px">57244.46</font>元，点击右上角继续分享</p>
        <p class="content">喊好友帮你砍价吧~</p>
        <p class="content">（ 时间有限，要抓紧噢！）</p>
      </div>
    </div>
    <!--页面内容-->
    <div class="bargain">
      <!--图像区-->
      <div class="userinfo">
        <img src="../../assets/images/img/car_01.jpg" alt="" class="userimg">
        <p class="name">实心梨子</p>
      </div>
      <!--砍价信息区-->
      <div class="kanjia_info">
        <div class="kanjia_info2">
          <div class="kanjia_info_carimg">
            <img src="../../assets/images/img/car_01.jpg" class="carimg">
          </div>
          <div class="kanjia_info_carmess">
            <p>
              <font class="carmess_title">上汽斯柯达明锐 2018款 1.6L 自动舒适版</font>
              <font class="carmess_more">【免购置税，送保险，0首付】</font>
            </p>
            <p>
              <span>
                <font class="carmess_dijia">5.88万</font>&nbsp;
                <font class="carmess_shichangjia">13.69万</font>
                <font class="carmess_kanjianum">剩88次 / 限砍100次</font>
              </span>
            </p>
          </div>
        </div>
      </div>
      <!--中部-->
      <div class="kanjia_middle">
        <div class="kanjia_price">
          <p class="kanjia_price_des">已砍
            <font class="kanjia_price_num1">1555.54</font>元，还差
            <font class="kanjia_price_num2">57244.46</font>元</p>
          <p class="kanjia_guize">规则说明</p>
        </div>
        <div class="kanjia_button">
          <p>
            <button type="button" class="kanjia_button1" id="zijikan" onclick="">自己砍价</button>
          </p>
          <p>
            <!-- <router-link :to="{path:'/helpBargain'}">-->
            <button type="button" class="kanjia_button1" @click="shareFriends">喊好友帮忙砍价</button>
            <!--</router-link>-->
          </p>
        </div>
        <div class="kanjia_time">
          <span><img src="../../assets/images/icon/icon_time.png" class="kanjia_time_icon"></span>
          <span class="kanjia_time_num">&nbsp;18 : 26 : 59 . 008</span>
        </div>
      </div>
      <!--底部-->
      <div class="kanjia_bottom_title">
        <p class="kanjia_record_title1">砍价记录</p>
        <p class="kanjia_record_title2">（自己砍1次，好友共帮砍12次）</p>
      </div>
      <div class="kanjia_bottom_list">
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
      </div>

      <div class="tips">
      </div>
    </div>

  </div>
</template>
<script type="text/javascript">
export default {
  data() {
    return {

    }
  },
  components: {
  },
  methods: {
    shareFriends() {
      document.getElementById("share").style.display = "block";
      document.getElementById("body").style.position = "fixed";
    },
    shutdown() {
      document.getElementById("share").style.display = "none";
      document.getElementById("body").style.position = "absolute";
    }
  }
}
</script>

<style scoped lang="stylus">
@import ('../../../static/css/kanjia');
</style>
