fun main(args: Array<String>) {
    var ip = "8.8.8.8"
    val processBuilder3 = ProcessBuilder("cmd.exe", "/c","ping $ip > C:\\Users\\laura\\Desktop\\Laura\\COMANDOS.txt")
    val processBuilder2 = ProcessBuilder("cmd.exe","/c","ipconfig > C:\\Users\\laura\\Desktop\\Laura\\COMANDOS.txt")
    val processBuilder = ProcessBuilder("cmd.exe", "/c", "date /t > C:\\Users\\laura\\Desktop\\Laura\\COMANDOS.txt ")
    processBuilder2.start()
    processBuilder.start()
    //, "/c", "ipconfig >> C:\\Users\\laura\\Desktop\\Laura\\COMANDOS.txt"
//C:\Users\laura\Desktop\Laura
//cmd.exe" , "/c" , "date /t > C:\\Users\\laura\\Desktop\\Laura\\hora.txt

}
//ejecutar con linea de comandos hay que saber donde esta el punto class. Copiamos la ruta del .class
//cd y ruta.Para ejecutarlo le pones java y nombre sin el punto class
//"C:\Program Files\Java\jdk-18.0.2.1\bin\java.exe" MainKt
//"C:\Program Files\Java\jdk-18.0.2.1\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2022.2.2\lib\idea_rt.jar=53635:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2022.2.2\bin" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath C:\Users\laura\Documents\GitHub\DAM2\PSP\T1\Intro\out\production\Intro;C:\Users\laura\.m2\repository\org\jetbrains\kotlin\kotlin-stdlib-jdk8\1.7.10\kotlin-stdlib-jdk8-1.7.10.jar;C:\Users\laura\.m2\repository\org\jetbrains\kotlin\kotlin-stdlib\1.7.10\kotlin-stdlib-1.7.10.jar;C:\Users\laura\.m2\repository\org\jetbrains\kotlin\kotlin-stdlib-common\1.7.10\kotlin-stdlib-common-1.7.10.jar;C:\Users\laura\.m2\repository\org\jetbrains\annotations\13.0\annotations-13.0.jar;C:\Users\laura\.m2\repository\org\jetbrains\kotlin\kotlin-stdlib-jdk7\1.7.10\kotlin-stdlib-jdk7-1.7.10.jar MainKt notepad

//ejecutar dos comandos separados.