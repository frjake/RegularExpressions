import org.example.BinaryDetector
import kotlin.test.Test
import kotlin.test.assertEquals

class BinaryDetectorTest {
    
    @Test
    fun testInitialStates(){
        val detector = BinaryDetector("0")
        assertEquals("BinaryEmpty", detector.state::class.simpleName)
        assertEquals("BinaryEmpty", detector.empty::class.simpleName)
        assertEquals("BinaryInvalid", detector.invalid::class.simpleName)
        assertEquals("BinaryValid", detector.valid::class.simpleName)
    }

    @Test
    fun testStartingZero(){
        val detector = BinaryDetector("0")
        assertEquals(false, detector.invalidChar)
        detector.setInvalidChar(true)
        assertEquals(true, detector.invalidChar)

        assertEquals(false, detector.startingZero)
        detector.setStartingZero(true)
        assertEquals(true, detector.startingZero)
    }

    @Test
    fun testValidBinary(){
        val detector = BinaryDetector("1")
        assertEquals(true, detector.detect())
        val detector2 = BinaryDetector("11")
        assertEquals(true, detector2.detect())
        val detector3 = BinaryDetector("101")
        assertEquals(true, detector3.detect())
        val detector4 = BinaryDetector("111111")
        assertEquals(true, detector4.detect())
        val detector5 = BinaryDetector("10011010001")
        assertEquals(true, detector5.detect())
    }

    @Test
    fun testInvalidBinary(){
        val detector = BinaryDetector("0")
        assertEquals(false, detector.detect())
        val detector2 = BinaryDetector("01")
        assertEquals(false, detector2.detect())
        val detector3 = BinaryDetector("10")
        assertEquals(false, detector3.detect())
        val detector4 = BinaryDetector("1000010")
        assertEquals(false, detector4.detect())
        val detector5 = BinaryDetector("100a01")
        assertEquals(false, detector5.detect())
    }

    @Test
    fun testEmptyString(){
        val detector = BinaryDetector("")
        assertEquals(false, detector.detect())
        assertEquals("BinaryEmpty", detector.state::class.simpleName)
    }
}