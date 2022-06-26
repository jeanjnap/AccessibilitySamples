package com.example.accessibilitysamples.extensions

import android.widget.TextView

fun TextView.setContentDescriptionCpf() {
    contentDescription = text?.toString()?.prepareForAccessibility()
}

fun TextView.setContentDescriptionMobileNumber() {
    contentDescription = text?.toString()?.prepareMobileNumberToAccessibility()
}