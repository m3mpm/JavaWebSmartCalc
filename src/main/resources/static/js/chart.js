const chartInputMinX = document.getElementById("chart-input-minX");
const chartInputMaxX = document.getElementById("chart-input-maxX");
const chartInputMinY = document.getElementById("chart-input-minY");
const chartInputMaxY = document.getElementById("chart-input-maxY");
const chartInputStepX = document.getElementById("chart-input-stepX");

const btnChartDraw = document.querySelector(".btn-chart-draw");

Chart.defaults.responsive = "false";

var canvas = document.querySelector("canvas");
var context = canvas.getContext('2d');

var chart = new Chart(context);

function clearChart(context, canvas){
    context.clearRect(0, 0, canvas.width, canvas.height);
    chart.destroy();
}

const createLineChart = (xData,yData) => {
    clearChart(context,canvas);

    var chartName = screen.textContent;
  
    var chartData = {
        labels: xData,
        datasets: [{
            label: chartName,
            data: yData,
            pointStyle: false,
            borderWidth: 1,
            cubicInterpolationMode: "monotone",
        }]
    }

    var chartOptions = {
        plugins: {
            legend: {
                display: true,
                position: "top",
                labels: {
                    color: "black",
                    font: {
                        weight: "bold"
                    }
                }
            }
        }
    }

    var config = {
        type: 'line',
        data: chartData,
        options: chartOptions
    };

    chart = new Chart(context,config);
};


function normalizedValue(arr){
    var newArr = arr.map(function(element){
        return parseFloat(element).toFixed(2);
    });
    return newArr;
}

btnChartDraw.addEventListener("click",function(event){
    event.preventDefault();

    var inputStr = screen.textContent;
    var minX = chartInputMinX.value;
    var maxX = chartInputMaxX.value;
    var minY = chartInputMinY.value;
    var maxY = chartInputMaxY.value;
    var stepX = chartInputStepX.value;
    
    if(inputStr.includes("x") && (minX < maxX) && (minY < maxY) && stepX >= 0.01){
        showStrInHistory(inputStr);
        saveRecordToHistory(inputStr)
        
        const promis = getChartData(inputStr,minX,maxX,stepX);
        promis.then(function(response){
            var matrix = response.data;
            var arr_x = normalizedValue(matrix[0]);
            var arr_y = normalizedValue(matrix[1]);
            createLineChart(arr_x,arr_y);
        })
        .catch(function(err){
            console.log(err);
        });
    }
});
