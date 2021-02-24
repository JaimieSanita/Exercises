<template>
  <div class="book-container" >
    <book-card
    v-for="bk in $store.state.books" v-bind:key="bk.isbn" v-bind:book="bk"/>
    <h2></h2>
    <img />
    <h3></h3>
  </div>
</template>

<script>
import BookCard from './BookCard.vue';
export default {
  components: { BookCard },
  name: "reading-list",
};

</script>

<style>
.book-container {
  display: flex;
  justify-content: space-evenly;
  flex-wrap: wrap;
}
</style>