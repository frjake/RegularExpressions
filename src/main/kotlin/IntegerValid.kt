package org.example

class IntegerValid(private val detector: Detector): Valid(detector) {
    override fun nextChar(next: Char) {
        when (next) {
            in '0'..'9' -> detector.changeState(IntegerValid(detector))
            else -> detector.changeState(IntegerInvalid(detector))
        }
    }
}