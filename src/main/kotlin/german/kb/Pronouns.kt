package german.kb

import german.engine.Word
import german.engine.WordForm
import german.engine.forms.Gender
import german.engine.forms.Person
import german.engine.forms.Plurality
import german.engine.forms.pronoun.PronounForm
import german.engine.restrictions.FormProducer
import german.engine.restrictions.Restriction
import german.engine.restrictions.RestrictionFail
import german.engine.words.Pronoun
import german.utils.Res

object Pronouns {
    val ich = object: PronounForm {
        override val text: String
            get() = "ich"
        override val originalWord: Pronoun
            get() = PersonalPronoun

    }

    object PersonalPronoun: Pronoun {
        override fun meaning(): String {
            return "личное местоимение"
        }

        override val formHandlers: Set<FormProducer<*>>
            get() = TODO("Not yet implemented")


        //        override fun produceForm(restrictions: List<Restriction>): WordForm? {
//            val restr = PronounRestrictions.from(restrictions) ?: return null
//            return when (restr.person) {
//                Person.First -> when (restr.plurality) {
//                    Plurality.Singular -> ich
//                    Plurality.Plural -> TODO()
//                    null -> TODO()
//                }
//                Person.Second -> TODO()
//                Person.Third -> TODO()
//                null -> TODO()
//            }
//        }

        private class PronounRestrictions(
            val gender: Gender?,
            val plurality: Plurality?,
            val person: Person?
        ) {
            companion object {
                fun from(restrictions: List<Restriction>) : PronounRestrictions? {
                    TODO()
                }
            }
        }
    }
}