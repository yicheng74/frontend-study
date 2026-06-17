<script setup>
    import{ ref } from 'vue';
    const formInline = ref({
        name: '',
        gender: '',
        date: '',
    })

    const search = () => {
        console.log(formInline.value);
    }

    const clear = () => {
        formInline.value = {name: '', gender: '', date: '',};
    }
</script>

<template>
    <h1>員工管理</h1>
    <div class="container">
        <el-form :inline="true" :model="formInline" class="demo-form-inline">
            <el-form-item label="name">
                <el-input v-model="formInline.name" placeholder="Approved by" />
            </el-form-item>
            <el-form-item label="gender">
                <el-select v-model="formInline.gender"placeholder="Activity zone"clearable>
                    <el-option label="male" value="1" />
                    <el-option label="female" value="2" />
                </el-select>
            </el-form-item>
            <el-form-item label="Activity time">
                <el-date-picker v-model="formInline.date" type="daterange" range-separator="To" start-placeholder="Start date" end-placeholder="End date" :size="size"/>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="search">Query</el-button>
                <el-button type="primary" @click="clear">Clear</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<style scoped>

</style>