import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:3000"
});

const boardPathRoot = "/boards"; //if set constant & have a syntax error, will prompt error

export default {

  getBoards() {
    return http.get(boardPathRoot);
  },

  addBoard(board){
    return http.post(boardPathRoot, board) //b/c post, no id is passed into url but need board object
  },

  deleteBoard(boardID){
    return http.delete(`${boardPathRoot}/${boardID}`) //needs to pass in boardID into the URL
  },

  getCards(boardID) {
    return http.get(`${boardPathRoot}/${boardID}`)
  },

  getCard(cardID) {
    return http.get(`/cards/${cardID}`)
  },

  addCard(card) {
    return http.post('/cards', card);
  },

  updateCard(card) {
    return http.put(`/cards/${card.id}`, card);
  },

  deleteCard(cardID) {
    return http.delete(`/cards/${cardID}`);
  }

}
