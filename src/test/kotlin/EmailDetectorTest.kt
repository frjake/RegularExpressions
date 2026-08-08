import org.example.EmailDetector
import kotlin.test.Test
import kotlin.test.assertEquals

class EmailDetectorTest {

    @Test
    fun testInitialStates(){
        val detector = EmailDetector("")
            assertEquals("EmailEmpty", detector.state::class.simpleName)
            assertEquals("EmailEmpty", detector.empty::class.simpleName)
            assertEquals("EmailPart1", detector.part1::class.simpleName)
            assertEquals("EmailAt", detector.at::class.simpleName)
            assertEquals("EmailPart2", detector.part2::class.simpleName)
            assertEquals("EmailPoint", detector.point::class.simpleName)
            assertEquals("EmailInvalid", detector.invalid::class.simpleName)
            assertEquals("EmailValid", detector.valid::class.simpleName)
    }

    @Test
    fun testEmailValid(){
        val detector = EmailDetector("a@b.c")
        assertEquals(true, detector.detect())
        assertEquals("EmailValid", detector.state::class.simpleName)
        val detector2 = EmailDetector("felix.jacob@usu.edu")
        assertEquals(true, detector2.detect())
        val detector3 = EmailDetector("{}*$.&$*(@*$%&.*&*")
        assertEquals(true, detector3.detect())
    }

    @Test
    fun testEmailInvalid(){
        val detector = EmailDetector("@b.c")
        assertEquals(false, detector.detect())
        assertEquals("EmailInvalid", detector.state::class.simpleName)
        val detector2 = EmailDetector("a@b@c.com")
        assertEquals(false, detector2.detect())
        assertEquals("EmailInvalid", detector2.state::class.simpleName)
        val detector3 = EmailDetector("a.b@b.b.c")
        assertEquals(false, detector3.detect())
        assertEquals("EmailInvalid", detector3.state::class.simpleName)
        val detector4 = EmailDetector("felix jacob@usu.edu")
        assertEquals(false, detector4.detect())
        assertEquals("EmailInvalid", detector4.state::class.simpleName)
        val detector5 = EmailDetector("a@.c")
        assertEquals(false, detector5.detect())
        assertEquals("EmailInvalid", detector5.state::class.simpleName)
        val detector6 = EmailDetector(" a@b.c")
        assertEquals(false, detector6.detect())
        assertEquals("EmailInvalid", detector6.state::class.simpleName)
        val detector7 = EmailDetector("a@b.c ")
        assertEquals(false, detector7.detect())
        assertEquals("EmailInvalid", detector7.state::class.simpleName)
        val detector8 = EmailDetector("a@b.c@")
        assertEquals(false, detector8.detect())
        assertEquals("EmailInvalid", detector8.state::class.simpleName)
    }

    @Test
    fun testEmailPart1(){
        val detector = EmailDetector("a")
        assertEquals(false, detector.detect())
        assertEquals("EmailPart1", detector.state::class.simpleName)
        val detector2 = EmailDetector("a ")
        assertEquals(false, detector2.detect())
    }

    @Test
    fun testEmailAt(){
        val detector = EmailDetector("a@")
        assertEquals(false, detector.detect())
        assertEquals("EmailAt", detector.state::class.simpleName)
        val detector2 = EmailDetector("a@ ")
        assertEquals(false, detector2.detect())
        assertEquals("EmailInvalid", detector2.state::class.simpleName)
        val detector3 = EmailDetector("a@@")
        assertEquals(false, detector3.detect())
        assertEquals("EmailInvalid", detector3.state::class.simpleName)
        val detector4 = EmailDetector("a@.")
        assertEquals(false, detector4.detect())
        assertEquals("EmailInvalid", detector4.state::class.simpleName)
    }

    @Test
    fun testEmailPart2(){
        val detector = EmailDetector("a@b")
        assertEquals(false, detector.detect())
        assertEquals("EmailPart2", detector.state::class.simpleName)
        val detector2 = EmailDetector("a@b ")
        assertEquals(false, detector2.detect())
        val detector3 = EmailDetector("a@b@")
        assertEquals(false, detector3.detect())
    }

    @Test
    fun testEmailPoint(){
        val detector = EmailDetector("a@b.")
        assertEquals(false, detector.detect())
        assertEquals("EmailPoint", detector.state::class.simpleName)
        val detector2 = EmailDetector("a@b. ")
        assertEquals(false, detector2.detect())
        assertEquals("EmailInvalid", detector2.state::class.simpleName)
        val detector3 = EmailDetector("a@b.@")
        assertEquals(false, detector3.detect())
        assertEquals("EmailInvalid", detector3.state::class.simpleName)
        val detector4 = EmailDetector("a@b..")
        assertEquals(false, detector4.detect())
        assertEquals("EmailInvalid", detector4.state::class.simpleName)
    }

    @Test
    fun testEmptyString(){
        val detector = EmailDetector("")
        assertEquals(false, detector.detect())
        assertEquals("EmailEmpty", detector.state::class.simpleName)
    }
}