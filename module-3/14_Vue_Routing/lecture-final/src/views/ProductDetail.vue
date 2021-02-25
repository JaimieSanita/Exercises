<template>
    <div id="app" class="main">
        <h1>{{product.name}}</h1>
        <p class="description">{{product.description}}</p>
        <a href="#">Back to products</a>&nbsp;
        <a href="#">Add Review</a>
    </div>
</template>

<script>
export default {
    //created is a Vue lifecycle hook
    //these are a series of events that happen when vue components are added/removed from a page
    created(){
        //grab the current product id from the url route (:id parameter)
        const activeProductId = this.$route.params.id;
        //update Vuex with the currently active ID so all sub components know which id to use
        this.$store.commit('SET_ACTIVE_PRODUCT', activeProductId);
    },
    computed: {
        product() {
            //get the list of products out of our vuex store
            const products = this.$store.state.products;
            //find works like filter, but it returns only the first element for which the function is true
            const product = products.find((p) => {return p.id == this.$store.state.activeProduct;});
            return product;
        }
    }
}
</script>

<style scoped>

</style>