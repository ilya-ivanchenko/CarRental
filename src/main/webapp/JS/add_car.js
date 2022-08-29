console.log("add_car works...");
let eMileageBlock;

let tankConsumptionBlock;

function init(){
    console.log("document onload");
    eMileageBlock = document.querySelector('#e-mileage-block');
    tankConsumptionBlock = document.querySelector('#tank-consumption-block'); //

    // взять значение из "Тип двигателя, input-fuel-checked"
    const fuelTypeInput = document.querySelector('input[name=fuel][checked]');
    onChangeEngineType(fuelTypeInput.value);
}

init();

function onChangeEngineType(value) {
    console.log("changeEngine = ", value);
    if (value === "Электро") {
        console.log("выбрано электро");
        showEMileageBlock();
        hideTankConsumptionBlock();
    } else {
        console.log("не выбрано электро");
        showTankConsumptionBlock();
        hideEMileageBlock();
    }
}

function showEMileageBlock() {
    console.log(eMileageBlock);
    eMileageBlock.hidden = false;
}
function hideEMileageBlock() {
    console.log(eMileageBlock);
    eMileageBlock.hidden = true;
}

function showTankConsumptionBlock() {
    tankConsumptionBlock.hidden = false;
}
function hideTankConsumptionBlock() {
    tankConsumptionBlock.hidden = true;
}