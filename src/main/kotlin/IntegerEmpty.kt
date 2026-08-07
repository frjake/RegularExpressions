package org.example

class IntegerEmpty(private val detector: IntegerDetector): Empty(detector) {
    override fun nextChar(next: Char){
        when (next) {
            in '1'..'9' -> detector.changeState(detector.valid)
            else -> detector.changeState(detector.invalid)
        }
    }
}