package german.engine.parse

import german.engine.Sentence
import german.engine.TargetedRestriction
import german.utils.Res

fun parse(text: String) : ParseSession {

    TODO()
}

class ParseError(val text: String)

/**
 * Allows to specify restrictions, that are not explicit by syntax structure
 */
interface ParseSession {
    fun tryParse() : Res<Sentence, ParseError>

    // TODO this may fail, actually
    fun submit(restrictions: List<TargetedRestriction>)
}