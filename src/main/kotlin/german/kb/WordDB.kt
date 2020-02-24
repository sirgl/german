package german.kb

import german.engine.Word

interface WordDB {
    val words: Sequence<Word>
}

