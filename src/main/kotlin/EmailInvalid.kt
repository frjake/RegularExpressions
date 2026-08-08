package org.example

class EmailInvalid(private val detector: EmailDetector): State(detector) {
    override fun nextChar(next: Char) {
       // Do nothing, as this is the invalid state
    }

    override fun submit(): Boolean {
        return false
    }
}