package german.engine.restrictions

import german.engine.*
import german.engine.forms.Case
import german.engine.forms.Gender
import german.engine.forms.Person
import german.engine.forms.Plurality
import german.engine.words.ArticleType


// TODO maybe here should be not the single restriction to e.g. gender, but possible restrictions as set

sealed class Restriction(val type: RestrictionType<*>)

class GenderRestriction(val gender: Gender) : Restriction(GenderRestrictionType) {
    companion object {
        val female = GenderRestriction(Gender.Female)
        val male = GenderRestriction(Gender.Male)
        val neutral = GenderRestriction(Gender.Neutral)

    }
}

class PluralityRestriction(val plurality: Plurality) : Restriction(PluralityRestrictionType) {
    companion object {
        val singular = PluralityRestriction(Plurality.Singular)
        val plural = PluralityRestriction(Plurality.Plural)
    }
}

class CaseRestriction(val case: Case) : Restriction(CaseRestrictionType) {
    companion object {
        val nominativ = CaseRestriction(Case.Nominativ)
        val dativ = CaseRestriction(Case.Dativ)
        val akkusativ = CaseRestriction(Case.Akkusativ)
    }
}

class PersonRestriction(val person: Person) : Restriction(PersonRestrictionType) {
    companion object {
        val first = PersonRestriction(Person.First)
        val second = PersonRestriction(Person.Second)
        val third = PersonRestriction(Person.Third)
    }
}

class PrepositionTypeRestriction(val articleType: ArticleType) : Restriction(PrepositionRestrictionType) {
    companion object {
        val definite = PrepositionTypeRestriction(ArticleType.Definite)
        val indefinite = PrepositionTypeRestriction(ArticleType.Indefinite)
        val zero = PrepositionTypeRestriction(ArticleType.Zero)
    }
}



fun Restriction.isOfType(type: RestrictionType<*>): Boolean {
    return this.type == type
}
