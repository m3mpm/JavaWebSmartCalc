document.addEventListener('click', function(e){ console.log(e.target); });

let valueX = parseFloat(0).toFixed(2);

let instruction = document.querySelector(".instruction-container");
let calc = document.querySelector(".calc-container");
let credit = document.querySelector(".credit-container");
let history = document.querySelector(".history-container");
let graph = document.querySelector(".chart-container");

/*---header menu---*/
const clickMenu1 = document.querySelector(".menu-item-1");
const clickMenu2 = document.querySelector(".menu-item-2");
const clickMenu3 = document.querySelector(".menu-item-3");

/*---calculator buttons---*/
let screen = document.querySelector(".screen");
let screenX = document.querySelector(".screen-x");

const btnDigit = document.querySelectorAll(".btn-digit");
const btnFunc = document.querySelectorAll(".btn-func");
const btnOpenBracket = document.querySelector(".btn-open-bracket");
const btnCloseBracket = document.querySelector(".btn-close-bracket");
const btnDivide = document.querySelector(".btn-divide");
const btnMulti = document.querySelector(".btn-multi");
const btnPlus = document.querySelector(".btn-plus");
const btnMinus = document.querySelector(".btn-minus");
const btnExp = document.querySelector(".btn-exp");
const btnX = document.querySelector(".btn-x");
const btnE = document.querySelector(".btn-e");
const btnDot = document.querySelector(".btn-dot");
const btnErase = document.querySelector(".btn-erase");
const btnAc = document.querySelector(".btn-ac");
const btnResult = document.querySelector(".btn-result");
const btnSetX = document.querySelector(".btn-set-x");
const btnResetX = document.querySelector(".btn-reset-x");

const btnHistory = document.querySelector(".btn-history");
const btnGraph = document.querySelector(".btn-graph");

/*---modal window---*/
var popup = document.querySelector(".modal");
var overlay = document.querySelector(".modal-overlay");

const modalInputX = document.getElementById("modal-input-x");
const btnSaveX = document.querySelector(".btn-modal-save");
const btnCloseModal = document.querySelector(".btn-modal-close");


/*---functions & button's click---*/
function checkIsEmpty(str) {
    if ((str === null) || (str.length === 0)) {
        return true;
    } else {
        return false;
    }
}

function clickDigits(event) {
    let digit = event.target.textContent;
    screen.textContent += digit;
}

function clickFuncs(event) {
    let func = event.target.textContent;
    screen.textContent += func + "(";
}

function clickClearScreen() {
    screen.textContent = "";
}


btnDigit.forEach(digitButton => {digitButton.addEventListener("click",clickDigits)});

btnFunc.forEach(funcButton => {funcButton.addEventListener("click",clickFuncs)});

btnOpenBracket.addEventListener("click",function clickOpenBracket(event) {
    let str = screen.textContent;
    let bracket = event.target.textContent;
    if(str.at(-1) !== ')') {
        screen.textContent += bracket;
    }
});

btnCloseBracket.addEventListener("click",function clickCloseBracket(event) {
    let str = screen.textContent;
    let bracket = event.target.textContent;
    if(str.length !== 0 && str.at(-1) !== '(') {
        screen.textContent += bracket;
    }
});

btnDivide.addEventListener("click",function clickDiv(event) {
    let str = screen.textContent;
    let div = event.target.textContent;
    if(str.length === 0) {
        screen.textContent += '0' + div;
    } else if(str.at(-1) === '*') {
        str = str.substring(0,str.length - 1);
        screen.textContent = str + div;
    } else if(str.at(-1) === '/') {
        screen.textContent = str;
    } else if(str.at(-1) === '-') {
        screen.textContent = str;
    } else if(str.at(-1) === '+') {
        screen.textContent = str;
    } else if(str.at(-1) === '^') {
        str = str.substring(0,str.length - 1);
        screen.textContent = str + div;
    } else {
        screen.textContent += div;
    }
});

btnMulti.addEventListener("click",function clickMulti(event) {
    let str = screen.textContent;
    let multi = event.target.textContent;
    if(str.length === 0) {
        screen.textContent += '0' + multi;
    } else if(str.at(-1) === '/') {
        str = str.substring(0,str.length - 1);
        screen.textContent = str + multi;
    } else if(str.at(-1) === '*') {
        screen.textContent = str;
    } else if(str.at(-1) === '-') {
        screen.textContent = str;
    } else if(str.at(-1) === '+') {
        screen.textContent = str;
    } else if(str.at(-1) === '^') {
        str = str.substring(0,str.length - 1);
        screen.textContent = str + multi;
    } else {
        screen.textContent += multi;
    }
});

btnPlus.addEventListener("click",function clickPlus(event){
    let str = screen.textContent;
    let plus = event.target.textContent;
    if(str.length === 0) {
        screen.textContent += plus;
    } else if(str.at(-1) === '-') {
        str = str.substring(0,str.length - 1);
        screen.textContent = str + plus;
    } else if(str.at(-1) === '+') {
        screen.textContent = str;
    } else {
        screen.textContent += plus;
    }
});

btnMinus.addEventListener("click",function clickMinus(event) {
    let str = screen.textContent;
    let minus = event.target.textContent;
    if(str.length === 0) {
        screen.textContent += minus;
    } else if(str.at(-1) === '-') {
        screen.textContent = str;
    } else if(str.at(-1) === '+') {
        str = str.substring(0,str.length - 1);
        screen.textContent = str + minus;
    } else {
        screen.textContent += minus;
    }
});

btnExp.addEventListener("click",function clickExp(event) {
    let str = screen.textContent;
    let exp = event.target.textContent;
    if(str.length === 0) {
        screen.textContent += '0' + exp;
    } else if((str.at(-1) >= '0' && str.at(-1) <= '9') || str.at(-1) === 'x' || str.at(-1) ===')') {
            screen.textContent += exp;
    }
        

});

btnE.addEventListener("click",function clickE(event) {
    let str = screen.textContent;
    let e = event.target.textContent;
    if(str.length === 0) {
        screen.textContent += '1' + e;
    } else if((str.at(-1) >= '0' && str.at(-1) <= '9') || ((str.at(-2) >= '0' && str.at(-2) <= '9') && str.at(-1) === '.')) {
        screen.textContent += e;
    }
});

btnX.addEventListener("click",function clickX(event) {
    let str = screen.textContent;
    let xSimbol = event.target.textContent;
    if(str.length === 0) {
        screen.textContent += xSimbol;
    } else if(str.length > 0 && str.at(-1) === 'x') {
        screen.textContent = str;
    } else if(str.length > 0 && str.at(-1) === 'e') {
        screen.textContent = str;
    } else if(str.length > 0 && str.at(-2) === 'e' && (str.at(-1) === '+' || str.at(-1) === '-')) {
        screen.textContent = str;
    } else if(str.length > 0) {
        screen.textContent += xSimbol;
    }
});

btnDot.addEventListener("click",function clickDot(event) {
    let str = screen.textContent;
    let dot = event.target.textContent;
    if(str.length === 0) {
        screen.textContent += '0' + dot;
    } else if (str.at(-1) === '.') {
        screen.textContent = str;
    } else {
        screen.textContent += dot;
    }
});

btnErase.addEventListener("click",function clickErase(event) {
    let str = screen.textContent;
    if(str.length - 1 === 0) {
        clickClearScreen();
    } else {
        str = str.substring(0,str.length - 1);
        screen.textContent = str;
    }
});

btnAc.addEventListener("click",clickClearScreen);

btnResult.addEventListener("click",function clickResult() {
    let inputStr = screen.textContent;
    if(checkIsEmpty(inputStr)){
        screen.textContent = str;
    } else if (inputStr.length > 255) {
        screen.textContent = "Input str is over 255 symbols"
        setTimeout(() => screen.textContent = "", 3000);
    } else {
        showStrInHistory(inputStr);
        saveRecordToHistory(inputStr)
        const promise = getResult(inputStr,valueX);
        promise.then(
            (response) => {
                screen.textContent = parseFloat(response.data).toFixed(2).toString();
            },() => {
                screen.textContent = "Input error";
                setTimeout(() => screen.textContent = "", 3000);
            }
        );
    }
});

btnResetX.addEventListener("click",function clickResetX() {
    valueX = parseFloat(0).toFixed(2);
    screenX.textContent = valueX;
});

/*---modal window---*/
btnSetX.addEventListener("click",function clickOpenModalWindow(event){
    event.preventDefault();
    modalInputX.value = valueX;
    popup.classList.add("modal-show");
    overlay.classList.add("modal-show-overlay");
});

btnSaveX.addEventListener("click",function clickSaveX(){
    let number = parseFloat(modalInputX.value).toFixed(2);
    if(!isNaN(number)){
        valueX = number;
    } else {
        valueX = parseFloat(0).toFixed(2);
    }
    screenX.textContent = valueX;
    popup.classList.remove("modal-show");
    overlay.classList.remove("modal-show-overlay");
});

btnCloseModal.addEventListener("click",function clickCloseModalWindow(event){
    event.preventDefault();
    screenX.textContent = valueX;
    popup.classList.remove("modal-show");
    overlay.classList.remove("modal-show-overlay");
});


/*---history---*/
btnHistory.addEventListener("click",function clickHistory(event){
    event.preventDefault();
    if(graph.classList.contains("chart-show")){
        graph.classList.toggle("chart-show");
    }
    if(calc.classList.contains("calc-chart-show")){
        calc.classList.toggle("calc-chart-show");
    }

    if(calc.classList.contains("calc-chart-hide")){
        calc.classList.toggle("calc-chart-hide");
    }

    if(!history.classList.contains("history-hide") && !history.classList.contains("history-show")){
        history.classList.add("history-show");
    } else {
        history.classList.toggle("history-hide");
        history.classList.toggle("history-show");
    }

    if(!calc.classList.contains("calc-history-show") && !calc.classList.contains("calc-history-hide")) {
        calc.classList.add("calc-history-show");
    } else {
        calc.classList.toggle("calc-history-hide");
        calc.classList.toggle("calc-history-show");
    }
});


/*---chart---*/
btnGraph.addEventListener("click",function clickGraph(event){
    event.preventDefault();
    if(history.classList.contains("history-show")){
        history.classList.toggle("history-show");
    }
    if(calc.classList.contains("calc-history-show")){
        calc.classList.toggle("calc-history-show");
    }
   
    if(!graph.classList.contains("chart-hide") && !graph.classList.contains("chart-show")){
        graph.classList.add("chart-show");
    } else {
        graph.classList.toggle("chart-hide");
        graph.classList.toggle("chart-show");
    }
    if(!calc.classList.contains("calc-chart-show") && !calc.classList.contains("calc-chart-hide")) {
        calc.classList.add("calc-chart-show");
    } else {
        calc.classList.toggle("calc-chart-hide");
        calc.classList.toggle("calc-chart-show");
    }
});


/*---header menu---*/
clickMenu1.addEventListener("click",function(event){
    event.preventDefault();
    if(!clickMenu1.classList.contains("current")){

        if(history.classList.contains("history-show") || history.classList.contains("history-hide")){
            history.classList.remove("history-show");
            history.classList.remove("history-hide");
        }
        if(graph.classList.contains("chart-show") || graph.classList.contains("chart-hide")){
            graph.classList.remove("chart-show");
            graph.classList.remove("chart-hide");
        }

        if(calc.classList.contains("calc-history-show") || calc.classList.contains("calc-history-hide")) {
            calc.classList.remove("calc-history-show");
            calc.classList.remove("calc-history-hide");
        }

        if(calc.classList.contains("calc-chart-show") || calc.classList.contains("calc-chart-hide")) {
            calc.classList.remove("calc-chart-show");
            calc.classList.remove("calc-chart-hide");
        }

        clickMenu1.classList.add("current");
        instruction.classList.remove("instruction-container-hide");
        instruction.classList.add("instruction-container-show");
        
    }
    if(clickMenu2.classList.contains("current")){
        clickMenu2.classList.remove("current");
        calc.classList.remove("calc-container-show");
        calc.classList.add("calc-container-hide");
    }
    if(clickMenu3.classList.contains("current")){
        clickMenu3.classList.remove("current");
        credit.classList.remove("credit-container-show");
        credit.classList.add("credit-container-hide");
    }   
});

clickMenu2.addEventListener("click",function(event){
    event.preventDefault();
    if(clickMenu1.classList.contains("current")){
        clickMenu1.classList.remove("current");
        instruction.classList.remove("instruction-container-show");
        instruction.classList.add("instruction-container-hide");
    }
    if(!clickMenu2.classList.contains("current")){
        clickMenu2.classList.add("current");
        calc.classList.remove("calc-container-hide");
        calc.classList.add("calc-container-show");

    }
    if(clickMenu3.classList.contains("current")){
        clickMenu3.classList.remove("current");
        credit.classList.remove("credit-container-show");
        credit.classList.add("credit-container-hide");
    }   
});

clickMenu3.addEventListener("click",function(event){
    event.preventDefault();
    if(clickMenu1.classList.contains("current")){
        clickMenu1.classList.remove("current");
        instruction.classList.remove("instruction-container-show");
        instruction.classList.add("instruction-container-hide");
    }
    if(clickMenu2.classList.contains("current")){
        clickMenu2.classList.remove("current");
        calc.classList.remove("calc-container-show");
        calc.classList.add("calc-container-hide");
    }
    if(!clickMenu3.classList.contains("current")){

        if(history.classList.contains("history-show") || history.classList.contains("history-hide")){
            history.classList.remove("history-show");
            history.classList.remove("history-hide");
        }
        if(graph.classList.contains("chart-show") || graph.classList.contains("chart-hide")){
            graph.classList.remove("chart-show");
            graph.classList.remove("chart-hide");
        }

        if(calc.classList.contains("calc-history-show") || calc.classList.contains("calc-history-hide")) {
            calc.classList.remove("calc-history-show");
            calc.classList.remove("calc-history-hide");
        }

        if(calc.classList.contains("calc-chart-show") || calc.classList.contains("calc-chart-hide")) {
            calc.classList.remove("calc-chart-show");
            calc.classList.remove("calc-chart-hide");
        }

        clickMenu3.classList.add("current");
        credit.classList.remove("credit-container-hide");
        credit.classList.add("credit-container-show");
    
    }   
});
