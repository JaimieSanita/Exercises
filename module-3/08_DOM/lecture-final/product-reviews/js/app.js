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

function setPageTitle() {
  // get element by ID can always be run directly off of the document
  // because browsers are very efficient at looking up id elements, 
  // they keep them in something like a map
  const pageTitle = document.getElementById('page-title'); //find the h2

  //if we are running an arbitrary selector, it's best to start from a nearby parent/ancestor 
  // to minimize the amount of searching the browser has to do
  const nameElement = pageTitle.querySelector('.name'); // find the span inside of it

  nameElement.innerText = name; //change the span's content into 'Cigar Parties for Dummies'
  // don't do this VERY HACKABLE
  //nameElement.innerHTML = name 
  
}

/**
 * Add our product description to the page.
 */
function setPageDescription() {
  //alternatively 
  // const descriptionElement = document.getElementById('main').querySelector('.description');
  const descriptionElement = document.querySelector('.description');
  descriptionElement.innerText = description;

}

/**
 * I will display all of the reviews on the page.
 * I will loop over the array of reviews and use some helper functions
 * to create the elements needed for our markup and add them to the DOM
 */
function displayReviews() {
  const main = document.getElementById('main');
                        
  reviews.forEach( (review) => {
    const container = document.createElement('div');
    container.setAttribute('class','review');
    //Reviewer
    addReviewer(container, review.reviewer);
    //Rating
    addRating(container, review.rating );
    //title
    addTitle(container, review.title);
    //text
    addReview(container, review.review);
    //insert the element into the DOM
    // takes two arguments, a string for the position, and an element
    main.insertAdjacentElement('beforeend', container);

  });
}

/**
 * I will creating a new  h4 element with the name of the reviewer and append it to
 * the parent element that is passed to me.
 *
 * @param {HTMLElement} el: The element to append the reviewer to
 * @param {string} name The name of the reviewer
 */
function addReviewer(parent, name) {
  const titleElement = document.createElement('h4');
  titleElement.innerText = name;
  parent.appendChild(titleElement);

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
    //make a star image and add it to the rating div
    const star = document.createElement('img');
    star.setAttribute('class','ratingStar');
    star.src = "img/star.png";
    rating.appendChild(star);
  }

  //add the rating container to the review elementS
  parent.appendChild(rating);

}

/**
 * I will add an h3 element along with the review title
 * @param {HTMLElement} parent  
 * @param {string} title
 */
function addTitle(parent, title) {
  const reviewTitle = document.createElement('h3');
  reviewTitle.innerText = title;
  parent.appendChild(reviewTitle);
}

/**
 * I will add the product review
 * @param {HTMLElement} parent
 * @param {string} review
 */
function addReview(parent, review) {
  const reviewElement = document.createElement('p');
  reviewElement.innerText = review;
  parent.appendChild(reviewElement);

}

// set the product reviews page title
setPageTitle();
// set the product reviews page description
setPageDescription();
// display all of the product reviews on our page
displayReviews();
