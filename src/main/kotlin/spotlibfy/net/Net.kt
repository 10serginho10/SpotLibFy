package spotlibfy.net

import java.net.ServerSocket
import java.net.URLDecoder

/**
 * Gets the authorization code from the Spotify authorization server.
 * @param port Port to listen for the authorization code.
 * @return Authorization code.
 * @author Serginho
 * @since 0.0.3
 */
fun getAuthorizationCode(port: Int): String? {
    val server = ServerSocket(8080)
    val socket = server.accept()
    val reader = socket.getInputStream().bufferedReader()
    val requestLine = reader.readLine()
    val code = Regex("code=([^& ]+)").find(requestLine)?.groupValues?.get(1)?.let { URLDecoder.decode(it, "UTF-8") }
    val response =
        "HTTP/1.1 200 OK\r\nContent-Type: text/html\r\n\r\n" + "<h1>Autorización recibida. Puedes cerrar esta ventana.</h1>"
    socket.getOutputStream().write(response.toByteArray())
    socket.close()
    server.close()
    return code
}