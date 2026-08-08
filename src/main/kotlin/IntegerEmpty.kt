package org.example

class IntegerEmpty(private val detector: IntegerDetector): State(detector) {
    override fun nextChar(next: Char){
        when (next) {
            in '1'..'9' -> detector.changeState(detector.valid)
            else -> detector.changeState(detector.invalid)
        }
    }

    override fun submit(): Boolean {
        return false
    }
}