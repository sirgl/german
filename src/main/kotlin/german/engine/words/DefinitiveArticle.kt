package german.engine.words

import german.engine.CaseRestrictionType
import german.engine.GenderRestrictionType
import german.engine.PluralityRestrictionType
import german.engine.WordForm
import german.engine.forms.articles.ArticleForm
import german.engine.forms.articles.DefinitiveSingularArticleForm
import german.engine.restrictions.*
import german.utils.Res
import german.utils.map

object DefinitiveArticle : Article {
    override val articleType: ArticleType
        get() = ArticleType.Definite

    override fun meaning(): String {
        return "Определенный артикль"
    }

    // either gender or plurality must be specified
//    override fun produceForm(restrictions: Set<Restriction>): Res<ArticleForm, RestrictionFail> {
//        val restrictionTypesSet = setOf(caseGenderRestrictions, casePluralityRestrictions)
//        return boundRestrictions(restrictions, restrictionTypesSet).map { pickForm(it, listOf(caseGenderHandler)) }
//    }

    private val caseGenderRestrictions = hashSetOf(CaseRestrictionType, GenderRestrictionType)
    private val casePluralityRestrictions = hashSetOf(CaseRestrictionType, PluralityRestrictionType)

    private val caseGenderHandler = FormProducer<ArticleForm>(caseGenderRestrictions) {
        DefinitiveSingularArticleForm(this, it[GenderRestrictionType].gender, it[CaseRestrictionType].case)
    }

    override val formHandlers: Set<FormProducer<*>> = setOf(caseGenderHandler)

    //    val casePluralityHandler = FormProducer<ArticleForm>(setOf(CaseRestrictionType, PluralityRestrictionType)) {
//        DefinitiveSingularArticleForm(this, it[GenderRestrictionType].gender, it[CaseRestrictionType].case)
//    }
}