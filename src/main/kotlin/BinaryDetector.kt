package org.example

class BinaryDetector(private val inputString: String): Detector(inputString) {
    override val empty = BinaryEmpty(this)
    override val invalid = BinaryInvalid(this)
    override val valid = BinaryValid(this)
    override var state: State = empty
    var startingZero = false
        private set
    var invalidChar = false
        private set

    fun setStartingZero(startingZero: Boolean) {
        this.startingZero = startingZero
    }

    fun setInvalidChar(invalidChar: Boolean) {
        this.invalidChar = invalidChar
    }
}