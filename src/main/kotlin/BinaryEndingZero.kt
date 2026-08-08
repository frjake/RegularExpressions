package org.example

class BinaryEndingZero(private val detector: BinaryDetector): State(detector) {
    override fun nextChar(next: Char) {
        if(next == '1'){
            detector.changeState(detector.valid)
        }
        else if (next != '0'){
            detector.changeState(detector.invalid)
        }
    }

    override fun submit(): Boolean {
        return false
    }
}