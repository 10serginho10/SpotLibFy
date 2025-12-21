package spotlibfy.configurator

/**
 * The quota mode refers to the mode in which an app can be: development mode or extended quota mode.
 * You can check the current mode of your app by checking the App Status value in the App Settings:
 * @author Serginho
 * @since 0.0.3
 */
enum class QuotaMode {
    /**
     * Development mode is used for testing and development purposes. It has limited access to the Spotify API.
     * @author Serginho
     * @since 0.0.3
     */
    DEVELOPMENT_MODE,

    /**
     * Extended quota mode is used for production purposes. It has unlimited access to the Spotify API.
     * @author Serginho
     * @since 0.0.3
     */
    EXTENDED_QUOTA_MODE
}

/**
 * Contains sensitive information for Spotify API configuration
 * @property clientID Spotify client ID
 * @property clientSecret Spotify client secret
 * @property appStatus Spotify app status @see [QuotaMode]
 * @author Serginho
 * @since 0.0.3
 */
data class ClientSecret(val clientID: String, val clientSecret: String, val appStatus: QuotaMode)

/**
 * Contains all the information necessary to configure the Spotify API
 * @property appName Spotify app name
 * @property appDescription Spotify app description
 * @property website Spotify app website
 * @property redirectUri Spotify redirect URI
 * @property clientSecret Spotify client secret @see [ClientSecret]
 * @author Serginho
 * @since 0.0.3
 */
data class SpotifyConfigurator(
    val appName: String,
    val appDescription: String,
    val website: String = "",
    val redirectUri: List<String>,
    val clientSecret: ClientSecret
)
