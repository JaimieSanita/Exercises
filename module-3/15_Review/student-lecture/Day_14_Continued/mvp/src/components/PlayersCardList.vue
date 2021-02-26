<template>
<section class="section">
    <div class="tile is-ancestor">
        <!--load Player Card component & do v-for w/ player-->
        <player-card
         v-for="ply in this.$store.state.players" 
         v-bind:key="ply.id" 
         v-bind:player="ply"
         />
    </div>
  
</section>
</template>

<script>

import PlayerCard from './PlayerCard.vue'

export default {
  components: { 
      PlayerCard },

}
</script>

<style scoped>
.tile.is-ancestor{
    justify-content: space-around;
}

</style>