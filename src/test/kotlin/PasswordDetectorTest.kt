import org.example.PasswordDetector
import kotlin.test.Test
import kotlin.test.assertEquals

class PasswordDetectorTest {

    @Test
    fun testInitialStates(){
        val detector = PasswordDetector("0")
        assertEquals("PasswordEmpty", detector.state::class.simpleName)
        assertEquals("PasswordEmpty", detector.empty::class.simpleName)
        assertEquals("PasswordNoCapOrSpecial", detector.noCapOrSpecial::class.simpleName)
        assertEquals("PasswordCapital", detector.capital::class.simpleName)
        assertEquals("PasswordSpecial", detector.special::class.simpleName)
        assertEquals("PasswordTooShort", detector.tooShort::class.simpleName)
        assertEquals("PasswordEndingSpecial", detector.endingSpecial::class.simpleName)
        assertEquals("PasswordValid", detector.valid::class.simpleName)
    }

    @Test
    fun testSpecialChar(){
        val detector = PasswordDetector("0")
        assertEquals(false, detector.specialChar('a'))
        assertEquals(true, detector.specialChar('!'))
    }

    @Test
    fun testPasswordValid(){
        val detector = PasswordDetector("aaaaH!aa")
        assertEquals(true, detector.detect())
        assertEquals("PasswordValid", detector.state::class.simpleName)
        val detector2 = PasswordDetector("1234567*9J")
        assertEquals(true, detector2.detect())
        val detector3 = PasswordDetector("asdpoihj;loikjasdf;ijp;lij2309jasd;lfkm20ij@aH")
        assertEquals(true, detector3.detect())
        val detector4 = PasswordDetector("!Password")
        assertEquals(true, detector4.detect())
        val detector5 = PasswordDetector("Abbbbbbb!b")
        assertEquals(true, detector5.detect())
    }

    @Test
    fun testPasswordNoCapOrSpecial(){
        val detector = PasswordDetector("a")
        assertEquals(false, detector.detect())
        assertEquals("PasswordNoCapOrSpecial", detector.state::class.simpleName)
    }

    @Test
    fun testPasswordCapital(){
        val detector = PasswordDetector("aaaHaaaaa")
        assertEquals(false, detector.detect())
        assertEquals("PasswordCapital", detector.state::class.simpleName)
    }

    @Test
    fun testPasswordSpecial(){
        val detector = PasswordDetector("aaaaaaa!")
        assertEquals(false, detector.detect())
        assertEquals("PasswordSpecial", detector.state::class.simpleName)
    }

    @Test
    fun testPasswordTooShort(){
        val detector = PasswordDetector("Abb!")
        assertEquals(false, detector.detect())
        assertEquals("PasswordTooShort", detector.state::class.simpleName)
    }

    @Test
    fun testPasswordEndingSpecial(){
        val detector = PasswordDetector("Abbbbbbb!")
        assertEquals(false, detector.detect())
        assertEquals("PasswordEndingSpecial", detector.state::class.simpleName)
        val detector2 = PasswordDetector("Abbbbbbbb!@")
        assertEquals(false, detector2.detect())
        assertEquals("PasswordEndingSpecial", detector2.state::class.simpleName)
        val detector3 = PasswordDetector("A!bbbbb!")
        assertEquals(false, detector3.detect())
        assertEquals("PasswordEndingSpecial", detector3.state::class.simpleName)
        val detector4 = PasswordDetector("A!bbbbbb!")
        assertEquals(false, detector4.detect())
        assertEquals("PasswordEndingSpecial", detector4.state::class.simpleName)
    }

    @Test
    fun testEmptyString(){
        val detector = PasswordDetector("")
        assertEquals(false, detector.detect())
        assertEquals("PasswordEmpty", detector.state::class.simpleName)
    }
}