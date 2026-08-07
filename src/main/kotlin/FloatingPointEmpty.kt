package org.example

class FloatingPointEmpty(private val detector: FloatingPointDetector): Empty(detector) {
    override fun nextChar(next: Char) {
        // Implement the logic to transition to the next state based on the next character
        if(next == '.'){
            detector.setPoint(true)
        }
        if(next == '0'){
            detector.setStartingZero(true)
        }
        if(next != '.' && next !in '0' .. '9'){
            detector.setInvalidChar(true)
        }
        detector.changeState(detector.invalid)
    }
}