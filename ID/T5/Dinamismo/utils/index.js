let lista = document.querySelector("#lista-tareas");
let boton = document.querySelector("button");

boton.addEventListener("click", (ev) => {
  //lista.innerHTML += "<li class='list-group-item'>Elemento</li>";
  let nodoLi = document.createElement("li");
  //nodoLi.className = "list-group-item"
  nodoLi.classList.add("list-group-item");
  nodoLi.textContent = "elemento";
  lista.appendChild(nodoLi);
});
/*let inputs = document.querySelectorAll("#select-prioridad");
  console.log(inputs);
});*/

//se añada unn elemento a la lista de la derecha
