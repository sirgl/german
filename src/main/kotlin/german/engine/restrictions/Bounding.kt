package german.engine.restrictions

import german.engine.RestrictionType
import german.engine.Word
import german.engine.WordForm
import german.utils.Err
import german.utils.Res
import german.utils.Success
import german.utils.map


fun <T : WordForm<*>> doBounding(
    formProducers: List<FormProducer<out T>>,
    restrictions: Set<Restriction>
): Res<T, RestrictionFail> {
    return boundRestrictions(restrictions, formProducers
        .map { it.requiredRestrictions }.toSet())
        .map { pickForm(it, formProducers) }
}

fun <T : WordForm<*>> pickForm(boundRestrictions: BoundRestrictions, producers: List<FormProducer<out T>>) : T {
    for (producer in producers) {
        if (boundRestrictions.types === producer.requiredRestrictions) {
            return producer.formCreator(boundRestrictions)
        }
    }
    error("Must be bounded")
}

class FormProducer<T: WordForm<*>>(
    val requiredRestrictions: Set<RestrictionType<*>>,
    val formCreator: (BoundRestrictions) -> T
)

fun boundRestrictions(
    restrictions: Set<Restriction>,
    wantedTypeSets: Set<Set<RestrictionType<*>>>
) : Res<BoundRestrictions, RestrictionFail>  {
    // TODO seems like set of restrictions requires its own optimized for hashing and contains type
    val problems = hashMapOf<Set<RestrictionType<*>>, RestrictionProblem>()
    for (wantedTypes in wantedTypeSets) {
        when (val r = boundSingle(restrictions, wantedTypes)) {
            is Success -> return r
            is Err -> problems[wantedTypes] = r.error
        }
    }
    return Err(RestrictionFail(problems))
}

fun boundSingle(
    restrictions: Set<Restriction>,
    wantedTypes: Set<RestrictionType<*>>
) : Res<BoundRestrictions, RestrictionProblem> {
    val restrictionMap = hashMapOf<RestrictionType<*>, Restriction>()
    for (restriction in restrictions) {
        val type = restriction.type
        if (type in wantedTypes) {
            val previous = restrictionMap.put(type, restriction)
            if (previous != null) {
                return Err(ConflictingRestrictions(setOf(previous, restriction)))
            }
        }
    }
    val unbound = wantedTypes - restrictionMap.keys
    if (unbound.isNotEmpty()) return Err(UnboundRestriction(unbound))
    return Success(BoundRestrictions(restrictionMap, wantedTypes))
}

class BoundRestrictions(
    private val restrictions: Map<RestrictionType<*>, Restriction>,
    val types: Set<RestrictionType<*>>
) {
    @Suppress("UNCHECKED_CAST")
    operator fun <T : Restriction> get(key: RestrictionType<T>) : T {
        val restriction = restrictions[key] ?: error("only bound restrictions allowed")
        return restriction as T
    }
}

// Error types

data class RestrictionFail(val typesToProblems: Map<Set<RestrictionType<*>>, RestrictionProblem>)

sealed class RestrictionProblem

data class UnboundRestriction(val unbound: Set<RestrictionType<*>>) : RestrictionProblem()
data class ConflictingRestrictions(val conflicting: Set<Restriction>) : RestrictionProblem()


