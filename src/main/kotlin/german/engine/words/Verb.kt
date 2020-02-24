package german.engine.words

import german.engine.VerbKind
import german.engine.Word
import german.engine.WordForm
import german.engine.WordKind
import german.engine.forms.Person
import german.engine.forms.Plurality


interface Verb : Word {
    val isTransitive: Boolean

    val text: String

    override val kind: WordKind<*>
        get() = VerbKind
}