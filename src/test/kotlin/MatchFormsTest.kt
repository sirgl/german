import german.engine.parse.matchForms
import german.kb.AllWordDB
import org.junit.Test

class MatchFormsTest {
    @Test
    fun test() {
        val forms = matchForms("katzen", AllWordDB)
        println(forms.map { it.text })
    }
}