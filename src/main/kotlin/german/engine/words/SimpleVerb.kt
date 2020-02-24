package german.engine.words

import german.engine.PersonRestrictionType
import german.engine.PluralityRestrictionType
import german.engine.RestrictionType
import german.engine.forms.verbs.SimpleVerbForm
import german.engine.restrictions.FormProducer

class SimpleVerb(
    private val root: String,
    private val meaning: String,
    override val isTransitive: Boolean
) : Verb {
    override val text: String
        get() = "${root}en"

    override fun meaning(): String = meaning

    private val personCaseHandler = FormProducer(personCaseRestrictions) {
        SimpleVerbForm(root, it[PersonRestrictionType].person, it[PluralityRestrictionType].plurality, this)
    }

    override val formHandlers: Set<FormProducer<*>> = setOf(personCaseHandler)

    companion object {
        private val personCaseRestrictions = hashSetOf<RestrictionType<*>>(
            PersonRestrictionType,
            PluralityRestrictionType
        )
    }
}