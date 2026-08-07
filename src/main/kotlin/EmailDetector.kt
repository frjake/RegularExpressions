package org.example

class EmailDetector(private val inputString: String): Detector(inputString) {
    override val empty = EmailEmpty(this)
    override val invalid = EmailInvalid(this)
    override val valid = EmailValid(this)
    override var state: State = empty
    var part1 = false
        private set
    var at = false
        private set
    var part2 = false
        private set
    var point = false
        private set
    var part3 = false
        private set
    var invalidEmail = false
        private set

    fun setPart1(part1: Boolean) {
        this.part1 = part1
    }

    fun setAt(at: Boolean) {
        this.at = at
    }

    fun setPart2(part2: Boolean) {
        this.part2 = part2
    }

    fun setPoint(point: Boolean) {
        this.point = point
    }

    fun setPart3(part3: Boolean) {
        this.part3 = part3
    }

    fun setInvalidEmail(invalidEmail: Boolean) {
        this.invalidEmail = invalidEmail
    }
}