const name = 'Cigar Parties for Dummies';
let description = 'Host and plan the perfect cigar party for all of your squirrelly friends.';
let reviews = [
  {
    id : 1,
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
  tmpl.querySelector('input[type="hidden"]').value = review.id;
  // there will always be 1 star because it is a part of the template
  for (let i = 1; i < review.rating; ++i) {
    const img = tmpl.querySelector('img').cloneNode();
    tmpl.querySelector('.rating').appendChild(img);
  }
  if(review.hasDelete) {
    const btnContainer = document.createElement('div');
    btnContainer.style = "display:flex; justify-content:flex-end;";

    const btn = document.createElement('button');
    btn.classList.add('btn', 'btn-outline-success', 'btn-sm');
    btn.innerText = "Delete";

    btn.addEventListener('click', (event) => {
      const btn = event.currentTarget;
      const reviewDiv = btn.closest('.review');
    
    
      // REMOVE FROM THE ARRAY
      // get the value of a form control
      const hiddenInput = reviewDiv.querySelector('input[type="hidden"]'); 
      const objectId = hiddenInput.value;
      
      // remove the value from the underlying array
      reviews = reviews.filter( (rv) => {
        return rv.id != objectId;
      } );
    
      // END REMOVE ARRAY


      // REMOVE FROM THE DOM
      //delete the node
      // remove removes the node from the dom
      reviewDiv.remove();
      
    
    });

    btnContainer.appendChild(btn);
    tmpl.querySelector('.review').appendChild(btnContainer);

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
  // grab the text box
  const textBox = desc.nextElementSibling;
  // set the text of the textbox to the current description text
  textBox.value = description;
  // make the textbox visible by removing the d-none class
  textBox.classList.remove('d-none');
  // make the <p> invisible by adding d-none to its classes
  desc.classList.add('d-none');
  // put the cursor in the textbox by giving it focus
  textBox.focus();
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

  if (form.classList.contains('d-none')) {
    form.classList.remove('d-none');
    btn.innerText = 'Hide Form';
    document.getElementById('name').focus();
  } else {
    resetFormValues();
    form.classList.add('d-none');
    btn.innerText = 'Add Review';
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
  const name = document.getElementById('name').value;
  const title = document.getElementById('title').value;
  const review = document.getElementById('review').value;
  const rating = document.getElementById('rating').value;

  //make a review object

  const randomId = Math.floor(Math.random() * 3000000000) + 1

  const newReview = {
    id : randomId,
    reviewer : name,
    title : title,
    review : review,
    rating : rating,
    hasDelete: true
  };

  //add the review object to array of reviews

  reviews.push(newReview);

  //call the code that redraws the 
  displayReview(newReview);

  //hide the form
  showHideForm();
 }


function onContentLoaded() {
  // set the product reviews page title
  setPageTitle();
  // set the product reviews page description
  setPageDescription();
  // display all of the product reviews on our page
  displayReviews();
}

/*
//example of using a named function as an event handler
document.addEventListener('DOMContentLoaded', onContentLoaded);
*/

//By convention, the dom loaded/boostrap functions go at the bottom of the file, 
// or potentially at the top 



// add event listener takes two arguments
// an event name, and a function to execute once the event fires
document.addEventListener('DOMContentLoaded', () => {

  // set the product reviews page title
  setPageTitle();
  // set the product reviews page description
  setPageDescription();
  // display all of the product reviews on our page
  displayReviews();

  //add a click handler to the description
  const desc = document.querySelector('.description');
  desc.addEventListener('click', (event) => {
    toggleDescriptionEdit(event.target);
  });

  //add keyboard event handlers to the description
  const inputDesc = document.getElementById('inputDesc');
  inputDesc.addEventListener('keyup', (event) => {
    if (event.key === 'Enter') {
      exitDescriptionEdit(event.target, true);
    } else if (event.key === 'Escape') {
      exitDescriptionEdit(event.target, false);
    }
  });

  // you may see this in the wild, using addEventListener with the name is always safe
  // some of the more common events have properties directly on the object
  //inputDesc.onfocusout = (event) => { exitDescriptionEdit(event.target, false);};

  inputDesc.addEventListener('focusout', (event) => {
    exitDescriptionEdit(event.target, false);
  });

  //toggle the form
  const toggleButton = document.getElementById('btnToggleForm');
  toggleButton.addEventListener('click', (event) => {
    showHideForm();
  });

const formButton = document.getElementById('btnSaveReview');

formButton.addEventListener('click', (event) => {
  event.preventDefault();
  saveReview();
} );


});


