<template>
  <div id="todo-app">
    <toDo-list></toDo-list>
  </div>
</template>

<script>
import ToDoList from "./components/ToDoList";

export default {
  name: "app",
  components: {
    ToDoList,
  },
};
</script>

<style>
body {
  background: rgb(74, 162, 244);
  background: radial-gradient(
    circle,
    rgba(74, 162, 244, 1) 0%,
    rgba(54, 131, 240, 1) 100%
  );
}
</style>
