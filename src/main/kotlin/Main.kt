package org.example

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    print("Choose a detector\n1 - Integer\n2 - Floating Point\n3 - Binary\n4 - Email\n5 - Password\n")
    val choice = readln().toIntOrNull() ?: 0
    print("Enter the string to be checked: \n")
    val inputString = readln()
    val detector = detectorFactory(choice, inputString)
    val result = detector.detect()
    if(result) {
        println("The input string is valid for the selected detector.")
    } else {
        println("The input string is NOT valid for the selected detector.")
    }
}