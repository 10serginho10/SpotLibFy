package endpoints

import endpoints.Show.IDS_DOC
import endpoints.Show.ID_DOC
import endpoints.Show.LIMIT_DOC
import endpoints.Show.MARKET_DOC
import endpoints.Show.OFFSET_DOC
import spotlibfy.scopes.Scopes.*

/**
 * Contains endpoints referenced to shows
 * @author Serginho
 * @since 0.0.2
 */
object Show {
    /**
     * Endpoint of the shows
     * @author Serginho
     * @since 0.0.2
     */
    const val ENDPOINT = "https://api.spotify.com/v1/shows"

    /**
     * Endpoint of users shows
     * @see [User.ENDPOINT_USER]
     * @author Serginho
     * @since 0.0.2
     */
    const val ENDPOINT_USER = "${User.ENDPOINT_USER}/shows"

    /**
     * Parameter id
     *
     * The Spotify ID for the show.
     *
     * Example: 38bS44xjbVVZ3No3ByF1dJ
     * @author Serginho
     * @since 0.0.2
     */
    private val ID_DOC = Unit

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
     * @see [Market]
     * @author Serginho
     * @since 0.0.2
     */
    private val MARKET_DOC = Unit

    /**
     * Parameter ids
     *
     * A comma-separated list of the Spotify IDs for the shows. Maximum: 50 IDs.
     *
     * Example: ids=5CfCWKI5pZ28U0uOzXkDHe,5as3aKmN2k11yfDDDSrvaZ
     * @author Serginho
     * @since 0.0.2
     */
    private val IDS_DOC = Unit

    /**
     * Parameter limit
     *
     * The maximum number of items to return.
     *
     * Default: limit=20, Range: 0 - 50, Example: limit=10
     * @author Serginho
     * @since 0.0.2
     */
    private val LIMIT_DOC = Unit

    /**
     * Parameter offset
     *
     * The index of the first item to return. Default: 0 (the first item). Use with limit to get the next set of items.
     *
     * Default: offset=0, Example: offset=5
     * @author Serginho
     * @since 0.0.2
     */
    private val OFFSET_DOC = Unit

    /**
     * Type Request: GET
     *
     * Get Spotify catalog information for a single show identified by its unique Spotify ID.
     *
     * Scopes Required: [USER_READ_PLAYBACK_POSITION]
     * @param id See [ID_DOC]
     * @param market See [MARKET_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    fun getShow(id: String, market: String = "") = "$ENDPOINT/$id?market=$market"

    /**
     * Type Request: GET
     *
     * Get Spotify catalog information for several shows based on their Spotify IDs.
     * @param ids See [IDS_DOC]
     * @param market See [MARKET_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    fun getShows(ids: String, market: String = "") = "$ENDPOINT/?ids=$ids&market=$market"

    /**
     * Type Request: GET
     *
     * Get Spotify catalog information about an show’s episodes. Optional parameters can be used to limit the number of
     * episodes returned.
     *
     * Scopes Required: [USER_READ_PLAYBACK_POSITION]
     * @param id See [ID_DOC]
     * @param market See [MARKET_DOC]
     * @param limit See [LIMIT_DOC]
     * @param offset See [OFFSET_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    fun getShowEpisodes(id: String, market: String = "", limit: Int = 20, offset: Int = 0) =
        "$ENDPOINT/$id/episodes?market=$market&limit=$limit&offset=$offset"

    /**
     * Type Request: GET
     *
     * Get a list of shows saved in the current Spotify user's library. Optional parameters can be used to limit the
     * number of shows returned.
     *
     * Scopes Required: [USER_LIBRARY_READ]
     * @param limit See [LIMIT_DOC]
     * @param offset See [OFFSET_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    fun getUserSavedShows(limit: Int = 20, offset: Int = 0) = "$ENDPOINT_USER?limit=$limit&offset=$offset"

    /**
     * Type Request: PUT
     *
     * Save one or more shows to current Spotify user's library.
     *
     * Scopes Required: [USER_LIBRARY_MODIFY]
     * @param ids See [IDS_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    fun saveCurrentUserShows(ids: String) = "$ENDPOINT_USER?ids=$ids"

    /**
     * Type Request: DELETE
     *
     * Delete one or more shows from current Spotify user's library.
     *
     * Scopes Required: [USER_LIBRARY_MODIFY]
     * @param ids See [IDS_DOC]
     * @param market See [MARKET_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    fun removeCurrentUserShows(ids: String, market: String = "") = "$ENDPOINT_USER?ids=$ids?market=$market"

    /**
     * Type Request: GET
     *
     * Check if one or more shows is already saved in the current Spotify user's library.
     *
     * Scopes Required: [USER_LIBRARY_READ]
     * @param ids See [IDS_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    fun checkCurrentUserShows(ids: String) = "$ENDPOINT_USER/contains?ids=$ids"
}