package spotlibfy.security.authenticator

import spotlibfy.configurator.SpotifyConfigurator
import java.awt.Desktop
import java.net.URI
import java.net.URLEncoder

/**
 * AuthURL class represents the URL used for Spotify authentication.
 * @property fullURL URL authentication
 * @author Serginho
 * @since 0.0.3
 */
data class AuthURL(val spotifyConfigurator: SpotifyConfigurator, val scopes: List<String>) {
    private val authURL = "https://accounts.spotify.com/authorize?"
    private val paramClientID = "client_id=${spotifyConfigurator.clientSecret.clientID}"
    private val redirectURI = "redirect_uri=${URLEncoder.encode(spotifyConfigurator.redirectUri.first(), "UTF-8")}}"
    private val paramScope = "scope=${URLEncoder.encode(scopes.joinToString(" "), "UTF-8")}"
    private val paramResponse = "response_type=code"

    /**
     * Returns the full authentication URL.
     * @author Serginho
     * @since 0.0.3
     */
    val fullURL = "$authURL$paramClientID&$redirectURI&$paramScope&$paramResponse"

    /**
     * Authenticates the user by opening the authentication URL in the default browser.
     * @author Serginho
     * @since 0.0.3
     */
    fun authenticateDesktop() {
        if (Desktop.isDesktopSupported()) Desktop.getDesktop().browse(URI(fullURL))
        else println("Desktop not supported, please copy and paste the URL: $fullURL and open it in your browser")
    }
}