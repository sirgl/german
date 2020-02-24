package german

import german.engine.forms.Plurality
import german.engine.sentence.SentenceWithSubject
import german.engine.sentence.SentenceWithSubject.*
import german.engine.sentence.SentenceWithSubject.Obj.NounObj
import german.engine.words.ArticleType
import german.kb.Nouns
import german.kb.Verbs

fun main() {
    val sentence = SentenceWithSubject(
        obj = NounObj(Nouns.katze, ArticleType.Definite, Plurality.Singular),
        predicate = Predicate(
            verb = Verbs.trinken
        ),
        subject = null
    )
    val text = sentence.forms.joinToString(" ") { it.text }

    println(text)
}