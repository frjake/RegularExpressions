package org.example

class PasswordInvalid(private val detector: PasswordDetector): Invalid(detector) {
    override fun nextChar(next: Char) {
        if(detector.specialChar(next)){
            if(!detector.special) {
                detector.setSpecial(true)
            }
            detector.setLastSpecial(true)
        }
        else{
            detector.setLastSpecial(false)
        }
        if(!detector.capital && next.isUpperCase()){
            detector.setCapital(true)
        }
        if(detector.chars < 8){
            detector.setChars()
        }
        if(detector.special && detector.capital && detector.chars >= 8 && !detector.lastSpecial){
            detector.changeState(detector.valid)
        }
    }
}