package german.engine

import german.engine.restrictions.FormProducer
import german.engine.restrictions.Restriction
import german.engine.restrictions.RestrictionFail
import german.utils.Res

interface Word {
    /**
     * Meaning in Russian
     */
    fun meaning(): String

    val restrictions: Set<TargetedRestriction>
        get() = emptySet()

    val formHandlers: Set<FormProducer<*>>

    val examples: List<String>
        get() = emptyList()

    val kind: WordKind<*>
}

