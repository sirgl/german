package german.engine.parse

import german.engine.*
import german.engine.forms.articles.ArticleForm
import german.engine.forms.nouns.NounForm
import german.engine.sentence.parts.Objekt
import german.engine.sentence.parts.Predicate
import german.engine.sentence.parts.Subject
import german.utils.Res


private sealed class ParsingData

private object Initial : ParsingData()

private class AfterArticle(val article: ArticleForm) : ParsingData()

private data class ObjectFirstParsing(val before: WordForm<*>)


private data class SentenceScheme(
    val objekt: Objekt?,
    val predicate: Predicate?,
    val subject: Subject?
)

private data class ParsingState(
    var position: Int,
    var data: ParsingData
)

// Parsing is exponential due to fork
class GermanParser(val forms: RawSentenceForms) {
    private val statesToExplore = mutableListOf<ParsingState>()

    private var state: ParsingState = ParsingState(0, Initial)

    private var position: Int
        get() = state.position
        set(value) {
            state.position = value
        }


    init {
        for (formVariant in forms.formVariants) {
            if (formVariant.size == 1) throw IllegalArgumentException("Only unambiguous word forms currently supported")
        }
    }

    private fun nth(offset: Int): WordForms? {
        if (offset + position >= forms.size()) return null
        return forms[offset + position]
    }

    private fun current(): WordForms? = nth(0)
//
//    fun isEnd(): Boolean {
//        return position >= forms.formVariants.size
//    }
//
//    fun at(word: Word): Boolean {
//        return current()?.originalWord == word
//    }
//
//    fun at(kind: WordKind<*>): Boolean {
//        return current()?.originalWord?.kind == kind
//    }
//
//    fun <W : Word> get(kind: WordKind<W>): WordForm<W>? {
//        val form = current() ?: return null
//        if (form.originalWord.kind != kind) return null
//        @Suppress("UNCHECKED_CAST")
//        return form as WordForm<W>
//    }

    fun advance() {
        position++
    }

    private fun fork(newState: ParsingState) {
        statesToExplore.add(newState)
    }

    private fun runSingle() {
        when (state.data) {
            Initial -> {
                val current = current() ?: terminate()
                select(current) {
                    on(::isArticle) {
                        if (it.size != 1) terminate()
                        state.data = AfterArticle(it.first() as ArticleForm)
                    }
                    on(::isNoun) {

                    }
                }
            }

        }
    }

    fun isNominativeNoun(form: WordForm<*>): Boolean {
        if (form !is NounForm) return false
//        form.
//       TODO Need to add case to word form
        TODO()
    }

    // TODO not the best way to terminate branch
    private fun terminate() : Nothing = throw TerminateFork()

//    fun <W : Word> expect(kind: WordKind<W>) : WordForm<W> {
//
//    }

    fun parser(): Res<Sentence, ParseError> {
//        val noun = get(NounKind)
//        get(VerbKind)
        TODO()
    }
}

private fun isArticle(form: WordForm<*>): Boolean = form is ArticleForm
private fun isNoun(form: WordForm<*>): Boolean = form is NounForm

private fun select(forms: WordForms, b: SelectBuilder.() -> Unit) {
    val builder = SelectBuilder()
    b(builder)
    val handlers = builder.handlers
    for (handler in handlers) {
        handler.formsHandler(forms.filter { handler.filter(it) })
    }
}

private class SelectBuilder {
    val handlers = mutableListOf<SelectHandler>()

    fun on(filter: (WordForm<*>) -> Boolean, handler: (WordForms) -> Unit) {
        handlers.add(SelectHandler(filter, handler))
    }
}

private class SelectHandler(
    val filter: (WordForm<*>) -> Boolean,
    val formsHandler: (WordForms) -> Unit
)

private class TerminateFork : Exception()