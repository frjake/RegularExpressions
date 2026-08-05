package org.example

fun detectorFactory(choice: Int, inputString: String): Detector {
    return when (choice) {
        1 -> IntegerDetector(inputString)
        2 -> FloatingPointDetector(inputString)
        3 -> BinaryDetector(inputString)
        4 -> EmailDetector(inputString)
        5 -> PasswordDetector(inputString)
        else -> throw IllegalArgumentException("Invalid choice")
    }
}