package org.example

class BinaryValid(private val detector: BinaryDetector): State(detector) {
    override fun nextChar(next: Char) {
        if(next == '0') {
            detector.changeState(detector.endingZero)
        }
        else if(next != '1'){
            detector.changeState(detector.invalid)
        }
    }

    override fun submit(): Boolean {
        return true
    }
}