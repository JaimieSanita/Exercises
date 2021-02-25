<template>
  <div id="app" class="main">
      <h1>{{product.name}}</h1>
      <p class="description">{{product.description}}</p>
      <a href="#">Back to Products</a>&nbsp; <!--&nbsp creates white space-->
      <a href="#">Add Review</a>&nbsp;
  </div>
</template>

<script>
export default {
    //created is a Vue lifecycle hook; these are a series of events that happen when Vue components are added/removed from a page
    //thus why we need to set product id in created() before the html of page renders 
    created(){ //first time component is created & this method is called
        const activeProductId=this.$route.params.id; //will fetch id parameter from the route
        //update Vuew with the currently active ID so all sub components know which id to use
        this.$store.commit('SET_ACTIVE_PRODUCT', activeProductId);
    },
    computed: {
        product(){
            //get the list of products out of our vuex store
            const products = this.$store.state.products;
            //find returns first element where functoin true
            //returns product with id that matchese the activeproductid from route params
            const product = products.find((p)=> {return p.id == this.$store.state.activeProduct;});
            return product;
        }
    }
}
</script>

<style scoped>

</style>