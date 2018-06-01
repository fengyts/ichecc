<!-- 选车页 -->
<template>
  <!--帮你选车-->
  <div id="tab2" class="weui-tab__bd-item">
    <!--表单-->
    <div class="form">
      <div class="weui-cells__title">购车预算</div>
      <div class="weui-cells">
        <div class="weui-cell">
          <div class="weui-cell__bd">
            <input class="weui-input" type="text" placeholder="请输入预算金额（万元）">
          </div>
        </div>
      </div>
      <div class="weui-cells__title">品牌类型</div>
      <div class="weui-cells">
        <div class="weui-cell">
          <div class="weui-cell__bd">
            <input id="pinpai" class="weui-input" type="text" placeholder="请选择品牌类型" onclick="select();" readonly>
          </div>
        </div>
      </div>
      <div class="weui-cells__title">能源类型</div>
      <div class="weui-cells">
        <div class="weui-cell">
          <div class="weui-cell__bd">
            <input id="nengyuan" class="weui-input" type="text" placeholder="请选择能源类型" onclick="select();" readonly>
          </div>
        </div>
      </div>
      <div class="weui-cells__title">车辆类型</div>
      <div class="weui-cells">
        <div class="weui-cell">
          <div class="weui-cell__bd">
            <input id="jibie" class="weui-input" type="text" placeholder="请选择车辆类型" onclick="select();" readonly>
          </div>
        </div>
      </div>
      <div class="weui-cells__title">座位数量</div>
      <div class="weui-cells">
        <div class="weui-cell">
          <div class="weui-cell__bd">
            <input id="zuowei" class="weui-input" type="text" placeholder="请选择座位数量" onclick="select();" readonly>
          </div>
        </div>
      </div>
      <div class="weui-cells__title">车型结构</div>
      <div class="weui-cells">
        <div class="weui-cell">
          <div class="weui-cell__bd">
            <input id="jiegou" class="weui-input" type="text" placeholder="请选择车型结构" onclick="select();" readonly>
          </div>
        </div>
      </div>
      <div class="weui-cells__title">变速箱类型</div>
      <div class="weui-cells">
        <div class="weui-cell">
          <div class="weui-cell__bd">
            <input id="biansuxiang" class="weui-input" type="text" placeholder="请选择变速箱类型" onclick="select();" readonly>
          </div>
        </div>
      </div>
      <div class="weui-cells__title">其他需求</div>
      <div class="weui-cells weui-cells_form">
        <div class="weui-cell">
          <div class="weui-cell__bd">
            <textarea class="weui-textarea" placeholder="请输入具体的购车需求" rows="3"></textarea>
            <div class="weui-textarea-counter">
              <span>0</span>/200</div>
          </div>
        </div>
      </div>
    </div>
    <!--提交按钮-->
    <div class="submit">
      <button class="button" id="submit" onclick="modal();">提交</button>
    </div>
    <!--提示信息-->
    <div class="tips">
      将在24小时内处理您的需求
    </div>
  </div>
</template>

<script type="text/javascript">
import Vue from "vue";
export default {
  props: {
  },
  data() {
    return {};
  },
};
</script>

<style scoped lang="stylus">
@import ('../../../static/css/xuanche');
</style>
