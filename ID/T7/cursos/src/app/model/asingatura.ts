export class AsignaturaClase {
  constructor(
    private nombre: string,
    private siglas: string,
    private horas: number,
    private profesor: string,
    private curso: string,
    private nivel: number,
    private conocimientos: Array<string>,
    private imagen: string
  ) {}

  public get getNivel(): number {
    return this.nivel;
  }

  public get getConocimientos(): Array<string> {
    return this.conocimientos;
  }

  public get getImagen(): string {
    return this.imagen;
  }
  public get getNombre(): string {
    return this.nombre;
  }

  public get getSiglas(): string {
    return this.siglas;
  }

  public get getHoras(): number {
    return this.horas;
  }

  public get getProfesor(): string {
    return this.profesor;
  }

  public get getCurso(): string {
    return this.curso;
  }
}
export interface AsignaturaInterfaz {
  nombre: string;
  siglas: string;
  horas: number;
  profesor: string;
  curso: string;
  nivel: number;
  conocimientos: Array<string>;
  imagen: string;
}
