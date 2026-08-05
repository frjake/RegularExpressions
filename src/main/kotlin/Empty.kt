package org.example

open class Empty(detector: Detector) : State(detector) {
    override fun nextChar(next: Char) {
        // Implement the logic to transition to the next state based on the next character
    }

    override fun submit(): Boolean {
        return false
    }
}