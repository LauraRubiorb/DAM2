import org.apache.commons.net.ftp.FTP
import org.apache.commons.net.ftp.FTPClient
import java.io.FileInputStream

fun main() {
    val clienteftp = FTPClient()

    try {
        clienteftp.connect("localhost", 21)
        clienteftp.login("dam2", "123456")
        clienteftp.enterLocalPassiveMode()
        clienteftp.setFileType(FTP.BINARY_FILE_TYPE)


        val inputstream = FileInputStream("ruta")
        val exito = clienteftp.storeFile("/ruta/archivo,msg",inputstream)
        inputstream.close()
        /*
        val ficheros = clienteftp.listFiles("/")
        for (fichero in ficheros) {
            if (fichero.isFile) {
                println("Fichero: $fichero")
            } else if (fichero.isDirectory) {
                println("directorio: $fichero")
            }
        }*/

    } catch (e: Exception) {
        e.printStackTrace()
    } finally {
        clienteftp.logout()
        clienteftp.disconnect()
    }
}