<!--  -->
<template>
<div>
        <div class="title">
            <p>请选择续费期限并支付</p>
            <hr class="hr">
        </div>
        <div class="vipinfo">
            <div class="line1">
                <div class="one">
                    <p class="price_num_checked">¥8.80</p>
                    <p class="viptype_checked">1天</p>                   
                </div>
                <div class="three">
                    <p class="price_num">¥18.80</p>
                    <p class="viptype">7天</p>
                    <div class="tuijian">
                        <span>&nbsp;推荐&nbsp;</span>
                    </div>
                </div>
            </div>
            <div class="line2">
                <div class="six">
                    <p class="price_num">¥188.00</p>
                    <p class="viptype">30天</p> 
                </div>
                <div class="twelve">
                    <p class="price_num">¥198.00</p>
                    <p class="viptype">90天</p>
                    <div class="tuijian">
                        <span>&nbsp;超值&nbsp;</span>
                    </div>
                </div>
            </div>
        </div>
        <!--支付按钮-->
        <div class="vippay">
            <button class="button_pay" id="viprenewpay" onclick="">立即支付</button>
        </div>
        <!--说明-->
        <div class="tips">
            <p>
                续费期限从原来有效期的最后一天往后累加
            </p>
            <p>
                支付成功后不支持退款
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
@import ('../../../static/css/viprenewpay');
</style>
