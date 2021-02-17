//a
function aFunction(foo) {
 //b
}
//c

function fizz() {
    //a
    const aLambda = (word) => {
        //b
        console.log(word);
        //c
    }; //d

    //e
}

/**
 * 
 *  Given a string sentence, return a string where the first letter only of every word is capitalized.
 * 
 * @param {string} sentence
 * @returns {string}   
 */
function capitalize(sentence) {
    if(sentence === undefined || sentence === null){
        return "";
    }
    const words = sentence.split(' ');
    
    const mapper = (word) => {
        if(word.length < 2) {
            return word.toUpperCase();
        } else {
            return word.substring(0,1).toUpperCase() + word.substring(1).toLowerCase();
        }
    }

    return words.map(mapper).join(' ');
    //return words.map(mapper).reduce((sentence,word) => sentence + ' ' + word);

}