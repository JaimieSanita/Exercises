import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    players: [
      {
        name: "Joel Embiid",
        position: "Center",
        stats: {
          pointsPerGame: 30.1,
          rebounds: 11.1,
        }
      },
      {
        name: "Nikola Jokic",
        position: "Center",
        stats: {
          pointsPerGame: 27,
          rebounds: 10,
        
      }
      }
  
    ]
  },
  mutations: {
 
    
  },
  actions: {
  },
  modules: {
  },
  strict: true
})
