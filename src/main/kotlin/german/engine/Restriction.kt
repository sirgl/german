package german.engine

import german.engine.restrictions.Restriction
import german.engine.restrictions.RestrictionTarget

class TargetedRestriction(val target: RestrictionTarget, val restriction: Restriction)

interface Restricted {
    val restrictions: List<Restriction>
}