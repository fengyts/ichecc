<template>
  <div class="body" id="body">

    <!--蒙版和二维码-->
    <div class="notice" id="notice" @click="shutDown">
      <div class="QRcode">
        <img src="../../assets/images/img/QRcode.png" alt="" class="QRCodeImg">
      </div>
      <div class="close">
        点击关闭
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
        </div>
        <div class="kanjia_guize">
          <div @click="guize" id="guize">规则说明</div>
        </div>
        <div class="kanjia_button">
          <p>
            <button type="button" class="kanjia_button1" @click="helpBargain" id="button1">帮TA砍价</button>
          </p>
          <p>
            <button type="button" class="kanjia_button2" @click="meToo" id="button2">我也要底价买车</button>
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
      </div>
      <div class="kanjia_bottom_list">
        <div class="kanjia_bottom_list_content">
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

        <div class="kanjia_bottom_list_content">
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

        
        <div class="kanjia_bottom_list_content">
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

        
        <div class="kanjia_bottom_list_content">
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


        
        <div class="kanjia_bottom_list_content">
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


        
        <div class="kanjia_bottom_list_content">
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

      </div>

        <div class="tips">
        <p>- 没有更多了 - </p>
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
    helpBargain() {
      $(document).on("click", "#button1", function () {
        $.toast("成功帮实心梨子砍掉888元", "text");
      });

      document.getElementById("button1").style.display = "none";
      document.getElementById("button2").style.display = "block";
    },

    meToo() {
      document.getElementById("notice").style.display = "block";
      document.getElementById("body").style.position = "fixed";
    },
    shutDown() {
      document.getElementById("notice").style.display = "none";
      document.getElementById("body").style.position = "absolute";
    },

    guize() {
      $(document).on("click", "#guize", function () {
        $.alert({
          title: '砍价规则说明',
          text: '1、在限砍次数内以及时间结束之前，最先将价格砍至特卖价的那位用户为砍价成功，此时砍价宣布结束，其余用户均砍价失败；' +
            '2、每次砍价，能砍掉的金额均为随机，能否砍价成功，全看用户的运气；' + '3、用户可以自己砍价，或者邀请好友帮忙砍价，邀的越多，砍价成功的概率越高；' +
            '4、砍价记录可在个人中心里查看，如果砍价成功，我们会尽快安排你到店购车。',
          onOK: function () {
            //点击确认
          }
        });
      });
    }

  }
}
</script>

<style scoped lang="stylus">
@import ('../../../static/css/bangkan');
</style>
