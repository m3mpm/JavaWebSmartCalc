const creditInputSum = document.getElementById("credit-input-sum");
const creditInputPeriod = document.getElementById("credit-input-period");
const creditInputPercent = document.getElementById("credit-input-percent");

const pay = document.querySelector(".pay");
const percent = document.querySelector(".percent");
const totalSum = document.querySelector(".total-sum");

const tableBody = document.querySelector(".credit-table tbody");

const btnCreditResult = document.querySelector(".btn-credit-result");

function typeCreditPayment(){
    var isAnnuity = document.getElementById("annuity").checked;
    var isDifferent = document.getElementById("different").checked;
    var type = 0;
    if(isAnnuity) type = 1;
    if(isDifferent) type = 2;
    return type;
}

function fillTable(creditData){
    tableBody.innerHTML = "";
    tableBody.insertAdjacentHTML('beforeend',creditData.map(n => `
                    <tr>
                    <td>${n[0]}</td>
                    <td>${parseFloat(n[1]).toFixed(2)}</td>
                    <td>${parseFloat(n[2]).toFixed(2)}</td>
                    <td>${parseFloat(n[3]).toFixed(2)}</td>
                    <td>${parseFloat(n[4]).toFixed(2)}</td>
                    </tr>`)
                .join('')
    )
}

function showMonthPay(creditData,type){
    var payPerMonth = parseFloat(creditData[0][1]).toFixed(2);
    var payFirstMonth = payPerMonth;
    var payLastMonth = parseFloat(creditData[creditData.length - 1][1]).toFixed(2);
    if(type == 1) {
        pay.textContent = payPerMonth;
    } else {
        pay.textContent = payFirstMonth + " .. " + payLastMonth;
    }
}

function showPercentAndSumPay(creditData){
    var percentPay = 0.0;
    var sumPay = 0.0;
    for(let i=0; i< creditData.length; i++){
        sumPay += creditData[i][1];
        percentPay += creditData[i][3];
    }
    percent.textContent = parseFloat(percentPay).toFixed(2);
    totalSum.textContent = parseFloat(sumPay).toFixed(2);
}

function showResult(creditData, type) {
    showMonthPay(creditData,type);
    showPercentAndSumPay(creditData);
}

btnCreditResult.addEventListener("click",function (event){
    event.preventDefault();

    var sum = creditInputSum.value;
    var period = creditInputPeriod.value;
    var percent = creditInputPercent.value;
    var type = typeCreditPayment();

    if(type == 1 || type == 2){
        const promis = getCreditData(sum,period,percent,type);

        promis.then(function(response){
            var creditData = response.data;
            showResult(creditData,type);
            fillTable(creditData);

        }).catch(function(err){
            console.log(err);
        });
    }

});
