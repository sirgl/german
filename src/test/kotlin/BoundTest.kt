import german.engine.GenderRestrictionType
import german.engine.PluralityRestrictionType
import german.engine.Word
import german.engine.WordForm
import german.engine.forms.Gender
import german.engine.forms.Plurality
import german.engine.restrictions.*
import german.utils.Err
import german.utils.Success
import kotlin.test.Test
import kotlin.test.assertEquals

class BoundTest  {
    @Test
    fun testBoundSuccess() {
        val bound = boundSingle(
            restrictions = setOf(
                PluralityRestriction(Plurality.Singular),
                GenderRestriction(Gender.Male)
            ),
            wantedTypes = setOf(
                PluralityRestrictionType,
                GenderRestrictionType
            )
        )
        val success = bound as Success
        val boundRestrictions = success.value
        assertEquals(Plurality.Singular, boundRestrictions[PluralityRestrictionType].plurality)
        assertEquals(Gender.Male, boundRestrictions[GenderRestrictionType].gender)
    }

    @Test
    fun testBoundFail() {
        val bound = boundSingle(
            restrictions = setOf(
                PluralityRestriction(Plurality.Singular)
            ),
            wantedTypes = setOf(
                PluralityRestrictionType,
                GenderRestrictionType
            )
        )
        val success = bound as Err
        val problem = success.error as UnboundRestriction
        val unbound = problem.unbound
        assertEquals(1, unbound.size)
        assertEquals(GenderRestrictionType, unbound.first())
    }

    @Test
    fun testPick() {
        val restrictionTypes = setOf(
            PluralityRestrictionType,
            GenderRestrictionType
        )
        val wordForm = object : WordForm<Word> {
            override val text: String
                get() = TODO("Not yet implemented")
            override val originalWord: Word
                get() = TODO("Not yet implemented")

        }
        val picked = pickForm(BoundRestrictions(
            restrictions = mapOf(
                PluralityRestrictionType to PluralityRestriction(Plurality.Singular),
                GenderRestrictionType to GenderRestriction(Gender.Male)
            ),
            types = restrictionTypes
        ), listOf(FormProducer(
            requiredRestrictions = restrictionTypes,
            formCreator = {
            assertEquals(Plurality.Singular, it[PluralityRestrictionType].plurality)
            assertEquals(Gender.Male, it[GenderRestrictionType].gender)
            wordForm
        }))
        )
        assertEquals(wordForm, picked)
    }
}