import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

export default defineConfig({
	plugins: [vue()],
	server: {
		port: 3000,
		proxy: {
			'/api/v1/caloriecounter': {
				target: 'http://localhost:8081',
				ws: true, // Enable WebSocket proxying
				changeOrigin: true // Allow requests to have a different origin
			}
		},
	},
})