<script setup>
    import{ ref } from 'vue';

    const tableData = ref([
  {
    index: '1',
    name: 'Tom',
    updatetime: '2026-06-14 19:36',
  }])
</script>

<template>
    <h1>部门管理</h1>
    <div class="container">
        <el-button type="primary">+新增</el-button>
    </div>

    <div class="table">
        <el-table :data="tableData" border style="width: 100%">
            <el-table-column prop="index" label="序号" width="100" align="center"/>
            <el-table-column prop="name" label="部门名称" width="260" align="center"/>
            <el-table-column prop="updatetime" label="最后操作时间" width="300" align="center"/>
            <el-table-column label="操作">
                <template #default="scope">
                    <el-button size="small" @click="handleEdit(scope.$index, scope.row)">
                        Edit
                    </el-button>
                    <el-button size="small" type="danger" @click="handleDelete(scope.$index, scope.row)">
                         Delete
                    </el-button>
                </template>
            </el-table-column>
        </el-table>
    </div>
</template>

<style scoped>
    .container{
        margin: 10px 0px;
    }
</style>