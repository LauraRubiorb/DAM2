export class PrendasClass {
  constructor(
    public nombre: string,
    public tipo: string,
    public precio: number,
    public tallas: Array<string>,
    public imagen: string,
    public categoria: string
  ) {}
}
export interface PrendasInterfaz {
  nombre: string;
  tipo: string;
  precio: number;
  tallas: Array<string>;
  imagen: string;
  categoria: string;
}
