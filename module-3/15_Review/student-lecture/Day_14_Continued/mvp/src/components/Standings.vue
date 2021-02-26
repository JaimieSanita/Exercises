<template>
  <div class="section">
    <h3>Standing</h3>
    <b-progress
      v-for="stat in voteStats"
      v-bind:key="stat.name"
      v-bind:value="stat.percentage"
      show-value
    >
      {{stat.name}}with{{stat.votes}}votes
    </b-progress>
  </div>
</template>

<script>
export default {
  methods: {
    totalVotes() {
      const players = this.$store.state.players;
      //loop thru entire array and reduce votes to one value
      //reduce takes two arguments
      return players.reduce((currentTotal, player) => {
        return currentTotal + player.votes;
        // reduce function requires initial value; & takes 0 votes to begin with
      }, 0);
    },
  },
  computed: {
    voteStats() {
      //create constant to hold all players
      const players = this.$store.state.players;
      //create constant to hold all votes
      const total = this.totalVotes();
      //return new votes array from data in players array
      //use this votes array in html above on b-progress component tag
      return players.map((player) => {
        //create votes object
        return {
          name: player.name,
          votes: player.votes,
          //         if total is 0 return 0;otherwise find percentage of votes
          percentage: total === 0 ? 0 : (player.votes / total) * 100,
        };
      });
    },
  },
};
</script>

<style scoped>
</style>