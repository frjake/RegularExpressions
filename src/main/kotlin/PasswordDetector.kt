package org.example

class PasswordDetector(private val inputString: String) : Detector(inputString) {
    val empty = PasswordEmpty(this)
    val noCapOrSpecial = PasswordNoCapOrSpecial(this)
    val capital = PasswordCapital(this)
    val special = PasswordSpecial(this)
    val tooShort = PasswordTooShort(this)
    val endingSpecial = PasswordEndingSpecial(this)
    val valid = PasswordValid(this)
    override var state: State = empty

    var chars = 0
        private set
    private val specialList = arrayListOf('!', '@', '#', '$', '%', '&', '*')

    fun setChars() {
        this.chars++
    }

    fun specialChar(char: Char): Boolean {
        return (char in specialList)
    }
}