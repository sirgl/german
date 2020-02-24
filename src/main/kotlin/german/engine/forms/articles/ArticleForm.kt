package german.engine.forms.articles

import german.engine.WordForm
import german.engine.forms.Gender
import german.engine.words.Article

interface ArticleForm : WordForm<Article> {
    val gender: Gender?
}

