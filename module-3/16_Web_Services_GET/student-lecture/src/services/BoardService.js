import axios from 'axios'; //library allowing http calls

const http = axios.create({ //making api off localhost3000
  baseURL: "http://localhost:3000"
});

export default { //exporting default object similar  to components
//specifications of various routes on api
//all of these methods return a 'promise'
//a promise is an object which represents a result which will happen in the future, once some asynchronous process finishes
//.then is a handler; 
//to keep things in a linear order, keep using .then => sets up an ordered events => promise chaining; how to impose order with random timed responses
  getBoards() { //JS function
    return http.get('/boards'); 
  },

  getCards(boardID) { //call a path with id
    //instead of using string interpolation
    //const path = '/boards/'+boardID
    //return http.get(path);
    return http.get(`/boards/${boardID}`) //string interpolation
  },

  getCard(boardID, cardID) {            //.then; whenever this http request resolves, execute this function on the result from request; must return object thus why 'return'
    return http.get(`/boards/${boardID}`).then((response) => {
      const cards = response.data.cards; //.data gives back all of data coming back from http request; refers to single board; had id, title, background color and cards array
      return cards.find(card => card.id == cardID); //using find to identify card matching id from card array
    })
  }

}
