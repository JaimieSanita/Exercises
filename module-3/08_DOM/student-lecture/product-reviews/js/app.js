const name = 'Cigar Parties for Dummies';
const description = 'Host and plan the perfect cigar party for all of your squirrelly friends.';
const reviews = [
  {
    reviewer: 'Malcolm Gladwell',
    title: 'What a book!',
    review:
      "It certainly is a book. I mean, I can see that. Pages kept together with glue (I hope that's glue) and there's writing on it, in some language.",
    rating: 3
  },
  {
    reviewer: 'Tim Ferriss',
    title: 'Had a cigar party started in less than 4 hours.',
    review:
      "It should have been called the four hour cigar party. That's amazing. I have a new idea for muse because of this.",
    rating: 4
  },
  {
    reviewer: 'Ramit Sethi',
    title: 'What every new entrepreneurs needs. A door stop.',
    review:
      "When I sell my courses, I'm always telling people that if a book costs less than $20, they should just buy it. If they only learn one thing from it, it was worth it. Wish I learned something from this book.",
    rating: 1
  },
  {
    reviewer: 'Gary Vaynerchuk',
    title: 'And I thought I could write',
    review:
      "There are a lot of good, solid tips in this book. I don't want to ruin it, but prelighting all the cigars is worth the price of admission alone.",
    rating: 3
  }
];

/**
 * Add our product name to the page title
 * Get our page page title by the id and the query the .name selector
 * once you have the element you can add the product name to the span.
 */
function setPageTitle() {}
  //.getElementById can always be run directly off the document
  //b/c browsers are very efficient at looking up id's of elements
  //and held in map-like structure & thus quick to retrieve
  
  //find the h2 element/container element
  const pageTitle = document.getElementById('page-title');
  //when running an arbitrary selector, its best to start from
  //a nearby parent/ancestor to minimize amount of searching for browser
  
   //find the span inside of h2 element
  const nameElement = pageTitle.querySelector('.name');
  //change the span's content into 'Cigar Parties for Dummies'
  nameElement.innerText = name;
/**
 * Add our product description to the page.
 */
function setPageDescription() {
  //OR get parent id of main and querySelector in one-line
  //const descriptionElement = document.getElementById('main').querySelector('.description');
  const descriptionElement = document.querySelector('.description');
  descriptionElement.innerText = description;
}
/**
 * I will display all of the reviews on the page.
 * I will loop over the array of reviews and use some helper functions
 * to create the elements needed for our markup and add them to the DOM
 */
function displayReviews() {

const mainElement = document.getElementById('main');
//foreach loop over array of reviews and passing in anonymous function
// and foreach object makes div container and sets class to review and 
// will set all review properties and insert into main div right before the end
reviews.forEach(
  (reviewVar) => {
    const container = document.createElement('div'); //creating div element; but doesn't exist in DOM yet
    container.setAttribute('class', 'review'); //sets class attribute to review on div element
    //TODO set reviewer, rating, title, review text
    //REVIEWER
    addReviewer(container, reviewVar.reviewer); //foreach review variable, use reviewer
    //RATING
    addRating(container, reviewVar.rating);
    //TITLE
    addTitle(container, reviewVar.title);
    //TEXT
    addReview(container, reviewVar.review);

    //insert element into DOM
    //takes two arguments, a string for position & an element
    //beforeend inserts container right before end of div id=main
                                    //position  //element
    mainElement.insertAdjacentElement('beforeend', container);
  }
);


}

/**
 * I will creating a new h4 element with the name of the reviewer and append it to
 * the parent element that is passed to me.
 *
 * @param {HTMLElement} el: The element to append the reviewer to
 * @param {string} name The name of the reviewer
 */
function addReviewer(parent, name) {
const titleElement = document.createElement('h4'); //make empty h4 container element
titleElement.innerText = name; //sets text to name of reviewer
parent.appendChild(titleElement); //add element at end of parent element
}

/**
 * I will add the rating div along with a star image for the number of ratings 1-5
 * @param {HTMLElement} parent
 * @param {Number} numberOfStars
 */

function addRating(parent, numberOfStars) {
  const rating = document.createElement('div');
  rating.setAttribute('class', 'rating');
  //add stars to my rating container
  for(let n = 0; n < numberOfStars; n++){
    //make a star img and add it to the rating div
    const star = document.createElement('img');
    star.setAttribute('class', 'ratingStar'); //'ratingstar' is in css already
    star.src = 'img/star.png';
    rating.appendChild(star);
  }
  //add rating container to review element
  parent.appendChild(rating);
}

/**
 * I will add an h3 element along with the review title
 * @param {HTMLElement} parent
 * @param {string} title
 */
function addTitle(parent, title) {
  const reviewTitle = document.createElement('h3');
  reviewTitle.setAttribute('class', 'title');
  reviewTitle.innerText = title;
  parent.appendChild(reviewTitle);
}

/**
 * I will add the product review
 * @param {HTMLElement} parent
 * @param {string} review
 */
function addReview(parent, review) {
const reviewBody = document.createElement('p');
reviewBody.setAttribute('class', 'review');
reviewBody.innerText = review;
parent.appendChild(reviewBody);
}

// set the product reviews page title
setPageTitle();
// set the product reviews page description
setPageDescription();
// display all of the product reviews on our page
displayReviews();
