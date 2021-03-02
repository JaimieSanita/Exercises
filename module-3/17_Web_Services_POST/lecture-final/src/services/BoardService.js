import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:3000"
});

const BOARD_PATH = "/boards";

export default {

  getBoards() {
    return http.get(BOARD_PATH);
  },

  addBoard(board){
    //invalid
    return http.post(BOARD_PATH,board);
  },

  deleteBoard(boardID){
    return http.delete(`${BOARD_PATH}/${boardID}`);
  },
  getCards(boardID) {
    return http.get(`${BOARD_PATH}/${boardID}`)
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
