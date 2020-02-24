package german.engine.sentence

import german.engine.Sentence
import german.engine.WordForm
import german.engine.forms.Plurality
import german.engine.words.Noun
import german.engine.words.ArticleType
import german.engine.words.Verb

class SimpleSentence(
    val articleType: ArticleType?,
//    val subject: Subjectable,
    val predicate: Verb,
    val plurality: Plurality,
    val objPrepType : ArticleType?,
    val anObject: Noun?
) : Sentence {
    override val forms: List<WordForm<*>>
        get() = listOf()

//    override fun produceText(): String {
//        val person = subject.person
//        return buildString {
//            val prepositionType = if (prepositionType == null && subject is Noun) {
//                PrepositionType.Definite
//            } else {
//                prepositionType
//            }
//            val preposition = when (prepositionType) {
//                PrepositionType.Definite -> when (subject.gender) {
//                    Gender.Male -> TODO()
//                    Gender.Female -> Prepositions.die
//                    Gender.Neutral -> TODO()
//                    Gender.Unknown -> TODO()
//                }
//                PrepositionType.Indefinite -> TODO()
//                PrepositionType.No -> TODO()
//                null -> null
//            }
//
//            if (preposition != null) {
//                append(preposition.text)
//                append(" ")
//            }
//
//            append(subject.produceForm(plurality).text)
//            append(" ")
//            append(predicate.conjugate(person, plurality).text)
//            if (anObject != null) {
//                append(" ")
//                append(anObject.produceForm(Plurality.Singular).text)
//            }
//        }
//    }

//    override val words: List<Word>
//        get() = listOf(subject, predicate)
}