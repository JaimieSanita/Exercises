<template>
  <div class="well">
    <span class="amount" v-on:click="updateFilter()">{{ averageRating }}</span>
    Average Rating
  </div>
</template>

<script>
export default {
  name: "average-summary",
  methods: {
    updateFilter() {
      //                  FUNCTION_NAME, parameter;set to 0 because when avgRating well is clicked, it shows all reviews thus 0 stars
      this.$store.commit('UPDATE_FILTER',0);
    }
  },
  computed: {
    averageRating() {
      const reviews = this.$store.state.reviews;
      let sum = reviews.reduce((currentSum, review) => {
        return currentSum + review.rating;
      }, 0);
      return (sum / reviews.length).toFixed(2);
    }
  }
};
</script>
