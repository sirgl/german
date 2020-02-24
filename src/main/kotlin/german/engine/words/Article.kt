package german.engine.words

import german.engine.ArticleKind
import german.engine.Word
import german.engine.WordKind

interface Article : Word {
    val articleType: ArticleType

    override val kind: WordKind<*>
        get() = ArticleKind
}