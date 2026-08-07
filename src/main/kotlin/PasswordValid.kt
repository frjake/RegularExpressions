package org.example

class PasswordValid(private val detector: PasswordDetector): Valid(detector) {
    override fun nextChar(next: Char) {
        if(detector.specialChar(next)){
            detector.setLastSpecial(true)
            detector.changeState(detector.invalid)
        }
    }
}