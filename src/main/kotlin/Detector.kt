package org.example

abstract class Detector (inputString: String) {

    abstract var state: State
    abstract val empty: Empty
    abstract val invalid: Invalid
    abstract val valid: Valid

    abstract fun detect(): Boolean

    fun changeState(state: State){
        this.state = state
    }
}