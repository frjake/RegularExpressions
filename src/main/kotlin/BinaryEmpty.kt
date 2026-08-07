package org.example

class BinaryEmpty(private val detector: BinaryDetector): Empty(detector) {
    override fun nextChar(next: Char) {
        if(next == '1'){
            detector.changeState(detector.valid)
        }
        else{
            if(next == '0'){
                detector.setStartingZero(true)
            }
            else{
                detector.setInvalidChar(true)
            }
            detector.changeState(detector.invalid)
        }
    }
}