import org.example.detectorFactory
import kotlin.test.Test
import kotlin.test.assertEquals

class DetectorSimpleFactoryTest {

    @Test
    fun createIntegerDetector() {
        val detector = detectorFactory(1, "")
        assertEquals("IntegerDetector", detector::class.simpleName)
    }

    @Test
    fun createFloatingPointDetector() {
        val detector = detectorFactory(2, "")
        assertEquals("FloatingPointDetector", detector::class.simpleName)
    }

    @Test
    fun createBinaryDetector() {
        val detector = detectorFactory(3, "")
        assertEquals("BinaryDetector", detector::class.simpleName)
    }

    @Test
    fun createEmailDetector() {
        val detector = detectorFactory(4, "")
        assertEquals("EmailDetector", detector::class.simpleName)
    }

    @Test
    fun createPasswordDetector() {
        val detector = detectorFactory(5, "")
        assertEquals("PasswordDetector", detector::class.simpleName)
    }

    @Test
    fun createInvalidFactory(){
        try{
            val detector = detectorFactory(6, "")
        }
        catch(e: IllegalArgumentException){
            assertEquals("Invalid choice", e.message)
        }
    }
}