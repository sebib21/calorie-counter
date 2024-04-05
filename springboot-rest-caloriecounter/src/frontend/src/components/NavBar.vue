<script>
	export default {
	  methods: {
	    isCurrentRoute(route) {
	      return this.$route.path === route;
	    }
	  }
	}
</script>

<template>
	<div class="w3-bar w3-border w3-black w3-xlarge">
		<router-link to="/"><img src="../assets/logo.png" title="Home" class="w3-bar-item app-logo" alt="NutriMeal logo"></router-link>
		<router-link to="/add-product" class="w3-bar-item w3-button w3-hover-none w3-hover-text-white"
			:class="[isCurrentRoute('/add-product') ? 'w3-text-lime' : 'w3-text-grey']">Add product</router-link>
		<router-link to="/" class="w3-bar-item w3-button w3-hover-none w3-hover-text-white"
			:class="[ isCurrentRoute('/add-meal') ? 'w3-text-lime': 'w3-text-grey' ]">Add meal</router-link>
		<router-link to="/" class="w3-bar-item w3-button w3-hover-none w3-hover-text-white"
			:class="[ isCurrentRoute('/edit-meal') ? 'w3-text-lime': 'w3-text-grey' ]">Edit meal</router-link>
	</div>
</template>

<style scoped>
	.app-logo {
		height: 55px;
		width: 55px;
	}
	
	.app-logo:hover {
  		filter: drop-shadow(0 0 20px rgba(0, 255, 0, 0.8));
	}
</style>