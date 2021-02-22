<!-- Here's a comment -->
<template>
  <div class="main">
    <h2>Product Reviews for {{ name }}</h2>
    <p class="description">{{ description }}</p>

    <div class="well-display">
      <div class="well">
        <span class="amount">{{ averageRating }}</span>
        Average Rating
      </div>
      <div class="well">
          <span class="amount">{{numberOfOneStarReviews}}</span>
          One Star Reviews
      </div>
    </div>

    <div class="review" v-bind:class="{favorited: rv.isFavorite}" v-for="rv in reviews" v-bind:key="rv.id">
      <h4>{{ rv.reviewer }}</h4>

      <div class="rating">
        <img
          src="../assets/star.png"
          class="ratingStar"
          v-bind:title="rv.rating + ' Star Review'"
          v-for="n in rv.rating"
          v-bind:key="n"
        />
      </div>

      <h3>{{ rv.title }}</h3>

      <p>{{ rv.review }}</p>
      <p>
          <!-- v-model causes a 2-way data binding, updating the data updates the control
               but updating the control also updates the data -->
          Favorite? <input type="checkbox" v-model="rv.isFavorite" />
      </p>
    </div>
  </div>
</template>

<script>
export default {
  name: "product-review",
  data() {
    return {
      name: "Cigar Parties for Dummies",
      description:
        "Host and plan the perfect cigar party for all your squirelly friends.",
      reviews: [
        {
          reviewer: "Malcom Gladwell",
          title: "What a book!",
          review:
            "It certainly is a book. I mean, I can see that. Pages kept together with glue and there's writing on it, in some language.",
          rating: 3,
          isFavorite: false
        },
        {
          reviewer: "Andrew McGuier",
          title: "This books was TERRIBLE!",
          review:
            "I really hated this book. There were no redeeming qualities.",
          rating: 5,
          isFavorite: false
        },
      ],
    };
  },
  computed: {
    averageRating() {
      const reviewArr = this.reviews;
      const totalRating = reviewArr.reduce((currentTotal, review) => {
        return currentTotal + review.rating;
      }, 0);
      return totalRating / reviewArr.length;
    },
    numberOfOneStarReviews() {
      return this.reviews.reduce((num, review) => {
        if (review.rating === 1) {
          return num + 1;
        } else {
          return num;
        }
      }, 0);
    },
  },
};
</script>

<style scoped>
div.main {
  margin: 1rem 0;
}

div.main div.well-display {
  display: flex;
  justify-content: space-around;
}

div.main div.well-display div.well {
  display: inline-block;
  width: 15%;
  border: 1px black solid;
  border-radius: 6px;
  text-align: center;
  margin: 0.25rem;
}

div.main div.well-display div.well span.amount {
  color: darkslategray;
  display: block;
  font-size: 2.5rem;
}

div.main div.review {
  border: 1px black solid;
  border-radius: 6px;
  padding: 1rem;
  margin: 10px;
}

div.main div.review div.rating {
  height: 2rem;
  display: inline-block;
  vertical-align: top;
  margin: 0 0.5rem;
}

div.main div.review div.rating img {
  height: 100%;
}

div.main div.review p {
  margin: 20px;
}

div.main div.review h3 {
  display: inline-block;
}

div.main div.review h4 {
  font-size: 1rem;
}

div.main div.review.favorited {
    background-color:lightyellow;
}
</style>