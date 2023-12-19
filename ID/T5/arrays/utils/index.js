//JSON
/**
 clave : valor
 */

let lenguajeJSON = {
  nombre: "JavaJSON",
  version: 21,
  usos: ["back", "front", "multi"],
  novedoso: false,
  dificultad: "media",
  mostrarDatos: function (param) {
    console.log(`parametro ${param}`);
    //funcion anonima
    console.log(`nombre: ${this.nombre}`);
    console.log(`version: ${this.version}`);
    console.log(`Tecnologia: ${this.tecnologia}`);
    console.log(`Dificultad: ${this.dificultad}`);
    console.log(`Novedoso: ${this.novedoso}`);
    console.log(`Usos: `);
  },
};
lenguajeJSON.mostrarDatos("asdasds");

const lenguajes = [
  new Lenguaje("Java", 21, "Back", [
    "Front",
    "Back",
    "Multiplataforma",
    "Media",
    false,
  ]),
  new Lenguaje(
    "Kotlin",
    14,
    "Movil",
    ["movil", "web", "plataforma"],
    "baja",
    true
  ),
  new Lenguaje(
    "Pyhton",
    3,
    "datos",
    ["IA", "BigData", "Análisis"],
    "baja",
    true
  ),
  new Lenguaje(
    "powershell",
    4,
    "sistemas",
    ["automatización", "scripting"],
    ",media",
    false
  ),
];

//SACAR TODOS LOS USOS DE TODOS AQUELLOS QUE SON NOVEDOSOS

lenguajes
  .filter((element) => element.novedoso)
  .forEach((e1) => {
    console.log(`Los usos del lenguaje ${e1.nombre} son:`);
    e1.usos.forEach((e2) => {
      console.log(e2);
    });
  });

//lenguajes.length
//console.log[lenguajes.length-1];//sacar el ultimo
/*lenguajes.forEach((elementos, index) => {
  console.log(" ${index+1} ${elementos} ");
});*/
/*
lenguajes
  .filter((elementos) => {
    return elementos.length >= 6;
  })
  .forEach((element, index) => {
    console.log(index + 1, element);
  });*/

//agregar
//lenguajes.push("TypeScript", "C#", "C++"); //final
//lenguajes.unshift("ObjetiveC", "PHP"); //principio
//console.log(lenguajes);

//eliminar

//lenguajes.pop(); //ultimo y lo guarda
//lenguajes.shift(); //principio
//console.log(lenguajes);
