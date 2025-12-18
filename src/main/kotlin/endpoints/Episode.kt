package endpoints

import endpoints.Episode.IDS_DOC
import endpoints.Episode.ID_DOC
import endpoints.Episode.LIMIT_DOC
import endpoints.Episode.MARKET_DOC
import endpoints.Episode.OFFSET_DOC
import spotlibfy.scopes.Scopes.*

/**
 * Contains endpoints referenced to categories
 * @author Serginho
 * @since 0.0.2
 */
object Episode {
    /**
     * Endpoint of the episodes
     * @author Serginho
     * @since 0.0.2
     */
    const val ENDPOINT = "https://api.spotify.com/v1/episodes"

    /**
     * Endpoint of users episodes
     * @author Serginho
     * @since 0.0.2
     */
    const val ENDPOINT_USER = "https://api.spotify.com/v1/me/episodes"

    /**
     * Parameter id
     *
     * The Spotify ID for the episode.
     *
     * Example: 512ojhOuo1ktJprKbVcKyQ
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
     * @author Serginho
     * @since 0.0.2
     */
    private val MARKET_DOC = Unit

    /**
     * Parameter ids
     *
     * A comma-separated list of the Spotify IDs for the episodes. Maximum: 50 IDs.
     *
     * Example: ids=77o6BIVlYM3msb4MMIL1jH,0Q86acNRm6V9GYx55SXKwf
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
     * Get Spotify catalog information for a single episode identified by its unique Spotify ID.
     *
     * Scopes Required: [USER_READ_PLAYBACK_POSITION]
     * @param id See [ID_DOC]
     * @param market See [MARKET_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    fun getEpisode(id: String, market: String = "") = "$ENDPOINT/$id?market=$market"

    /**
     * Type Request: GET
     *
     * Get Spotify catalog information for several episodes based on their Spotify IDs.
     *
     * Scopes Required: [USER_READ_PLAYBACK_POSITION]
     * @param ids See [IDS_DOC]
     * @param market See [MARKET_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    fun getEpisodes(ids: String, market: String = "") = "$ENDPOINT/?ids=$ids&market=$market"

    /**
     * Type Request: GET
     *
     * Get a list of the episodes saved in the current Spotify user's library. This API endpoint is in beta and could
     * change without warning. Please share any feedback that you have, or issues that you discover, in our developer
     * community forum.
     *
     * Scopes Required: [USER_LIBRARY_READ] [USER_READ_PLAYBACK_POSITION]
     * @param market See [MARKET_DOC]
     * @param limit See [LIMIT_DOC]
     * @param offset See [OFFSET_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    @Deprecated("This API endpoint is in beta and could change without warning.")
    fun getUsersSavedEpisodes(market: String = "", limit: Int = 20, offset: Int = 0) =
        "$ENDPOINT_USER?market=$market&limit=$limit&offset=$offset"

    /**
     * Type Request: PUT
     *
     * Save one or more episodes to the current user's library. This API endpoint is in beta and could change without
     * warning. Please share any feedback that you have, or issues that you discover, in our developer community forum.
     *
     * Scopes Required: [USER_LIBRARY_MODIFY]
     *
     * @param ids See [IDS_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    @Deprecated("This API endpoint is in beta and could change without warning.")
    fun saveEpisodesCurrentUser(ids: String) = "$ENDPOINT_USER/?ids=$ids"

    /**
     * Type Request: DELETE
     *
     * Remove one or more episodes from the current user's library.
     * This API endpoint is in beta and could change without warning. Please share any feedback that you have, or issues
     * that you discover, in our developer community forum.
     *
     * Scopes Required: [USER_LIBRARY_MODIFY]
     * @param ids See [IDS_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    @Deprecated("This API endpoint is in beta and could change without warning.")
    fun removeEpisodesCurrentUser(ids: String) = saveEpisodesCurrentUser(ids)

    /**
     * Type Request: GET
     *
     * Check if one or more episodes is already saved in the current Spotify user's 'Your Episodes' library. This API
     * endpoint is in beta and could change without warning. Please share any feedback that you have, or issues that you
     * discover, in our developer community forum.
     *
     *Scopes Required: [USER_LIBRARY_READ]
     * @param ids See [IDS_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    @Deprecated("This API endpoint is in beta and could change without warning.")
    fun checkEpisodesCurrentUser(ids: String) = "$ENDPOINT_USER/contains?ids=$ids"
}