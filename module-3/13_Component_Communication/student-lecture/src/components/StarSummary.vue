<template>
  <div class="well">
    <span class="amount" v-on:click="updateFilter()">{{ numberOfReviews }}</span>
    {{ rating }} Star Review{{ numberOfReviews === 1 ? '' : 's' }}
  </div>
</template>

<script>
export default {
  name: "star-summary",
  //properties passed into component from outside when component is created
  props: ["rating"],
  methods: {
    updateFilter() {
      //setting constant equal to props[rating] by setting it as this.rating
      //parseInt to ensure it is a number and not a string
      const ratingNumber = parseInt(this.rating);
      //pass constant as payload parameter in commit
      //run this update with ratingNumber as parameter  
      this.$store.commit('UPDATE_FILTER', ratingNumber);
    }
  },
  computed: {
    numberOfReviews() {
      const reviews = this.$store.state.reviews;
      return reviews.reduce((currentCount, review) => {
        return currentCount + (review.rating === parseInt(this.rating) ? 1 : 0);
      }, 0);
    }
  }
};
</script>

