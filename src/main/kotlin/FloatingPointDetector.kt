package org.example

class FloatingPointDetector(private val inputString: String) : Detector(inputString) {
    val empty = FloatingPointEmpty(this)
    val startingZero = FloatingPointStartingZero(this)
    val startingDigit = FloatingPointStartingDigit(this)
    val decimal = FloatingPointDecimal(this)
    val invalid = FloatingPointInvalid(this)
    val valid = FloatingPointValid(this)
    override var state: State = empty
}