import org.example.EmailDetector
import kotlin.test.Test
import kotlin.test.assertEquals

class EmailDetectorTest {

    @Test
    fun testInitialStates(){
        val detector = EmailDetector("")
            assertEquals("EmailEmpty", detector.state::class.simpleName)
            assertEquals("EmailEmpty", detector.empty::class.simpleName)
            assertEquals("EmailInvalid", detector.invalid::class.simpleName)
            assertEquals("EmailValid", detector.valid::class.simpleName)
    }

    @Test
    fun testBooleans(){
        val detector = EmailDetector("")
        assertEquals(false, detector.part1)
        detector.setPart1(true)
        assertEquals(true, detector.part1)

        assertEquals(false, detector.at)
        detector.setAt(true)
        assertEquals(true, detector.at)

        assertEquals(false, detector.part2)
        detector.setPart2(true)
        assertEquals(true, detector.part2)

        assertEquals(false, detector.point)
        detector.setPoint(true)
        assertEquals(true, detector.point)

        assertEquals(false, detector.part3)
        detector.setPart3(true)
        assertEquals(true, detector.part3)

        assertEquals(false, detector.invalidEmail)
        detector.setInvalidEmail(true)
        assertEquals(true, detector.invalidEmail)
    }

    @Test
    fun testValidEmail(){
        val detector = EmailDetector("a@b.c")
        assertEquals(true, detector.detect())
        val detector2 = EmailDetector("felix.jacob@usu.edu")
        assertEquals(true, detector2.detect())
        val detector3 = EmailDetector("{}*$.&$*(@*$%&.*&*")
        assertEquals(true, detector3.detect())
    }

    @Test
    fun testInvalidEmail(){
        val detector = EmailDetector("@b.c")
        assertEquals(false, detector.detect())
        val detector2 = EmailDetector("a@b@c.com")
        assertEquals(false, detector2.detect())
        val detector3 = EmailDetector("a.b@b.b.c")
        assertEquals(false, detector3.detect())
        val detector4 = EmailDetector("felix jacob@usu.edu")
        assertEquals(false, detector4.detect())
        val detector5 = EmailDetector("a@b.")
        assertEquals(false, detector5.detect())
        val detector6 = EmailDetector("a@.c")
        assertEquals(false, detector6.detect())
    }

    @Test
    fun testEmptyString(){
        val detector = EmailDetector("")
        assertEquals(false, detector.detect())
        assertEquals("EmailEmpty", detector.state::class.simpleName)
    }
}