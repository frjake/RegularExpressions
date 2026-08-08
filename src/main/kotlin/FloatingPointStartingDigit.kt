package org.example

class FloatingPointStartingDigit(private val detector: FloatingPointDetector): State(detector) {
    override fun nextChar(next: Char) {
        if(next == '.'){
            detector.changeState(detector.decimal)
        }
        else if(next !in '0'..'9'){
            detector.changeState(detector.invalid)
        }
    }

    override fun submit(): Boolean {
        return false
    }
}