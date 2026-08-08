package org.example

class IntegerDetector(private val inputString: String) : Detector(inputString) {
    val empty = IntegerEmpty(this)
    val invalid = IntegerInvalid(this)
    val valid = IntegerValid(this)
    override var state: State = empty
}