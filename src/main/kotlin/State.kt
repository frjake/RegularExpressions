package org.example

abstract class State(detector: Detector) {
    abstract fun nextChar(next: Char)
    abstract fun submit(): Boolean
}