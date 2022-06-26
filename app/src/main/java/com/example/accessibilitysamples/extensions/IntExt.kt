package com.example.accessibilitysamples.extensions

private const val ZERO_VALUE = 0
private const val TWO_VALUE = 2

fun Int.isOdd() = this % TWO_VALUE != ZERO_VALUE
