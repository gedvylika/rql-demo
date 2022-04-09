package net.gger.rqldemo.commons

// Stack as type alias of Mutable List
typealias Stack<T> = MutableList<T>

fun <T> Stack<T>.push(item: T) = add(item)
fun <T> Stack<T>.pop(): T? = if (isNotEmpty()) removeAt(lastIndex) else null