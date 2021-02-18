const name = 'Cigar Parties for Dummies';
let description = 'Host and plan the perfect cigar party for all of your squirrelly friends.';
let reviews = [
  {
    reviewer: 'Malcolm Gladwell',
    title: 'What a book!',
    review:
      "It certainly is a book. I mean, I can see that. Pages kept together with glue (I hope that's glue) and there's writing on it, in some language.",
    rating: 3
  }
];

/**
 * Add our product name to the page title
 * Get our page page title by the id and the query the .name selector
 * once you have the element you can add the product name to the span.
 */
function setPageTitle() {
  const pageTitle = document.getElementById('page-title');
  pageTitle.querySelector('.name').innerHTML = name;
}

/**
 * Add our product description to the page.
 */
function setPageDescription() {
  document.querySelector('.description').innerHTML = description;
}

/**
 * I will display all of the reviews in the reviews array
 */
function displayReviews() {
  if ('content' in document.createElement('template')) {
    reviews.forEach((review) => {
      displayReview(review);
    });
  } else {
    console.error('Your browser does not support templates');
  }
}

/**
 *
 * @param {Object} review The review to display
 */
function displayReview(review) {
  const main = document.getElementById('main');
  const tmpl = document.getElementById('review-template').content.cloneNode(true);
  tmpl.querySelector('h4').innerHTML = review.reviewer;
  tmpl.querySelector('h3').innerHTML = review.title;
  tmpl.querySelector('p').innerHTML = review.review;
  // there will always be 1 star because it is a part of the template
  for (let i = 1; i < review.rating; ++i) {
    const img = tmpl.querySelector('img').cloneNode();
    tmpl.querySelector('.rating').appendChild(img);
  }
  if(review.hasDelete){
    const buttonContainer = document.createElement('div');
    buttonContainer.classList.add('float-right');

    const button = document.createElement('button');
    button.classList.add('btn', 'btn-outline-success', 'btn-sm');
    button.innerText = "Delete";

    buttonContainer.appendChild(button);
    tmpl.querySelector('.review').appendChild(buttonContainer);
  }
  main.appendChild(tmpl);
}

// LECTURE STARTS HERE ---------------------------------------------------------------

/**
 * Take an event on the description and swap out the description for a text box.
 *
 * @param {Event} event the event object
 */
function toggleDescriptionEdit(desc) {
  const textBox = desc.nextElementSibling; //select input text box below descriptoin p tag
  textBox.value = description; //set description value to textbox
  textBox.classList.remove('d-none'); //remove d-none class from text box to make visible
  desc.classList.add('d-none'); //add class d-none to discription p tag and make invisible
  textBox.focus(); //put cursor in the textbox by giving it focus
}

/**
 * Take an event on the text box and set the description to the contents
 * of the text box and then hide the text box and show the description.
 *
 * @param {Event} event the event object
 * @param {Boolean} save should we save the description text
 */
function exitDescriptionEdit(textBox, save) {
  let desc = textBox.previousElementSibling;
  if (save) {
    desc.innerText = textBox.value;
  }
  textBox.classList.add('d-none');
  desc.classList.remove('d-none');
}

/**
 * I will show / hide the add review form
 */
function showHideForm() {
  const form = document.querySelector('form');
  const btn = document.getElementById('btnToggleForm');

  if (form.classList.contains('d-none')) { //if form is hidden
    form.classList.remove('d-none'); //display
    btn.innerText = 'Hide Form'; //button says Hide Form
    document.getElementById('name').focus(); 
  } else {
    resetFormValues(); //if displayed, reset
    form.classList.add('d-none'); //hide form
    btn.innerText = 'Add Review'; //button says Add Review
  }
}

/**
 * I will reset all of the values in the form.
 */
function resetFormValues() {
  const form = document.querySelector('form');
  const inputs = form.querySelectorAll('input');
  inputs.forEach((input) => {
    input.value = '';
  });
  document.getElementById('rating').value = 1;
  document.getElementById('review').value = '';
}

/**
 * I will save the review that was added using the add review from
 */
function saveReview() { 
//get the data from each form control
//select each form control
const name = document.getElementById('name').value; //gets value
const title = document.getElementById('title').value;
const review = document.getElementById('review').value;
const rating = document.getElementById('rating').value;

//make a review object with key value pairs
const newReview = {
  reviewer: name,
  title: title,
  review: review,
  rating: rating,
  hasDelete: true
};

//add the review object to array of reviews
reviews.push(newReview);

//call the code that redraws the reviews
displayReview(newReview);
//hide/toggle the form
showHideForm();
}




//BY CONVENTION, THE DOM LOADED FUNCTIONS APPEAR AT BOTTOM OF FILE
//addEventListener takes two arguments
//an event name, and a function to execute once the event fires
//add all event listening event inside so only execute when DOM content
//is loaded
document.addEventListener('DOMContentLoaded', () => {
  // set the product reviews page title
  setPageTitle();
  // set the product reviews page description
  setPageDescription();
  // display all of the product reviews on our page
  displayReviews();

  //add a click handeler to the description
  const description = document.querySelector('.description');
  //declaring event parameter
  description.addEventListener('click', (event) => {
    toggleDescriptionEdit(event.target);
  });
  //add keyboard event handlers to description
  const inputDescription = document.getElementById('inputDesc');
  inputDescription.addEventListener('keyup', (event) => {
    if (event.key === 'Enter') {
      exitDescriptionEdit(event.target, true);
    } else if (event.key === 'Escape') {
      exitDescriptionEdit(event.target, false);
    }
  });

  //ALT
  //inputDescription.onfocusout = (event) => {exitDescriptionEdit(event.target,false);};
  inputDescription.addEventListener('focusout', (event) => {
    exitDescriptionEdit(event.target, false);
  });

  const button = document.getElementById('btnToggleForm');
  button.addEventListener('click', (event) => {
    showHideForm();
  });

  const formButton = document.getElementById('btnSaveReview');
  formButton.addEventListener('click', (event)=>{
    event.preventDefault(); //stops bubble up of default for event
    saveReview();
  });



});

/*
Altnernative to above
function onContentLoaded(){
  setPageTitle();
  // set the product reviews page description
  setPageDescription();
  // display all of the product reviews on our page
  displayReviews();
}
//example of using a named function as an event handler
document.addEventListener('DOMContentLoaded', onContentLoaded);
*/