package german.engine.words

import german.engine.forms.articles.ArticleForm
import german.engine.restrictions.Restriction
import german.utils.unwrap

enum class ArticleType {
    Definite,
    Indefinite,
    Zero;

    fun article(restrictions: Set<Restriction>) : ArticleForm? {
        return when (this) {
//            Definite -> DefinitiveArticle.produceForm(restrictions).unwrap()
            Definite -> TODO()
            Indefinite -> TODO()
            Zero -> null
        }
    }
}