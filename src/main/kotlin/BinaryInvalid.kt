package org.example

class BinaryInvalid(private val detector: BinaryDetector): Invalid(detector) {
    override fun nextChar(next: Char) {
        if(next == '1' && !detector.startingZero && !detector.invalidChar) {
            detector.changeState(detector.valid)
        }
        else if(next != '0' && !detector.invalidChar) {
            detector.setInvalidChar(true)
        }
    }
}