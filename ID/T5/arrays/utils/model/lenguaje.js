class Lenguaje {
  nombre;
  version;
  tecnologia;
  usos;
  dificultad;
  novedoso;

  constructor(nombre, version, tecnologia, usos, dificultad, novedoso) {
    this.nombre = nombre;
    this.version = version;
    this.tecnologia = tecnologia;
    this.usos = usos;
    this.dificultad = dificultad;
    this.novedoso = novedoso;
  }

  mostrarDatos() {
    console.log(`nombre: ${this.nombre}`);
    console.log(`version: ${this.version}`);
    console.log(`Tecnologia: ${this.tecnologia}`);
    console.log(`Dificultad: ${this.dificultad}`);
    console.log(`Novedoso: ${this.novedoso}`);
    console.log(`Usos: `);

    this.usos.forEach((element) => {
      console.log(element);
    });
  }

  //getter
  get getNombre() {
    return this.nombre;
  }
  //setter
  set setNombre(nombre) {
    return this.nombre;
  }
}
