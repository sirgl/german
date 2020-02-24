package german.engine

import german.engine.words.Article
import german.engine.words.Noun
import german.engine.words.Pronoun
import german.engine.words.Verb

interface WordKind<out W: Word>

object NounKind : WordKind<Noun>
object VerbKind : WordKind<Verb>
object ArticleKind : WordKind<Article>
object PronounKind : WordKind<Pronoun>

val kinds = listOf(NounKind, VerbKind, ArticleKind, PronounKind)