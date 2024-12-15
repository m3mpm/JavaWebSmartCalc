/*----Calculator----*/

function getResult(inputStr,inputX) {
    const promise = axios.get(`/calc`,{
            params: {
                str: inputStr,
                x: inputX
            } 
        });

    return promise;     
}

/*----History----*/

function saveRecordToHistory(inputStr){
    axios.post(`/history/save`,{
        str: inputStr
    });
}

function getHistory() {
    const promise = axios.get(`/history/get`);
    return promise;
}

function cleanHistory() {
    axios.delete(`/history/clean`);
}

/*----Chart----*/

function getChartData(inputStr,minX,maxX,stepX){
    const promis = axios.get(`/chart`,{
        params: {
            str: inputStr,
            min: minX,
            max: maxX,
            step: stepX
        }
    });

    return promis;
}

/*----Credit----*/

function getCreditData(inputSum, inputPeriod, inputPercent,inputType){
    const promis = axios.get(`/credit`,{
        params: {
            sum: inputSum,
            period: inputPeriod,
            percent: inputPercent,
            type: inputType
        }
    });

    return promis;
}


