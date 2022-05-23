// click button to create a new container
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
