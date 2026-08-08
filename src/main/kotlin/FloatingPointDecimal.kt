package org.example

class FloatingPointDecimal(private val detector: FloatingPointDetector): State(detector) {
    override fun nextChar(next: Char) {
        if(next in '0'..'9') {
            detector.changeState(detector.valid)
        }
        else{
            detector.changeState(detector.invalid)
        }
    }

    override fun submit(): Boolean {
        return false
    }
}