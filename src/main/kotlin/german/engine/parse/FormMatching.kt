package german.engine.parse

import german.engine.RestrictionType
import german.engine.WordForm
import german.engine.restrictions.Restriction
import german.engine.restrictions.doBounding
import german.kb.WordDB
import german.utils.ok

fun matchForms(wordStr: String, db: WordDB): List<WordForm<*>> {
    val forms = mutableListOf<WordForm<*>>()
    for (word in db.words) {
        for (formHandler in word.formHandlers) {
            val requiredRestrictions = formHandler.requiredRestrictions
            val possibleRestrictions = possibleRestrictions(requiredRestrictions)
            for (restrictions in possibleRestrictions) {
                val formProducers = listOf(formHandler)
                val wordForm = doBounding(formProducers, restrictions.toHashSet()).ok() ?: continue
                if (wordForm.text == wordStr) {
                    forms.add(wordForm)
                }
            }
        }
    }
    return forms
}

/**
 * for set of restriction types produces all possible restriction combinations
 */
private fun possibleRestrictions(restrictionTypes: Set<RestrictionType<*>>) : List<List<Restriction>> {
    val restrictions = restrictionTypes.map { it.allRestrictions }
    return combine(restrictions)
}

fun <T> combine(listOfLists: List<List<T>>) : List<List<T>> {
    return listOfLists.fold(initial = listOf(listOf())) { acc, other ->
        val newAcc = mutableListOf<List<T>>()
        for (list in acc) {
            for (otherElement in other) {
                newAcc.add(list + otherElement)
            }
        }
        newAcc
    }
}