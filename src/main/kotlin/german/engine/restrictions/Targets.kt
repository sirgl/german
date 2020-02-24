package german.engine.restrictions

import german.engine.forms.articles.ArticleForm
import german.engine.sentence.Positioned

sealed class RestrictionTarget

object PredicateTarget : RestrictionTarget()

class ArticleNounTarget(val article: Positioned<ArticleForm>) : RestrictionTarget()