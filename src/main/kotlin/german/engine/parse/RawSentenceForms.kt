package german.engine.parse

import german.engine.WordForm

typealias WordForms = List<WordForm<*>>

// List of forms for each word of sentence
class RawSentenceForms(val formVariants: List<WordForms>)  {
    operator fun get(index: Int): WordForms {
        return formVariants[index]
    }

    fun size(): Int {
        return formVariants.size
    }
}