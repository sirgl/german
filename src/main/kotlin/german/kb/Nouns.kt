package german.kb

import german.engine.Word
import german.engine.forms.Gender
import german.engine.words.Noun
import german.engine.words.SimpleNoun

object Nouns : WordDB {
    private val _words = mutableListOf<Noun>()

    val katze = +SimpleNoun("katze", "katzen", Gender.Female, "кошка")
    // TODO need a way to express non plural
    val wasser = +SimpleNoun("wasser", "wasser", Gender.Neutral, "вода")
    val hund = +SimpleNoun("hund", "hunde", Gender.Male, "собака")


    operator fun Noun.unaryPlus(): Noun {
        _words.add(this)
        return this
    }

    override val words: Sequence<Word>
        get() = _words.asSequence()
}