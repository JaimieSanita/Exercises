/*
    Example of a multi-line comment just like in C#/Java
*/

// Single line comment
//no return type nor types on arguments
function multiplyTogether(firstNum, secondNum){
    return firstNum*secondNum;
}
/**
 * Functions start with the word function.
 * They don't have a return type and the naming convention is camel-case.
 */
function variables() {
  // Declares a variable where the value cannot be changed
  const daysPerWeek = 7;
  console.log("Hello world")
  console.log(`There are ${daysPerWeek} days in the week`)
  // Declares a variable those value can be changed
  let daysPerMonth = 30;
  console.log(`Months usually have ${daysPerMonth} days`);
  daysPerMonth = 28;
  console.log(`Except for Feb which has ${daysPerMonth}`);
  //you may see variables declared this way 
  //DO NOT DO THIS; bad for scope
  var x=5;
  y=7;


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
  weekdays.push("Humpday");
  console.table(weekdays);
 
}

/**
 * Functions can also accept parameters.
 * Notice the parameters do not have types.
 * @param {Number} param1 The first number to display
 * @param {Number} param2 The second number to display
 */
function printNumericParameters(param1, param2) {
  //if call function with only one paramter
  //the second parameter wil be undefined
  //note also undefined and null are different
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
  console.log(`types(x) === typeof(y) ${typeof x === (typeof y)}`);

  console.log(`x == y : ${x == y}`); // true if object's are equal or could be coerced into something equal
  //if you don't have a strong reason not to, use ===
  console.log(`x === y : ${x === y}`); // potentially false if the types don't match 
}

/**
 * Each value is inherently truthy or falsy.
 * false, 0, '', null, undefined, and NaN are always falsy
 * everything else is always truthy
 * @param {Object} x The object to check for truthy or falsy,
 */
function falsy(x) {
  if (x) {
    console.log(`${x} is truthy`);
  } else {
    console.log(`${x} is falsy`);
  }
}

function falsyInPractice(param1){
  if(param1){
    //do a real thing:
    console.log(`You passed in a valid parameter ${param1}`)
  }else {
    console.log("You mut supply a valid parameter.");
  }

}

/**
 *  Objects are simple key-value pairs
    - values can be primitive data types
    - values can be arrays
    - or they can be functions
*/
function showHowObjectsWork() { //declaring function that takes no arguments

  const person = {              //declaring object called person
    firstName: "Bill",          //firstName(key); "Bill"(value)
    lastName: "Lumbergh",
    age: 42,
    employees: [
      "Peter Gibbons",
      "Milton Waddams",
      "Samir Nagheenanajar",
      "Michael Bolton"
    ],
    //assigning function to object property
    toString: function(){      //toString(key); function()(value)
      //this function will calculate 1 string combining multiple string properties off person object
      return `${this.lastName}, ${this.firstName}, (${this.age})`;
    }
  };

  // Log the object
  console.table(person);

  // Log the first and last name
console.table(`First Name: ${person.firstName}   Last Name: ${person.lastName} `);
const firstName = person.firstName;
//be careful with this notation
//prefer dot notation
const lastName = person["lastName"];
console.log(`lastName variable: ${lastName}`);
  // Log each employee

  for(let i = 0; i < person.employees.length; i++){
    //i+1 because setting number to employee and arrays start at 0
    console.log(`Employee: ${i+1} is ${person.employees[i]}`);
  }

  //calling toString() function off of person object
  console.log(person.toString());
  //assign toString() function off person object to const variable
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

//function that only takes numbers of arguments
//if given string, will make value 0 and only print numbers
function Add(num1, num2, num3) {
  let x=0;
  let y=0;
  let z=0;
  //checks if num1 is true and a number
  if(num1 && typeof num1=== 'number'){
    x=num1;
  }
  if(num2 && typeof num2=== 'number'){
    y=num2
  }
  if(num3 && typeof num3=== 'number'){
    z=num3
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
  //this random is not cryptographically secure
  //you cannot trust any values it provides
  //NOT FOR PASSWORDS, NOT FOR GAMES/GAMBLING
  console.log("Math.random() : " + Math.random());
  console.log("Math.round(2.03) : " + Math.round(2.03));
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

function generateAnObject(){
  
  const anObject = {
    printSilly: function(){
      console.log(`${Math.random()} is a silly number.`);
    },
    counter : 1, //added property called counter and set to 1
    increment : function() { //created increment function which will add 1 to counter
      this.counter += 1;
    }
  };

  return anObject;
}
