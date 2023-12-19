/*comentar */ //
//tres tipos de variables utilizaremos 2

//lenguaje no tipado
//variable de bloque
let nombre = "Borja"; // string
let edad = 1234; // numer de cualquier tipo
let experiencia = false; //boolean
let carnet = null; //null
let portatil; //undefield
let hobbies = []; //arrays dinamicos

console.log(typeof nombre);

// var variable de clase

//constantes

const DNI = "21214A";
const nombres = ["borja", "juan", "celia"];
console.log("Mensaje que quiero sacar por consola");
console.log(`El nombre del usuario es ${nombre}`);

//alert("Estas seguro que esto es un aviso ?");
//const respuesta = confirm("¿Estas seguro que quieres borrar los datos?");
/*
if (respuesta) {
  console.log("User true");
} else {
  console.log("user false");
}*/

/*

const nombreUser = prompt("Porfavor introduce tu nombre");
console.log(`EL nombre introducido x el user es ${nombreUser}`);

if (nombreUser == "" || nombreUser.length == 0) {
  alert("Faltan datos");
} else {
  console.log(`EL nombre introducido x el user es ${nombreUser}`);
}*/

let numero1 = Number(prompt("Introduce numero 1: "));

if (isNaN(numero1)) {
  console.log("not numero");
  alert("dato incorrecto");
} else {
  console.log("yes numer");
  let numero2 = Number(prompt("Introduce numero 2: "));
  if (isNaN(numero2)) {
    alert("dato incorrecto");
  } else {
    console.log("yes numer");

    let suma = numero1 + numero2;
    let resta = numero1 - numero2;
    let multi = numero1 * numero2;
    let div = numero1 / numero2;
    let mod = numero1 % numero2;
    alert(`${numero1} + ${numero2} = ${suma}\n
        ${numero1} - ${numero2} = ${resta}\n
        ${numero1} x ${numero2} = ${multi}\n
        ${numero1} / ${numero2} = ${div}\n
        ${numero1} % ${numero2} = ${mod}\n `);
  }
}
