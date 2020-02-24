package german.engine

/**
 * Word of form inside of sentence
 * Have all grammatical attributes (person, case, ...) already set
 */
interface WordForm<W: Word> : WordOrForm {
    val text: String

    val originalWord: W
}