fun main(args: Array<String>) {
    //var arrayVacio: Array<String> = emptyArray();

    var arrayVacio: Array<String?> = arrayOfNulls<String>(7);
    //array de cualquier cosa
    var arrayELementos: Array<Any?> = arrayOf(1, 3, 2, 3, "asd", false, null);
    var arrayNumeros = intArrayOf(1, 2, 3, 4);

    //obtener datos:
    println(arrayELementos[0])
    arrayELementos.forEach {
        it
        println(it)
    }
    //cambiar elementos:
    arrayELementos[3] = "cambio"

    for (i in arrayELementos) {
        println(i);
    }
    //encontrar cuantos 3:
    var contador = 0;
    arrayELementos.forEach {
        if (it == 3) {
            contador++;
        }
    }
    //.find te devuelve el primer elemento que cumpla la condicion
    var lista = arrayELementos.find { it == 3 }
    //.filter te devuelve un list
    arrayELementos.filter { it == 3 }
    println("numero 3 ${arrayELementos.filter { it == 3 }.size}")

    //ARRAYLIST igual
    var listaELementos = ArrayList<String>()
    listaELementos.add("123134")
    listaELementos[1]="1243678s"
    //posicion 0
    listaELementos.get(0)
    listaELementos[0]
    //borra lo igual
    listaELementos.remove("afsg")
    //borra posicion AT
    listaELementos.removeAt(0)
    //borra con condicion
    listaELementos.removeIf { it.equals("qwe",false)}
    
}