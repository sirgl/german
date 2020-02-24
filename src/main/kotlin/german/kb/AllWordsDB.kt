package german.kb

import german.engine.Word

object AllWordDB : WordDB {
    override val words: Sequence<Word>
        get() = Nouns.words

}