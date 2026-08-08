package org.example

class IntegerInvalid(private val detector: IntegerDetector): State(detector) {
    override fun nextChar(next: Char) {
        // Do nothing, as this is the invalid state
    }

    override fun submit(): Boolean {
        return false
    }
}