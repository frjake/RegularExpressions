package org.example

class FloatingPointStartingZero(private val detector: FloatingPointDetector): State(detector) {
    override fun nextChar(next: Char) {
        if(next == '.'){
            detector.changeState(detector.decimal)
        }
        else{
            detector.changeState(detector.invalid)
        }
    }

    override fun submit(): Boolean {
        return false
    }
}