import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    activePlayer: {},
    players: [
      {
        id: 1,
        name: "Joel Embiid",
        position: "Center",
        stats: {
          pointsPerGame: 30.1,
          rebounds: 11.1,
        }
      },
      {
        id: 2,
        name: "Nikola Jokic",
        position: "Center",
        stats: {
          pointsPerGame: 27,
          rebounds: 10,

        },
        votes: 0,
      }

    ]
  },
  mutations: {
    SET_ACTIVE_PLAYER(state, playerId) {
      state.activePlayer = state.players.find((player) => {
        return player.id == playerId
      });
      state.selectedPlayer = playerId;
    },
    VOTE_ACTIVE_PLAYER(state){
      state.activePlayer.votes += 1;
    }
  },
  actions: {
  },
  modules: {
  },
  strict: true
})
