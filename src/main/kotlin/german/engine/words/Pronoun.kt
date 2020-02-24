package german.engine.words

import german.engine.PronounKind
import german.engine.Word
import german.engine.WordKind

/**
 * Part of speech that points to an object, but don't calls explicitly
 */
interface Pronoun : Word {
    override val kind: WordKind<*>
        get() = PronounKind
}