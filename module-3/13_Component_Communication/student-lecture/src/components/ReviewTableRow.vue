<template>
 <!--sets background color to light yellow to row is checkbox is checked, ie review is favorited--> 
  <tr v:bind:class="{favorited: review.favorited}">
      <!--setting column headers from imported review props-->
    <td>{{ review.title }}</td>
    <td>{{ review.reviewer }}</td>
    <td>{{ review.review }}</td>
    <td>
       <!--setting # of stars images to match rating number -->  
       <!--must v-for (for loop) over each number in review.rating --> 
       <!--must v-bind:key to give v-for an id to bind to elements that are looping -->   
        <img
        src="../assets/star.png"
        v-bind:title="review.rating + 'Star Review'"
        class='star'
        v-for='n in review.rating'
        v-bind:key='n'
        width='20px'
        />
    </td>
     <td>
          <!--setting up favorited check box-->  
        <!--v-bind:checked sets checkbox to checked if review.favorited is true--> 
         <input type="checkbox"
        v-bind:checked="review.favorited" 
        v-on:change="onFavoriteChange"
        />
     </td>
  </tr>
</template>

<script>
export default {
  name: "review-table-row",
  //review passed in from the outside
  props: ["review"],
  methods: {
      //needed a method to implement change for checkbox
      //this method will be called on checkbox input with v-on:change
      onFavoriteChange(){
          this.$store.commit('FLIP_FAVORITED', this.review);
      }
  },
};
</script>

<style scoped>
 tr.favorited{
     background-color: lightyellow;
 }
</style>