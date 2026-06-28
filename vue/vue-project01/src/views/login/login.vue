<script setup>
    import { ref } from 'vue'
    import { ElMessage } from 'element-plus'
    import { useRouter} from 'vue-router'

    const loginForm = ref({
        username: '',
        password: '',
    })
    const router = useRouter();

    const login = async() => {
        const result = await loginApi(loginForm.value);
        if(result.code){
            ElMessage.success('success');
            router.push('/index')
        }
        else{
            ElMessage.error(result.msg);
        }
    }

    const clear = () => {
        loginForm.value = {username: '', password:''};
    }
</script>

<template>
    <div id="container">
        <div class="login-form">
            <el-form label-width="80px">
                <p class="title">hhhh</p>

                <el-form-item label="用戶名" prop="username">
                    <el-input v-model="loginForm.username" placeholder="請輸入用戶名"></el-input>
                </el-form-item>

                <el-form-item label="密碼" prop="password">
                    <el-input v-model="loginForm.password" placeholder="請輸入密碼"></el-input>
                </el-form-item>

                <el-form-item>
                    <el-button class="button" type="primary" @click="login">登錄</el-button>
                    <el-button class="button" type="primary" @click="clear">重置</el-button>
                </el-form-item>
            </el-form>
        </div>
    </div>
</template>

<style scoped>



</style>