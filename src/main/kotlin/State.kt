package org.example

abstract class State(private val detector: Detector) {
    abstract fun nextChar(next: Char)
    abstract fun submit(): Boolean
}