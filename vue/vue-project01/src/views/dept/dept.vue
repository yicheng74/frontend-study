<script setup>
    import{ ref } from 'vue';
    import { ElMessage } from 'element-plus'

    const tableData = ref([
    {
        index: '1',
        name: 'Tom',
        updatetime: '2026-06-14 19:36',
    }])


    const dialogFormVisible = ref(false)
    const dept = ref({name:''})
    const formTitle = ref('')
    /*const save = async() => {
        if(!deptFormRef.value) return;
        deptFormRef.value.validate(async(valid)=>{
            if(valid)
            {   
                let result;
                if(dept.value.id)
                {
                    result = await updateapi(dept.value);
                }
                else
                {
                    result = await addApi(dept.value);
                }


                if(result.code)
                {
                    ElMessage.success('good');
                    dialogFormVisible.value = false;
                }
                else
                {
                    ElMessage.success('老哥为臭屁')
                }
            }
            else{

            }
        })
    }*/
    const addDept = () => {
        dialogFormVisible.value = true;
        formTitle.value= '新增部门';
        dept.value = {name:''};
        if (deptFormRef.value){
            deptFormRef.value.resetFields();
        }
       
    }

    const rules = ref({
        name: [
            { required: true, message: 'Please input Activity name', trigger: 'blur' },
            { min: 2, max: 10, message: 'Length should be 2 to 10', trigger: 'blur' },
    ]})

    const deptFormRef = ref()



    /*const handleEdit = async(id) => {
        const result = await quierybyid(id);
        if (deptFormRef.value){
            deptFormRef.value.resetFields();
        }
        if(result.code){
            dialogFormVisible.value = true;
            dept.value = result.data;
            formTitle.value = 'xgbm';
        }
    }*/
    
    
</script>

<template>
    <h1>部门管理</h1>
    <div class="container">
        <el-button type="primary" @click="addDept">+新增</el-button>
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

    <el-dialog v-model="dialogFormVisible" title="formTitle" width="500">
        <el-form :model="dept" :rules="rules" ref="deptFormRef">
            <el-form-item label="部门名称" :label-width="formLabelWidth" prop="name">
                <el-input v-model="dept.name" />
            </el-form-item>
        </el-form>
        <template #footer>
            <div class="dialog-footer">
                <el-button @click="dialogFormVisible = false">Cancel</el-button>
                <el-button type="primary" @click="dialogFormVisible = false">Confirm</el-button>
            </div>
        </template>
    </el-dialog>
</template>

<style scoped>
    .container{
        margin: 10px 0px;
    }
</style>