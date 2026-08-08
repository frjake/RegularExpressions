package org.example

import kotlin.text.forEach

abstract class Detector (private val inputString: String) {

    abstract var state: State

    fun detect(): Boolean {
        inputString.forEach { state.nextChar(it) }
        return state.submit()
    }

    fun changeState(state: State){
        this.state = state
    }
}