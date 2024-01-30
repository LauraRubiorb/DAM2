import org.apache.commons.net.ftp.FTP
import org.apache.commons.net.ftp.FTPClient
import java.io.FileOutputStream

fun main() {
    val ftpcliente = FTPClient()
    try{
        //lo primero es conectar al host y puerto 21
        ftpcliente.connect("localhost",21)
        ftpcliente.login("dam2","123456")
        //entrar en modo pasivo
        ftpcliente.enterLocalPassiveMode()
        //preparar
        ftpcliente.setFileType(FTP.ASCII_FILE_TYPE)
        ftpcliente.changeWorkingDirectory("ftp")

        val output = FileOutputStream("archivo.msg")
        ftpcliente.retrieveFile("index.html",output)
        output.close()
    }catch (e:Exception){
        e.printStackTrace()
    }
}