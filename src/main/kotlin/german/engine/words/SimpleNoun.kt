package german.engine.words

import german.engine.CaseRestrictionType
import german.engine.PluralityRestrictionType
import german.engine.RestrictionType
import german.engine.forms.Gender
import german.engine.forms.nouns.NounForm
import german.engine.forms.nouns.SimpleNounForm
import german.engine.restrictions.FormProducer

class SimpleNoun(
    private val singular: String,
    private val plural: String,
    override val gender: Gender,
    private val meaning: String,
    override val examples: List<String> = listOf()
) : Noun {
    override fun meaning(): String = meaning

    // TODO case is not required here actually now
    private val pluralityCaseHandler = FormProducer<NounForm>(pluralityCaseRestrictions) {
        SimpleNounForm(this, singular, plural, it[PluralityRestrictionType].plurality)
    }

    override val formHandlers: Set<FormProducer<*>> = setOf(pluralityCaseHandler)

    override val text: String
        get() = singular


    companion object {
        private val pluralityCaseRestrictions = hashSetOf<RestrictionType<*>>(
            PluralityRestrictionType,
            CaseRestrictionType
        )
    }
}