package org.example

class EmailDetector(private val inputString: String): Detector(inputString) {
    override var state: State = Empty(this)

    override fun detect(): Boolean {
        // Implement the logic to detect if the input string is an email
        return state.submit()
    }
}