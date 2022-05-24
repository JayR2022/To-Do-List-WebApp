// click button to create a new container
function createCard(){

    let div = document.querySelector('.start-div');
    let divCard = document.createElement('div');
    divCard.className = 'card';
    divCard.style ="width: 18rem;";
    let divCardBody = document.createElement('div');
    divCardBody.className = 'card-body';
    let pCardText = document.createElement('p');
    pCardText.textContent = 'Hello';
    pCardText.className = 'card-text';
    let lineBreak = document.createElement("br");
    
    div.appendChild(divCard);
    divCard.appendChild(divCardBody);
    divCardBody.appendChild(pCardText)
    div.appendChild(lineBreak);
}



let btn = document.querySelector('#create_button');
btn.addEventListener('click',createCard);





// btn.innerText = "Hello World";

// let para = document.querySelectorAll('button');
// for(let p of para) {
//     p.style.color = 'blue';
// }

// console.log("Hello");

// let btn1 = document.querySelector(".btn.btn-secondary");
// console.log("Hi"+btn1);
// btn1.addEventListener('click',printHello);
// btn.onclick=printHello;

// document.getElementById("myBtn").addEventListener("click", displayDate);

// making a post request
