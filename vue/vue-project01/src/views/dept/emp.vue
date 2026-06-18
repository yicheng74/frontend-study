<script setup>
    import{ ref, watch} from 'vue';
    const formInline = ref({
        name: '',
        gender: '',
        date: [],
        begin:'',
        end:'',
    })

    const search = () => {
        console.log(formInline.value);
    }

    const clear = () => {
        formInline.value = {name: '', gender: '', date: [], begin:'', end:'',};
    }

    watch(() => formInline.value.date, (newVal,oldVal) => {
        if(newVal.length == 2){
            formInline.value.begin = newVal[0];
            formInline.value.end = newVal[1];
        }else{
            formInline.value.begin = '';
            formInline.value.end = '';
        }
    })


    const tableData = ref([{
        name: 'choupi',
        gender: 1,
        image:'',
        dept:'臭屁部',
        job:'无',
        entry_date:'',
        updatetime:'',
    }])

    const currentPage = ref(4)
    const pageSize = ref(100)
    const background = ref(ture)
</script>

<template>
    <h1>員工管理</h1>

    <div class="button">
        <el-button type="primary" @click="">+add</el-button>
        <el-button type="danger" @click="">delete</el-button>
    </div>

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

    <div class="table">
        <el-table :data="tableData" border style="width: 100%">
            <el-table-column type="selection" width="55" align="center"/>
            <el-table-column prop="name" label="部门名称" width="260" align="center"/>
            <el-table-column prop="gender" label="性别" width="260" align="center">
                <template #default="scope">
                    {{ scope.row.gender == 1 ? '男' : '女' }}
                </template>
            </el-table-column>
            <el-table-column prop="image" label="图像" width="260" align="center"/>
            <el-table-column prop="dept" label="部门" width="260" align="center"/>
            <el-table-column prop="job" label="职位" width="260" align="center"/>
            <el-table-column prop="entry_date" label="入职时间" width="260" align="center"/>
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

    <div class="demo-pagination-block">
    <div class="demonstration">All combined</div>
    <el-pagination
      v-model:current-page="currentPage"
      v-model:page-size="pageSize"
      :page-sizes="[100, 200, 300, 400]"
      :background="background"
      layout="total, sizes, prev, pager, next, jumper"
      :total="400"
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
    />
  </div>
</template>

<style scoped>

</style>