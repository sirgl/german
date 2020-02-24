package german.engine.forms.articles

import german.engine.forms.Case
import german.engine.forms.Gender
import german.engine.words.Article

class DefinitiveSingularArticleForm(
    override val originalWord: Article,
    override val gender: Gender,
    val case: Case
) : ArticleForm {
    override val text: String
        get() = when (case) {
            Case.Nominativ -> when (gender) {
                Gender.Male -> "der"
                Gender.Female -> "die"
                Gender.Neutral -> "das"
            }
            Case.Akkusativ -> when (gender) {
                Gender.Male -> "den"
                Gender.Female -> "die"
                Gender.Neutral -> "das"
            }
            Case.Dativ -> when (gender) {
                Gender.Male -> "dem"
                Gender.Female -> "der"
                Gender.Neutral -> "dem"
            }
        }
}