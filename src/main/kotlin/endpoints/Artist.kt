package endpoints

/**
 * Contains endpoints referenced to artists
 * @author Serginho
 * @since 0.0.2
 */
object Artist {
    /**
     * Endpoint of the artists
     * @author Serginho
     * @since 0.0.2
     */
    const val ENDPOINT = "https://api.spotify.com/v1/artists"

    /**
     * Parameter id
     *
     *The Spotify ID of the artist.
     *
     * Example: 0TnOYISbd1XYRBk9myaseg
     * @author Serginho
     * @since 0.0.2
     */
    private val ID_DOC = Unit

    /**
     * Parameter ids
     *
     * A comma-separated list of the Spotify IDs for the artists. Maximum: 50 IDs.
     *
     * Example: ids=2CIMQHirSU0MQqyYHq0eOx,57dN52uHvrHOxijzpIgu3E,1vCWHaC5f2uS3yhpwWbIA6
     * @author Serginho
     * @since 0.0.2
     */
    private val IDS_DOC = Unit

    /**
     * Parameter include_groups
     *
     * A comma-separated list of keywords that will be used to filter the response. If not supplied, all album types
     * will be returned.
     * Valid values are:
     * - album
     * - single
     * - appears_on
     * - compilation
     *
     * Example: include_groups=single,appears_on
     * @author Serginho
     * @since 0.0.2
     */
    private val INCLUDE_GROUPS_DOC = Unit

    /**
     * Parameter market
     *
     * An ISO 3166-1 alpha-2 country code. If a country code is specified, only content that is available in that market
     * will be returned. If a valid user access token is specified in the request header, the country associated with
     * the user account will take priority over this parameter. Note: If neither market or user country are provided,
     * the content is considered unavailable for the client. Users can view the country that is associated with their
     * account in the account settings.
     *
     * Example: market=ES
     * @author Serginho
     * @since 0.0.2
     */
    private val MARKET_DOC = Unit

    /**
     * Parameter limit
     *
     * The maximum number of items to return. Default: 20. Minimum: 1. Maximum: 50.
     *
     * Default: limit=20,
     * Range: 0 - 50,
     * Example: limit=10
     * @author Serginho
     * @since 0.0.2
     */
    private val LIMIT_DOC = Unit

    /**
     * Parameter offset
     *
     * The index of the first item to return. Default: 0 (the first object). Use with limit to get the next set of items.
     *
     * Default: offset=0,
     * Example: offset=5
     * @author Serginho
     * @since 0.0.2
     */
    private val OFFSET_DOC = Unit

    /**
     * Type Request: GET
     *
     * Get Spotify catalog information for a single artist identified by their unique Spotify ID.
     * @param id See [ID_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    fun getArtist(id: String) = "$ENDPOINT/$id"

    /**
     * Type Request: GET
     *
     * Get Spotify catalog information for multiple artists based on their Spotify IDs.
     * @param ids See [IDS_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    fun getSeveralArtists(ids: String) = "$ENDPOINT/?ids=$ids"

    /**
     * Type Request: GET
     *
     * Get a list of albums released by an artist.
     * @param id See [ID_DOC]
     * @param include_groups See [INCLUDE_GROUPS_DOC]
     * @param market See [MARKET_DOC]
     * @param limit See [LIMIT_DOC]
     * @param offset See [OFFSET_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    fun getArtistAlbums(
        id: String, include_groups: String = "", market: String = "", limit: Int = 20, offset: Int = 0
    ) = "$ENDPOINT/$id/albums?include_groups=$include_groups&market=$market&limit=$limit&offset=$offset"

    /**
     * Type Request: GET
     *
     * Get Spotify catalog information about an artist's top tracks by country.
     * @param id See [ID_DOC]
     * @param market See [MARKET_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    fun getArtistTopTracks(id: String, market: String) = "$ENDPOINT/$id/top-tracks?market=$market"

    /**
     * Type Request: GET
     *
     * Get Spotify catalog information about artists similar to a given artist. Similarity is based on analysis of the
     * Spotify community's listening history.
     * @param id See [ID_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    @Deprecated("")
    fun getRelatedArtists(id: String) = "$ENDPOINT/$id/related-artists"
}