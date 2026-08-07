package org.example

class IntegerDetector(private val inputString: String) : Detector(inputString) {
    override val empty = IntegerEmpty(this)
    override val invalid = IntegerInvalid(this)
    override val valid = IntegerValid(this)
    override var state: State = empty
}