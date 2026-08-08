import org.example.IntegerDetector
import kotlin.test.Test
import kotlin.test.assertEquals

class IntegerDetectorTest {

    @Test
    fun testInitialStates() {
        val detector = IntegerDetector("123")
        assertEquals("IntegerEmpty", detector.state::class.simpleName)
        assertEquals("IntegerEmpty", detector.empty::class.simpleName)
        assertEquals("IntegerInvalid", detector.invalid::class.simpleName)
        assertEquals("IntegerValid", detector.valid::class.simpleName)
    }

    @Test
    fun testIntegerValid() {
        val detector = IntegerDetector("123")
        assertEquals(true, detector.detect())
        val detector2 = IntegerDetector("1")
        assertEquals(true, detector2.detect())
        val detector3 = IntegerDetector("9452342352434534524346")
        assertEquals(true, detector3.detect())
    }

    @Test
    fun testIntegerInvalid() {
        val detector = IntegerDetector("0")
        assertEquals(false, detector.detect())
        assertEquals("IntegerInvalid", detector.state::class.simpleName)
        val detector2 = IntegerDetector("01")
        assertEquals(false, detector2.detect())
        val detector3 = IntegerDetector("34a")
        assertEquals(false, detector3.detect())
        val detector4 = IntegerDetector("a")
        assertEquals(false, detector4.detect())
        val detector5 = IntegerDetector("6/7")
        assertEquals(false, detector5.detect())
    }

    @Test
    fun testEmptyString() {
        val detector = IntegerDetector("")
        assertEquals(false, detector.detect())
        assertEquals("IntegerEmpty", detector.state::class.simpleName)
    }
}