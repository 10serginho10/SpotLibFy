package endpoints

import endpoints.Album.IDS_DOC
import endpoints.Album.ID_DOC
import endpoints.Album.LIMIT_DOC
import endpoints.Album.MARKET_DOC
import endpoints.Album.OFFSET_DOC
import spotlibfy.scopes.Scopes.USER_LIBRARY_MODIFY
import spotlibfy.scopes.Scopes.USER_LIBRARY_READ

/**
 * Contains endpoints referenced to albums
 * @author Serginho
 * @since 0.0.2
 */
object Album {
    /**
     * Endpoint of the albums
     * @author Serginho
     * @since 0.0.2
     */
    const val ENDPOINT = "https://api.spotify.com/v1/albums"

    /**
     * Endpoint of users albums
     * @author Serginho
     * @since 0.0.2
     */
    const val ENDPOINT_USER = "https://api.spotify.com/v1/me/albums"

    /**
     * Parameter id
     *
     * The Spotify ID for the album.
     *
     * Example: 4aawyAB9vmqN3uQ7FjRGTy.
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
     * A comma-separated list of the Spotify IDs for the albums. Maximum: 20 IDs.
     *
     * Example: ids=382ObEPsp2rxGrnsizN5TX,1A2GTWGtFfWp7KSQTwWOyo,2noRn2Aes5aoNVsU6iWThc
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
     * The index of the first item to return. Default: 0 (the first object). Use with limit to get the next set of items.
     *
     * Default: offset=0, Example: offset=5
     * @author Serginho
     * @since 0.0.2
     */
    private val OFFSET_DOC = Unit

    /**
     * Type Request: GET
     *
     * Get Spotify catalog information for a single album.
     * @param id See [ID_DOC]
     * @param market See [MARKET_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    fun getAlbum(id: String, market: String = "") = "$ENDPOINT/$id?market=$market"

    /**
     * Type Request: GET
     *
     * Get Spotify catalog information for multiple albums identified by their Spotify IDs.
     * @param ids See [IDS_DOC]
     * @param market See [MARKET_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    fun getSeveralAlbums(ids: String, market: String = "") = "$ENDPOINT/?ids=$ids&market=$market"

    /**
     * Type Request: GET
     *
     * Get Spotify catalog information about an album’s tracks. Optional parameters can be used to limit the number of
     * tracks returned.
     * @param id See [ID_DOC]
     * @param market See [MARKET_DOC]
     * @param limit See [LIMIT_DOC]
     * @param offset See [OFFSET_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    fun getAlbumTracks(id: String, market: String = "", limit: Int = 20, offset: Int = 0) =
        "$ENDPOINT/$id/tracks?market=$market&limit=$limit&offset=$offset"

    /**
     * Type Request: GET
     *
     * Get a list of the albums saved in the current Spotify user's 'Your Music' library.
     *
     * Scopes Required: [USER_LIBRARY_READ]
     *
     * @param limit See [LIMIT_DOC]
     * @param offset See [OFFSET_DOC]
     * @param market See [MARKET_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    fun getUsersSavedAlbums(limit: Int = 20, offset: Int = 0, market: String = "") =
        "$ENDPOINT_USER?limit=$limit&offset=$offset&market=$market"

    /**
     * Type Request: PUT
     *
     * Save one or more albums to the current user's 'Your Music' library.
     *
     * Scopes Required: [USER_LIBRARY_MODIFY]
     *
     * @param ids See [IDS_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    fun saveAlbumsCurrentUser(ids: String) = "$ENDPOINT_USER?ids=$ids"

    /**
     * Type Request: DELETE
     *
     * Remove one or more albums from the current user's 'Your Music' library.
     *
     * Scopes Required: [USER_LIBRARY_MODIFY]
     *
     * @param ids See [IDS_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    fun removeAlbumsCurrentUser(ids: String) = saveAlbumsCurrentUser(ids)

    /**
     * Type Request: GET
     *
     * Check if one or more albums is already saved in the current Spotify user's 'Your Music' library.
     *
     * Scopes Required: [USER_LIBRARY_READ]
     *
     * @param ids See [IDS_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    fun checkAlbumsCurrentUser(ids: String) = "$ENDPOINT_USER/contains?ids=$ids"

    /**
     * Type Request: GET
     *
     * Get a list of new album releases featured in Spotify (shown, for example, on a Spotify player’s “Browse” tab).
     *
     * @param limit See [LIMIT_DOC]
     * @param offset See [OFFSET_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    fun getNewReleases(limit: Int = 20, offset: Int = 0) =
        "https://api.spotify.com/v1/browse/new-releases?limit=$limit&offset=$offset"
}