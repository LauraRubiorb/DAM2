let contador = 0;
//buscar id
let listaMasc = document.querySelector("#lista_male");
let listaFem = document.querySelector("#lista_female");
//seleccion por etiqueta
let boton = document.querySelector("button");
let span = document.querySelector("span");
var inputResults = document.querySelector("#inputResults");

/*
solo ejecutas una vez
setTimeout(() => {
  console.log("ejecucion");
}, 5000);

ejecutas todo el ratp
setInterval(() => {
  console.log("Ejecucion recurrente");
});*/

//temporizador: contador a 0 : al dar boton el contador empieza a funcionar
/*
boton.addEventListener("click", (e) => {
  setInterval(() => {
    contador++;
    span.innerHTML = contador;
    console.log(contador);
  }, 1000);
});*/

//una promesa devuelve otra promesa, le pasas una funcion de flecha LANZAR LA PROMESA->ahora tratarla
let promesa = new Promise((res, rej) => {
  setTimeout(() => {
    let aleatorio = Math.random() * 11;
    if (aleatorio >= 5) {
      //correcta
      res(aleatorio); //funciones
    } else {
      rej("fallo en la primersa numero pequeño:"); //funciones
      //incorrecta
    }
  }, 4000);
});

promesa
  .then((res) => {
    return res;
  })
  .then((res1) => {
    console.log();
  })
  .catch((rej) => {
    console.log(rej);
  });

//https://randomuser.me/api/?results=50

function consultarUsers() {
  //cuando pulse el boton lanza la peticion

  boton.addEventListener("click", (e) => {
    if (inputResults.value === "") {
      alert("Escriba un numero para poder ver los resultados");
      return;
    } else {
      //console.log(inputResults.value);
      //SACAR EL VALOR DEL INPUT: results Y CONCATENARSELO A LA PETICION :p
      let results = inputResults.value;

      fetch("https://randomuser.me/api/?results=" + results)
        .then((res) => {
          //console.log(res);
          if (res.ok) {
            //tratar la promesa-> pasar a json
            return res.json();
          }
        })
        .then((res1) => {
          //console.log(res1);
          //sacar el nombre y apellido de todos los usuarios
          /*
      res1.results.forEach((e) => {
        console.log(e.name.first + " " + e.name.last);
      });*/

          //SACAR LOS ELEMENTOS CADA 1 SEGUNDO
          const intervalo = setInterval(() => {
            res1.results.forEach((element) => {
              if (contador < results) {
                if (element.gender == "female") {
                  listaFem.innerHTML += `<li class="list-group-item animate__animated animate__fadeInUp">${element.name.first} ${element.name.last}</li>`;
                } else {
                  listaMasc.innerHTML += `<li class="list-group-item animate__animated animate__fadeInUp">${element.name.first} ${element.name.last}</li>`;
                }
              } else {
                clearInterval(intervalo);
              }
            });
          }, 1000);
        })

        .catch(() => {});
      //clearInterval(intervalo);
    }
  });
}
consultarUsers();

//ARRANCAR LA CONSULTA CUANDO SE PULSE EL BOTON:
//antes habra un input donde tu pondras el numero
//animacion libreria: animatecss cada 0,2 segundos salga un user de arriba a abajo dowhile
//animate__fadeInUp
