package german.engine.sentence

import german.engine.Sentence
import german.engine.WordForm
import german.engine.forms.Case
import german.engine.forms.Person
import german.engine.forms.Plurality
import german.engine.restrictions.*
import german.engine.words.Noun
import german.engine.words.ArticleType
import german.engine.words.Pronoun
import german.engine.words.Verb
import german.utils.unwrap

class SentenceWithSubject(
    val obj: Obj,
    val predicate: Predicate,
    val subject: Subject?
) : Sentence {
    override val forms: List<WordForm<*>>
        get() = create()


    private fun create() : List<WordForm<*>> {
        val forms = mutableListOf<WordForm<*>>()
        val person: Person
        val plurality: Plurality
        when (obj) {
            is Obj.NounObj -> {
                val noun = obj.noun
                val gender = noun.gender
                // TODO actually here must be rules
                val article = obj.articleType.article(restrictions = setOf(
                    GenderRestriction(gender),
                    CaseRestriction(Case.Nominativ)
                ))
                if (article != null) {
                    forms.add(article)
                }
                TODO()
//                val nounForm = noun.produceForm(restrictions = setOf(
//                    PluralityRestriction(obj.plurality),
//                    CaseRestriction(Case.Nominativ)
//                )).unwrap()
//                forms.add(nounForm)
//                person = Person.Third
//                plurality = obj.plurality
            }
            is Obj.PronounObj -> TODO()
        }

        val verbRestrictions = setOf(PersonRestriction(person), PluralityRestriction(plurality))

        TODO()
//        forms.add(predicate.verb.produceForm(verbRestrictions).unwrap())

        return forms
    }

    // TODO restrictions must be consistent?

    class Subject(val noun: Noun, val restrictions: List<Restriction>)

    sealed class Obj() {
        class NounObj(val noun: Noun, val articleType: ArticleType, val plurality: Plurality): Obj()
        class PronounObj(val pronoun: Pronoun): Obj()
    }

    class Predicate(val verb: Verb)
}