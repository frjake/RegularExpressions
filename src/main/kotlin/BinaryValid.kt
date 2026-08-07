package org.example

class BinaryValid(private val detector: BinaryDetector): Valid(detector) {
    override fun nextChar(next: Char) {
        if(next != '1'){
            if(next != '0'){
                detector.setInvalidChar(true)
            }
            detector.changeState(detector.invalid)
        }
    }
}