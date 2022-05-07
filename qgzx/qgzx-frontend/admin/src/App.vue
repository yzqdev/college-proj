<template>
  <el-config-provider :locale="locale">
    <router-view></router-view>
  </el-config-provider>
</template>

<script>
import { ElConfigProvider } from "element-plus";
import zhCn from "element-plus/lib/locale/lang/zh-cn";
import { defineComponent } from "vue";
import {verify} from "@/utils/apis/admin";

export default defineComponent({
  name: "app",
  components: {
    [ElConfigProvider.name]: ElConfigProvider,
  },
  data() {
    return {
      locale: zhCn,
    };
  },
  created() {
    if (localStorage.getItem("token")) {

      this.$store.commit("setToken", localStorage.token);
      verify( ).then((res ) => {

        console.log(res)
      })
    }
  },
});
</script>

<style>
@import "./assets/css/main.css";
@import "./assets/css/color-dark.css"; /*深色主题*/
/*!*@import "./assets/css/theme-green/color-green.css";   浅绿色主题*!*/
</style>
