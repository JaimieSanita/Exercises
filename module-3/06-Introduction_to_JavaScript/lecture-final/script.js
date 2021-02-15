/*
    Example of a multi-line comment just like in C#/Java
*/


// Single line comment

//basic javascript function.
// notice there is no return type, nor types on the arguments
function multiplyTogether(firstNum, secondNum) {
    return firstNum * secondNum;
}


/**
 * Functions start with the word function.
 * They don't have a return type and the naming convention is camel-case.
 */
function variables() {
  // Declares a variable where the value cannot be changed
  const daysPerWeek = 7;
  
  //This will trigger an error if uncommented
  //daysPerWeek = daysPerWeek + 1;
  
  console.log("Hello world");
  console.log(`There are ${daysPerWeek} days in the week`);
  
    // Declares a variable those value can be changed
    //notice the missing datatype, javascript doesn't need them
    let daysPerMonth = 30;

  console.log(`Months usually have ${daysPerMonth} days`);

  daysPerMonth = 28;

  console.log(`Except for February which has ${daysPerMonth}`);

  //you may see variables declared this way DO NOT DO THIS
  var x = 5;
  y = 7;
  // BAD BAD BAD

  // Declares a variable that will always be an array
const weekdays = [
  "Monday",
  "Tuesday",
  "Wednesday",
  "Thursday",
  "Friday",
  "Saturday",
  "Sunday"
];
console.table(weekdays);
 
//add a bonus day, the variable is constant but not it's internals
weekdays.push("Humpday");
console.table(weekdays);

// uncomment this to see a type error
//weekdays = [];

}

/**
 * Functions can also accept parameters.
 * Notice the parameters do not have types.
 * @param {Number} param1 The first number to display
 * @param {Number} param2 The second number to display
 */
function printNumericParameters(param1, param2) {
  //try calling the function with only one parameter
  // the second param will be undefined
  // note also in javascript undefined and null are different
  console.log(`The value of param1 is ${param1}`);
  console.log(`The value of param2 is ${param2}`);
}

/**
 * Compares two values x and y.
 * == is loose equality
 * === is strict equality
 * @param {Object} x
 * @param {Object} y
 */
function equality(x, y) {
  console.log(`x is ${typeof x}`);
  console.log(`y is ${typeof y}`);
  // do they have the same type?
  console.log(`types(x) === typeof(y) ${(typeof x) === (typeof y)}`)

  console.log(`x == y : ${x == y}`); // true if the objects are equal, or can be type coerced into something equal
  // if you don't have a strong reason not to, just use === for all comparisons
  console.log(`x === y : ${x === y}`); // potentially false if the types don't match false
}

/**
 * Each value is inherently truthy or falsy.
 * false, 0, '', null, undefined, and NaN are always falsy
 * everything else is always truthy
 * @param {Object} x The object to check for truthy or falsy,
 */
function isTruthyOrFalsy(x) {
  if (x) {
    console.log(`${x} is truthy`);
  } else {
    console.log(`${x} is falsy`);
  }
}

function falsyInPractice(param1){
  if(param1){
    // do a real thing here
    console.log(`You passed in a valid parameter ${param1}`)
  } else {
    console.log("You must supply a valid parameter");
  }
}

/**
 * Note, javascript does not have CLASSES although it does have OBJECTs
 */

/**
 *  Objects are simple key-value pairs
    - values can be primitive data types
    - values can be arrays
    - or they can be functions
*/
function showHowObjectsWork() {
  
  
  const person = {
    firstName: "Bill",
    lastName: "Lumbergh",
    age: 42,
    employees: [
      "Peter Gibbons",
      "Milton Waddams",
      "Samir Nagheenanajar",
      "Michael Bolton"
    ],
    //equivalent to defining a method in java
    toString: function() {
      return `${this.lastName}, ${this.firstName} (${this.age})`;
      // alternatively, java style concat 
      //return this.lastName + ", " + this.firstName + " (" + this.age + ")";
    }
  };

  // Log the object
  console.table(person);

  // Log the first and last name
  const firstName = person.firstName;
  console.log(`First Name: ${person.firstName} Last Name: ${person.lastName}`);

  // you may also see this notation be careful with it/prefer the dot notation
  // be particularly careful if you use this with arrays!!!
  const lastName = person["lastName"];
  console.log(`lastName variable: ${lastName}`);

  // Log each employee
  for(let i = 0; i < person.employees.length; i++ ){
    console.log(`Employee ${i+1} is ${person.employees[i]}`);
  }


  const personFormatted = person.toString();
  console.log(personFormatted);
}

/*
########################
Function Overloading
########################

Function Overloading is not available in Javascript. If you declare a
function with the same name, more than one time in a script file, the
earlier ones are overriden and the most recent one will be used.
*/

function Add(num1, num2) {
  return num1 + num2;
}

// below is an example of how I can make a function
// which takes variables numbers of arguments
function Add(num1, num2, num3) {
  let x = 0;
  let y = 0;
  let z = 0;

  if(num1 && typeof num1 === 'number'){
    x = num1;
  }
  if(num2 && typeof num2 === 'number'){
    y = num2;
  }
  if(num3 && typeof num3 === 'number') {
    z = num3;
  }
  return x + y + z;
}

/*
########################
Math Library
########################

A built-in `Math` object has properties and methods for mathematical constants and functions.
*/

function mathFunctions() {
  console.log("Math.PI : " + Math.PI);
  console.log("Math.LOG10E : " + Math.LOG10E);
  console.log("Math.abs(-10) : " + Math.abs(-10));
  console.log("Math.floor(1.99) : " + Math.floor(1.99));
  console.log("Math.ceil(1.01) : " + Math.ceil(1.01));
  // this random is not cryptographically secure
  // you cannot trust any values it provides!
  // NOT FOR PASSWORDS, NOT FOR GAMES/GAMBLING
  console.log("Math.random() : " + Math.random());
}

/*
########################
String Methods
########################

The string data type has a lot of properties and methods similar to strings in Java/C#
*/

function stringFunctions(value) {
  console.log(`.length -  ${value.length}`);
  console.log(`.endsWith('World') - ${value.endsWith("World")}`);
  console.log(`.startsWith('Hello') - ${value.startsWith("Hello")}`);
  console.log(`.indexOf('Hello') - ${value.indexOf("Hello")}`);

  /*
    Other Methods
        - split(string)
        - substr(number, number)
        - substring(number, number)
        - toLowerCase()
        - trim()
        - https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/String
    */
}


function generateAnObject() {

  const anObject = {
    printSilly: function(){
      console.log(`${Math.random()} is a silly number`);
    },
    counter : 1,
    increment : function() {
      this.counter += 1;
    }
  };

  return anObject;

}