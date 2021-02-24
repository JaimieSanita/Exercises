<template>
  <section class="new-todo">
    <form v-on:submit.prevent="saveToDo">
      <input type="text" placeholder="Name" v-model="newTodo.name"/>
      <select v-model="newTodo.category">
        <option value="">--- Select a category ---</option>
        <option value="Home">Home</option>
        <option value="Work">Work</option>
      </select>
      <button>Add</button>
    </form>
  </section>
</template>

<script>
export default {
    //create data() to store form elements(input box and select)
    data(){
        return{
            newTodo: {
                name:'',
                category: '',
                done: false
            }
        }
    },
    methods: {
        saveToDo(){ //when saving a new todo, do the following
            this.newTodo.done = false; //set the new todo item to not done
            this.$store.commit('ADD_NEW_TODO', this.newTodo); //commit new todo to datastore
            this.newTodo = { //empty space to enter new todo?
                name: '',
                category: '',
                done: false
            }
        }
    },
};
</script>

<style scoped>
.new-todo {
    width:450px;
    background: #fff;
    margin: auto;
    font-family: 'Roboto Condensed', sans-serif;
    border-radius: 10px;
}
input, select, button {
  padding: 5px 5px;
  margin: 5px;
}
</style>