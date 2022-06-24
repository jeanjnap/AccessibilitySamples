package com.example.accessibilitysamples.extensions

private val ONLY_NUMBERS_REGEX = "[^0-9]*".toRegex()
private const val EMPTY_TEXT = ""
private const val ZERO_VALUE = 0

fun String.onlyNumbers() = replace(ONLY_NUMBERS_REGEX, EMPTY_TEXT)

fun String.prepareForAccessibility(): String {
    val contentDescription: CharSequence = onlyNumbers()
    var result: String = EMPTY_TEXT

    for (index in ZERO_VALUE..contentDescription.lastIndex) {
        result += "${contentDescription[index]} "
    }
    return result
}