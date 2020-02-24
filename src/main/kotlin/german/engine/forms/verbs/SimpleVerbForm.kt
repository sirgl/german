package german.engine.forms.verbs

import german.engine.forms.Person
import german.engine.forms.Plurality
import german.engine.words.Verb

class SimpleVerbForm(
    val root: String,
    val person: Person,
    val number: Plurality,
    override val originalWord: Verb
) : VerbForm {
    override val text: String
        get() = when (number) {
            Plurality.Singular -> when (person) {
                Person.First -> "${root}e"
                Person.Second -> "${root}st"
                Person.Third -> "${root}t"
            }
            Plurality.Plural -> TODO()
        }
}