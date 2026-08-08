package org.example

class EmailAt(private val detector: EmailDetector): State(detector) {
    override fun nextChar(next: Char) {
        if(next.isWhitespace() || next == '@' || next == '.') {
            detector.changeState(detector.invalid)
        }
        else{
            detector.changeState(detector.part2)
        }
    }

    override fun submit(): Boolean {
        return false
    }
}