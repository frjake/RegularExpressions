package org.example

// capital - no
// special - yes
// length - doesn't matter yet
// doesn't end with special - doesn't matter yet
class PasswordSpecial(private val detector: PasswordDetector): State(detector) {
    override fun nextChar(next: Char) {
        if(detector.chars < 8){
            detector.setChars()
        }
        if(next.isUpperCase()){
            if(detector.chars < 8){
                detector.changeState(detector.tooShort)
            }
            else {
                detector.changeState(detector.valid)
            }
        }
    }

    override fun submit(): Boolean {
        return false
    }
}