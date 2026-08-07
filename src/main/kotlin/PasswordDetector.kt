package org.example

class PasswordDetector(private val inputString: String) : Detector(inputString) {
    override val empty = PasswordEmpty(this)
    override val invalid = PasswordInvalid(this)
    override val valid = PasswordValid(this)
    override var state: State = empty
    var capital = false
        private set
    var special = false
        private set
    var lastSpecial = false
        private set
    var chars = 0
        private set
    private val specialList = arrayListOf('!', '@', '#', '$', '%', '&', '*')

    fun setCapital(capital: Boolean) {
        this.capital = capital
    }

    fun setSpecial(special: Boolean) {
        this.special = special
    }

    fun setChars() {
        this.chars++
    }

    fun setLastSpecial(lastSpecial: Boolean) {
        this.lastSpecial = lastSpecial
    }

    fun specialChar(char: Char): Boolean {
        return (char in specialList)
    }
}