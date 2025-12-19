package spotlibfy.endpoints

import spotlibfy.endpoints.Search.INCLUDE_EXTERNAL_DOC
import spotlibfy.endpoints.Search.LIMIT_DOC
import spotlibfy.endpoints.Search.MARKET_DOC
import spotlibfy.endpoints.Search.OFFSET_DOC
import spotlibfy.endpoints.Search.Q_DOC
import spotlibfy.endpoints.Search.TYPE_DOC


/**
 * Contains endpoints referenced to search
 * @author Serginho
 * @since 0.0.2
 */
object Search {
    /**
     * Endpoint of the search
     * @author Serginho
     * @since 0.0.2
     */
    const val ENDPOINT = "https://api.spotify.com/v1/search"

    /**
     * Parameter q
     *
     * Your search query.
     *
     * You can narrow down your search using field filters. The available filters are album, artist, track, year, upc,
     * tag:hipster, tag:new, isrc, and genre. Each field filter only applies to certain result types. The artist and
     * year filters can be used while searching albums, artists and tracks. You can filter on a single year or a range
     * (e.g. 1955-1960). The album filter can be used while searching albums and tracks. The genre filter can be used
     * while searching artists and tracks. The isrc and track filters can be used while searching tracks. The upc,
     * tag:new and tag:hipster filters can only be used while searching albums. The tag:new filter will return albums
     * released in the past two weeks and tag:hipster can be used to return only albums with the lowest 10% popularity.
     *
     * Example: q=remaster%2520track%3ADoxy%2520artist%3AMiles%2520Davis
     * @author Serginho
     * @since 0.0.2
     */
    private val Q_DOC = Unit

    /**
     * Parameter type
     *
     * A comma-separated list of item types to search across. Search results include hits from all the specified item
     * types. For example: q=abacab&type=album,track returns both albums and tracks matching "abacab".
     *
     * Allowed values: "album", "artist", "playlist", "track", "show", "episode", "audiobook"
     * @author Serginho
     * @since 0.0.2
     */
    private val TYPE_DOC = Unit

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
     * Parameter include_external
     *
     * If include_external=audio is specified it signals that the client can play externally hosted audio content, and
     * marks the content as playable in the response. By default externally hosted audio content is marked as unplayable
     * in the response.
     *
     * Allowed values: "audio"
     * @author Serginho
     * @since 0.0.2
     */
    private val INCLUDE_EXTERNAL_DOC = Unit

    /**
     * Type Request: GET
     *
     * Get Spotify catalog information about albums, artists, playlists, tracks, shows, episodes or audiobooks that
     * match a keyword string. Audiobooks are only available within the US, UK, Canada, Ireland, New Zealand and
     * Australia markets
     * @param q See [Q_DOC]
     * @param type See [TYPE_DOC]
     * @param market See [MARKET_DOC]
     * @param limit See [LIMIT_DOC]
     * @param offset See [OFFSET_DOC]
     * @param includeExternal See [INCLUDE_EXTERNAL_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    fun searchItem(
        q: String, type: String, market: String = "", limit: Int = 20, offset: Int = 0, includeExternal: String = ""
    ) = "$ENDPOINT?q=$q&type=$type&market=$market&limit=$limit&offset=$offset&include_external=$includeExternal"
}