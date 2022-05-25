// click button to create a new container
<<<<<<< HEAD
function printHello(){
    return "Hello World";
}

let btn = document.querySelector('#mybutton');
btn.innerText = "Hello World";

let para = document.querySelectorAll('button');
for(let p of para) {
    p.style.color = 'blue';
}
// console.log("Hello");

// let btn1 = document.querySelector(".btn.btn-secondary");
// console.log("Hi"+btn1);
// btn1.addEventListener('click',printHello);
// btn.onclick=printHello;

// document.getElementById("myBtn").addEventListener("click", displayDate);

// making a post request
=======


function createCard(){

    let div = document.querySelector('.start-div');
    let divCard = document.createElement('div');
    divCard.className = 'card';
    divCard.style ="width: 18rem;";
    let divCardBody = document.createElement('div');
    divCardBody.className = 'card-body';
    
    
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
    // divInputGroup.removeChild(addButton);
}

// 


let btn = document.querySelector('#create_button');
btn.addEventListener('click',createCard);

// Integrating the card with the backend api.
>>>>>>> feature-frontend

