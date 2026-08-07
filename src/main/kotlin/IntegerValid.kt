package org.example

class IntegerValid(private val detector: IntegerDetector): Valid(detector) {
    override fun nextChar(next: Char) {
        if(next !in '0'..'9') {
            detector.changeState(detector.invalid)
        }
    }
}