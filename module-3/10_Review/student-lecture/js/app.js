/*
TechElevator = TechElevator || {}; //pattern to create pseudo namespaces
TechElevator.myApp = {};
*/

//NAMESPACE
//Object of functions
//Key = function name: value = function
const myApp = {
    emailIsValid: function (email) {
        const re = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        return re.test(String(email).toLowerCase());
    },
    onEmailInputChange: function (event) {
        console.log('We changed the email form');
        //get containing element
        const inputElement = event.currentTarget;
        const inputContainer = inputElement.closest('.field'); //outer div
        const emailValid = myApp.emailIsValid(inputElement.value);

        //if email is not valid:
        if (!emailValid) {
            //remove is-hidden from warning message
            inputContainer.querySelector('.help').classList.remove('is-hidden');
            //add is-danger class to control div
            inputElement.classList.add('is-danger');
            //if email is valid:
        } else {
            // remove is-danger from control div
            inputContainer.querySelector('.help').classList.add('is-hidden');
            //hide warning message
            inputElement.classList.remove('is-danger');
        }


    }

}













document.addEventListener('DOMContentLoaded', () => {
    document.querySelector('input[type="email"]').addEventListener('change', myApp.onEmailInputChange);



});
