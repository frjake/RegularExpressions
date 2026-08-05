package org.example

class FloatingPointDetector(private val inputString: String) : Detector(inputString) {
    override var state: State = Empty(this)
    override val empty = Empty(this)
    override val invalid = Invalid(this)
    override val valid = Valid(this)

    override fun detect(): Boolean {
        // Implement the logic to detect if the input string is an integer
        return state.submit()
    }
}