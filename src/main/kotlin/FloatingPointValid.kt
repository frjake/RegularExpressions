package org.example

class FloatingPointValid(private val detector: FloatingPointDetector): Valid(detector) {
    override fun nextChar(next: Char) {
        // Implement the logic to transition to the next state based on the next character
        if(next !in '0'..'9') {
            detector.setInvalidChar(true)
            detector.changeState(detector.invalid)
        }
    }
}