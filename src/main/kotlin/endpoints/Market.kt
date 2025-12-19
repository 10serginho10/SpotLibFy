package endpoints

/**
 * Contains endpoints referenced to markets
 * @author Serginho
 * @since 0.0.2
 */
object Market {
    /**
     * Endpoint of the markets
     * @author Serginho
     * @since 0.0.2
     */
    const val ENDPOINT = "https://api.spotify.com/v1/markets"

    /**
     * Type Request: GET
     *
     * Get the list of markets where Spotify is available.
     * @author Serginho
     * @since 0.0.2
     */
    fun getMarkets(): String = ENDPOINT
}