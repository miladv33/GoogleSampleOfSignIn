package com.arium.rival

open class A {
    open val a = "A"

    init {
        println(a)
    }
}

class B : A() {

    override val a = "B"

}

fun main() {

    B()

}