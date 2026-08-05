package org.example

abstract class Detector (inputString: String) {

    abstract var state: State

    abstract fun detect(): Boolean

    fun changeState(state: State){
        this.state = state
    }
}