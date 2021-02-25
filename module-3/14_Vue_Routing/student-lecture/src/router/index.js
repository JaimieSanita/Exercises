import Vue from 'vue';
import VueRouter from 'vue-router';
//must import component before defining it in components section of a route
import Products from '@/views/Products';// this @ makes App.vue main entry & nav from app.vue
import ProductDetail from '@/views/ProductDetail';


Vue.use(VueRouter)
//object with key/value pairs
const routes = [
  {
    path: '/',
    name: 'products', //must be unique & name for particular route
    component: Products
  },
  {
    path: '/products/:id',
    name: 'product-detail',
    component: ProductDetail
    
  }

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
