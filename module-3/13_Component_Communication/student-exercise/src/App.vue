<template>
  <div id="app">
    <h1>Reading List</h1>
    <reading-list />
    <book-card/>
  </div>
</template>

<script>
import BookCard from './components/BookCard.vue';
import ReadingList from './components/ReadingList.vue';

export default {
  name: 'app',
  components: {
    ReadingList,
    BookCard
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin: 60px;
}
</style>
