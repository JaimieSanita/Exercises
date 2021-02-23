<template>
  <div class="main">
    <h2>Product Reviews for {{ name }}</h2>

    <p class="description">{{ description }}</p>

    <div class="well-display">
      <div class="well">
        <span class="amount" v-on:click="starFilter = 0">{{ averageRating }}</span>
        Average Rating
      </div>

      <div class="well">
        <!-- Showing this to show it can be done, not a huge fan of embedding actual script logic
             in the databinds though -->
        <span class="amount" v-on:click="starFilter = 1">{{ numberOfStarReviews(1) }}</span>
        1 Star Review{{ numberOfOneStarReviews === 1 ? "" : "s" }}
      </div>

      <div class="well">
        <span class="amount" v-on:click="starFilter = 2">{{ numberOfTwoStarReviews }}</span>
        2 Star Review{{ numberOfTwoStarReviews === 1 ? "" : "s" }}
      </div>

      <div class="well">
        <span class="amount" v-on:click="starFilter = 3">{{ numberOfThreeStarReviews }}</span>
        3 Star Review{{ numberOfThreeStarReviews === 1 ? "" : "s" }}
      </div>

      <div class="well">
        <span class="amount" v-on:click="starFilter = 4">{{ numberOfFourStarReviews }}</span>
        4 Star Review{{ numberOfFourStarReviews === 1 ? "" : "s" }}
      </div>

      <div class="well">
        <span class="amount" v-on:click="starFilter = 5">{{ numberOfFiveStarReviews }}</span>
        5 Star Review{{ numberOfFiveStarReviews === 1 ? "" : "s" }}
      </div>
    </div>

    <a id="show-form-button"
     href="#"
     v-if="showForm === false"
     v-on:click.prevent="showForm = true"
     > Show Form </a>

   <!-- v-on is used to bind events in vue -->
   <!--  v-on:event-name.prevent to prevent the default action -->
    <form 
      v-on:submit.prevent="addNewReview" 
      v-if="showForm === true">

      <div class="form-element">
        <label for="reviewer">Name:</label>
        <input id="reviewer" type="text" v-model="newReview.reviewer" >
      </div>
      
      <div class="form-element">
        <label for="title">Title:</label>
        <input id="title" v-model="newReview.title" >
      </div>

      <div class="form-element">
        <label for="rating">Rating:</label>
        <select id="rating" v-model.number="newReview.rating">
          <option value="1">1 Star</option>
          <option value="2">2 Star</option>
          <option value="3">3 Star</option>
          <option value="4">4 Star</option>
          <option value="5">5 Star</option>
        </select>
      </div>

      <div class="form-element">
        <label for="review">Review:</label>
        <textarea id="review" v-model="newReview.review"></textarea>
      </div>

      <input type="submit" value="Save" >
      <input type="button" value="Cancel" v-on:click.prevent="resetForm" >

    </form>


    <div
      class="review"
      v-for="review in filteredReviews"
      v-bind:class="{ favorited: review.favorited }"
      v-bind:key="review.id"
    >
      <h4>{{ review.reviewer }}</h4>
      <div class="rating">
        <img
          src="../assets/star.png"
          v-bind:title="review.rating + ' Star Review'"
          class="ratingStar"
          v-for="n in review.rating"
          v-bind:key="n"
        />
      </div>
      <h3>{{ review.title }}</h3>

      <p>{{ review.review }}</p>

      <p>
        Favorite?
        <input type="checkbox" v-model="review.favorited" />
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
        "Host and plan the perfect cigar party for all of your squirrelly friends.",
      newReview: {},
      showForm: false,
      starFilter: 0,
      reviews: [
        {
          reviewer: "Malcolm Gladwell",
          title: "What a book!",
          review:
            "It certainly is a book. I mean, I can see that. Pages kept together with glue and there's writing on it, in some language.",
          rating: 3,
          favorited: false,
        },
        {
          reviewer: "Tim Ferriss",
          title: "Had a cigar party started in less than 4 hours.",
          review:
            "It should have been called the four hour cigar party. That's amazing. I have a new idea for muse because of this.",
          rating: 4,
          favorited: false,
        },
        {
          reviewer: "Ramit Sethi",
          title: "What every new entrepreneurs needs. A door stop.",
          review:
            "When I sell my courses, I'm always telling people that if a book costs less than $20, they should just buy it. If they only learn one thing from it, it was worth it. Wish I learned something from this book.",
          rating: 1,
          favorited: false,
        },
        {
          reviewer: "Gary Vaynerchuk",
          title: "And I thought I could write",
          review:
            "There are a lot of good, solid tips in this book. I don't want to ruin it, but prelighting all the cigars is worth the price of admission alone.",
          rating: 3,
          favorited: false,
        },
      ],
    };
  },
  computed: {
    averageRating() {
      let sum = this.reviews.reduce((currentSum, review) => {
        return currentSum + review.rating;
      }, 0);
      return (sum / this.reviews.length).toFixed(2);
    },
    //we could delete this, see example
    // I still personally prefer this form
    numberOfOneStarReviews() {
      return this.numberOfStarReviews(1);
    },
    
    numberOfTwoStarReviews() {
      return this.numberOfStarReviews(2);
    },
    
    numberOfThreeStarReviews() {
      return this.numberOfStarReviews(3);
    },
    numberOfFourStarReviews() {
      return this.numberOfStarReviews(4);
    },
    numberOfFiveStarReviews() {
      return this.numberOfStarReviews(5);
    },

    filteredReviews() {
      const filteredReviews = this.reviews.filter((review) => { return this.starFilter === 0 || review.rating === this.starFilter});
      return filteredReviews;
    }
  },
  methods: {
    addNewReview() {
      const theReview = this.newReview;
      this.reviews.unshift(theReview);
      this.resetForm();
    },
    resetForm() {
      this.newReview = {};
      this.showForm = false;
    },
    numberOfStarReviews(numOfStars){
        return this.reviews.reduce((currentCount, review) => {
        return currentCount + (review.rating === numOfStars);
      }, 0);
    }
  }
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

div.main div.review.favorited {
  background-color: lightyellow;
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

div.form-element {
  margin-top: 10px;
}
div.form-element > label {
  display: block;
}
div.form-element > input,
div.form-element > select {
  height: 30px;
  width: 300px;
}
div.form-element > textarea {
  height: 60px;
  width: 300px;
}
form > input[type="button"] {
  width: 100px;
}
form > input[type="submit"] {
  width: 100px;
  margin-right: 10px;
}
</style>

