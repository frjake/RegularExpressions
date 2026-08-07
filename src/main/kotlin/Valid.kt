package org.example

abstract class Valid(private val detector: Detector) : State(detector) {
    abstract override fun nextChar(next: Char)

    override fun submit(): Boolean {
        return true
    }
}