<script setup>
	import { ref, onMounted } from 'vue';
	
	const noCategoryIconURL = 'https://i.ibb.co/wp2zPkC/icons8-prohibited-96.png';
	const selectedCategoryIconURL = ref(noCategoryIconURL);

	const productData = ref({
		name: '',
		categoryId: '',
		kilocalories: '',
		productMacronutrientList: {},
		productMicronutrientList: {}
	});
	
	const validationErrors = ref({});
	
	const showSuccessModal = ref(false);
	
	const categories = ref([]);
	const macronutrients = ref([]);
	const micronutrients = ref([]);
	
	async function fetchData() {
		try {
			const [categoriesResponse, macronutrientsResponse, micronutrientsResponse] = await Promise.all([
				fetch('/api/v1/caloriecounter/categories'),
				fetch('/api/v1/caloriecounter/macronutrients'),
				fetch('/api/v1/caloriecounter/micronutrients'),
			]);
	
			if (!categoriesResponse.ok || !macronutrientsResponse.ok || !micronutrientsResponse.ok) {
				throw new Error('Failed to fetch data');
			}
	
			categories.value = await categoriesResponse.json();
			macronutrients.value = await macronutrientsResponse.json();
			micronutrients.value = await micronutrientsResponse.json();
			
			initializeNutrientLists();
		} catch (error) {
			console.error('Error fetching data:', error);
		}
	}
	
	function initializeNutrientLists(){
		productData.value.productMacronutrientList = Object.fromEntries(
			macronutrients.value.map((macronutrient) => [macronutrient.macronutrientId, null])
			);
		productData.value.productMicronutrientList = Object.fromEntries(
			micronutrients.value.map((micronutrient) => [micronutrient.micronutrientId, null])
			);
	}
	
	onMounted(fetchData);
	
	// Error functions
	function hasErrorForMacronutrient(macronutrientId) {
    	return this.validationErrors && this.validationErrors[`productMacronutrientList[${macronutrientId - 1}].content`] !== undefined;
	}
	function getErrorMessageForMacronutrient(macronutrientId) {
	    return this.validationErrors[`productMacronutrientList[${macronutrientId - 1}].content`] || "";
	}
	
	// UI/UX functions
	function clearInputError(inputField) {
		this.validationErrors[inputField] = null;
	}

	function updateCategoryIcon() {
		const selectedCategoryObject = categories.value.find(
			category => category.categoryId === productData.value.categoryId
			);
		
		selectedCategoryIconURL.value = selectedCategoryObject?.iconURL || noCategoryIconURL;
	}
	
	// Filter micronutrients functions
	function filterVitamins(){
		return this.micronutrients.filter(nutrient => nutrient.type === 'vitamin');
	}
	
	function filterMinerals(){
		return this.micronutrients.filter(nutrient => nutrient.type === 'mineral');
	}
	
	
	async function submitForm() {
		let productDataToPost = JSON.parse(JSON.stringify(productData.value));
		
		productDataToPost.kilocalories = parseFloat(productDataToPost.kilocalories).toFixed(1);
		
		productDataToPost.productMacronutrientList = Object.entries(productDataToPost.productMacronutrientList).map(
			([macronutrientId, content]) => ({
				macronutrientId: parseInt(macronutrientId),
				content: content === null ? null : parseFloat(content)
			})
		);

		productDataToPost.productMicronutrientList = Object.entries(productDataToPost.productMicronutrientList).map(
			([micronutrientId, content]) => ({
				micronutrientId: parseInt(micronutrientId),
				content: content === null ? null : parseFloat(content)
			})
		);
				
		await fetch('/api/v1/caloriecounter/products', {
			method: 'POST',
			headers:{
				'Content-Type': 'application/json'
			},
			body: JSON.stringify(productDataToPost)
		})
		.then(response => {
			if(response.ok){
				showSuccessModal.value = true;
			} else{
				response.json().then(data => {
					validationErrors.value = data;
				});
			}
		})
		.catch(error => {
			console.log('Error: ', error);
		});
	}
</script>

<template>
	<div class="sb-center">
		<form class="w3-container w3-card-4 w3-twothird w3-padding-16" @submit.prevent="submitForm">
			<h1><b>New product</b></h1>
			<p>Complete the form below with the corresponding data for <b>100 grams</b> of product.</p>
			
			<hr/>
			
			<h3 class="w3-text-dark-gray"><b>General</b></h3>
			<div class="w3-row-padding">
				<p>
					<label>Product name</label>
					<input type="text" name="product_name" class="w3-input w3-border w3-round-large" v-model="productData.name" @input="clearInputError('name')"/>
					<h6 v-if="validationErrors.name" class="w3-text-red sb-error-margin-top"> {{ validationErrors.name }} </h6>
				</p>
			</div>
				
			<div class="w3-row-padding">
				<div class="w3-half">
					<img :src="selectedCategoryIconURL" class="sb-icon" alt="categoryIcon"/>
					<label>Category</label>
					<select name="product_category" class="w3-input w3-border w3-round-large" 
							 		v-model="productData.categoryId" @change="updateCategoryIcon(); clearInputError('categoryId')">
						<option disabled value="">- Select a category -</option>
						<option v-for="category in categories" :key="category.categoryId" :value="category.categoryId">{{ category.name }}</option>
					</select>
					<h6 v-if="validationErrors.categoryId" class="w3-text-red sb-error-margin-top"> {{ validationErrors.categoryId }} </h6>
				</div>
				<div class="w3-half">
					<label>Kilocalories</label>
					<input type="number" name="kilocalories" class="w3-input w3-center w3-border w3-round-large" step="0.1" 
							v-model="productData.kilocalories" @input="clearInputError('kilocalories')"/>
					<h6 v-if="validationErrors.kilocalories" class="w3-text-red sb-error-margin-top"> {{ validationErrors.kilocalories }} </h6>
				</div>
			</div>
			
			<hr/>
			
			<h3 class="w3-text-dark-gray"><b>Macronutrients</b></h3>
			<div class="w3-row-padding" v-for="macronutrient in macronutrients">
				<div class="w3-half">
					<h5>{{ macronutrient.nutrient }}</h5>
				</div>
				
				<div class="w3-half sb-inline-input-group">
					<input type="number" class="w3-input w3-center w3-border w3-round-large" step="0.1" 
							v-model="productData.productMacronutrientList[macronutrient.macronutrientId]" 
							@input="clearInputError(`productMacronutrientList[${macronutrient.macronutrientId - 1}].content`)"/>
					<span>g</span>
					<h6 v-if="hasErrorForMacronutrient(macronutrient.macronutrientId)" class="w3-text-red sb-error-margin-top"> 
						{{ getErrorMessageForMacronutrient(macronutrient.macronutrientId) }}
					</h6>
				</div>
			</div>
	
			<hr/>
			
			<h3 class="w3-text-dark-gray"><b>Micronutrients</b></h3>
			<div class="w3-row-padding">
				<div class="w3-half w3-border-right">
					<h4 class="w3-text-dark-gray" ><b>Vitamins</b></h4>
					<div v-for="micronutrient in filterVitamins()">
						<div class="w3-half">
							<h5>{{ micronutrient.nutrient }}</h5>
						</div>
						
						<div class="w3-half sb-small-inline-input-group">
							<input type="number" class="w3-input w3-center w3-border w3-round-large" step="0.001" 
									v-model="productData.productMicronutrientList[micronutrient.micronutrientId]"/>
							<span>{{ micronutrient.units }}</span>
						</div>
					</div>
				</div>
				
				<div class="w3-half">
					<h4 class="w3-text-dark-gray"><b>Minerals</b></h4>
					<div v-for="micronutrient in filterMinerals()">
						<div class="w3-half">
							<h5>{{ micronutrient.nutrient }}</h5>
						</div>
						
						<div class="w3-half sb-small-inline-input-group">
							<input type="number" class="w3-input w3-center w3-border w3-round-large" step="0.001" 
									v-model="productData.productMicronutrientList[micronutrient.micronutrientId]"/>
							<span>{{ micronutrient.units }}</span>
						</div>
					</div>
				</div>
			</div>
			
			<hr/>
			
			<div class="w3-center">
				<input type="submit" value="Save" class="w3-btn w3-border w3-border-gray w3-green w3-round-xlarge"/>				
			</div>
		</form>
	</div>
	
	<div v-if="showSuccessModal" class="w3-modal sb-display-modal">
	    <div class="w3-modal-content w3-pale-green w3-border w3-round">
	      <div class="w3-container w3-center">
	        <h3>Product saved succesfully!</h3>
	        <br/><br/>
	        <button class="w3-btn w3-black w3-round-xlarge w3-display-bottommiddle" @click="this.$router.push('/')">
	        	Continue
	        </button>
	      </div>
	    </div>
	</div>
</template>

<style scoped>
	.sb-icon {
		width: 24px;
		height: 24px;
	}
	
	.sb-error-margin-top {
		margin-top: 0px;
	}
	
	.sb-display-modal {
		display: block;
	}
	
	@media (max-width: 768px) {
	  .w3-border-right {
	    border-right: none !important;
	  }
	}
</style>