// create pseudo namespaces
/*
TechElevator = TechElevator || {};
*/

const myApp = {
    isViewSonicSKU : function(str) {
        //VX2768-PC-MHD
        const re = /^VX[0-9]+-[A-Z][A-Z]-[A-Z]+$/
        return re.test(str);
    },
    isDecimalNumberString : function (str) {
        //        ^digits(.)(digits)$
        const re = /^[0-9]+[.]*[0-9]*$/;
        return re.test(str);
    },
    emailIsValid: function(email) {
        const re = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        return re.test(String(email).toLowerCase());
    },
    onEmailInputChange : function(event) {
        console.log('We changed the email form');
        //get the containing element
        const inputElement = event.currentTarget;
        const container = inputElement.closest('.field');
        const emailValid = myApp.emailIsValid(inputElement.value);
        //if it is not valid:
        if(!emailValid){
            // remove the is-hidden from the warning message
            container.querySelector('.help').classList.remove('is-hidden');
        // add is-danger class to the control div
            inputElement.classList.add('is-danger');
        } else {
            container.querySelector('.help').classList.add('is-hidden');
            inputElement.classList.remove('is-danger'); 
        }

        //if it is valid, remove the is-danger from the control div
        // hide the warning
    }

}









document.addEventListener('DOMContentLoaded', () => {

    document.querySelector('input[type="email"]').addEventListener('change', myApp.onEmailInputChange);

});