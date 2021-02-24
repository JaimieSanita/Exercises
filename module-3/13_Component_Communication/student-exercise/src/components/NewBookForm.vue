<template>
  <form class="new-book-form" v-on:submit.prevent="saveBook">
    <input type="text" class="title-input" placeholder="Title" v-model="newBook.title" />
    <input type="text" class="author-input" placeholder="Author" v-model="newBook.author" />
    <input type="text" class="isbn-input" placeholder="ISBN" v-model="newBook.isbn" />
    <button>ADD</button>
  </form>
</template>

<script>
export default {
    data(){
        return{
            newBook:{
                title:'',
                author: '',
                isbn: ''
            }
        }
    },
    methods:{
        saveBook(){
            this.newBook.read = false;
            this.$store.commit('ADD_NEW', this.newBook);
            this.newBook = {
                title:'',
                author: '',
                isbn: '' 
            }
        }
    }
};
</script>

<style>
</style>