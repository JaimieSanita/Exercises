<template>
  <div v-bind:class="calcCardClasses()">
    <h1>{{card.title}}</h1>
    <p>{{card.description}}</p>
    <span class="pill" v-bind:class="calcTagClass()">{{card.tag}}</span>
    
    <div class="loading" v-if="isLoading">
        <img src="../assets/ping_pong_loader.gif" />
    </div>
    <comments-list v-bind:comments="card.comments" v-else     />

    <div class="board-actions" v-if="!isLoading">
      <router-link v-bind:to="{name:'Board', params:{id : this.$route.params.boardID }}" >
        Back to Board
      </router-link>
    </div>

  </div>
</template>

<script>
import boardService from '../services/BoardService';
import CommentsList from './CommentsList.vue';

export default {
  name: "card-detail",
  components: { CommentsList },
  data() {
    return {
      card: {
        title: "",
        description: "",
        status: "",
        tag: "",
        comments: [],
      },
      isLoading: true
    };
  },
  created() {
    const boardID = this.$route.params.boardID;
    const cardID = this.$route.params.cardID;
    boardService.getCard(boardID, cardID).then((response) => {
      this.card = response;
      this.isLoading = false;
    });

  },
  methods: {
    calcCardClasses() {
      return {
        'in-progress' : this.card.status === 'In Progress',
        complete : this.card.status === 'Completed',
        planned: this.card.status === 'Planned'
      }
    },
    calcTagClass() {
        if(this.card.tag === 'Q&A'){
          return {qa:true};
        } else if(this.card.tag ==='Feature Request'){
          return {feature: true};
        } else if(this.card.tag === 'Design'){
          return {design: true};
        } else {
          return {};
        }
      
    }
    
  }
};
</script>

<style scoped>
.pill {
  padding: 16px 16px;
  border-radius: 30px;
  font-size: 1.0rem;
  margin-bottom:10px;
  display:inline-block;
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

.in-progress {
  background-color: lightgoldenrodyellow;
}

.complete {
  background-color: lightgreen;
}

.planned {
  background-color:lightblue;
}

</style>