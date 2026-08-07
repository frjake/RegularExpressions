package org.example

class PasswordEmpty(private val detector: PasswordDetector): Empty(detector) {
    override fun nextChar(next: Char) {
        if(detector.specialChar(next)){
            detector.setSpecial(true)
            detector.setLastSpecial(true)
        }
        else if(next.isUpperCase()){
            detector.setCapital(true)
        }
        detector.setChars()
        detector.changeState(detector.invalid)
    }
}