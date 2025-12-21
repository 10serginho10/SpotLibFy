package spotlibfy.net

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*

/**
 * Makes an authenticated HTTP request with the provided access token and returns the response body as text.
 * @author Serginho
 * @since 0.0.3
 */
suspend fun makeRequest(
    accesToken: String, response: String, client: HttpClient
): String {
    val response = client.get(response) {
        headers {
            append(HttpHeaders.Authorization, "Bearer $accesToken")
        }
    }
    return response.bodyAsText()
}