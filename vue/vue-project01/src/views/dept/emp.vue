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

    //
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


    //+
    const dialogFormVisible = ref(false)
    const emp = ref({
        name: '',
        gender: '',
        position: '',
        department: '',
    })
    const formTitle = ref('')

    const rules = ref({
        name: [
            { required: true, message: 'Please input Activity name', trigger: 'blur' },
            { min: 2, max: 10, message: 'Length should be 2 to 10', trigger: 'blur' },
    ]})

    const addemp = () => {
        dialogFormVisible.value = true;
        formTitle.value= '新增员工';
        emp.value = {
            name: '',
            gender: '',
            position: '',
            department: '',
            experience: [
                {
                    dateRange: [],
                    company: '',
                    role: '',
                }
            ],
        };
        if (empFormRef.value){
            empFormRef.value.resetFields();
        }
       
    }

    const empFormRef = ref()

    // 添加工作经历
    const addExperience = () => {
        emp.experience.push({
            dateRange: [],
            company: '',
            role: '',
    })
    }

    // 删除工作经历
    const removeExperience = (index) => {
        emp.experience.splice(index, 1)
    }

    //genders
    const genders = ref([{name:'男', value:1},{name:'女', value:2}])
</script>

<template>
    <h1>員工管理</h1>

    <div class="button">
        <el-button type="primary" @click="addemp">+add</el-button>
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

    <el-dialog v-model="dialogFormVisible" title="formTitle" width="500">
        <el-form :model="emp" :rules="rules" ref="empFormRef">
            <el-col :span="12">
                <el-form-item label="员工名称" :label-width="formLabelWidth" prop="name">
                    <el-input v-model="emp.name" />
                </el-form-item>
                <el-form-item label="性别">
                    <el-select v-model="emp.gender" placeholder="请选择性别" style="width: 100%">
                        <el-option v-for="g in genders" :key="g.value" :label="g.name" :value="g.value" />
                    </el-select>
                </el-form-item>
                <el-form-item label="职位">
                    <el-select v-model="emp.position" placeholder="请选择职位" style="width: 100%">
                        <el-option label="经理" value="1" />
                        <el-option label="职员" value="2" />
                    </el-select>
                </el-form-item>
                <el-form-item label="所属部门">
                    <el-select v-model="emp.department" placeholder="请选择部门" style="width: 100%">
                        <el-option label="技术部" value="tech" />
                        <el-option label="人事部" value="hr" />
                    </el-select>
                </el-form-item>
            </el-col>

            <div class="divider"></div>

            <div class="work-experience-section">
                <div class="section-title">
                    <span>工作经历</span>
                    <el-button type="success" size="small" class="add-btn" @click="addExperience">
                        + 添加工作经历
                    </el-button>
                </div>

                <div v-for="(item, index) in emp.experience" :key="index" class="experience-row">
                    <span class="row-label">时间</span>
                    <el-date-picker
                        v-model="item.dateRange"
                        type="daterange"
                        range-separator="至"
                        start-placeholder="开始日期"
                        end-placeholder="结束日期"
                        class="date-range-picker"
                    />

                    <span class="row-label">公司</span>
                    <el-input v-model="item.company" placeholder="请输入公司名称" class="company-input" />

                    <span class="row-label">职位</span>
                    <el-input v-model="item.role" placeholder="请输入职位" class="role-input" />

                    <el-button type="danger" size="default" class="delete-btn" @click="removeExperience(index)">
                        - 删除
                    </el-button>
                </div>
            </div>
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

</style>