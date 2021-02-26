import Vue from 'vue';
import VueRouter from 'vue-router';
import Home from '../views/Home.vue';
import Player from '../views/Player.vue';

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: Home
  },
  {
    path: '/player/:pid',
    name: 'player-profile',
    component: Player
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
