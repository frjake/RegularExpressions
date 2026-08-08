package org.example

class FloatingPointValid(private val detector: FloatingPointDetector): State(detector) {
    override fun nextChar(next: Char) {
        // Implement the logic to transition to the next state based on the next character
        if(next !in '0'..'9') {
            detector.changeState(detector.invalid)
        }
    }

    override fun submit(): Boolean {
        return true
    }
}