package german.engine

import german.engine.restrictions.Restriction

/**
 * Things, raw sentence consists of
 */
interface WordOrForm {
    val restrictions : List<Restriction>
    get() = emptyList()
}