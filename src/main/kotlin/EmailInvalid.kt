package org.example

class EmailInvalid(private val detector: EmailDetector): Invalid(detector) {
    override fun nextChar(next: Char) {
        if(!detector.invalidEmail) {
            if (next.isWhitespace()) {
                detector.setInvalidEmail(true)
            } else if (next == '@') {
                if (detector.part1 && !detector.at) {
                    detector.setAt(true)
                } else {
                    detector.setInvalidEmail(true)
                }
            } else if (next == '.') {
                if (detector.at) {
                    if (!detector.part2 || detector.point) {
                        detector.setInvalidEmail(true)
                    } else {
                        detector.setPoint(true)
                    }
                }
            } else {
                if(detector.at && !detector.part2) {
                    detector.setPart2(true)
                } else if(detector.point && !detector.part3) {
                    detector.setPart3(true)
                    detector.changeState(detector.valid)
                }
            }
        }
    }
}