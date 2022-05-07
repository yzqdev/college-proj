<template>
  <div class="main-container">
    <el-container style="height: 100vh; border: 1px solid #eee">
      <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
        <el-menu router :default-active="actMenu">
          <el-submenu index="1">
            <template #title><i class="el-icon-message"></i>操作</template>
            <el-menu-item-group>
              <template #title>管理员操作</template>
              <el-menu-item index="/admin/admin-create"
                >编辑管理员</el-menu-item
              >
              <el-menu-item index="/admin/list">管理员列表</el-menu-item>
            </el-menu-item-group>

            <el-menu-item-group title="公告管理">
              <el-menu-item index="/notice/create">公告编辑</el-menu-item>
              <el-menu-item index="/notice/list">公告列表</el-menu-item>
            </el-menu-item-group>
            <el-menu-item-group title="职位管理">
              <el-menu-item index="/job/create">职位编辑</el-menu-item>
              <el-menu-item index="/job/list">职位列表</el-menu-item>
            </el-menu-item-group>
          </el-submenu>
          <el-submenu index="2">
            <template #title><i class="el-icon-message"></i>系统管理</template>
            <el-menu-item index="/user-manager">用户管理</el-menu-item>
            <el-menu-item index="/dictionary">字典管理</el-menu-item>
            <el-menu-item index="/resource-manager">资源管理</el-menu-item>
            <el-menu-item index="/auth-manager">权限管理</el-menu-item>
          </el-submenu>
        </el-menu>
      </el-aside>

      <div class="main-content">
        <header class="main-header">
          <div class="link-logo">logo</div>
          <div class="right-profile">
            <el-dropdown style="flex: 1; text-align: right">
              <span class="el-dropdown-link">
                下拉菜单<i class="el-icon-arrow-down el-icon--right"></i>
              </span>
              <template #dropdown>
                <el-dropdown-menu>
                  <el-dropdown-item>个人信息</el-dropdown-item>
                  <el-dropdown-item @click="logout">退出登录</el-dropdown-item>
                </el-dropdown-menu></template
              >
            </el-dropdown>
          </div>
        </header>

        <el-main>
          <router-view></router-view>
        </el-main>
      </div>
    </el-container>
  </div>
</template>
<script setup>
import {createRouter, useRoute, useRouter} from "vue-router";
import {ref, watch} from "vue";

const router = useRouter()
const route=useRoute()
const actMenu=ref('')
watch(route, (val,oldVal) => {
  /* ... */
   actMenu.value = val.path;
},{immediate:true})
// watch: {
//   $route: {
//     handler: function (newVal) {
//       this.actMenu = newVal.path;
//     },
//     immediate: true,
//   },
// },
function logout() {
  localStorage.clear()
  router.push({ name: "login" });
}
</script>
<style lang="less" scoped>
.main-container {
  .main-content {
    width: 100%;
    .main-header {
      display: flex;
      align-items: center;
      padding: 20px;
      .link-logo {
        cursor: pointer;
        &:hover {
          color: #2d8cf0;
        }
      }
      .right-profile {
        flex: 1;
        text-align: right;
        .el-dropdown-link {
          cursor: pointer;
          &:hover {
            color: #2d8cf0;
          }
        }
      }
    }
  }
}
</style>
