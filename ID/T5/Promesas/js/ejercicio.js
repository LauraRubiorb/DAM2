let selectCategorias = document.querySelector("#select-categorias");
let botonBusqueda = document.querySelector("#boton-busqueda");
let inputResultados = document.querySelector("#input-resultados");
let productosCartas = document.querySelector("#productos-cartas");
let botonCompra = document.querySelector("#boton-compra");
let botonDetalle = document.querySelector("#boton-detalle");
let listaDetalle = document.querySelector("#lista-detalles");
let listaCarrito = document.querySelector("#lista-carrito");

//HACER MAÑANA, BOTON COMPRAR Y BOTON DETALLE si le das a ver detalle abajo de carrito esta detalle y deberá salir ahi
//la descripcion y el titulo

cargarCategorias();

botonBusqueda.addEventListener("click", () => {
  cargarProductos(inputResultados.value, selectCategorias.value);
});

function cargarCategorias() {
  fetch("https://dummyjson.com/products/categories")
    .then((res) => {
      return res.json();
    })
    .then((res1) => {
      res1.forEach((element) => {
        selectCategorias.innerHTML += `<option>${element}</option>`;
      });
    });
}

function cargarProductos(numero, categoria) {
  productosCartas.innerHTML = "";
  let url = `https://dummyjson.com/products/category/${categoria}?limit=${numero}`;
  fetch(url)
    .then((res) => {
      return res.json();
    })
    .then((res1) => {
      res1.products.forEach((element) => {
        //console.log(element);
        productosCartas.innerHTML += `<div class="card m-4" style="width: 18rem">
        <img src="${element.thumbnail}" class="card-img-top" alt="${element.title}" />
        <div class="card-body">
          <h5 class="card-title">${element.title}</h5>
          <p class="card-text">
            ${element.price}
          </p>
          <div class="row">
            <a href="#" class="btn btn-primary col" onclick="agregarAlCarro('${element.title}', '${element.price}')">Comprar</a>
            <a href="#" class="btn btn-success col" onclick="mostrarDetalles('${element.title}','${element.price}','${element.thumbnail}','${element.description}')">Ver detalle</a>
          </div>
        </div>
      </div>`;
      });
    });
  function mostrarDetalles(nombre, precio, imagen, descripcion) {
    detalles.innerHTML = "";
    detalles.innerHTML = `<img src="${imagen}" alt="producto">
      <span>${nombre} · ${precio}€</span>
      <p>${descripcion}</p>`;
  }
  function agregarAlCarro(nombre, precio) {
    listaCarrito.innerHTML += `<li class="list-group-item">${nombre} · ${precio}€</li>`;
  }
}
