package org.example

// capital - yes
// special - yes
// length - yes
// doesn't end with special - no
class PasswordEndingSpecial(private val detector: PasswordDetector): State(detector) {
    override fun nextChar(next: Char) {
        if(!detector.specialChar(next)){
            detector.changeState(detector.valid)
        }
    }

    override fun submit(): Boolean {
        return false
    }
}