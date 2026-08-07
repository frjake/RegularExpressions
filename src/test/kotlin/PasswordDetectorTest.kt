import org.example.PasswordDetector
import kotlin.test.Test
import kotlin.test.assertEquals

class PasswordDetectorTest {

    @Test
    fun testInitialStates(){
        val detector = PasswordDetector("0")
        assertEquals("PasswordEmpty", detector.state::class.simpleName)
        assertEquals("PasswordEmpty", detector.empty::class.simpleName)
        assertEquals("PasswordInvalid", detector.invalid::class.simpleName)
        assertEquals("PasswordValid", detector.valid::class.simpleName)
    }

    @Test
    fun testVariables(){
        val detector = PasswordDetector("0")
        assertEquals(false, detector.capital)
        detector.setCapital(true)
        assertEquals(true, detector.capital)

        assertEquals(false, detector.special)
        detector.setSpecial(true)
        assertEquals(true, detector.special)

        assertEquals(false, detector.lastSpecial)
        detector.setLastSpecial(true)
        assertEquals(true, detector.lastSpecial)

        assertEquals(0, detector.chars)
        detector.setChars()
        assertEquals(1, detector.chars)
    }

    @Test
    fun testSpecialChar(){
        val detector = PasswordDetector("0")
        assertEquals(false, detector.specialChar('a'))
        assertEquals(true, detector.specialChar('!'))
    }

    @Test
    fun testValidPassword(){
        val detector = PasswordDetector("aaaaH!aa")
        assertEquals(true, detector.detect())
        val detector2 = PasswordDetector("1234567*9J")
        assertEquals(true, detector2.detect())
        val detector3 = PasswordDetector("asdpoihj;loikjasdf;ijp;lij2309jasd;lfkm20ij@aH")
        assertEquals(true, detector3.detect())
    }

    @Test
    fun testInvalidPassword(){
        val detector = PasswordDetector("a")
        assertEquals(false, detector.detect())
        val detector2 = PasswordDetector("aaaaaaa!")
        assertEquals(false, detector2.detect())
        val detector3 = PasswordDetector("aaaHaaaaa")
        assertEquals(false, detector3.detect())
        val detector4 = PasswordDetector("Abbbbbbb!")
        assertEquals(false, detector4.detect())
    }

    @Test
    fun testEmptyString(){
        val detector = PasswordDetector("")
        assertEquals(false, detector.detect())
        assertEquals("PasswordEmpty", detector.state::class.simpleName)
    }
}