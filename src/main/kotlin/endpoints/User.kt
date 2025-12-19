package endpoints

import endpoints.User.IDS_DOC
import endpoints.User.ID_DOC
import endpoints.User.LIMIT_DOC
import endpoints.User.OFFSET_DOC
import endpoints.User.PLAYLIST_ID_DOC
import endpoints.User.TIME_RANGE_DOC
import endpoints.User.TYPE_DOC
import spotlibfy.scopes.Scopes.*

/**
 * Contains endpoints referenced to users
 * @author Serginho
 * @since 0.0.2
 */
object User {

    /**
     * Endpoint of the users
     * @author Serginho
     * @since 0.0.2
     */
    const val ENDPOINT = "https://api.spotify.com/v1/users/"
    const val ENDPOINT_USER = "https://api.spotify.com/v1/me"

    /**
     * Parameter type
     *
     * The type of entity to return. Valid values: artists or tracks
     *
     * Allowed values: "artists", "tracks"
     * @author Serginho
     * @since 0.0.2
     */
    private val TYPE_DOC = Unit

    /**
     * Parameter time_range
     *
     * Over what time frame the affinities are computed. Valid values: long_term (calculated from ~1 year of data and
     * including all new data as it becomes available), medium_term (approximately last 6 months), short_term
     * (approximately last 4 weeks).
     *
     * Default: time_range=medium_term, Example: time_range=medium_term
     */
    private val TIME_RANGE_DOC = Unit

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
     * Parameter id
     *
     * The Spotify user ID of the user.
     *
     * Example: smedjan
     * @author Serginho
     * @since 0.0.2
     */
    private val ID_DOC = Unit

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
     * Parameter ids
     *
     * A comma-separated list of the artist or the user Spotify IDs. A maximum of 50 IDs can be sent in one request.
     *
     * Example: ids=2CIMQHirSU0MQqyYHq0eOx,57dN52uHvrHOxijzpIgu3E,1vCWHaC5f2uS3yhpwWbIA6
     * @author Serginho
     * @since 0.0.2
     */
    private val IDS_DOC = Unit

    /**
     * Type Request: GET
     *
     * Get detailed profile information about the current user (including the current user's username).
     *
     * Scopes required: [USER_READ_PRIVATE] | [USER_READ_EMAIL]
     * @author Serginho
     * @since 0.0.2
     */
    fun getUser() = ENDPOINT

    /**
     * Type Request: GET
     *
     * Get the current user's top artists or tracks based on calculated affinity.
     *
     * Scopes Required: [USER_TOP_READ]
     * @param type See [TYPE_DOC]
     * @param timeRange See [TIME_RANGE_DOC]
     * @param limit See [LIMIT_DOC]
     * @param offset See [OFFSET_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    fun getUserTopItems(type: String, timeRange: String = "medium_term", limit: Int = 20, offset: Int = 0) =
        "$ENDPOINT/top/$type?limit=$limit&offset=$offset&time_range=$timeRange"

    /**
     * Type Request: GET
     *
     * Get public profile information about a Spotify user.
     * @param userId See [ID_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    fun getUserProfile(userId: String) = "$ENDPOINT/$userId"

    /**
     * Type Request: PUT
     *
     * Add the current user as a follower of a playlist.
     *
     * Scopes Required: [PLAYLIST_MODIFY_PUBLIC] | [PLAYLIST_MODIFY_PRIVATE]
     * @param playlistId See [PLAYLIST_ID_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    fun followPlaylist(playlistId: String) = "${Playlist.ENDPOINT}/$playlistId/followers"

    /**
     * Type Request: DELETE
     *
     * Remove the current user as a follower of a playlist.
     *
     * Scopes Required: [PLAYLIST_MODIFY_PUBLIC] | [PLAYLIST_MODIFY_PRIVATE]
     * @param playlistId See [PLAYLIST_ID_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    fun unfollowPlaylist(playlistId: String) = "${Playlist.ENDPOINT}/$playlistId/followers"

    /**
     * Type Request: GET
     *
     * Get the current user's followed artists.
     *
     * Scopes Required: [USER_FOLLOW_READ]
     * @param type See [TYPE_DOC]
     * @param after See [OFFSET_DOC]
     * @param limit See [LIMIT_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    fun getFollowedArtists(type: String, after: String = "", limit: Int = 20) =
        "$ENDPOINT/following?type=$type&after=$after&limit=$limit"

    /**
     * Type Request: PUT
     *
     * Add the current user as a follower of one or more artists or other Spotify users.
     *
     * Scopes Required: [USER_FOLLOW_MODIFY]
     * @param type See [TYPE_DOC]
     * @param ids See [IDS_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    fun followArtistsOrUsers(type: String, ids: String) = "$ENDPOINT/following?type=artist&ids=$ids"

    /**
     * Type Request: DELETE
     *
     * Remove the current user as a follower of one or more artists or other Spotify users.
     *
     * Scopes Required: [USER_FOLLOW_MODIFY]
     * @param type See [TYPE_DOC]
     * @param ids See [IDS_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    fun unfollowArtistsOrUsers(type: String, ids: String) = followArtistsOrUsers(type, ids)

    /**
     * Type Request: GET
     *
     * Check to see if the current user is following one or more artists or other Spotify users.
     *
     * Scopes Required: [USER_FOLLOW_READ]
     * @param type See [TYPE_DOC]
     * @param ids See [IDS_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    fun checkFollowingArtistsOrUsers(type: String, ids: String) = "$ENDPOINT/following/contains?type=$type&ids=$ids"

    /**
     * Type Request: GET
     *
     * Check to see if the current user is following a specified playlist.
     *
     * Scopes Required: [USER_FOLLOW_READ]
     * @param playlistId See [PLAYLIST_ID_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    fun checkFollowingPlaylist(playlistId: String) = "${Playlist.ENDPOINT}/$playlistId/followers/contains"
}