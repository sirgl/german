package german.engine.forms.nouns

import german.engine.forms.Plurality
import german.engine.words.Noun

class SimpleNounForm(
    override val originalWord: Noun,
    val singularForm: String,
    val pluralForm: String,
    val plurality: Plurality
) : NounForm {
    override val text: String
        get() = when (plurality) {
            Plurality.Singular -> singularForm
            Plurality.Plural -> pluralForm
        }
}