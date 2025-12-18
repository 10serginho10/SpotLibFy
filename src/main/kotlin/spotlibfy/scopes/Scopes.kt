package spotlibfy.scopes

/**
 * Contains every value from the Spotify scopes
 * @author Serginho
 * @since 0.0.1
 */
enum class Scopes(val scope: String) {
    /**
     * Description: Write access to user-provided images.
     *
     * Visible to users: Upload images to Spotify on your behalf.
     * @since 0.0.1
     */
    UGC_IMAGE_UPLOAD("ugc-image-upload"),

    /**
     * Description: Read access to a user’s player state.
     *
     * Visible to users: Read your currently playing content and Spotify Connect devices information.
     * @since 0.0.1
     */
    USER_READ_PLAYBACK_STATE("user-read-playback-state"),

    /**
     * Description: Write access to a user’s playback state
     *
     * Visible to users: Control playback on your Spotify clients and Spotify Connect devices.
     * @since 0.0.1
     */
    USER_MODIFY_PLAYBACK_STATE("user-modify-playback-state"),

    /**
     * Description: Read access to a user’s currently playing content.
     *
     * Visible to users: Read your currently playing content.
     * @since 0.0.1
     */
    USER_READ_CURRENTLY_PLAYING("user-read-currently-playing"),

    /**
     * Description: Remote control playback of Spotify. This scope is currently available to Spotify iOS and Android SDKs.
     *
     * Visible to users: Communicate with the Spotify app on your device.
     * @since 0.0.1
     */
    APP_REMOTE_CONTROL("app-remote-control"),

    /**
     * Description: Control playback of a Spotify track. This scope is currently available to the Web Playback SDK. The user must have a Spotify Premium account.
     *
     * Visible to users: Play content and control playback on your other devices.
     * @since 0.0.1
     */
    STREAMING("streaming"),

    /**
     * Description: Read access to user's private playlists.
     *
     * Visible to users: Access your private playlists.
     * @since 0.0.1
     */
    PLAYLIST_READ_PRIVATE("playlist-read-private"),

    /**
     * Description: Include collaborative playlists when requesting a user's playlists.
     *
     * Visible to users: Access your collaborative playlists.
     * @since 0.0.1
     */
    PLAYLIST_READ_COLLABORATIVE("playlist-read-collaborative"),

    /**
     * Description: Write access to a user's public playlists.
     *
     * Visible to users: Manage your public playlists.
     * @since 0.0.1
     */
    PLAYLIST_MODIFY_PUBLIC("playlist-modify-public"),

    /**
     * Description: Write access to a user's private playlists.
     *
     * Visible to users: Manage your private playlists.
     * @since 0.0.1
     */
    PLAYLIST_MODIFY_PRIVATE("playlist-modify-private"),

    /**
     * Description: Write/delete access to the list of artists and other users that the user follows.
     *
     * Visible to users: Manage who you are following.
     * @since 0.0.1
     */
    USER_FOLLOW_MODIFY("user-follow-modify"),

    /**
     * Description: Read access to the list of artists and other users that the user follows.
     *
     * Visible to users: Access your followers and who you are following.
     * @since 0.0.1
     */
    USER_FOLLOW_READ("user-follow-read"),

    /**
     * Description: Read access to a user’s playback position in a content.
     *
     * Visible to users: Read your position in content you have played.
     * @since 0.0.1
     */
    USER_READ_PLAYBACK_POSITION("user-read-playback-position"),

    /**
     * Description: Read access to a user's top artists and tracks.
     *
     * Visible to users: Read your top artists and content.
     * @since 0.0.1
     */
    USER_TOP_READ("user-top-read"),

    /**
     * Description: Read access to a user’s recently played tracks.
     *
     * Visible to users: Access your recently played items.
     * @since 0.0.1
     */
    USER_READ_RECENTLY_PLAYED("user-read-recently-played"),

    /**
     * Description: Write/delete access to a user's "Your Music" library.
     *
     * Visible to users: Manage your saved content.
     * @since 0.0.1
     */
    USER_LIBRARY_MODIFY("user-library-modify"),

    /**
     * Description: Read access to a user's library.
     *
     * Visible to users: Access your saved content.
     * @since 0.0.1
     */
    USER_LIBRARY_READ("user-library-read"),

    /**
     * Description: Read access to user’s email address.
     *
     * Visible to users: Get your real email address.
     * @since 0.0.1
     */
    USER_READ_EMAIL("user-read-email"),

    /**
     * Description: Write access to user-provided images.
     *
     * Visible to users: Access your subscription details.
     * @since 0.0.1
     */
    USER_READ_PRIVATE("user-read-private"),

    /**
     * Description: Get personalized content for the user.
     * @since 0.0.1
     */
    USER_PERSONALIZED("user-personalized"),

    /**
     * Description: Link a partner user account to a Spotify user account
     * @since 0.0.1
     */
    USER_SOA_LINK("user-soa-link"),

    /**
     * Description: Unlink a partner user account from a Spotify account
     * @since 0.0.1
     */
    USER_SOA_UNLINK("user-soa-unlink"),

    /**
     * Description: Modify entitlements for linked users
     * @since 0.0.1
     */
    SOA_MANAGE_ENTITLEMENTS("soa-manage-entitlements"),

    /**
     * Description: Update partner information
     * @since 0.0.1
     */
    SOA_MANAGE_PARTNER("soa-manage-partner"),

    /**
     * Description: Create new partners, platform partners only
     * @since 0.0.1
     */
    SOA_CREATE_PARTNER("soa-create-partner")
}