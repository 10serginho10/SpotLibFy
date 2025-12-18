package endpoints

/**
 * Contains endpoints referenced to genres
 * @author Serginho
 * @since 0.0.2
 */
object Genre {
    /**
     * Endpoint of the genres
     * @author Serginho
     * @since 0.0.2
     */
    const val ENDPOINT = "https://api.spotify.com/v1/recommendations/available-genre-seeds"

    /**
     * Type Request: GET
     *
     * Retrieve a list of available genres seed parameter values for recommendations.
     * @author Serginho
     * @since 0.0.2
     */
    @Deprecated("May disappear in the future.")
    fun getAvailableGenreSeeds() = ENDPOINT
}