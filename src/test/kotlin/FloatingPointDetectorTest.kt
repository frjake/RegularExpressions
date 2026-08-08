import org.example.FloatingPointDetector
import kotlin.test.Test
import kotlin.test.assertEquals

class FloatingPointDetectorTest {

    @Test
    fun testInitialStates(){
        val detector = FloatingPointDetector("0")
        assertEquals("FloatingPointEmpty", detector.state::class.simpleName)
        assertEquals("FloatingPointEmpty", detector.empty::class.simpleName)
        assertEquals("FloatingPointStartingZero", detector.startingZero::class.simpleName)
        assertEquals("FloatingPointStartingDigit", detector.startingDigit::class.simpleName)
        assertEquals("FloatingPointDecimal", detector.decimal::class.simpleName)
        assertEquals("FloatingPointInvalid", detector.invalid::class.simpleName)
        assertEquals("FloatingPointValid", detector.valid::class.simpleName)
    }

    @Test
    fun testFloatingPointValid(){
        val detector = FloatingPointDetector("1.0")
        assertEquals(true, detector.detect())
        assertEquals("FloatingPointValid", detector.state::class.simpleName)
        val detector2 = FloatingPointDetector("223.14")
        assertEquals(true, detector2.detect())
        val detector3 = FloatingPointDetector("0.20000")
        assertEquals(true, detector3.detect())
        val detector4 = FloatingPointDetector("32349871234.32340981234098")
        assertEquals(true, detector4.detect())
        val detector5 = FloatingPointDetector(".423")
        assertEquals(true, detector5.detect())
    }

    @Test
    fun testFloatingPointInvalid(){
        val detector = FloatingPointDetector("423.523.")
        assertEquals(false, detector.detect())
        assertEquals("FloatingPointInvalid", detector.state::class.simpleName)
        val detector2 = FloatingPointDetector("523.62a")
        assertEquals(false, detector2.detect())
        assertEquals("FloatingPointInvalid", detector2.state::class.simpleName)
        val detector3 = FloatingPointDetector("012.7")
        assertEquals(false, detector3.detect())
        assertEquals("FloatingPointInvalid", detector3.state::class.simpleName)
        val detector4 = FloatingPointDetector("a")
        assertEquals(false, detector4.detect())
        assertEquals("FloatingPointInvalid", detector4.state::class.simpleName)
        val detector5 = FloatingPointDetector("/")
        assertEquals(false, detector5.detect())
        assertEquals("FloatingPointInvalid", detector5.state::class.simpleName)
    }

    @Test
    fun testFloatingPointStartingZero(){
        val detector = FloatingPointDetector("0")
        assertEquals(false, detector.detect())
        assertEquals("FloatingPointStartingZero", detector.state::class.simpleName)
    }

    @Test
    fun testFloatingPointStartingDigit(){
        val detector = FloatingPointDetector("623")
        assertEquals(false, detector.detect())
        assertEquals("FloatingPointStartingDigit", detector.state::class.simpleName)
        val detector2 = FloatingPointDetector("7a")
        assertEquals(false, detector2.detect())
        assertEquals("FloatingPointInvalid", detector2.state::class.simpleName)
        val detector3 = FloatingPointDetector("6/7")
        assertEquals(false, detector3.detect())
        assertEquals("FloatingPointInvalid", detector3.state::class.simpleName)
    }

    @Test
    fun testFloatingPointDecimal(){
        val detector = FloatingPointDetector("823.")
        assertEquals(false, detector.detect())
        assertEquals("FloatingPointDecimal", detector.state::class.simpleName)
        val detector2 = FloatingPointDetector(".a")
        assertEquals(false, detector2.detect())
        assertEquals("FloatingPointInvalid", detector2.state::class.simpleName)
        val detector3 = FloatingPointDetector("./")
        assertEquals(false, detector3.detect())
        assertEquals("FloatingPointInvalid", detector3.state::class.simpleName)
    }

    @Test
    fun testEmptyString(){
        val detector = FloatingPointDetector("")
        assertEquals(false, detector.detect())
        assertEquals("FloatingPointEmpty", detector.state::class.simpleName)
    }
}