import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:3000"
});

export default {

  //all of these methods return a `promise` 
  // a promise is an object, which represents a result which will happen in the future,
  // once some asyncronous process finishes

  getBoards() {
    return http.get('/boards');
  },

  getCards(boardID) {
    // instead of using string interpolation you could do
    //const path = '/boards/' + boardID;
    // return http.get(path);
    return http.get(`/boards/${boardID}`)
  },

  getCard(boardID, cardID) {
    return http.get(`/boards/${boardID}`).then((response) => {
      const cards = response.data.cards;
      return cards.find(card => card.id == cardID);
    })
  }

}
