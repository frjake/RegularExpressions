package org.example

class IntegerInvalid(private val detector: Detector): Invalid(detector) {
    override fun nextChar(next: Char) {
        // can't change
    }
}