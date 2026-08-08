package org.example

// capital - yes
// special - yes
// length - yes
// doesn't end with special - yes
class PasswordValid(private val detector: PasswordDetector): State(detector) {
    override fun nextChar(next: Char) {
        if(detector.specialChar(next)){
            detector.changeState(detector.endingSpecial)
        }
    }

    override fun submit(): Boolean {
        return true
    }
}