package german.engine.words

import german.engine.Word
import german.engine.forms.Gender

// TODO should I use here WordForm
interface Preposition : Word {
    val gender: Gender
    val type: ArticleType
    val text: String
}