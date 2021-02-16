/**
 * All named functions will have the function keyword and
 * a name followed by parentheses.
 * 
 * @returns {number} 1
 */

//function keyword   name         argument list     {
function returnOne() {
  return 1;
}

/**
 * Functions can also take parameters. These are just variables that are filled
 * in by whoever is calling the function.
 *
 * Also, we don't *have* to return anything from the actual function.
 *
 * @param {any} value the value to print to the console
 */
function printToConsole(value) {
  console.log(value);
}

/**
 * Write a function called multiplyTogether that multiplies two numbers together. But 
 * what happens if we don't pass a value in? What happens if the value is not a number?
 *
 * @param {number} firstParameter the first parameter to multiply
 * @param {number} secondParameter the second parameter to multiply
 */
function multiplyTogether(firstParameter, secondParameter) {
  return firstParameter * secondParameter;
}


/**
 * This version makes sure that no parameters are ever missing. If
 * someone calls this function without parameters, we default the
 * values to 0. However, it is impossible in JavaScript to prevent
 * someone from calling this function with data that is not a number.
 * Call this function multiplyNoUndefined
 *
 * @param {number} [firstParameter=0] the first parameter to multiply
 * @param {number} [secondParameter=0] the second parameter to multiply
 */

function multiplyNoUndefined(firstParameter = 0, secondParameter = 0) {
  return firstParameter * secondParameter;
}

/**
 * Functions can return earlier before the end of the function. This could be useful
 * in circumstances where you may not need to perform additional instructions or have to
 * handle a particular situation.
 * In this example, if the firstParameter is equal to 0, we return secondParameter times 2.
 * Observe what's printed to the console in both situations.
 * 
 * @param {number} firstParameter the first parameter
 * @param {number} secondParameter the second parameter
 */
function returnBeforeEnd(firstParameter, secondParameter) {
  console.log("This will always fire.");

  if (firstParameter == 0) {
    console.log("Returning secondParameter times two.");
    return secondParameter * 2;
  }

  //this only runs if firstParameter is NOT 0
  console.log("Returning firstParameter + secondParameter.");
  return firstParameter + secondParameter;
}

function dontReturnBeforeEnd(firstParameter, secondParameter) {
  console.log("This will always fire.");
  let result = 0;
  if (firstParameter == 0) {
    console.log("Returning secondParameter times two.");
    result = secondParameter * 2;
  } else {
    //this only runs if firstParameter is NOT 0
    console.log("Returning firstParameter + secondParameter.");
    result = firstParameter + secondParameter
  }

  return result;
}

/**
 * Scope is defined as where a variable is available to be used.
 *
 * If a variable is declare inside of a block, it will only exist in
 * that block and any block underneath it. Once the block that the
 * variable was defined in ends, the variable disappears.
 */
function scopeTest() {
  // This variable will always be in scope in this function
  let inScopeInScopeTest = true;

  {
    // this variable lives inside this block and doesn't
    // exist outside of the block
    let scopedToBlock = inScopeInScopeTest;
  }

  // scopedToBlock doesn't exist here so an error will be thrown
  if (inScopeInScopeTest && scopedToBlock) {
    console.log("This won't print!");
  }
}



/**
 * 
 * Take the details of a person and create an English readable sentence
 * that uses the information to describe them. We join the quirks together with
 * the separator, or `, ` by default.
 * 
 * @param {string} name name of the person we're describing
 * @param {number} age  age of the person we're describing
 * @param {string[]} [listOfQuirks] listOfQuirks the person's quirks, a list of strings
 * @param {string} [separator=', '] separator the string to separate the quirks by
 * @returns {string} the full descriptive string
 */
function createSentenceFromUser(name, age, listOfQuirks = [], separator = ', ') {
  let description = `${name} is currently ${age} years old. Their quirks are: `;
  return description + listOfQuirks.join(separator);
}


function addTwo(sum, number) {
  return sum + number;
}

/**
 * Takes an array and, using the power of anonymous functions, generates
 * their sum.
 *
 * @param {number[]} numbersToSum numbers to add up
 * @returns {number} sum of all the numbers
 */
function sumAllNumbers(numbersToSum) {
  // call reduce with a named function
  //return numbersToSum.reduce(addTwo);

  // use an anonymous function
                  //parameter list  function body
  const reducer = (sum, number) => { return sum + number;};
  
  /*
  const shortReducer = (sum, number) => sum + number;
 
  const longReducer = function(sum,number) {
    return sum + number;
  };
 */

  return numbersToSum.reduce(reducer);
}

function sumAllNumbersOldFashioned(numbersToSum) {
  let sum = 0;
  for(let i = 0; i < numbersToSum.length; i++){
    sum += numbersToSum[i];
  }
  return sum;
}

function reduceExplained(numbersToSum) {
  let sum = 0;
  for(let i = 0; i < numbersToSum.length; i++) {
    sum = addTwo(sum,numbersToSum[i]);
  }
}

/**
 * Takes an array and returns a new array of only numbers that are
 * multiples of 3
 *
 * @param {number[]} numbersToFilter numbers to filter through
 * @returns {number[]} a new array with only those numbers that are
 *   multiples of 3
 */
function allDivisibleByThree(numbersToFilter) { 
  const filterFunc = (num) => num % 3 === 0;
  return numbersToFilter.filter(filterFunc);
}


function printAllElements(arr) {
  arr.forEach((elm) => { console.log(elm);});
}

/**
 * 
 * @param {number[]} numbersToMultiply array of numbers to be multiplied
 * @param {number} multiple number to multiply all the array values by
 * @returns {number[]} returns a new array of numbers multiplied by the multiple number
 */
function multiplyAll(numbersToMultiply, multiple) {

  const mapper = (number) => {return number * multiple};
  //map function accepts a function which takes a value and returns a value (potentially different)
  return numbersToMultiply.map(mapper);

}

/* functional transformations
  function        result
   map:           array<something> -> array<somethingElse> (same sized array, 1 to 1 mapping)
   reduce:        array<something> -> 1 value of something/something else
   filter:        array<something> -> array<something> (same size, or smaller)
   forEach:       array<something> -> returns nothing, performs some action on each element

  each of the above accepts a function as its first argument
  the function takes one, or two arguments depending on the behavior of the array function*
  reduce takes two arguments*
  map, filter, forEach take a single element as their argument*

   */


/**
 * 
 * returns the number of even numbers in the provided array
 * 
 * @param {number[]} numbers an array of numbers 
 */
function numberOfEvens(numbers){
/*
   //could do this in one shot
   const reduceEvens = (sum, num) => {
     if(num %2 == 0){
       return sum + 1;
     }else {
       return sum;
     }
   }

   return numbers.reduce(reduceEvens);
   */

   /*
   // could do it in two operations
  const mapToEven = (num) => {
    if(num % 2 == 0) {
      return 1;
    } else {
      return 0;
    }
  };
  return numbers.map(mapToEven).reduce((sum,num) => sum + num);
 */

 //clearest version to read
  return numbers.filter((num) => num %2 == 0)
                .map( (num) => {return 1;})
                .reduce((sum, num) => {return sum + num;}  );

}

/**
 * 
 * @param {number[]} numbers an array of numbers 0-10
 * @returns {string[]} array of strings each representing the number in english
 */
function numberToWord(numbers){

  const mapper = (num) => {
    if(num === 1){
      return "one"
    } else if (num === 2) {
      return "two"
    } else if (num === 3) {
      return "three"
    } else {
      return "some number";
    }

  };

  return numbers.map(mapper);

}