import Vue from 'vue';
import VueRouter from 'vue-router';
import Home from '@/views/Home.vue';
import MyBooks from '@/views/MyBooks.vue';
import NewBook from '@/views/NewBook.vue';
import Books from '@/views/Books.vue';

Vue.use(VueRouter);

const routes = [
{
  path:'/',
  name:'home',
  component: Home
},
{
  path: '/myBooks',
  name: 'myBooks',
  component: MyBooks
},
{
  path: '/addBook',
  name: 'addBook',
  component: NewBook
},
{
  path: '/book/:isbn',
  name: 'bookDetails',
  component: Books
}
];

const router = new VueRouter({
  mode: 'history',
  routes
});

export default router;
