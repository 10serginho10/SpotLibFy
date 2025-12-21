package spotlibfy.security.authenticator

import io.ktor.client.*
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.http.headers
import spotlibfy.configurator.SpotifyConfigurator

data class TokenResponse(val spotifyConfigurator: SpotifyConfigurator, val client: HttpClient, val code: String) {
    private val urlPost = "https://accounts.spotify.com/api/token"
    private val clientIDEncoded = spotifyConfigurator.clientSecret.clientID.encodeURLParameter()
    private val clientSecretEncoded = spotifyConfigurator.clientSecret.clientSecret.encodeURLParameter()
    private val redirectURIEncoded = spotifyConfigurator.redirectUri.first().encodeURLParameter()

    /**
     * Retrieves the access token from Spotify using the authorization code flow.
     * @return Access token as a string.
     */
    suspend fun getToken(): String {
        val tokenResponse: HttpResponse = client.post(urlPost) {
            headers {
                append(HttpHeaders.Authorization, "Basic $clientIDEncoded:$clientSecretEncoded")
                append("Content-Type", "application/x-www-form-urlencoded")
            }
            setBody(
                "grant_type=authorization_code&code=$code&redirect_uri=$redirectURIEncoded"
            )
        }
        return Regex("\"access_token\":\"(.*?)\"").find(tokenResponse.bodyAsText())!!.groupValues[1]
    }
}