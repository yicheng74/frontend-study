import { createApp } from 'vue'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'

import App from './App.vue'
import router from'./router'

import './assets/main.css'

const app = createApp(App)

// 3. 使用插件
app.use(ElementPlus) 
app.use(router)      

// 4. 挂载
app.mount('#app')


