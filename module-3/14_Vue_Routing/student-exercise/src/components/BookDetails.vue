<template>
    <div class="book-container">
    <book-card v-bind:book="book" v-for="book in $store.state.books" v-bind:key="book.isbn" />
  </div>
</template>

<script>
import BookCard from '@/components/BookCard.vue';

export default {
    name: 'book-details',
    components: {
        BookCard
    },
    computed: {
        book(){
            //get the list of products out of our vuex store
            const books = this.$store.state.books;
            //find returns first element where functoin true
            //returns product with id that matchese the activeproductid from route params
            const book = books.find((b)=> {return b.isbn == this.$route.params.isbn;});
            return book;
        }
    }
}
</script>

<style scoped>

</style>