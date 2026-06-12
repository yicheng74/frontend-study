import { createWebHistory, createRouter } from 'vue-router'

import IndexView from '@views/index/index.vue'

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes:[
        {
            path: '/index',
            name: 'index',
            component: IndexView
        }
    ]
  })


export default router