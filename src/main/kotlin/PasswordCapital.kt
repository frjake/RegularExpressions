package org.example

// capital - yes
// special - no
// length - doesn't matter yet
// doesn't end with special - doesn't matter yet
class PasswordCapital(private val detector: PasswordDetector): State(detector) {
    override fun nextChar(next: Char) {
        if(detector.chars < 8){
            detector.setChars()
        }
        if(detector.specialChar(next)){
            if(detector.chars < 8){
                detector.changeState(detector.tooShort)
            }
            else {
                detector.changeState(detector.endingSpecial)
            }
        }
    }

    override fun submit(): Boolean {
        return false
    }
}