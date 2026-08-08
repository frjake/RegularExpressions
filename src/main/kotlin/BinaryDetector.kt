package org.example

class BinaryDetector(private val inputString: String): Detector(inputString) {
    val empty = BinaryEmpty(this)
    val endingZero = BinaryEndingZero(this)
    val invalid = BinaryInvalid(this)
    val valid = BinaryValid(this)
    override var state: State = empty
}