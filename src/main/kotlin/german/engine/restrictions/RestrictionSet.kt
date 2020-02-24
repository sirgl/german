package german.engine.restrictions

class RestrictionSet(
    val restrictions: Set<Restriction>
) {
    constructor(vararg restrictions: Restriction) : this(restrictions.toSet())
}