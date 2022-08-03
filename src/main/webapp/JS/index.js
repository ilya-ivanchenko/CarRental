let startDateInput;
let endDateInput;

function initIndex() {
    console.log("initIndex works..");
    startDateInput = document.querySelector('#rentStartDate');
    endDateInput = document.querySelector('#rentEndDate');

    startDateInput.addEventListener('change', function (event) {
        const startDate = event.target.value;

        endDateInput.min = startDate;
        endDateInput.value = startDate;
        //логика на изменение дат
    });

    endDateInput.addEventListener('change', function (event) {

    });
}

initIndex();