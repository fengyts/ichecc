<template>
  <div id="test">
      index helloword!!!
      <span id="testJq"><a href="#">点击我</a></span>
  </div>
</template>
<script>
import $ from "jquery";
export default {
  name: "Index"
};
var _t = $("#test").text();
console.log(_t);
$.alert(_t);
$("#test").css("background", "red");
$("#testJq a").on("click", function() {
  alert("haha");
});
</script>

<style>
</style>

