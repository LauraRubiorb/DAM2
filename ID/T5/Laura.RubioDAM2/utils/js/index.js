let inputNombre = document.querySelector("#nombre-input");
let inputPassw = document.querySelector("#passw-input");
let botonAcceso = document.querySelector("#boton-acceder");
let user = "admin";
let passw = "admin";

let contenedor = document.querySelector("#contenedor");
let select = document.querySelector("#select-asig");
let boton_buscar = document.querySelector("#boton-buscar");
let ul_alumnos = document.querySelector("#lista-alumnos");
let ul_profes = document.querySelector("#lista-profes");
let contadorApr = 0;
let contadorSus = 0;

let url = "https://run.mocky.io/v3/e85e13eb-10e5-436f-9a5f-c5cbaac4eea9";

select.disabled = true;
boton_buscar.disabled = true;
ul_alumnos.disabled = true;

cargarAsig();

botonAcceso.addEventListener("click", (e) => {
  if (inputNombre.value == user && inputPassw.value == passw) {
    select.disabled = false;
    boton_buscar.disabled = false;
    ul_alumnos.disabled = false;
  } else {
    alert("Datos incorrectos");
  }
});

function cargarAsig() {
  fetch(url)
    .then((result) => {
      return result.json();
    })
    .then((res) => {
      res.asignaturas.forEach((element) => {
        select.innerHTML += `<option>${element.nombre}</option>`;
      });
    });
}

boton_buscar.addEventListener("click", (e) => {
  fetch(url)
    .then((result) => {
      return result.json();
    })
    .then((res) => {
      console.log(select.value);
      res.asignaturas.forEach((element) => {
        console.log(element.nombre);
        if (select.value == element.nombre) {
          element.alumnos.forEach((alu) => {
            ul_alumnos.innerHTML += `<li class="list-group-item">${alu.name} ,${alu.surname} ,${alu.age}</li>`;
          });
        }
      });
    });
  fetch(url)
    .then((result) => {
      return result.json();
    })
    .then((res) => {
      console.log(res); //array de las asig
      res.asignaturas.forEach((element) => {
        //nombre horas y estado
        if (element.nombre == select.value) {
          element.alumnos.forEach((alu) => {
            if ((alu.estado = "aprobado")) {
              contadorApr++;
            } else {
              contadorSus++;
            }
          });
          ul_profes.innerHTML += `<li class="list-group-item">${element.profesor} Horas: ${element.horas} Alumnos aprobados: ${contadorApr} Alumnos suspensos: ${contadorSus}</li>`;
        }
      });
    });
});
