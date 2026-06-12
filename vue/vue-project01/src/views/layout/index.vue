<script setup>
  import { EditPen, SwitchButton } from '@element-plus/icons-vue'
  import { StarFilled, HomeFilled} from '@element-plus/icons-vue'
</script>


<template>
  <div class="common-layout">
    <el-container>
        <el-header class="header">
            <span class="title">Tlias智能学习辅助系统</span>
            <span class="right_tool">
                <a href="">
                    <el-icon><EditPen /></el-icon> 修改密码 &nbsp;&nbsp;&nbsp; | &nbsp;&nbsp;&nbsp; 
                </a>

                <a href="">
                    <el-icon><SwitchButton /></el-icon> 退出登录
                </a>
            </span>
        </el-header>

        <el-container>
            <el-aside width="200px" class="aside">
                <el-menu router>
                    <el-menu-item index="/index">
                        首页
                    </el-menu-item>
                    

                    <el-sub-menu index="1">
                        <template #title>
                            <el-icon><HomeFilled /></el-icon>班級學員管理
                        </template>
                        <el-menu-item index="1-1"><el-icon><StarFilled /></el-icon>班級管理</el-menu-item>
                        <el-menu-item index="1-2"><el-icon><StarFilled /></el-icon>學員管理</el-menu-item>
                    </el-sub-menu>
                </el-menu>
            </el-aside>

            <el-main>
                右侧内容区域
            </el-main>
        </el-container>
    </el-container>
  </div>
</template>

<style scoped>
    .header{
        background-image: linear-gradient(to right, #00547d, #007fa4, #00aaa0, #00d072, #a8eb12);
        display: flex;
        justify-content: space-between;
        align-items: center;
    }

    .title{
        color: white;
        font-size: 40px;
        font-family: 楷体;
        line-height: 60px;
        font-weight: bolder;
    }

    .common-layout {
    height: 100vh;
    }
</style>