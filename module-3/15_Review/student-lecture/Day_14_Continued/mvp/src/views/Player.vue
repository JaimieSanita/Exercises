<template>
  <div class="container">
      <section class="hero">
          <div class="hero-body">
              <p class="title">{{this.$store.state.activePlayer.name}}</p>
              <p class="subtitle">{{this.$store.state.activePlayer.position}}</p>
          </div>
      </section>
      <section class="section">
          <!--need to data bind voteAction method with v-on:click.prevent-->
          <b-button v-on:click.prevent="voteAction">Vote!</b-button>
          </section>
  </div>
</template>

<script>
export default {
    created(){ //runs when the component is created
                        //refers to URL of CURRENT page
        const playerId = this.$route.params.pid;
        //update VUEX 
        this.$store.commit('SET_ACTIVE_PLAYER', playerId);
    },
    methods: {
        voteAction(){
            this.$store.commit('VOTE_ACTIVE_PLAYER');
            this.$router.push({name: 'home'});
        }
    },
}
</script>

<style scoped>

</style>