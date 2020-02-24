//import german.engine.sentence.SentenceBuilder
//import german.engine.sentence.simpleSentence
import german.engine.sentence.SentenceWithSubject
import german.engine.sentence.SentenceWithSubject.Obj.NounObj
import german.engine.sentence.SentenceWithSubject.Predicate
import german.engine.words.ArticleType
import german.kb.Nouns
import german.kb.Verbs
import org.junit.Test

class SimpleSentenceTest {
    @Test
    fun nounVerb() {
//        val sentence = SentenceWithSubject(
//            obj = NounObj(Nouns.katze, ArticleType.Definite),
//            predicate = Predicate(
//                verb = Verbs.trinken,
//                restrictions = setOf()
//            ),
//            subject = null
//        )
//        val text = sentence.forms.joinToString(" ")
//        println(text)
//        testSentence("die Katze trinkt Wasser") {
//            subj {
//                subj = Nouns.katze
//            }
//            obj {
//                subj = Nouns.wasser
//            }
//            predicate = Verbs.trinken
//        }
    }

    @Test
    fun pronounVerb() {
//        testSentence("ich trinke Wasser") {
//            subj {
//                subj = Pronouns.ich
//            }
//            obj {
//                subj = Nouns.wasser
//            }
//            predicate = Verbs.trinken
//        }
    }

//    private fun testSentence(
//        expected: String,
//        sentence: SentenceBuilder.() -> Unit
//    ) {
//        val text = simpleSentence(sentence).produceText()
//        assertEquals(expected, text)
//    }
}