package org.example

class EmailPart2(private val detector: EmailDetector): State(detector) {
    override fun nextChar(next: Char) {
        if(next.isWhitespace() || next == '@') {
            detector.changeState(detector.invalid)
        }
        else if(next == '.') {
            detector.changeState(detector.point)
        }
    }

    override fun submit(): Boolean {
        return false
    }
}