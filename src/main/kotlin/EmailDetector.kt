package org.example

class EmailDetector(private val inputString: String): Detector(inputString) {
    val empty = EmailEmpty(this)
    val part1 = EmailPart1(this)
    val at = EmailAt(this)
    val part2 = EmailPart2(this)
    val point = EmailPoint(this)
    val invalid = EmailInvalid(this)
    val valid = EmailValid(this)
    override var state: State = empty
}