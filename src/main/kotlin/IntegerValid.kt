package org.example

class IntegerValid(private val detector: Detector): Valid(detector) {
    override fun nextChar(next: Char) {
        when (next) {
            in '0'..'9' -> detector.changeState(detector.valid)
            else -> detector.changeState(detector.invalid)
        }
    }
}