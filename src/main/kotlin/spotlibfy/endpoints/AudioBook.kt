package spotlibfy.endpoints

import spotlibfy.endpoints.AudioBook.IDS_DOC
import spotlibfy.endpoints.AudioBook.ID_DOC
import spotlibfy.endpoints.AudioBook.LIMIT_DOC
import spotlibfy.endpoints.AudioBook.MARKET_DOC
import spotlibfy.endpoints.AudioBook.OFFSET_DOC
import spotlibfy.scopes.Scopes.USER_LIBRARY_MODIFY
import spotlibfy.scopes.Scopes.USER_LIBRARY_READ

/**
 * Contains endpoints referenced to artists
 * @author Serginho
 * @since 0.0.2
 */
object AudioBook {
    /**
     * Endpoint of the AudioBooks
     * @author Serginho
     * @since 0.0.2
     */
    const val ENDPOINT = "https://api.spotify.com/v1/audio-books"

    /**
     * Endpoint of users AudioBooks
     * @see [User.ENDPOINT_USER]
     * @author Serginho
     * @since 0.0.2
     */
    const val ENDPOINT_USER = "${User.ENDPOINT_USER}/audio-books"

    /**
     * Parameter id
     *
     * The Spotify ID for the audiobook.
     *
     * Example: 7iHfbu1YPACw6oZPAFJtqe
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
     *Parameter ids
     *
     * A comma-separated list of the Spotify IDs.
     *
     * Example: ids=18yVqkdbdRvS24c0Ilj2ci,1HGw3J3NxZO1TP1BTtVhpZ,7iHfbu1YPACw6oZPAFJtqe
     */
    private val IDS_DOC = Unit

    /**
     * Parameter limit
     *
     * The maximum number of items to return.
     *
     * Default: limit=20, Range: 1 - 50, Example: limit=10
     * @author Serginho
     * @since 0.0.2
     */
    private val LIMIT_DOC = Unit

    /**
     * Parameter offset
     *
     * The index of the first item to return. Default: 0 (the first item). Use with limit to get the next set of items.
     *
     * Default: offset=0, Example: offset=10
     * @author Serginho
     * @since 0.0.2
     */
    private val OFFSET_DOC = Unit

    /**
     * Type Request: GET
     *
     * Get Spotify catalog information for a single audiobook. Audiobooks are only available within the US, UK, Canada,
     * Ireland, New Zealand and Australia markets.
     * @param id See [ID_DOC]
     * @param market See [MARKET_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    fun getAudioBook(id: String, market: String = "") = "$ENDPOINT/$id?market=$market"

    /**
     * Type Request: GET
     *
     * Get Spotify catalog information for several audiobooks identified by their Spotify IDs. Audiobooks are only
     * available within the US, UK, Canada, Ireland, New Zealand and Australia markets.
     * @param ids See [IDS_DOC]
     * @param market See [MARKET_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    fun getAudioBooks(ids: String, market: String) = "$ENDPOINT/?ids=$ids&market=$market"

    /**
     * Type Request: GET
     *
     * Get Spotify catalog information about an audiobook's chapters. Audiobooks are only available within the US, UK,
     * Canada, Ireland, New Zealand and Australia markets.
     * @param id See [ID_DOC]
     * @param market See [MARKET_DOC]
     * @param limit See [LIMIT_DOC]
     * @param offset See [OFFSET_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    fun getAudioBookChapters(id: String, market: String = "", limit: Int = 20, offset: Int = 0) =
        "$ENDPOINT/$id/chapters?market=$market&limit=$limit&offset=$offset"

    /**
     * Type Request: GET
     *
     * Get a list of the audiobooks saved in the current Spotify user's 'Your Music' library.
     *
     * Scopes Required: [USER_LIBRARY_READ]
     * @param limit See [LIMIT_DOC]
     * @param offset See [OFFSET_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    fun getUserSavedAudioBooks(limit: Int = 20, offset: Int = 0) = "$ENDPOINT_USER?limit=$limit&offset=$offset"

    /**
     * Type Request: PUT
     *
     * Save one or more audiobooks to the current Spotify user's library.
     *
     * Scopes Required: [USER_LIBRARY_MODIFY]
     * @param ids See [IDS_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    fun saveAudioBooksCurrentUser(ids: String) = "$ENDPOINT_USER?ids=$ids"

    /**
     * Type Request: DELETE
     *
     * Remove one or more audiobooks from the Spotify user's library.
     *
     * Scopes Required: [USER_LIBRARY_MODIFY]
     * @param ids See [IDS_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    fun removeAudioBooksCurrentUser(ids: String) = saveAudioBooksCurrentUser(ids)

    /**
     * Type Request: GET
     *
     * Check if one or more audiobooks are already saved in the current Spotify user's library.
     *
     * Scopes Required: [USER_LIBRARY_READ]
     * @param ids See [IDS_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    fun checkAudioBooksCurrentUser(ids: String) = "$ENDPOINT_USER/contains?ids=$ids"
}