import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import './style.css'
import './assets/css/w3.css'


createApp(App)
	.use(router)
	.mount('#app')