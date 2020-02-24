package german.engine.words

import german.engine.NounKind
import german.engine.Word
import german.engine.WordKind
import german.engine.forms.Gender


interface Noun : Word {
    val text: String

    val gender: Gender

    override val kind: WordKind<*>
        get() = NounKind
}