package org.example

// capital - no
// special - no
// length - doesn't matter yet
// doesn't end with special - doesn't matter yet
class PasswordNoCapOrSpecial(private val detector: PasswordDetector): State(detector) {
    override fun nextChar(next: Char) {
        if(detector.chars < 8){
            detector.setChars()
        }
        if(detector.specialChar(next)){
            detector.changeState(detector.special)
        }
        else if(next.isUpperCase()){
            detector.changeState(detector.capital)
        }
    }

    override fun submit(): Boolean {
        return false
    }
}