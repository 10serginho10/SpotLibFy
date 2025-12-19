package endpoints

import endpoints.Playlist.ADDITIONAL_TYPES_DOC
import endpoints.Playlist.CATEGORY_ID_DOC
import endpoints.Playlist.FIELDS_DOC
import endpoints.Playlist.LIMIT_DOC
import endpoints.Playlist.Locale_DOC
import endpoints.Playlist.MARKET_DOC
import endpoints.Playlist.OFFSET_DOC
import endpoints.Playlist.PLAYLIST_ID_DOC
import endpoints.Playlist.POSITION_DOC
import endpoints.Playlist.URIS_DOC
import endpoints.Playlist.USER_ID_DOC
import spotlibfy.scopes.Scopes.*

/**
 * Contains endpoints referenced to genres
 * @author Serginho
 * @since 0.0.2
 */
object Playlist {
    /**
     * Endpoint of the playlists
     * @author Serginho
     * @since 0.0.2
     */
    const val ENDPOINT = "https://api.spotify.com/v1/playlists"

    /**
     * Endpoint of users playlists
     * @author Serginho
     * @since 0.0.2
     */
    const val ENDPOINT_USER = "https://api.spotify.com/v1/me/playlists"

    /**
     * Parameter playlist_id
     *
     * The Spotify ID of the playlist.
     *
     * Example: 3cEYpjA9oz9GiPac4AsH4n
     * @author Serginho
     * @since 0.0.2
     */
    private val PLAYLIST_ID_DOC = Unit

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
     * Parameter fields
     *
     * Filters for the query: a comma-separated list of the fields to return. If omitted, all fields are returned. For
     * example, to get just the playlist''s description and URI: fields=description,uri. A dot separator can be used to
     * specify non-reoccurring fields, while parentheses can be used to specify reoccurring fields within objects. For
     * example, to get just the added date and user ID of the adder: fields=tracks.items(added_at,added_by.id). Use
     * multiple parentheses to drill down into nested objects, for example: fields=tracks.items(track(name,href,
     * album(name,href))). Fields can be excluded by prefixing them with an exclamation mark, for example:
     * fields=tracks.items(track(name,href,album(!name,href)))
     *
     * Example: fields=items(added_by.id,track(name,href,album(name,href)))
     * @author Serginho
     * @since 0.0.2
     */
    private val FIELDS_DOC = Unit

    /**
     * Parameter additional_types
     *
     * A comma-separated list of item types that your client supports besides the default track type. Valid types are:
     * track and episode. Note: This parameter was introduced to allow existing clients to maintain their current
     * behaviour and might be deprecated in the future. In addition to providing this parameter, make sure that your
     * client properly handles cases of new types in the future by checking against the type field of each object.
     * @author Serginho
     * @since 0.0.2
     */
    @Deprecated("May disappear in the future.")
    private val ADDITIONAL_TYPES_DOC = Unit

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
     * Parameter uris
     *
     * A comma-separated list of Spotify URIs to set, can be track or episode URIs. A maximum of 100 items can be set in
     * one request.
     *
     * Example: uris=spotify:track:4iV5W9uYEdYUVa79Axb7Rh,spotify:track:1301WleyT98MSxVHPZCA6M,
     * spotify:episode:512ojhOuo1ktJprKbVcKyQ
     */
    private val URIS_DOC = Unit

    /**
     * Parameter position
     *
     * The position to insert the items, a zero-based index. For example, to insert the items in the first position:
     * position=0; to insert the items in the third position: position=2. If omitted, the items will be appended to the
     * playlist. Items are added in the order they are listed in the query string or request body.
     *
     * Example: position=0
     * @author Serginho
     * @since 0.0.2
     */
    private val POSITION_DOC = Unit

    /**
     * Parameter playlist_id
     *
     * The user's Spotify user ID.
     *
     * Example: smedjan
     * @author Serginho
     * @since 0.0.2
     */
    private val USER_ID_DOC = Unit

    /**
     * Parameter locale
     *
     * The desired language, consisting of an ISO 639-1 language code and an ISO 3166-1 alpha-2 country code, joined by
     * an underscore. For example: es_MX, meaning "Spanish (Mexico)". Provide this parameter if you want the category
     * strings returned in a particular language. Note: if locale is not supplied, or if the specified language is not
     * available, the category strings returned will be in the Spotify default language (American English).
     *
     * Example: locale=sv_SE
     */
    private val Locale_DOC = Unit

    /**
     * Parameter category_id
     *
     * The Spotify category ID for the category.
     *
     * Example: dinner
     */
    private val CATEGORY_ID_DOC = Unit

    /**
     * Type Request: GET
     *
     * Get a playlist owned by a Spotify user.
     *
     *@param playlistId See [PLAYLIST_ID_DOC]
     * @param market See [MARKET_DOC]
     * @param fields See [FIELDS_DOC]
     * @param additionalTypes See [ADDITIONAL_TYPES_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    fun getPlaylists(playlistId: String, market: String = "", fields: String = "", additionalTypes: String = "") =
        "$ENDPOINT/$playlistId?market=$market&fields=$fields&additional_types=$additionalTypes"

    /**
     * Type Request: PUT
     *
     * Change a playlist's name and public/private state. (The user must, of course, own the playlist.)
     *
     * Scopes Required: [PLAYLIST_MODIFY_PUBLIC] | [PLAYLIST_MODIFY_PRIVATE]
     * @param playlistId See [PLAYLIST_ID_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    fun changePlaylistDetails(playlistId: String) = "$ENDPOINT/$playlistId"

    /**
     * Type Request: GET
     *
     * Get full details of the items of a playlist owned by a Spotify user.
     *
     * Scopes Required: [PLAYLIST_READ_PRIVATE]
     * @param playlistId See [PLAYLIST_ID_DOC]
     * @param market See [MARKET_DOC]
     * @param fields See [FIELDS_DOC]
     * @param limit See [LIMIT_DOC]
     * @param offset See [OFFSET_DOC]
     * @param additionalTypes See [ADDITIONAL_TYPES_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    fun getPlayListItems(
        playlistId: String,
        market: String = "",
        fields: String = "",
        limit: Int = 20,
        offset: Int = 0,
        additionalTypes: String = ""
    ) =
        "$ENDPOINT/$playlistId/tracks?market=$market&fields=$fields&limit=$limit&offset=$offset&additional_types=$additionalTypes"

    /**
     * Type Request: PUT
     *
     * Either reorder or replace items in a playlist depending on the request's parameters. To reorder items, include
     * range_start, insert_before, range_length and snapshot_id in the request's body. To replace items, include uris as
     * either a query parameter or in the request's body. Replacing items in a playlist will overwrite its existing
     * items. This operation can be used for replacing or clearing items in a playlist. Note: Replace and reorder are
     * mutually exclusive operations which share the same endpoint, but have different parameters. These operations
     * can't be applied together in a single request.
     *
     * Scopes Required: [PLAYLIST_MODIFY_PUBLIC] | [PLAYLIST_MODIFY_PRIVATE]
     * @param playlistId See [PLAYLIST_ID_DOC]
     * @param uris See [URIS_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    fun updatePlaylistItems(playlistId: String, uris: String = "") = "$ENDPOINT/$playlistId/tracks?uris=$uris"

    /**
     * Type Request: POST
     *
     * Add one or more items to a user's playlist.
     *
     * Scopes Required: [PLAYLIST_MODIFY_PUBLIC] | [PLAYLIST_MODIFY_PRIVATE]
     * @param playlistId See [PLAYLIST_ID_DOC]
     * @param position See [POSITION_DOC]
     * @param uris See [URIS_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    fun addItemsToPlaylist(playlistId: String, position: Int = 0, uris: String = "") =
        "$ENDPOINT/$playlistId/tracks?uris=$uris&position=$position"

    /**
     * Type Request: DELETE
     *
     * Remove one or more items from a user's playlist.
     *
     * Scopes Required: [PLAYLIST_MODIFY_PUBLIC] | [PLAYLIST_MODIFY_PRIVATE]
     * @param playlistId See [PLAYLIST_ID_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    fun removeItemsFromPlaylist(playlistId: String) = "$ENDPOINT/$playlistId/tracks"

    /**
     * Type Request: GET
     *
     * Get a list of the playlists owned or followed by the current Spotify user.
     *
     * Scopes Required: [USER_READ_PRIVATE]
     * @param limit See [LIMIT_DOC]
     * @param offset See [OFFSET_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    fun getCurrentUserPlaylists(limit: Int = 20, offset: Int = 0) = "$ENDPOINT_USER?limit=$limit&offset=$offset"

    /**
     * Type Request: GET
     *
     * Get a list of the playlists owned or followed by a Spotify user.
     *
     * Scopes Required: [USER_READ_PRIVATE] | [PLAYLIST_READ_COLLABORATIVE]
     * @param userId See [USER_ID_DOC]
     * @param limit See [LIMIT_DOC]
     * @param offset See [OFFSET_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    fun getUserPlaylists(userId: String, limit: Int = 20, offset: Int = 0) =
        "$ENDPOINT/user/$userId/playlists?limit=$limit&offset=$offset"

    /**
     * Type Request: POST
     *
     * Create a playlist for a Spotify user. (The playlist will be empty until you add tracks.) Each user is generally
     * limited to a maximum of 11000 playlists.
     *
     * Scopes Required: [PLAYLIST_MODIFY_PUBLIC] | [PLAYLIST_MODIFY_PRIVATE]
     * @param userId See [USER_ID_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    fun createPlaylist(userId: String) = "$ENDPOINT/user/$userId/playlists"

    /**
     * Type Request: GET
     *
     * Get a list of Spotify featured playlists (shown, for example, on a Spotify player's 'Browse' tab).
     * @param locale See [Locale_DOC]
     * @param limit See [LIMIT_DOC]
     * @param offset See [OFFSET_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    @Deprecated("")
    fun getFeaturedPlaylist(locale: String = "", limit: Int = 20, offset: Int = 0) =
        "https://api.spotify.com/v1/browse/featured-playlists?locale=$locale&limit=$limit&offset=$offset"

    /**
     * Type Request: GET
     *
     * Get a list of Spotify playlists tagged with a particular category.
     * @param categoryId See [CATEGORY_ID_DOC]
     * @param limit See [LIMIT_DOC]
     * @param offset See [OFFSET_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    @Deprecated("")
    fun getCategoryPlaylists(categoryId: String, limit: Int = 20, offset: Int = 0) =
        "https://api.spotify.com/v1/browse/categories/$categoryId/playlists?limit=$limit&offset=$offset"

    /**
     * Type Request: GET
     *
     * Get the current image associated with a specific playlist.
     * @param playlistId See [PLAYLIST_ID_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    fun getPlaylistCoverImage(playlistId: String) = "$ENDPOINT/$playlistId/images"

    /**
     * Type Request: PUT
     *
     * Replace the image used to represent a specific playlist.
     *
     * Scopes Required: [UGC_IMAGE_UPLOAD] | [PLAYLIST_MODIFY_PUBLIC] | [PLAYLIST_MODIFY_PRIVATE]
     * @param playlistId See [PLAYLIST_ID_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    fun setCustomPlaylistCoverImage(playlistId: String) = "$ENDPOINT/$playlistId/images"
}