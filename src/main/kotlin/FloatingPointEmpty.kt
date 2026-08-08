package org.example

class FloatingPointEmpty(private val detector: FloatingPointDetector): State(detector) {
    override fun nextChar(next: Char) {
        // Implement the logic to transition to the next state based on the next character
        when (next) {
            '.' -> {
                detector.changeState(detector.decimal)
            }
            '0' -> {
                detector.changeState(detector.startingZero)
            }
            in '1'..'9' -> {
                detector.changeState(detector.startingDigit)
            }
            else -> {
                detector.changeState(detector.invalid)
            }
        }
    }

    override fun submit(): Boolean {
        return false
    }
}