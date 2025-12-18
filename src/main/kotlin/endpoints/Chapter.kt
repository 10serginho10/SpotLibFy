package endpoints

import endpoints.Chapter.IDS_DOC
import endpoints.Chapter.ID_DOC
import endpoints.Chapter.MARKET_DOC


/**
 * Contains endpoints referenced to categories
 * @author Serginho
 * @since 0.0.2
 */
object Chapter {
    /**
     * Endpoint of the chapters
     * @author Serginho
     * @since 0.0.2
     */
    const val ENDPOINT = "https://api.spotify.com/v1/chapters"

    /**
     * Parameter id
     *
     * The Spotify ID for the chapter.
     *
     * Example: 0D5wENdkdwbqlrHoaJ9g29
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
     * A comma-separated list of the Spotify IDs.
     *
     * Example: ids=0IsXVP0JmcB2adSE338GkK,3ZXb8FKZGU0EHALYX6uCzU,0D5wENdkdwbqlrHoaJ9g29
     * @author Serginho
     * @since 0.0.2
     */
    private val IDS_DOC = Unit

    /**
     * Type Request: GET
     *
     * Get Spotify catalog information for a single audiobook chapter. Chapters are only available within the US, UK,
     * Canada, Ireland, New Zealand and Australia markets.
     * @param id See [ID_DOC]
     * @param market See [MARKET_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    fun getChapters(id: String, market: String = "") = "$ENDPOINT/$id&market=$market"

    /**
     * Type Request: GET
     *
     * Get Spotify catalog information for several audiobook chapters identified by their Spotify IDs. Chapters are
     * only available within the US, UK, Canada, Ireland, New Zealand and Australia markets.
     * @param ids See [IDS_DOC]
     * @param market See [MARKET_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    fun getSeveralChapters(ids: String, market: String = "") = "$ENDPOINT/?ids=$ids&market=$market"
}