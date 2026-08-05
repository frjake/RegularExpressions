package org.example

class IntegerDetector(private val inputString: String) : Detector(inputString) {
    override var state: State = IntegerEmpty(this)
    override val empty = IntegerEmpty(this)
    override val invalid = IntegerInvalid(this)
    override val valid = IntegerValid(this)

    override fun detect(): Boolean {
        inputString.forEach { state.nextChar(it) }
        return state.submit()
    }
}