package org.example

class FloatingPointInvalid(private val detector: FloatingPointDetector): Invalid(detector) {
    override fun nextChar(next: Char) {
        // Implement the logic to transition to the next state based on the next character
        if(!detector.invalidChar) {
            if (next == '.') {
                if (!detector.point) {
                    detector.setPoint(true)
                }
            }
            else if (next in '0' .. '9'){
                if (detector.point) {
                    detector.changeState(detector.valid)
                }
                else if(detector.startingZero){
                    detector.setInvalidChar(true)
                }
            }
            else{
                detector.setInvalidChar(true)
            }
        }
    }
}