package german.engine

import german.engine.restrictions.*

sealed class RestrictionType<T : Restriction> {
    abstract val allRestrictions: List<T> // TODO what to do if this set is infinite?
}

object GenderRestrictionType : RestrictionType<GenderRestriction>() {
    override val allRestrictions: List<GenderRestriction> = listOf(
        GenderRestriction.male,
        GenderRestriction.female,
        GenderRestriction.neutral
    )

}

object PluralityRestrictionType : RestrictionType<PluralityRestriction>() {
    override val allRestrictions: List<PluralityRestriction> = listOf(
        PluralityRestriction.plural,
        PluralityRestriction.singular
    )
}

object CaseRestrictionType : RestrictionType<CaseRestriction>() {
    override val allRestrictions: List<CaseRestriction> = listOf(
        CaseRestriction.nominativ,
        CaseRestriction.dativ,
        CaseRestriction.akkusativ
    )
}

object PersonRestrictionType : RestrictionType<PersonRestriction>() {
    override val allRestrictions: List<PersonRestriction> = listOf(
        PersonRestriction.first,
        PersonRestriction.second,
        PersonRestriction.third
    )
}

object PrepositionRestrictionType : RestrictionType<PrepositionTypeRestriction>() {
    override val allRestrictions: List<PrepositionTypeRestriction> = listOf(
        PrepositionTypeRestriction.definite,
        PrepositionTypeRestriction.indefinite,
        PrepositionTypeRestriction.zero
    )
}