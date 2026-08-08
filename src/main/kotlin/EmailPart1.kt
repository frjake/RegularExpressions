package org.example

class EmailPart1(private val detector: EmailDetector): State(detector) {
    override fun nextChar(next: Char) {
        if(next == '@') {
            detector.changeState(detector.at)
        }
        else if(next.isWhitespace()) {
            detector.changeState(detector.invalid)
        }
    }

    override fun submit(): Boolean {
        return false
    }
}