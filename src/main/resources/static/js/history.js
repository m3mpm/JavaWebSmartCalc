table = document.querySelector(".history-table");
btnClearHistory = document.querySelector(".btn-clear-history");

function showStrInHistory(str) {
    const newtr = document.createElement('tr');
    const newtd = document.createElement('td');
    
    newtd.textContent = str;
    newtr.append(newtd);
    table.prepend(newtr);
}

function showAllHistory() {
    const promise = getHistory();
    promise.then(response => {
        let history = response.data;
        history.forEach((str) => {
            showStrInHistory(str);
        });
    });
}

showAllHistory();

table.addEventListener("click", function(event) {
    var target = event.target;

    if (target.tagName === "TD") {
      var text = target.textContent;
      screen.textContent = text;
    }
});

btnClearHistory.addEventListener("click",function(event){
    event.preventDefault();
    while(table.rows.length > 0){
        table.deleteRow(0);
    }
    cleanHistory();
});
    