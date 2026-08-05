package org.example

class IntegerDetector(private val inputString: String) : Detector(inputString) {
    override var state: State = IntegerEmpty(this)

    override fun detect(): Boolean {
        inputString.forEach { state.nextChar(it) }
        return state.submit()
    }
}