package spotlibfy.endpoints

import spotlibfy.endpoints.Player.ADDITIONAL_TYPES_DOC
import spotlibfy.endpoints.Player.AFTER_DOC
import spotlibfy.endpoints.Player.BEFORE_DOC
import spotlibfy.endpoints.Player.DEVICE_ID_DOC
import spotlibfy.endpoints.Player.LIMIT_DOC
import spotlibfy.endpoints.Player.MARKET_DOC
import spotlibfy.endpoints.Player.POSITION_MS_DOC
import spotlibfy.endpoints.Player.URI_DOC
import spotlibfy.endpoints.Player.VOLUME_PERCENT_DOC
import spotlibfy.scopes.Scopes.*

/**
 * Contains endpoints referenced to genres
 * @author Serginho
 * @since 0.0.2
 */
object Player {
    /**
     * Endpoint of users players
     * @see [User.ENDPOINT_USER]
     * @author Serginho
     * @since 0.0.2
     */
    const val ENDPOINT_USER = "${User.ENDPOINT_USER}/player"

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
     * Parameter device_id
     *
     * The id of the device this command is targeting. If not supplied, the user's currently active device is the target.
     *
     * Example: device_id=0d1841b0976bae2a3a310dd74c0f3df354899bc8
     * @author Serginho
     * @since 0.0.2
     */
    private val DEVICE_ID_DOC = Unit

    /**
     * Parameter position_ms
     *
     * The position in milliseconds to seek to. Must be a positive number. Passing in a position that is greater than
     * the length of the track will cause the player to start playing the next song.
     *
     * Example: position_ms=25000
     * @author Serginho
     * @since 0.0.2
     */
    private val POSITION_MS_DOC = Unit

    /**
     * Parameter volume_percent
     *
     * The volume to set. Must be a value from 0 to 100 inclusive.
     *
     * Example: volume_percent=50
     * @author Serginho
     * @since 0.0.2
     */
    private val VOLUME_PERCENT_DOC = Unit

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
     * Parameter after
     *
     * A Unix timestamp in milliseconds. Returns all items after (but not including) this cursor position. If after is
     * specified, before must not be specified.
     *
     * Example: after=1484811043508
     * @see [BEFORE_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    private val AFTER_DOC = Unit

    /**
     * Parameter before
     *
     * A Unix timestamp in milliseconds. Returns all items before (but not including) this cursor position. If before is
     * specified, after must not be specified.
     *
     * Example: before=1484811043508
     * @see [AFTER_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    private val BEFORE_DOC = Unit

    /**
     * Parameter uri
     *
     * The uri of the item to add to the queue. Must be a track or an episode uri.
     *
     * Example: uri=spotify%3Atrack%3A4iV5W9uYEdYUVa79Axb7Rh
     * @author Serginho
     * @since 0.0.2
     */
    private val URI_DOC = Unit

    /**
     * Type Request: GET
     *
     * Get information about the user’s current playback state, including track or episode, progress, and active device.
     *
     * Scopes Required: [USER_READ_PLAYBACK_STATE]
     * @param market See [MARKET_DOC]
     * @param additionalTypes See [ADDITIONAL_TYPES_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    fun getPlayerState(market: String = "", additionalTypes: String = "") =
        "$ENDPOINT_USER/?market=$market&additional_types=$additionalTypes"

    /**
     * Type Request: PUT
     *
     * Transfer playback to a new device and optionally begin playback. This API only works for users who have Spotify
     * Premium. The order of execution is not guaranteed when you use this API with other Player API endpoints.
     *
     * Scopes Required: [USER_MODIFY_PLAYBACK_STATE]
     */
    fun transferPlayer() = ENDPOINT_USER

    /**
     * Type Request: GET
     *
     * Get information about a user’s available Spotify Connect devices. Some device models are not supported and will
     * not be listed in the API response.
     *
     * Scopes Required: [USER_READ_PLAYBACK_STATE]
     * @author Serginho
     * @since 0.0.2
     */
    fun getAvailableDevices() = "$ENDPOINT_USER/devices"

    /**
     * Type Request: GET
     *
     * Get the object currently being played on the user's Spotify account.
     *
     * Scopes Required: [USER_READ_CURRENTLY_PLAYING]
     * @param market See [MARKET_DOC]
     * @param additionalTypes See [ADDITIONAL_TYPES_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    fun getCurrentlyPlayerTrack(market: String, additionalTypes: String) =
        "$ENDPOINT_USER/currently-playing?market=$market&additional_types=$additionalTypes"

    /**
     * Type Request: PUT
     *
     * Start a new context or resume current playback on the user's active device. This API only works for users who
     * have Spotify Premium. The order of execution is not guaranteed when you use this API with other Player API
     * endpoints.
     *
     * Scopes Required: [USER_MODIFY_PLAYBACK_STATE]
     * @param deviceID See [DEVICE_ID_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    fun startResumePlayer(deviceID: String = "") = "$ENDPOINT_USER/play?device_id=$deviceID"

    /**
     * Type Request: PUT
     *
     * Pause playback on the user's account. This API only works for users who have Spotify Premium. The order of
     * execution is not guaranteed when you use this API with other Player API endpoints.
     *
     * Scopes Required: [USER_MODIFY_PLAYBACK_STATE]
     * @param deviceID See [DEVICE_ID_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    fun pausePlayer(deviceID: String = "") = "$ENDPOINT_USER/pause?device_id=$deviceID"

    /**
     * Type Request: POST
     *
     * Skips to next track in the user’s queue. This API only works for users who have Spotify Premium. The order of
     * execution is not guaranteed when you use this API with other Player API endpoints.
     *
     * Scopes Required: [USER_MODIFY_PLAYBACK_STATE]
     *
     * @param deviceID See [DEVICE_ID_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    fun skipNext(deviceID: String = "") = "$ENDPOINT_USER/next?device_id=$deviceID"

    /**
     * Type Request: POST
     *
     * Skips to previous track in the user’s queue. This API only works for users who have Spotify Premium. The order
     * of execution is not guaranteed when you use this API with other Player API endpoints.
     *
     * Scopes Required: [USER_MODIFY_PLAYBACK_STATE]
     * @param deviceID See [DEVICE_ID_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    fun skipPrevious(deviceID: String = "") = "$ENDPOINT_USER/previous?device_id=$deviceID"

    /**
     * Type Request: PUT
     *
     * Seeks to the given position in the user’s currently playing track. This API only works for users who have Spotify
     * Premium. The order of execution is not guaranteed when you use this API with other Player API endpoints.
     *
     * Scopes Required: [USER_MODIFY_PLAYBACK_STATE]
     * @param positionMS See [POSITION_MS_DOC]
     * @param deviceID See [DEVICE_ID_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    fun seekToPosition(positionMS: Int, deviceID: String = "") =
        "$ENDPOINT_USER/seek?position_ms=$positionMS&device_id=$deviceID"

    /**
     * Type Request: PUT
     *
     * Set the repeat mode for the user's playback. This API only works for users who have Spotify Premium. The order of
     * execution is not guaranteed when you use this API with other Player API endpoints.
     *
     * Scopes Required: [USER_MODIFY_PLAYBACK_STATE]
     * @param state track, context or off.
     * - track will repeat the current track.
     * - context will repeat the current context.
     * - off will turn repeat off.
     * @param deviceID See [DEVICE_ID_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    fun setRepeatMode(state: String, deviceID: String = "") = "$ENDPOINT_USER/repeat?state=$state&device_id=$deviceID"

    /**
     * Type Request: PUT
     *
     * Set the volume for the user’s current playback device. This API only works for users who have Spotify Premium.
     * The order of execution is not guaranteed when you use this API with other Player API endpoints.
     *
     * Scopes Required: [USER_MODIFY_PLAYBACK_STATE]
     * @param volumePercent See [VOLUME_PERCENT_DOC]
     * @param deviceID See [DEVICE_ID_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    fun setPlayerVolume(volumePercent: Int, deviceID: String = "") =
        "$ENDPOINT_USER/volume?volume_percent=$volumePercent&device_id=$deviceID"

    /**
     * Type Request: PUT
     *
     * Toggle shuffle on or off for user’s playback. This API only works for users who have Spotify Premium. The order
     * of execution is not guaranteed when you use this API with other Player API endpoints.
     *
     * Scopes Required: [USER_MODIFY_PLAYBACK_STATE]
     * @param state
     * - true: Shuffle user's playback.
     * - false: Do not shuffle user's playback.
     * @param deviceID See [DEVICE_ID_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    fun setShuffle(state: Boolean, deviceID: String = "") = "$ENDPOINT_USER/shuffle?state=$state&device_id=$deviceID"

    /**
     * Type Request: GET
     *
     * Get tracks from the current user's recently played tracks. Note: Currently doesn't support podcast episodes.
     *
     * Scopes Required: [USER_READ_RECENTLY_PLAYED]
     * @param limit See [LIMIT_DOC]
     * @param after See [AFTER_DOC]
     * @param before See [BEFORE_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    fun getRecentlyPlayed(limit: Int = 20, after: Int = 0, before: Int = 0) =
        "https://api.spotify.com/v1/me/player/recently-played?limit=$limit&after=$after&before=$before"

    /**
     * Type Request: GET
     *
     * Get the list of objects that make up the user's queue.
     *
     * Scopes Required: [USER_READ_CURRENTLY_PLAYING] | [USER_READ_PLAYBACK_STATE]
     * @author Serginho
     * @since 0.0.2
     */
    fun getUserQueue() = "$$ENDPOINT_USER/queue"

    /**
     * Type Request: POST
     *
     * Add an item to be played next in the user's current playback queue. This API only works for users who have
     * Spotify Premium. The order of execution is not guaranteed when you use this API with other Player API endpoints.
     *
     * Scopes Required: [USER_MODIFY_PLAYBACK_STATE]
     * @param uri See [URI_DOC]
     * @param deviceID See [DEVICE_ID_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    fun addItemToQueue(uri: String, deviceID: String = "") = "$ENDPOINT_USER/queue?uri=$uri&device_id=$deviceID"

}