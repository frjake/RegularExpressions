package org.example

class FloatingPointInvalid(private val detector: FloatingPointDetector): State(detector) {
    override fun nextChar(next: Char) {
        // Do nothing, as this is the invalid state
    }

    override fun submit(): Boolean {
        return false
    }
}