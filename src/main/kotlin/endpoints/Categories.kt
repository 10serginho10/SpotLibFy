package endpoints

import endpoints.Categories.CATEGORY_ID_DOC
import endpoints.Categories.LIMIT_DOC
import endpoints.Categories.LOCALE_DOC
import endpoints.Categories.OFFSET_DOC


/**
 * Contains endpoints referenced to categories
 * @author Serginho
 * @since 0.0.2
 */
object Categories {
    /**
     * Endpoint of the categories
     * @author Serginho
     * @since 0.0.2
     */
    const val ENDPOINT = "https://api.spotify.com/v1/browse/categories"

    /**
     * Parameter locale
     *
     * The desired language, consisting of an ISO 639-1 language code and an ISO 3166-1 alpha-2 country code, joined by
     * an underscore. For example: es_MX, meaning "Spanish (Mexico)". Provide this parameter if you want the category
     * strings returned in a particular language. Note: if locale is not supplied, or if the specified language is not
     * available, the category strings returned will be in the Spotify default language (American English).
     *
     * Example: locale=sv_SE
     * @author Serginho
     * @since 0.0.2
     */
    private val LOCALE_DOC = Unit

    /**
     * Parameter limit
     *
     * The maximum number of items to return. Default: 20. Minimum: 1. Maximum: 50.
     *
     * Default: limit=20,
     * Range: 0 - 50,
     * Example: limit=10
     * @author Serginho
     * @since 0.0.2
     */
    private val LIMIT_DOC = Unit

    /**
     * Parameter offset
     *
     * The index of the first item to return. Default: 0 (the first item). Use with limit to get the next set of items.
     *
     * Default: offset=0,
     * Example: offset=5
     * @author Serginho
     * @since 0.0.2
     */
    private val OFFSET_DOC = Unit

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
     * Get a list of categories used to tag items in Spotify (on, for example, the Spotify player’s “Browse” tab).
     *
     * @param locale See [LOCALE_DOC]
     * @param limit See [LIMIT_DOC]
     * @param offset See [OFFSET_DOC]
     * @author Serginho
     * @since 0.0.2
     */
    fun getSeveralCategories(locale: String = "", limit: Int = 20, offset: Int = 0) =
        "$ENDPOINT?locale=$locale&limit=$limit&offset=$offset"

    /**
     * Type Request: GET
     *
     * Get a single category used to tag items in Spotify (on, for example, the Spotify player’s “Browse” tab).
     * @param categoryId See [CATEGORY_ID_DOC]
     * @param locale See [LOCALE_DOC]
     */
    fun getCategory(categoryId: String, locale: String = "") = "$ENDPOINT/$categoryId?locale=$locale"
}