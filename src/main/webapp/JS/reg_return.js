console.log("reg_return works...");

let needRepairField;

function init(){
    console.log("init calls...");
    needRepairField = document.querySelector('#repairPrice-block');

    const needRepairInput = document.querySelector('input[name=need_repair]');
    onChangeRepairStatus(needRepairInput.checked);
}

init();

function onChangeRepairStatus(isChecked){
    console.log("changeInput calls...");
    if (isChecked) {
        showRepairPrice();
    } else {
        hideRepairPrice();
    }
}

function showRepairPrice() {
    needRepairField.hidden = false;
}

function hideRepairPrice() {
    needRepairField.hidden = true;
}