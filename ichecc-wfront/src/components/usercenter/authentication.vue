<!--  -->
<template>
  <div class="authentication">

    <!--表单-->
    <div class="form">
      <div class="weui-cells__title">真实姓名</div>
      <div class="weui-cells">
        <div class="weui-cell">
          <div class="weui-cell__bd">
            <input class="weui-input" type="text" placeholder="请填写真实姓名">
          </div>
        </div>
      </div>

      <div class="weui-cells__title">身份证号</div>
      <div class="weui-cells">
        <div class="weui-cell">
          <div class="weui-cell__bd">
            <input class="weui-input" type="text" placeholder="请填写真实身份证号">
          </div>
        </div>
      </div>

      <div class="weui-cells__title">手机号码</div>
      <div class="weui-cells">
        <div class="weui-cell">
          <div class="weui-cell__bd">
            <input class="weui-input" type="text" placeholder="请填写真实手机号码">
          </div>
        </div>
      </div>

      <div class="weui-cells__title">居住地址</div>
      <div class="weui-cells">
        <div class="weui-cell">
          <div class="weui-cell__bd">
            <input class="weui-input" type="text" placeholder="请填写当前居住地址">
          </div>
        </div>
      </div>
    </div>

    <!--提交按钮-->
     <router-link :to="{path:'/authenticationDid'}">
      <div class="submit">
        <button class="button" id="idconfirm" onclick="">提交</button>
      </div>
     </router-link>

    <!--提示信息-->
    <div class="tips">
      <p>
        温馨提示：
      </p>
      <p>
        1、资料填写后不可更改，请确保资料填写真实准确。
      </p>
      <p>
        2、因资料有误而带来的一切损失，由用户自行承担。
      </p>
      <p>
        3、现场购车时，需提供与此处认证信息完全一致的身份证原件，经校验通过后，方能办理购车。
      </p>
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
  }
}
</script>

<style scoped lang="stylus">
@import ('../../../static/css/idconfirm');
</style>
