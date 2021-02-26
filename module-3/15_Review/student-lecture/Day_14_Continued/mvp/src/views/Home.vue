<template>
  <div class="container">
  <section class="hero">
    <div class="hero-body">
      <p class="title">Tech Elevator MVP Race</p>
      <p class="subtitle">Built with love in DE and CLT</p>
    </div>
  </section>
  <players-card-list />
  <standings/>
  </div>
</template>

<script>
import PlayersCardList from '../components/PlayersCardList.vue'
import Standings from '../components/Standings.vue'


export default {
  name: 'Home',
  components: {
    PlayersCardList,
    Standings
 
  }
}
</script>
