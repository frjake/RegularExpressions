package org.example

class EmailValid(private val detector: EmailDetector): State(detector) {
    override fun nextChar(next: Char) {
        if(next == '@' || next == '.' || next.isWhitespace()) {
            detector.changeState(detector.invalid)
        }
    }

    override fun submit(): Boolean {
        return true
    }
}