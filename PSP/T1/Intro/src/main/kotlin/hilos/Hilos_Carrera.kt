fun main() {
    val tortuga  = Thread{
        var  i = 0
        println("La tortuga comienza")
        while (i<5){
            Thread.sleep(500)
            println("Tortuga")
            i++
        }
    }
    val liebre = Thread{
        var j = 0
        println("la tortuga comienza")
        while (j<5){
            Thread.sleep(100)
            println("Libre")
            j++
        }
    }

    tortuga.start()
    liebre.start()
    tortuga.join()

}