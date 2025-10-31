import { createRouter, createWebHistory } from 'vue-router'

import ViewPatients from '@/views/ViewPatients.vue'
import AddPatient from '@/views/AddPatient.vue'
import UpdatePatient from '@/views/UpdatePatient.vue'

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes: [

        {
            path: '/',
            name: 'home',
            component: ViewPatients
        },
        {
            path: '/add',
            name: 'add',
            component: AddPatient
        },
        {
            path: '/edit/:id',
            name: 'edit',
            component: UpdatePatient
        }

    ]
})

export default router