package org.example

// capital - yes
// special - yes
// length - no
// doesn't end with special - doesn't matter yet
class PasswordTooShort(private val detector: PasswordDetector): State(detector) {
    override fun nextChar(next: Char) {
        detector.setChars()
        if(detector.chars >= 8){
            if(detector.specialChar(next)){
                detector.changeState(detector.endingSpecial)
            }
            else{
                detector.changeState(detector.valid)
            }
        }
    }

    override fun submit(): Boolean {
        return false
    }
}