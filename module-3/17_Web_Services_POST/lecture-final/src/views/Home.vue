<template>
  <div></div>
</template>

<script>
export default {
  created() {
    if(this.$store.state.boards.length > 0){
      const boardId = this.$store.state.boards[0].id;
      this.$router.push({name:'Board', params: {id: boardId}});
    }
  }
};
</script>
