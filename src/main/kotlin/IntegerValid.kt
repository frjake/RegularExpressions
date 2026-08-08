package org.example

class IntegerValid(private val detector: IntegerDetector): State(detector) {
    override fun nextChar(next: Char) {
        if(next !in '0'..'9') {
            detector.changeState(detector.invalid)
        }
    }

    override fun submit(): Boolean {
        return true
    }
}