import { createRouter, createWebHistory } from 'vue-router'
import Home from '../view/Home.vue'
import AddProduct from '../view/AddProduct.vue'

const routes = [
	{path:'/', name: 'Home', component: Home},
	{path:'/add-product', name: 'AddProduct', component: AddProduct}
]

const router = createRouter({
	history: createWebHistory(),
	routes
})

export default router;