import org.example.FloatingPointDetector
import kotlin.test.Test
import kotlin.test.assertEquals

class FloatingPointDetectorTest {

    @Test
    fun testInitialStates(){
        val detector = FloatingPointDetector("0")
        assertEquals("FloatingPointEmpty", detector.state::class.simpleName)
        assertEquals("FloatingPointEmpty", detector.empty::class.simpleName)
        assertEquals("FloatingPointInvalid", detector.invalid::class.simpleName)
        assertEquals("FloatingPointValid", detector.valid::class.simpleName)
    }

    @Test
    fun testBooleans(){
        val detector = FloatingPointDetector("0")
        assertEquals(false, detector.point)
        detector.setPoint(true)
        assertEquals(true, detector.point)

        assertEquals(false, detector.invalidChar)
        detector.setInvalidChar(true)
        assertEquals(true, detector.invalidChar)

        assertEquals(false, detector.startingZero)
        detector.setStartingZero(true)
        assertEquals(true, detector.startingZero)
    }

    @Test
    fun testValidFloatingPoint(){
        val detector = FloatingPointDetector("1.0")
        assertEquals(true, detector.detect())
        val detector2 = FloatingPointDetector("123.34")
        assertEquals(true, detector2.detect())
        val detector3 = FloatingPointDetector("0.20000")
        assertEquals(true, detector3.detect())
        val detector4 = FloatingPointDetector("12349871234.12340981234098")
        assertEquals(true, detector4.detect())
        val detector5 = FloatingPointDetector(".123")
        assertEquals(true, detector5.detect())
    }

    @Test
    fun testInvalidFloatingPoint(){
        val detector = FloatingPointDetector("123")
        assertEquals(false, detector.detect())
        val detector2 = FloatingPointDetector("123.123.")
        assertEquals(false, detector2.detect())
        val detector3 = FloatingPointDetector("123.02a")
        assertEquals(false, detector3.detect())
        val detector4 = FloatingPointDetector("123.")
        assertEquals(false, detector4.detect())
        val detector5 = FloatingPointDetector("012.4")
        assertEquals(false, detector5.detect())
    }

    @Test
    fun testEmptyString(){
        val detector = FloatingPointDetector("")
        assertEquals(false, detector.detect())
        assertEquals("FloatingPointEmpty", detector.state::class.simpleName)
    }
}