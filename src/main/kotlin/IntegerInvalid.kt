package org.example

class IntegerInvalid(private val detector: Detector): Invalid(detector) {
    override fun nextChar(next: Char) {
        detector.changeState(detector.invalid)
    }
}