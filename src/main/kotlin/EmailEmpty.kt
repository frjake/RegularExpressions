package org.example

class EmailEmpty(private val detector: EmailDetector): Empty(detector) {
    override fun nextChar(next: Char) {
        if(next.isWhitespace() || next == '@') {
            detector.setInvalidEmail(true)
        }
        else{
            detector.setPart1(true)
        }
        detector.changeState(detector.invalid)
    }
}