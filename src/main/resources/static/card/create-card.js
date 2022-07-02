function createCard() {
      
    let div = document.querySelector('.start-div');
    let divCard = document.createElement('div');
    divCard.className = 'card';
    divCard.style ="width: 18rem;";
    let divCardBody = document.createElement('div');
    divCardBody.clsassName = 'card-body';

    const d = new Date();
    // Add Button elements
    let divInputGroup = document.createElement('div');
    divInputGroup.className = 'input-group mb-3';
    let addButton = document.createElement('button');
    addButton.className='btn btn-outline-secondary';
    addButton.type = 'button';
    addButton.id = 'button-addon1';
    addButton.innerHTML = 'Add';

    // Text Box elements
    let contentTextBox = document.createElement('input');
    contentTextBox.type='text';
    contentTextBox.placeholder='Type to-do item...';
    contentTextBox.class= 'form-control';
    contentTextBox.ariaLabel='Example text with button addon';
    contentTextBox.ariaRoleDescription='button-addon1';

    let pCardText = document.createElement('p');

    pCardText.innerText = '';
    pCardText.className = 'card-text';
    let lineBreak = document.createElement("br");

    function readText(){
        pCardText.innerText = contentTextBox.value;
    }

    function removeButtonText(){
        divInputGroup.removeChild(addButton);
        divInputGroup.removeChild(contentTextBox);
    }
    addButton.addEventListener('click',readText);

    div.appendChild(divCard);
    divCard.appendChild(divCardBody);

    divCardBody.appendChild(divInputGroup);
    divInputGroup.appendChild(addButton);
    divInputGroup.appendChild(contentTextBox);
    divCardBody.appendChild(pCardText);
    div.appendChild(lineBreak);

    addButton.addEventListener('click',removeButtonText);
    

    function CardPostApi(){
        
        console.log("Start of the function");
        fetch("http://localhost:8080/card/createCard", { //1
            method: 'post', //2
            headers: {
            "Content-type": "application/json", //3
            "Access-Control-Allow-Origin": "*",
            "Access-Control-Allow-Methods": "POST,GET,OPTIONS, PUT, DELETE",
            "Access-Control-Allow-Headers": "Accept, Content-TypeContent-Length, Accept-Encoding, X-CSRF-Token, Authorization"

            },
            body: JSON.stringify( //4
            {
                "content": contentTextBox.value,
                "createdOn": d.toISOString(),
                "selected": "false",
                "customerId": "1"
            }
            )
        })
        .then(res => console.log(res.json()))
        .then((data) => console.log(`Request succeeded with JSON response ${data}`))
        .catch((error) => console.log(`Request failed ${error}`))
        
        console.log("Inside Post APi function");


    }

    addButton.addEventListener('click',CardPostApi);
}

module.exports.createCard;