package org.example

class EmailPoint(private val detector: EmailDetector): State(detector) {
    override fun nextChar(next: Char) {
        if(next.isWhitespace() || next == '@' || next == '.') {
            detector.changeState(detector.invalid)
        }
        else{
            detector.changeState(detector.valid)
        }
    }

    override fun submit(): Boolean {
        return false
    }
}