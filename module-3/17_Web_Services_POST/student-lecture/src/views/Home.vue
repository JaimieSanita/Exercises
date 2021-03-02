<template>
  <div></div>
</template>

<script>
export default {
  created(){
    if(this.$store.state.boards.length > 0){ //if there have any boards
      const boardID = this.$store.state.boards[0].id; //get first board out of the list
      this.$router.push({name:'Board', params:{id: boardID}}); //navigate to 1st board page
    }
  }
};
</script>
