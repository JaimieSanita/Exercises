<template>
  <div class="tile notification is-3 is-warning is-parent">
      <div class="tile is-child box">
      <p class="title">
          <!--                      name of link                    parameter:value-->
          <router-link v-bind:to="{name: 'player-profile', params: {pid:player.id}}">
          {{player.name}}
        </router-link>
        </p>
      </div>
  </div>
</template>

<script>
export default {
    name: 'player-card',
    props: ['player'], //i don't know what the player will be, & it will be provided from the outside
}
</script>

<style scoped>

</style>