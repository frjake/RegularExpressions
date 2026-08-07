package org.example

abstract class Empty(private val detector: Detector) : State(detector) {
    abstract override fun nextChar(next: Char)

    override fun submit(): Boolean {
        return false
    }
}