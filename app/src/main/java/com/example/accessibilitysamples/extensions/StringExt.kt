package com.example.accessibilitysamples.extensions

private val ONLY_NUMBERS_REGEX = "[^0-9]*".toRegex()
private const val EMPTY_TEXT = ""
private const val ZERO_VALUE = 0

fun String.onlyNumbers() = replace(ONLY_NUMBERS_REGEX, EMPTY_TEXT)

fun String.prepareForAccessibility(): String {
    //966.642.750–82
    val contentDescription: CharSequence = onlyNumbers() //96664275082
    var result: String = EMPTY_TEXT

    for (index in ZERO_VALUE..contentDescription.lastIndex) {
        result += "${contentDescription[index]} "
    }
    return result //9 6 6 6 4 2 7 5 0 8 2
}

fun String.prepareMobileNumberToAccessibility(): String {
    //(11) 98765–4321
    val mobileNumber = onlyNumbers() //11987654321
    val ddd = mobileNumber.substring(0, 2) //11
    val ninthDigit =  mobileNumber.substring(2, 3) //9
    val firstPair = mobileNumber.substring(3, 5) //87
    val secondPair = mobileNumber.substring(5, 7) //65
    val thirdPair = mobileNumber.substring(7, 9) //43
    val fourthPair = mobileNumber.substring(9, 11) //21
    // DDD11 9 87 65 43 21
    return "DDD$ddd $ninthDigit $firstPair $secondPair $thirdPair $fourthPair"
}