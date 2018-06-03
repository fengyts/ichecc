<!--  -->
<template>
  <div class="authentication">
    <div class="info">
      <p class="title">
        真实姓名
      </p>
      <p class="content">
        <input type="text" class="text" value=" 请填写真实姓名">
      </p>
      <p class="title">
        身份证号
      </p>
      <p class="content">
        <input type="text" class="text" value=" 请填写真实身份证号">
      </p>
      <p class="title">
        居住地址
      </p>
      <p class="content">
        <input type="text" class="text" value=" 请填写当前居住地址">
      </p>
    </div>
    <!--提交按钮-->
    <div class="submit">
      <button class="button" id="idconfirm" onclick="">提交</button>
    </div>

    <!--提示信息-->
    <div class="tips">
      <p>
        温馨提示：
      </p>
      <p>
        1、资料填写后不可更改，请确保资料填写真实准确。
      </p>
      <p>
        2、因资料有误给用户带来的一切损失，由用户自行承担。
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
