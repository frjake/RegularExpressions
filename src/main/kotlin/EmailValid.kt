package org.example

class EmailValid(private val detector: EmailDetector): Valid(detector) {
    override fun nextChar(next: Char) {
        if(next == '@' || next == '.' || next.isWhitespace()) {
            detector.setInvalidEmail(true)
            detector.changeState(detector.invalid)
        }
    }
}