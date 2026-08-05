package org.example

class IntegerEmpty(private val detector: Detector): Empty(detector) {
    override fun nextChar(next: Char){
        when (next) {
            in '1'..'9' -> detector.changeState(IntegerValid(detector))
            else -> detector.changeState(IntegerInvalid(detector))
        }
    }
}