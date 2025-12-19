package spotlibfy.endpoints

import spotlibfy.endpoints.Track.IDS_DOC
import spotlibfy.endpoints.Track.ID_DOC
import spotlibfy.endpoints.Track.LIMIT_DOC
import spotlibfy.endpoints.Track.MARKET_DOC
import spotlibfy.endpoints.Track.OFFSET_DOC
import spotlibfy.scopes.Scopes.USER_LIBRARY_MODIFY
import spotlibfy.scopes.Scopes.USER_LIBRARY_READ

/**
 * Contains endpoints referenced to tracks
 * @author Serginho
 * @since 0.0.2
 */
object Track {
    /**
     * Endpoint of the tracks
     * @author Serginho
     * @since 0.0.2
     */
    const val ENDPOINT = "https://api.spotify.com/v1/tracks"

    /**
     * Endpoint of users tracks
     * @see [User.ENDPOINT_USER]
     * @author Serginho
     * @since 0.0.2
     */
    const val ENDPOINT_USER = "${User.ENDPOINT_USER}/tracks"

    /**
     * Parameter id
     *
     * The Spotify ID for the track.
     *
     * Example: 11dFghVXANMlKmJXsNCbNl
     * @author Serginho
     * @since 0.0.2
     */
    private val ID_DOC = Unit

    /**
     * Parameter ids
     *
     * A comma-separated list of the Spotify IDs. Maximum: 50 IDs.
     *
     * Example: ids=7ouMYWpwJ422jRcDASZB7P,4VqPOruhp5EdPBeR92t6lQ,2takcwOaAZWiXQijPHIx7B
     * @author Serginho
     * @since 0.0.2
     */
    private val IDS_DOC = Unit

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
     * Type Request: GET
     *
     * Get Spotify catalog information for a single track identified by its unique Spotify ID.
     * @param id See [ID_DOC]
     * @param market See [MARKET_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    fun getTrack(id: String, market: String = "") = "$ENDPOINT/$id?market=$market"

    /**
     * Type Request: GET
     *
     * Get Spotify catalog information for multiple tracks based on their Spotify IDs.
     * @param ids See [IDS_DOC]
     * @param market See [MARKET_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    fun getTracks(ids: String, market: String = "") = "$ENDPOINT/?ids=$ids&market=$market"

    /**
     * Type Request: GET
     *
     * Get a list of the songs saved in the current Spotify user's 'Your Music' library.
     *
     * Scopes Required: [USER_LIBRARY_READ]
     * @param market See [MARKET_DOC]
     * @param limit See [LIMIT_DOC]
     * @param offset See [OFFSET_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    fun getUsersSavedTracks(market: String = "", limit: Int = 20, offset: Int = 0) =
        "$ENDPOINT_USER?limit=$limit&offset=$offset&market=$market"

    /**
     * Type Request: PUT
     *
     * Save one or more tracks to the current user's 'Your Music' library.
     *
     * Scopes Required: [USER_LIBRARY_MODIFY]
     * @author Serginho
     * @since 0.0.2
     */
    fun saveTrackToUser() = ENDPOINT_USER

    /**
     * Type Request: DELETE
     *
     * Remove one or more tracks from the current user's 'Your Music' library.
     *
     * Scopes Required: [USER_LIBRARY_MODIFY]
     * @param ids See [IDS_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    fun deleteTrackFromUser(ids: String) = "$ENDPOINT_USER?ids=$ids"

    /**
     * Type Request: GET
     *
     * Check if one or more tracks is already saved in the current Spotify user's 'Your Music' library.
     * @param ids See [IDS_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    fun checkCurrentUserTracks(ids: String) = "$ENDPOINT_USER/contains?ids=$ids"

    /**
     * Type Request: GET
     *
     * Get audio features for multiple tracks based on their Spotify IDs.
     *
     * @param ids See [IDS_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    @Deprecated("")
    fun getSeveralTracksAudioFeatures(ids: String) = "$ENDPOINT/audio-features/?ids=$ids"

    /**
     * Type Request: GET
     *
     * Get audio feature information for a single track identified by its unique Spotify ID.
     * @param id See [ID_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    @Deprecated("")
    fun getTrackAudioFeatures(id: String) = "$ENDPOINT/audio-features/$id"

    /**
     * Type Request: GET
     *
     * Get a low-level audio analysis for a track in the Spotify catalog. The audio analysis describes the track’s
     * structure and musical content, including rhythm, pitch, and timbre.
     *
     * @param id See [ID_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    @Deprecated("")
    fun getTrackAudioAnalysis(id: String) = "$ENDPOINT/$id/audio-analysis"

    /**
     * Type Request: GET
     *
     * Recommendations are generated based on the available information for a given seed entity and matched against
     * similar artists and tracks. If there is sufficient information about the provided seeds, a list of tracks will be
     * returned together with pool size details. For artists and tracks that are very new or obscure there might not be
     * enough data to generate a list of tracks.
     *
     * @author Serginho
     * @since 0.0.2
     */
    @Deprecated("")
    fun getRecommendations(
        seedArtists: String,
        seedGenres: String,
        seedTracks: String,
        limit: Int = 20,
        market: String = "",
        minAcousticness: Float = 0.0f,
        maxAcousticness: Float = 1.0f,
        targetAcousticness: Float = 0.5f,
        minDanceability: Float = 0.0f,
        maxDanceability: Float = 1.0f,
        targetDanceability: Float = 0.5f,
        minDurationMs: Int = 0,
        maxDurationMs: Int = 0,
        targetDurationMs: Int = 0,
        minEnergy: Float = 0.0f,
        maxEnergy: Float = 1.0f,
        targetEnergy: Float = 0.5f,
        minInstrumentalness: Float = 0.0f,
        maxInstrumentalness: Float = 1.0f,
        targetInstrumentalness: Float = 0.5f,
        minKey: Int = 0,
        maxKey: Int = 11,
        targetKey: Int = 0,
        minLiveness: Float = 0.0f,
        maxLiveness: Float = 1.0f,
        targetLiveness: Float = 0.5f,
        minLoudness: Float = 0.0f,
        maxLoudness: Float = 1.0f,
        targetLoudness: Float = 0.5f,
        minMode: Int = 0,
        maxMode: Int = 11,
        targetMode: Int = 0,
        minPopularity: Int = 0,
        maxPopularity: Int = 100,
        targetPopularity: Int = 0,
        minSpeechiness: Float = 0.0f,
        maxSpeechiness: Float = 1.0f,
        targetSpeechiness: Float = 0.5f,
        minTempo: Float = 0.0f,
        maxTempo: Float = 1.0f,
        targetTempo: Float = 0.5f,
        minTimeSignature: Int = 0,
        maxTimeSignature: Int = 11,
        targetTimeSignature: Int = 0,
        minValence: Float = 0.0f,
        maxValence: Float = 1.0f,
        targetValence: Float = 0.5f

    ) = ""
}