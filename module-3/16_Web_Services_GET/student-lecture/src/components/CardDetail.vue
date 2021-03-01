<template>
  <div v-bind:class="calcCardClasses()"> <!--//calling method to v-bind:class-->
    <h1> {{card.title}}</h1>
    <p>{{card.description}}</p>
    <span class="pill" v-bind:class="calcTagClass()">{{card.tag}}</span>
      <div class="loading" v-if="isLoading" >
        <img src="../assets/ping_pong_loader.gif" />
      </div>
                  <!--bind the comments component from CommentsList to card.comments from api -->
    <comments-list v-bind:comments="card.comments" v-else/> <!--the v-else needs to follow element with v-if on it; makes this element conditional to element with v-if on it-->
                                                  <!--could have subbed out v-else for a v-if ='!isLoaded'-->
<div class="board-actions" v-if="!isLoading">                         <!--sets the id to the current board ID of current page-->
  <router-link v-bind:to="{name:'Board', params: {id:this.$route.params.boardID}}">
    Back to Board
  </router-link>
</div>  
  </div>
</template>

<script>
import boardsService from '../services/BoardService';
import CommentsList from '../components/CommentsList';
export default {
  name: "card-detail",
  components: {
    CommentsList
    },
  data() {
    return {
      card: { //create card object to hold object with title, description, status and comment array
        title: "",
        description: "",
        status: "",
        tag: "",
        comments: [],
      },
      isLoading: true,
    };
  },
  created(){ //this function will run after component is created / loaded onto the page
    const boardID = this.$route.params.boardID; 
    const cardID = this.$route.params.cardID;  //can be any variable but response is standard; reps individual card
    boardsService.getCard(boardID, cardID).then((response)=>{
      this.card = response; //changes card in data to whatever is returned from response of api call
      this.isLoading = false;
    });
  },
  methods:{ //made method for status binding b/c more than a single line
    calcCardClasses(){
      return{
        'in-progress': this.card.status === 'In Progress',
        'complete': this.card.status === 'Completed',
        'planned': this.card.status === 'Planned',
      }
    },
    calcTagClass(){
     if(this.card.tag === 'Q&A'){
       return {qa:true};
     } else if(this.card.tag === 'Feature Request'){
       return {feature:true};
     } else if (this.card.tag ==='Design'){
       return {design:true};
     } else {
       return {};
     }

     }
      }
    }
  

</script>
<style scoped>
.pill {
  padding: 16px 16px;
  border-radius: 30px;
  font-size: 1.0rem;
  margin-bottom: 10px;
  display: inline-block; 
}

.design {
  background-color: #faf5ff;
  color: #6b46c1;
}
.qa {
  background-color: #f0fff4;
  color: #2c7a7b;
}

.feature {
  background-color: #e6fffa;
  color: #2c7a7b;
}
.in-progress{
  background-color: lightgoldenrodyellow;

}
.complete{
  background-color: lightgreen;
}
.planned{
  background-color: lightblue;
}
</style>
