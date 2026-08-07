package org.example

class FloatingPointDetector(private val inputString: String) : Detector(inputString) {
    override val empty = FloatingPointEmpty(this)
    override val invalid = FloatingPointInvalid(this)
    override val valid = FloatingPointValid(this)
    override var state: State = empty
    var point = false
        private set
    var invalidChar = false
        private set
    var startingZero = false
        private set

    fun setPoint(point: Boolean) {
        this.point = point
    }

    fun setInvalidChar(invalidChar: Boolean) {
        this.invalidChar = invalidChar
    }

    fun setStartingZero(startingZero: Boolean) {
        this.startingZero = startingZero
    }
}