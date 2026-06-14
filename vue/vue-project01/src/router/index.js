import { createWebHistory, createRouter } from 'vue-router'

import IndexView from '@/views/index/index.vue'
import LoginView from '@/views/login/login.vue'
import Layout from '@/views/layout/index.vue';

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes:[
        {
            path: '/',
            name: '',
            component: Layout,
            children:[
                {
                    path:'/index',
                    name:'index',
                    component:IndexView
                }
            ]
        },

        {
            path: '/login',
            name: 'login',
            component: LoginView
        }
    ]
  })


export default router